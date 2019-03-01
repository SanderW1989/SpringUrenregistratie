package com.rotterdam.groep1.Urenregistratie.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.rotterdam.groep1.Urenregistratie.domein.Testclass;
@Component
public interface TestclassRepository extends CrudRepository<Testclass, Long>{

}
