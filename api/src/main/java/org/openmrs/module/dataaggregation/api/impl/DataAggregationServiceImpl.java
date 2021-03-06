/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.dataaggregation.api.impl;

import java.util.List;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import java.util.HashMap;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.dataaggregation.api.DataAggregationService;
import org.openmrs.module.dataaggregation.api.db.DataAggregationDAO;

/**
 * It is a default implementation of {@link DataAggregationService}.
 */
public class DataAggregationServiceImpl extends BaseOpenmrsService implements DataAggregationService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private DataAggregationDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(DataAggregationDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public DataAggregationDAO getDao() {
	    return dao;
    }
    
    public String getAllPatientNames() {
		String toReturn = new String();
		List<Patient> patients = Context.getPatientService().getAllPatients();
		for (Patient patient : patients) {
		  toReturn = toReturn + ("/n Patient: " + patient.getGivenName() + " " + patient.getFamilyName());
		}
		return toReturn;
    }

	@Override
	public HashMap<String, Integer> getDiseaseBurden() {
		//make up fake data for now
		HashMap<String, Integer> diseaseBurden = new HashMap<String, Integer>();
		
		diseaseBurden.put("malaria", 1202);
		diseaseBurden.put("cholera", 1202);
		diseaseBurden.put("typhoid", 1202);
		diseaseBurden.put("hiv/aids", 1202);
		diseaseBurden.put("syphilis", 1202);
		
		return diseaseBurden;
	}
}