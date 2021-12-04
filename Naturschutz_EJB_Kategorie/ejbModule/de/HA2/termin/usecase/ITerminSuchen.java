package de.HA2.termin.usecase;

import java.util.List;

import javax.ejb.Local;


import de.HA2.termin.entity.TerminTO;

@Local
public interface ITerminSuchen {
	

	public List<TerminTO> terminSuchen(int patientenId);
	
	
}
