package de.HA2.termin.entity;

import java.io.Serializable;


import de.HA2.termin.AnwendungskernException;
import de.HA2.termin.entity.impl.Termin;



public class TerminTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1965005798780312432L;
	private int terminId;
	private String termindatum;
	private String uhrzeit;
	private String impfdatum;
	private String impfuhrzeit;
	private String impfstoff;
	private String bemerkung;
	private int patientenId;
	

	public TerminTO() {}
	
	public Termin toTermin()  throws AnwendungskernException {
		
		Termin termin = new Termin(this.terminId, this.termindatum, this.uhrzeit, this.patientenId);
		
		return termin;
		
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
	public String toString() {
		return this.terminId+" "+this.impfdatum+" "+this.impfuhrzeit+" "+this.impfstoff+" "+this.bemerkung;
	}
	public String toString1() {
		return this.terminId+" "+this.termindatum+" "+this.uhrzeit+" "+this.patientenId;
	}
	
}
