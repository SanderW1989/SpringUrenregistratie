package com.rotterdam.groep1.Urenregistratie.controller;

import org.springframework.data.repository.CrudRepository;

import com.rotterdam.groep1.Urenregistratie.domein.Admin;
import com.rotterdam.groep1.Urenregistratie.domein.Werknemer;

public interface AdminRepository extends CrudRepository<Admin, Long> {

}


