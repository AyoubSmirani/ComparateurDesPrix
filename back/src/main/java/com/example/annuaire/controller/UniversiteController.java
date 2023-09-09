package com.example.annuaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.annuaire.entities.Universite;
import com.example.annuaire.services.UniversiteServiceImpl;

@RestController
public class UniversiteController {
	@Autowired
	UniversiteServiceImpl universiteserv;
	
	@PostMapping(value = "/addUniversite")
	public Universite addUniversite(@RequestBody Universite univ)
	{
		return universiteserv.addUniversite(univ);
	}
	


}
