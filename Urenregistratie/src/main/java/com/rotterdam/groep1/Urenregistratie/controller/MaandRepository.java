package com.rotterdam.groep1.Urenregistratie.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


import com.rotterdam.groep1.Urenregistratie.domein.Kandidaat;
import com.rotterdam.groep1.Urenregistratie.domein.Maand;
import com.rotterdam.groep1.Urenregistratie.domein.Werkdag;

import com.rotterdam.groep1.Urenregistratie.domein.Maand;


@Component
public interface MaandRepository extends CrudRepository<Maand, Long> {
	
	
	@Query(value = "SELECT * from account a JOIN maand m ON a.id = m.kandidaat_fk WHERE a.dtype='kandidaat'"
			,nativeQuery = true)
	 Optional <Maand> findById(long Id);

	
}
