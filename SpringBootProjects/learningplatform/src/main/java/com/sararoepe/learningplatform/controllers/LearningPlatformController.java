package com.sararoepe.learningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LearningPlatformController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("/m/{chapter}/0553/{lessonID}")
	public String findLesson(@PathVariable("chapter") String discard, @PathVariable("lessonID") String lessonID, Model model) {

		model.addAttribute("discard", "*");
		if(lessonID.equals("0733")){
			model.addAttribute("content", "Setting up your servers");
		} else if(lessonID.equals("0342")) {
			model.addAttribute("content", "Punch Cards");
		} else if(lessonID.equals("0348")) {
			model.addAttribute("content", "Advanced Fortran Intro");
		}
		return "lesson";	
	}
	
	@RequestMapping("/m/{chapter}/0483/{assignmentID}")
	public String findAssignment(@PathVariable("chapter") String discard, @PathVariable("assignmentID") String assignmentID, Model model) {

		model.addAttribute("discard", "*");
		if(assignmentID.equals("0345")){
			model.addAttribute("content", "Coding Forms");
		} else if(assignmentID.equals("2342")) {
			model.addAttribute("content", "Fortran to Binary");
		} 
		return "assignment";	
	}
	


}
