package me.blog.kei8205.lpsearch.controller;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import me.blog.kei8205.lpsearch.common.constant.LPConstant;
import me.blog.kei8205.lpsearch.common.helper.NaverShoppingHelper;
import me.blog.kei8205.lpsearch.common.helper.PriceHistoryChartHelper;
import me.blog.kei8205.lpsearch.common.model.LPBaseResponse;
import me.blog.kei8205.lpsearch.common.model.LPUser;
import me.blog.kei8205.lpsearch.common.model.param.AddInterestItemParam;
import me.blog.kei8205.lpsearch.common.model.param.CheckItemParam;
import me.blog.kei8205.lpsearch.common.model.param.ItemHistoryParam;
import me.blog.kei8205.lpsearch.item.InterestedItemService;
import me.blog.kei8205.lpsearch.log.ItemPriceLogService;
import me.blog.kei8205.lpsearch.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(value = { "/lp" })
public class LPController {

	@Autowired
	private UserService userService;
	@Autowired
	private InterestedItemService interestedItemService;
	@Autowired
	private ItemPriceLogService itemPriceLogService;

	@RequestMapping(value = { "", "/", "/list" })
	public String list(Model model) {
		LPUser user = userService.getUser(LPConstant.ACCESSTOKEN_FOR_GUEST_USER);
		model.addAttribute("user", user);
		model.addAttribute("interestedItemList", interestedItemService.getInterestedItemList(user));
		return "item/list";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam(value = "cid", defaultValue = "-1") long cid, @RequestParam(value = "mid", defaultValue = "-1") long mid) {
		LPUser user = userService.getUser(LPConstant.ACCESSTOKEN_FOR_GUEST_USER);
		model.addAttribute("user", user);
		if (cid < 0 || mid < 0) {
			return "item/register";
		}
		model.addAttribute("item", interestedItemService.getInterestedItem(user.getSeq(), mid, cid));
		return "item/detail";
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public LPBaseResponse checkInterestItem(@RequestBody CheckItemParam param) throws Exception {
		if (Strings.isNullOrEmpty(param.getTarget())) {
			return LPBaseResponse.errorResult("target url not exist");
		}
		return LPBaseResponse.successResult(NaverShoppingHelper.naverShoppingUrlCheck(param.getTarget()));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public LPBaseResponse addInterestItem(@RequestBody AddInterestItemParam param) throws Exception {
		return interestedItemService.insertInterestedItem(param) ? LPBaseResponse.success() : LPBaseResponse.errorResult("error on insert");
	}

	@RequestMapping(value = "/history", method = RequestMethod.POST)
	@ResponseBody
	public LPBaseResponse getPriceHistory(@RequestBody ItemHistoryParam param) throws Exception {
		return LPBaseResponse.successResult(PriceHistoryChartHelper.generateStatisticsChartData(itemPriceLogService.getPriceLogList(param.getCid(), param.getMid())));
	}
}
