package de.HA2.termin.usecase;

import java.util.List;

import javax.ejb.Local;

import de.HA2.termin.AnwendungskernException;
import de.HA2.termin.entity.TerminTO;

@Local
public interface ITerminPflegen {
	
	void terminAnlegen (int terminId, String termindatum, String uhrzeit, int patientenId) throws AnwendungskernException;
	public List<TerminTO> getAllTermin();
	public void terminSpeichern(TerminTO terminTO);
	public void terminDurchfuehren (TerminTO terminTO);
		

	
}

