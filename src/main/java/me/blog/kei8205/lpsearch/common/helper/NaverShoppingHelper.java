package me.blog.kei8205.lpsearch.common.helper;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import me.blog.kei8205.lpsearch.common.model.InterestedItem;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Slf4j
public class NaverShoppingHelper {
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36";
	private static final String KEY_CID = "cat_id";
	private static final String KEY_MID = "nv_mid";

	public static String generateNaverShoppingDetailUrl(long mid, long cid){
		return String.format("http://shopping.naver.com/detail/detail.nhn?nv_mid=%d&cat_id=%d", mid, cid);
	}

	private static Map<String, String> parseQuery(String target) throws MalformedURLException, UnsupportedEncodingException {
		URL url = new URL(target);

		Map<String, String> query_pairs = new LinkedHashMap<String, String>();
		String query = url.getQuery();
		String[] pairs = query.split("&");
		for (String pair : pairs) {
			int idx = pair.indexOf("=");
			query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
		}
		return query_pairs;
	}

	public static InterestedItem naverShoppingUrlCheck(String target) throws Exception {
		URL url = new URL(target);
		Map<String, String> queryMap = parseQuery(target);
		if (!queryMap.containsKey(KEY_CID) || !queryMap.containsKey(KEY_MID)) {
			throw new Exception("invalid query");
		}

		Document document = Jsoup
			.connect("http://" + url.getHost() + "/detail/detail.nhn?" + KEY_CID + "=" + queryMap.get(KEY_CID) + "&" + KEY_MID + "=" + queryMap.get(KEY_MID))
			.method(Connection.Method.GET)
			.userAgent(USER_AGENT)
			.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
			.header("Content-Type", "application/x-www-form-urlencoded")
			.header("Accept-Encoding", "gzip, deflate, br")
			.header("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4")
			.get();

		String title = null;
		String thumbNailUrl = null;
		long initLowPrice = 0;

		Elements titleArea = document.select(".summary_area .summary_inner .h_area h2");
		if (titleArea != null && titleArea.size() > 0) {
			Element titleElement = titleArea.first();
			title = titleElement.text();
		}

		Elements priceArea = document.select(".summary_cet .price_view");
		if (priceArea != null && priceArea.size() > 0) {
			Element priceElement = priceArea.first();
			initLowPrice = Long.parseLong(priceElement.select(".low_price em").text().replaceAll(",", ""));
		}

		Elements thumbNailArea = document.select(".summary_lft .photo_area .thmb");
		if (thumbNailArea != null && thumbNailArea.size() > 0) {
			Element thumNailElement = thumbNailArea.first();
			thumbNailUrl = thumNailElement.select("img").attr("src");
		}

		return InterestedItem.builder()
			.cid(Long.parseLong(queryMap.get(KEY_CID)))
			.mid(Long.parseLong(queryMap.get(KEY_MID)))
			.title(title.trim())
			.initialLowPrice(initLowPrice)
			.thumbUrl(thumbNailUrl)
			.build();
	}
}
