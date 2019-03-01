package com.rotterdam.groep1.Urenregistratie.controller;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.rotterdam.groep1.Urenregistratie.domein.Contactpersoon;
import com.rotterdam.groep1.Urenregistratie.domein.Kandidaat;

@Component
public interface ContactpersoonRepository extends CrudRepository<Contactpersoon, Long>{

	
	@Query(value = "SELECT * FROM werkgever w JOIN account a ON w.id = a.Werkgever_fk WHERE a.dtype='contactpersoon'"
			,nativeQuery = true)
	Optional<Contactpersoon> findById(long Id);
	
	
}


