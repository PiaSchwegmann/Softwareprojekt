package de.HA2.termin.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import de.HA2.Patient.usecase.IPatientinformationFuerNr;
import de.HA2.Patient.usecase.ITerminRegistrieren;
import de.HA2.termin.AnwendungskernException;
import de.HA2.termin.dao.TerminDAO;
import de.HA2.termin.entity.TerminTO;
import de.HA2.termin.entity.impl.Termin;
import de.HA2.termin.usecase.ITerminPflegen;


@Stateless
public class TerminPflegen implements ITerminPflegen {

	@Inject
	TerminDAO terminDAO;
	
	@Inject
	ITerminRegistrieren terminRegistrieren;
	
	@Inject
	IPatientinformationFuerNr patienteninfo;

	
	@Override
	public void terminAnlegen(int terminId, String datum, String uhrzeit, int patientenId) throws AnwendungskernException {
		
		
		Termin einTermin = new Termin(terminId, datum, uhrzeit, patientenId);
		terminDAO.save(einTermin);
			
		
		terminRegistrieren.terminHinzufuegen(patientenId, einTermin.getTerminId() );
		
	}
	
	@Override
	public List<TerminTO> getAllTermin() {
		List<Termin> aList = terminDAO.findAll();
		List<TerminTO> returnList = new ArrayList<TerminTO>();
		for (Termin aTermin : aList) returnList.add(aTermin.toTerminTO());
		return returnList;
	}

	@Override
	public void terminSpeichern(TerminTO terminTO) {
		System.out.println(terminTO.toString1());

		Termin aTermin = terminDAO.find(terminTO.getTerminId());
		aTermin.setTermindatum(terminTO.getTermindatum());
		aTermin.setUhrzeit(terminTO.getUhrzeit());
		aTermin.setPatientenId(terminTO.getPatientenId());
		
		terminDAO.update(aTermin);		
		
	}
	@Override
	public void terminDurchfuehren(TerminTO terminTO) {
		System.out.println(terminTO.toString());

		Termin aTermin = terminDAO.find(terminTO.getTerminId());
		aTermin.setImpfdatum(terminTO.getImpfdatum());
		aTermin.setImpfuhrzeit(terminTO.getImpfuhrzeit());
		aTermin.setImpfstoff(terminTO.getImpfstoff());
		aTermin.setBemerkung(terminTO.getBemerkung());
		
		terminDAO.update(aTermin);		
	}
}
