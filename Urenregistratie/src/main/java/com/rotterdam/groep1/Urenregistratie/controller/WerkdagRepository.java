package com.rotterdam.groep1.Urenregistratie.controller;

import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.rotterdam.groep1.Urenregistratie.domein.Werkdag;

@Component
public interface WerkdagRepository extends CrudRepository<Werkdag, Long> {
	

	@Query(value = "SELECT * from maand m JOIN werkdag w ON m.id = w.maand_fk WHERE m.id = :id"
			,nativeQuery = true)
	List<Werkdag> findAllWerkdag(@Param("id") long id);
	
	


}
