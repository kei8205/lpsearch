package me.blog.kei8205.lpsearch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping(value = { "/internal" })
public class InternalController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String addCount() {
		return "main";
	}
}
