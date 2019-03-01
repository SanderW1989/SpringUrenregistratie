package com.rotterdam.groep1.Urenregistratie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rotterdam.groep1.Urenregistratie.domein.Testclass;

@Service
@Transactional
public class TestclassService {
	
	@Autowired
	TestclassRepository testclassRepository;
	
	public Iterable<Testclass> geefAllen() {
		return testclassRepository.findAll();
	}
	
	public Testclass save(Testclass t) {
		return testclassRepository.save(t);
	}
	
}