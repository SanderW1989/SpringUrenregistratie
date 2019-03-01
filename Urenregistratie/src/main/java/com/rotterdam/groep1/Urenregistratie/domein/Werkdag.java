package com.rotterdam.groep1.Urenregistratie.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Werkdag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String dag;
	private int urenGewerkt;
	private int urenOverwerk;
	private int urenZiek;
	private int urenVerlof;
	
	@ManyToOne 
	@JoinColumn (name = "Maand_fk", referencedColumnName = "id")
	private Maand maand;	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDag() {
		return dag;
	}

	public void setDag(String dag) {
		this.dag = dag;
	}

	public int getUrenGewerkt() {
		return urenGewerkt;
	}

	public void setUrenGewerkt(int urenGewerkt) {
		this.urenGewerkt = urenGewerkt;
	}

	public int getUrenOverwerk() {
		return urenOverwerk;
	}

	public void setUrenOverwerk(int urenOverwerk) {
		this.urenOverwerk = urenOverwerk;
	}

	public int getUrenZiek() {
		return urenZiek;
	}

	public void setUrenZiek(int urenZiek) {
		this.urenZiek = urenZiek;
	}

	public int getUrenVerlof() {
		return urenVerlof;
	}

	public void setUrenVerlof(int urenVerlof) {
		this.urenVerlof = urenVerlof;
	}

	public Maand getMaand() {
		return maand;
	}

	public void setMaand(Maand maand) {
		this.maand = maand;
	}	


	
	
}


	

