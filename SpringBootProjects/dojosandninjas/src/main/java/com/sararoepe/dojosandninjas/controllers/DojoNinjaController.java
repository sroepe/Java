package com.sararoepe.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sararoepe.dojosandninjas.models.Dojo;
import com.sararoepe.dojosandninjas.models.Ninja;
import com.sararoepe.dojosandninjas.services.DojoService;
import com.sararoepe.dojosandninjas.services.NinjaService;

@Controller
public class DojoNinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoNinjaController (DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/")
	public String indexRed() {
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(Model model, @ModelAttribute("dojo") Dojo dojo) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}else {
			dojoService.addDojo(dojo);
			return "success.jsp";
		}
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	
	@PostMapping("ninjas/new")
	public String addNinja(@RequestParam(value="dojo") Long id, @Valid @ModelAttribute("ninja") Ninja ninja, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}else {
			ninjaService.addNinja(ninja);
			return "success2.jsp";
		}
	}
	
	@RequestMapping("dojos/{id}")
	public String findDojoById(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojoById(id));
		return "showOne.jsp";
	}
	
	

}
