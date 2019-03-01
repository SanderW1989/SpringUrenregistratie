package com.rotterdam.groep1.Urenregistratie.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.rotterdam.groep1.Urenregistratie.domein.Werkgever;
@Component
public interface WerkgeverRepository extends CrudRepository<Werkgever, Long>{

	
	
	
}
