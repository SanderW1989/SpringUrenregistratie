package com.rotterdam.groep1.Urenregistratie.controller;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.rotterdam.groep1.Urenregistratie.domein.Contactpersoon;
import com.rotterdam.groep1.Urenregistratie.domein.Kandidaat;

@Component
public interface KandidaatRepository extends CrudRepository<Kandidaat, Long> {
	
	
	@Query(value = "SELECT * FROM werkgever w JOIN account a ON w.id = a.Werkgever_fk WHERE a.dtype='kandidaat'"
			,nativeQuery = true)
	Optional<Kandidaat> findById(long Id);
	
	
	@Query(value = "SELECT * FROM account c JOIN account k ON c.id = k.Contactpersoon_fk WHERE c.dtype='kandidaat'"
			,nativeQuery = true)
	Optional<Kandidaat> FindById(long Id);
	
}
