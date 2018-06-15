package com.sararoepe.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/") 
	public String index() {
		return "forward:/index.html";
	}
	
	@RequestMapping("/me")
	public String about() {
		return "forward:/about.html";
	}
	
	@RequestMapping("/projects")
	public String projects() {
		return "forward:/project.html";
	}

}
