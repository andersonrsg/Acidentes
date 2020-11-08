package com.acidentes.backend;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.acidentes.backend.Services.FirebaseService;

import models.APIAge;
import utils.ApiUtils;

public class ServiceManager {
	
	public Map<String, APIAge> accidentsByAgeGroup = new HashMap<>();
	public APIAge getAccidentsByAgeGroup(FirebaseService firebaseService, boolean fatal, String startDate, String endDate) throws InterruptedException, ExecutionException {
		
		String hashKey = (fatal ? "fatal" : "nfatal") + startDate + endDate;  
		
		APIAge object = accidentsByAgeGroup.get(hashKey);
		if (object == null) {
			accidentsByAgeGroup.put(hashKey, firebaseService.getAccidentsByAgeGroup(fatal, startDate, endDate));
			System.out.println("fetched again");
			return accidentsByAgeGroup.get(hashKey);
		} else {
			System.out.println("returned existing");
			return object;
		}
	}
	

}
