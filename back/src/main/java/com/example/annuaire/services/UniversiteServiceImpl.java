package com.example.annuaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.annuaire.entities.Universite;
import com.example.annuaire.repository.IUniversiteRepository;

@Service
public class UniversiteServiceImpl implements IUniversiteService {
	 
	@Autowired
	IUniversiteRepository UniversiteRep;

	@Override
	public Universite addUniversite(Universite universite) {
		// TODO Auto-generated method stub
		return UniversiteRep.save(universite);
	}
	

}
