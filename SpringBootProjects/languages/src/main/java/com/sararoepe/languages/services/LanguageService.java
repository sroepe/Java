package com.sararoepe.languages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sararoepe.languages.models.Language;
import com.sararoepe.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	List<Language> languages = new ArrayList<Language>(Arrays.asList(

	));

	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public void addLanguage(Language language) {
		languageRepository.save(language);
	}
	
	public Language findLangById(Long id) {
		return languageRepository.findOne(id);
	}
	
	public void updateLang(Language language) {
		languageRepository.save(language);
	}
	
	public void deleteLang(Long id) {
		languageRepository.delete(id);
	}
	
}
