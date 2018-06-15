package com.sararoepe.relationships.services;

import org.springframework.stereotype.Service;

import com.sararoepe.relationships.models.License;
import com.sararoepe.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public void addLicense(License license) {
		licenseRepository.save(license);
	}
}
