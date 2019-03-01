package com.rotterdam.groep1.Urenregistratie.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotterdam.groep1.Urenregistratie.domein.Kandidaat;

@Service
@Transactional
public class KandidaatService {
	@Autowired
	KandidaatRepository kandidaatRepository;
	
	public Iterable<Kandidaat> geefAllen() {
		return kandidaatRepository.findAll();
	}
	
	public Kandidaat save(Kandidaat t) {
		return kandidaatRepository.save(t); //kandidaat / account
	}
	
	public Kandidaat findById(Long id) {
        return this.kandidaatRepository.findById(id).orElse(null);
    }
	
	public boolean existsById(Long id){
        return this.kandidaatRepository.existsById(id);
	}
	
	public Kandidaat getById(long id) {
		return kandidaatRepository.findById(id).orElse(null);
	}
	
	public void deleteById(long id) {
		kandidaatRepository.deleteById(id);
	}

}
