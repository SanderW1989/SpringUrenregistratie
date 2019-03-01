package com.rotterdam.groep1.Urenregistratie.domein;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.ws.rs.core.Response;

@Entity
public class Contactpersoon extends Account implements Overzicht{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String telefoonnummer;
	private String afdeling;
	
	@ManyToOne
	@JoinColumn (name = "Werkgever_fk", referencedColumnName = "id")
	private Werkgever werkgever;
	
		
	public String getTelefoonnummer() {
		return telefoonnummer;
	}
	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}
	public String getAfdeling() {
		return afdeling;
	}
	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}
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
