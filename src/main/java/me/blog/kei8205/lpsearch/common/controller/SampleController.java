package me.blog.kei8205.lpsearch.common.controller;

import lombok.extern.slf4j.Slf4j;
import me.blog.kei8205.lpsearch.common.model.LPBaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(value = { "/sample" })
public class SampleController {

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	@ResponseBody
	public LPBaseResponse addCount() {
		return LPBaseResponse.success();
	}
}
