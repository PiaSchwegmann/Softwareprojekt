package de.HA2.termin.usecase;

import javax.ejb.Local;

import de.HA2.termin.entity.TerminTO;

@Local
public interface ITermininformationFuerNr {

	public TerminTO terminSuchenByNr (int nr);
}
