package com.sararoepe.counter.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionAttribute")
public class HomeController	extends HttpServlet {
	
	public static final long serialVersionUID = 1L;
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0);
		}
		session.setAttribute("counter", (int)session.getAttribute("counter") + 1);
		return "index";
	}
	
	@RequestMapping("/counter")
	public String showCount(Model model, HttpSession session) {
		model.addAttribute("counter", session.getAttribute("counter"));
		return "counter";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("counter", 0);
		return "redirect:/";
	}
	
	@RequestMapping("/doublecount")
	public String doubleCount(HttpSession session) {
		session.setAttribute("counter", (int)session.getAttribute("counter") + 1);
		return "double";
	}
}
