package com.rotterdam.groep1.Urenregistratie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rotterdam.groep1.Urenregistratie.domein.Kandidaat;
import com.rotterdam.groep1.Urenregistratie.domein.Werkdag;


@Service
@Transactional
public class WerkdagService {
	
	@Autowired
	WerkdagRepository werkdagRepository;
	
	public Iterable<Werkdag> geefAllen() {
		return werkdagRepository.findAll();
	}
	
	public Werkdag save(Werkdag t) {
		return werkdagRepository.save(t);
	}
	
	public Werkdag findById(Long id) {
        return this.werkdagRepository.findById(id).orElse(null);
    }
	
	public boolean existsById(Long id){
        return this.werkdagRepository.existsById(id);
	}
	
	public Werkdag getById(long id) {
		return werkdagRepository.findById(id).orElse(null);
	}
	
	public void deleteById(long id) {
		werkdagRepository.deleteById(id);
	}
	
	public Iterable<Werkdag> geefAlleWerkagenPerMaand(long id) {
		return werkdagRepository.findAllWerkdag(id);
	}

		
}
