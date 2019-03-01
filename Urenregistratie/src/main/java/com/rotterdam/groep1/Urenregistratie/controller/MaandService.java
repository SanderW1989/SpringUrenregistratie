package com.rotterdam.groep1.Urenregistratie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rotterdam.groep1.Urenregistratie.domein.Kandidaat;
import com.rotterdam.groep1.Urenregistratie.domein.Maand;


@Service
@Transactional
public class MaandService {
	
	@Autowired
	MaandRepository maandRepository;
	
	public Iterable<Maand> geefAllen() {
		return maandRepository.findAll();
	}
	
	public Maand save(Maand m) {
		return maandRepository.save(m); 
	}
	
	public Maand findById(Long id) {
        return this.maandRepository.findById(id).orElse(null);
    }
	
	public boolean existsById(Long id){
        return this.maandRepository.existsById(id);
	}
	
	public Maand getById(long id) {
		return maandRepository.findById(id).orElse(null);
	}
	
	public void deleteById(long id) {
		maandRepository.deleteById(id);
	}	
	
	
}
