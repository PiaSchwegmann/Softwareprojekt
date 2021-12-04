package de.HA2.termin.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import de.HA2.Patient.usecase.IPatientinformationFuerNr;

import de.HA2.termin.dao.TerminDAO;
import de.HA2.termin.entity.TerminTO;
import de.HA2.termin.entity.impl.Termin;
import de.HA2.termin.usecase.ITerminSuchen;

@Stateless
public class TerminSuchen implements ITerminSuchen {

	@Inject
	TerminDAO terminDAO;
	
	@Inject
	IPatientinformationFuerNr patientinfo;
	

	
	@Override
	public List<TerminTO> terminSuchen(int patientenId) {
		
		List<Termin> aList = terminDAO.findTerminByPatient(patientenId);
		List<TerminTO> returnList = new ArrayList<TerminTO>();
		for (Termin aTermin : aList) returnList.add(aTermin.toTerminTO());
		return returnList;
	}

}
