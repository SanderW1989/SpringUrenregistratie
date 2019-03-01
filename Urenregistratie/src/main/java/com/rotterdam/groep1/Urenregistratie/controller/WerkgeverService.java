package com.rotterdam.groep1.Urenregistratie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rotterdam.groep1.Urenregistratie.domein.Werkgever;

@Service
@Transactional
public class WerkgeverService {
	
	@Autowired
	WerkgeverRepository werkgeverRepository;
	
	public Iterable<Werkgever> geefAllen() {
		return werkgeverRepository.findAll();
	}
	
	public Werkgever save(Werkgever t) {
		return werkgeverRepository.save(t);
	}
	
	public Werkgever findById(Long id) {
        return this.werkgeverRepository.findById(id).orElse(null);
    }
	
	public boolean existsById(Long id){
        return this.werkgeverRepository.existsById(id);
	}
	
	public Werkgever getById(long id) {
		return werkgeverRepository.findById(id).orElse(null);
	}
	
	public void deleteById(long id) {
		werkgeverRepository.deleteById(id);
	}
	
}
