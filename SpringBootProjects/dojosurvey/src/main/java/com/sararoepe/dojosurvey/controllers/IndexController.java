package com.sararoepe.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment", required = false) String comment) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
	
		return "redirect:/result";
		
	}
	
	@RequestMapping(path="/result", method=RequestMethod.GET)
	public String result() {
		
		return "result";
	}
}
