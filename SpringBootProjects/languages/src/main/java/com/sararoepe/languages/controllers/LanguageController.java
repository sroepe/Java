package com.sararoepe.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 	
import com.sararoepe.languages.models.Language;
import com.sararoepe.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	private final LanguageService languageService;
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String indexRed() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String languages(Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		model.addAttribute("language", new Language());
		return "languages.jsp";
	}
	@PostMapping("/newLanguage")
	public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "languages.jsp";
		}else {
			languageService.addLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String findLangById(Model model, @PathVariable("id") Long id) {
		model.addAttribute("language", languageService.findLangById(id));
		return "showLanguage.jsp";
	}
	
	@RequestMapping("/languages/update/{id}")
	public String editLang(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLangById(id);
		if(language != null) {
			model.addAttribute("language", language);
			model.addAttribute("id", id);
			return "update.jsp";
		}else {
			return "redirect:/languages";
		}
	}
	
	@PostMapping("/languages/update/{id}")
	public String updateLang(@Valid @ModelAttribute("language") Language language, @PathVariable("id") Long id, BindingResult result) {
		if(result.hasErrors()) {
			return "update.jsp";
		}else {
			languageService.updateLang(language);
			return "redirect:/languages/{id}";
		}
	}
	
	@RequestMapping("/languages/delete/{id}")
	public String deleteLang(@PathVariable("id") Long id) {
		languageService.deleteLang(id);
		return "redirect:/languages";
	}
	
}
