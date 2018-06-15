package com.sararoepe.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/date")
	public String date() {
		return "date";
	}
	
	@RequestMapping("/time")
	public String time() {
		return "time";
	}
}
