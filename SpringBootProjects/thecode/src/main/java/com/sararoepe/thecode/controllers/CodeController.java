package com.sararoepe.thecode.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	
	@RequestMapping("/")
	public String index(@ModelAttribute("errors") String errors) {
		return "index";
	}
	
	@RequestMapping("/errors")
	public String errors(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errors", "You must train harder!");
		return "redirect:/";
	}
	
	@RequestMapping("/code")
	public String showCode(HttpSession session, @RequestParam(value="code") String code) {
		if(code.equals("bushido")) {
			return "code";
		} else {
			return "redirect:/errors";
		}
		
	}
}
