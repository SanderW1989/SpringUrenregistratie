package com.rotterdam.groep1.Urenregistratie.domein;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Maand {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int jaar;
	private String naam;
	private byte maandnummer;
	private String commentkandidaat;
	private String commentContactpersoon;
	private goedKeuring verzendenWerknemer;
	private goedKeuring verzendenContactpersoon;
	
	
	@ManyToOne
	@JoinColumn (name = "Kandidaat_fk", referencedColumnName = "id")
	private Kandidaat kandidaat;	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getJaar() {
		return jaar;
	}
	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public byte getMaandnummer() {
		return maandnummer;
	}
	public void setMaandnummer(byte maandnummer) {
		this.maandnummer = maandnummer;
	}
	public String getCommentkandidaat() {
		return commentkandidaat;
	}
	public void setCommentkandidaat(String commentkandidaat) {
		this.commentkandidaat = commentkandidaat;
	}
	public String getCommentContactpersoon() {
		return commentContactpersoon;
	}
	public void setCommentContactpersoon(String commentContactpersoon) {
		this.commentContactpersoon = commentContactpersoon;
	}
	public goedKeuring getVerzendenWerknemer() {
		return verzendenWerknemer;
	}
	
	public Kandidaat getKandidaat() {
		return kandidaat;
	}

	public void setKandidaat(Kandidaat kandidaat) {
		this.kandidaat = kandidaat;
	}	
	
	
	public int setVerzendenWerknemer(goedKeuring verzendenWerknemer) {
		this.verzendenWerknemer = verzendenWerknemer;
		if (verzendenWerknemer == goedKeuring.AFGEKEURD)
			return 0;
		else if (verzendenWerknemer == goedKeuring.ONBEPAALD)
			return 1;
		else
			return 2;
	}
	public  goedKeuring getVerzendenContactpersoon() {
		return verzendenContactpersoon;

	}
	public int setVerzendenContactpersoon(goedKeuring verzendenContactpersoon) {
		this.verzendenContactpersoon = verzendenContactpersoon;
		if (verzendenContactpersoon == goedKeuring.AFGEKEURD)
			return 0;
		else if (verzendenContactpersoon == goedKeuring.ONBEPAALD)
			return 1;
		else
			return 2;
	}
	
	
	}	
	
enum goedKeuring{
	GOEDGEKEURD,
	AFGEKEURD,
	ONBEPAALD;
}
