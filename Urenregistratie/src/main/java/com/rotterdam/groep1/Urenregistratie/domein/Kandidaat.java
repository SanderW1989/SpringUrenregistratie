package com.rotterdam.groep1.Urenregistratie.domein;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.ws.rs.core.Response;


@Entity
public class Kandidaat extends Account implements Overzicht{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String telefoonnummer;
	private double Uurtarief;
	private String pasfotoUrl;
	
	public String getPasfotoUrl() {
		return pasfotoUrl;
	}
	public void setPasfotoUrl(String pasfotoUrl) {
		this.pasfotoUrl = pasfotoUrl;
	}

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "Contactpersoon_fk", referencedColumnName = "id")
	private Contactpersoon contactpersoon;
	
	@ManyToOne //mappedBy
	@JoinColumn (name = "Werkgever_fk", referencedColumnName = "id")
	private Werkgever werkgever;	
	

	public long getId() {
		return id;	
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTelefoonnummer() {
		return telefoonnummer;
	}
	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}
	public double getUurtarief() {
		return Uurtarief;
	}
	public void setUurtarief(double uurtarief) {
		Uurtarief = uurtarief;
	}
	public Contactpersoon getContactpersoon() {
		return contactpersoon;
	}
	public void setContactpersoon(Contactpersoon contactpersoon) {
		this.contactpersoon = contactpersoon;
	}
	public Werkgever getWerkgever() {
		return werkgever;
	}
	public void setWerkgever(Werkgever werkgever) {
		this.werkgever = werkgever;	
	}	

	@Override
	public Response getOverzicht() {
		return null;
	}
	
	
	

}