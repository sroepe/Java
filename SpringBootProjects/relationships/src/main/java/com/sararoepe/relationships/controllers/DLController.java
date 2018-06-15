package com.sararoepe.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sararoepe.relationships.models.License;
import com.sararoepe.relationships.models.Person;
import com.sararoepe.relationships.services.LicenseService;
import com.sararoepe.relationships.services.PersonService;

@Controller
public class DLController {
	//Persons
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public DLController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/")
	public String indexRedirect() {
		return "redirect:/persons/new";
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(Model model, @ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/addPerson")
	public String addPerson(@Valid @ModelAttribute("person") Person person, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		}else {
			personService.addPerson(person);
			return "success.jsp";
		}
	}
	
	@RequestMapping("persons/{id}")
	public String findNameById(@PathVariable("id") Long id, Model model){
		model.addAttribute("person", personService.findPersonById(id));
		return "showOne.jsp";
	}

	
	@RequestMapping("licenses/new")
	public String newLicense(Model model, @ModelAttribute("license") License license) {
		model.addAttribute("persons", personService.getAllPersons());
		return "newLicense.jsp";
	}
	
	@PostMapping("/addLicense")
	public String addLicense(@ModelAttribute("license") @Valid License license, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "newLicense.jsp";
		}else {
			licenseService.addLicense(license);
			return "success2.jsp";
		}
	}
	
}
