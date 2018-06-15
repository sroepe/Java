package com.sararoepe.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sararoepe.dojosandninjas.models.Ninja;
import com.sararoepe.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository ninjaRepository;
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
}
