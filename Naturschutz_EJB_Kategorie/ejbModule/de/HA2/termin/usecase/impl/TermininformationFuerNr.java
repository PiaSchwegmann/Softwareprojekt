package de.HA2.termin.usecase.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.HA2.termin.dao.TerminDAO;
import de.HA2.termin.entity.TerminTO;
import de.HA2.termin.usecase.ITermininformationFuerNr;

@Stateless
public class TermininformationFuerNr implements ITermininformationFuerNr {


	@Inject
	TerminDAO terminDAO;
	
	@Override
	public TerminTO terminSuchenByNr(int nr) {
		return terminDAO.find(nr).toTerminTO();
	}


}
