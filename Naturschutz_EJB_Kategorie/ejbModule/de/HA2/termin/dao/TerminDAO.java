package de.HA2.termin.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import de.HA2.termin.entity.impl.Termin;

@Stateless
public class TerminDAO extends GenericDAO<Termin> {
	
	public TerminDAO(){
		super(Termin.class);
	}
	
	public List<Termin> findTerminByPatient(int patientenId){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("patientenId", patientenId);
		
		return super.findListResult(Termin.FIND_BY_PATIENT, parameters);
		
	}

}
