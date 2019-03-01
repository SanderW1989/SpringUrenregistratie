package com.rotterdam.groep1.Urenregistratie.domein;

import javax.persistence.CascadeType;
import javax.ws.rs.core.Response;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Werknemer extends Account implements Overzicht {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn (name = "Werknemer_fk", referencedColumnName = "id")
	private Admin admin;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public Response getOverzicht() {
		return null;
	}
}
