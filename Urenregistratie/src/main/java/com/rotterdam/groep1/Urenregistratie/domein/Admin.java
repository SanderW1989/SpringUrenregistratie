package com.rotterdam.groep1.Urenregistratie.domein;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.ws.rs.core.Response;

@Entity
public class Admin extends Werknemer implements Overzicht {
	
	@Id
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public Response getOverzicht() {
		return null;
	}
	
	
}
