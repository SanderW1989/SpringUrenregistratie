package com.rotterdam.groep1.Urenregistratie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rotterdam.groep1.Urenregistratie.domein.Admin;
import com.rotterdam.groep1.Urenregistratie.domein.Kandidaat;
import com.rotterdam.groep1.Urenregistratie.domein.Werknemer;


@Service
@Transactional
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	public Iterable<Admin> geefAllen() {
		return adminRepository.findAll();
	}
	
	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}	
	
	public void delete(Admin admin) {
		adminRepository.delete(admin);
	}
	
	public void deleteAll(Admin admin) {
		adminRepository.deleteAll();
	}
	

}
