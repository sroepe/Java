package com.sararoepe.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sararoepe.dojosandninjas.models.Dojo;
import com.sararoepe.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	
	public Dojo findDojoById(Long id) {
		return dojoRepository.findOne(id);
	}
}
