package me.blog.kei8205.lpsearch.controller;

import lombok.extern.slf4j.Slf4j;
import me.blog.kei8205.lpsearch.common.model.LPBaseResponse;
import me.blog.kei8205.lpsearch.log.ItemPriceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(value = { "/internal" })
public class InternalController {

	@Autowired
	private ItemPriceLogService itemPriceLogService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public LPBaseResponse logItemPrice() {
		itemPriceLogService.logInterestedItem();
		return LPBaseResponse.success();
	}
}
