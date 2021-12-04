package de.HA2.termin.entity.impl;

import java.io.Serializable;


import javax.inject.Inject;
import javax.persistence.Access;
import javax.persistence.AccessType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.NamedQuery;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import de.HA2.Patient.usecase.ITerminRegistrieren;
import de.HA2.termin.AnwendungskernException;
import de.HA2.termin.entity.TerminTO;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)
@Table(name="HA2_Termine")
@NamedQuery(name="Termin.findTerminByNr", 
	query="SELECT t from Termin t where t.patientenId = :patientenId")
public class Termin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1791762923927701475L;
	
	public static final String FIND_BY_PATIENT = "Termin.findTerminByNr";
	
	@Transient		
	@Inject
	ITerminRegistrieren terminRegistrieren;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HA2_TERMIN_NR")
	@SequenceGenerator(name="HA2_TERMIN_NR", sequenceName="HA2_SEQ_TERMIN_NR", allocationSize = 1)
	private int terminId;
	
	private String termindatum;
	private String uhrzeit;
	private String impfdatum;
	private String impfuhrzeit;
	private String impfstoff;
	private String bemerkung;
	private int patientenId;
	
	
	public Termin() {	
	}
	
	public Termin(int terminId, String termindatum, String uhrzeit, int patientenId	) throws AnwendungskernException {
		this.terminId = terminId;
		this.termindatum = termindatum;
		this.uhrzeit = uhrzeit;
//		this.impfdatum = impfdatum;
//		this.impfuhrzeit= impfuhrzeit;
//		this.impfstoff =impfstoff;
//		this.bemerkung= bemerkung;
		this.patientenId= patientenId;

	}
	
	
	
	public TerminTO toTerminTO() {
		TerminTO einTerminTO = new TerminTO();
		
		einTerminTO.setPatientenId(this.patientenId);
		einTerminTO.setTerminId(this.terminId);
		einTerminTO.setTermindatum(this.termindatum);
		einTerminTO.setUhrzeit(this.uhrzeit);
		einTerminTO.setImpfdatum(this.impfdatum);
		einTerminTO.setImpfuhrzeit(impfuhrzeit);
		einTerminTO.setImpfstoff(this.impfstoff);
		einTerminTO.setBemerkung(this.bemerkung);
		return einTerminTO;
	}

	public int getTerminId() {
		return terminId;
	}

	public void setTerminId(int terminId) {
		this.terminId = terminId;
	}

	public String getTermindatum() {
		return termindatum;
	}

	public void setTermindatum(String termindatum) {
		this.termindatum = termindatum;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public String getImpfdatum() {
		return impfdatum;
	}

	public void setImpfdatum(String impfdatum) {
		this.impfdatum = impfdatum;
	}

	public String getImpfuhrzeit() {
		return impfuhrzeit;
	}

	public void setImpfuhrzeit(String impfuhrzeit) {
		this.impfuhrzeit = impfuhrzeit;
	}

	public String getImpfstoff() {
		return impfstoff;
	}

	public void setImpfstoff(String impfstoff) {
		this.impfstoff = impfstoff;
	}

	public String getBemerkung() {
		return bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}

	public int getPatientenId() {
		return patientenId;
	}

	public void setPatientenId(int patientenId) {
		this.patientenId = patientenId;
	}

	

}
