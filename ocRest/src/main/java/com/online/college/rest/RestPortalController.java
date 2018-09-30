package com.online.college.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestPortalController {
	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("index");
	}
}
