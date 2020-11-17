package com.acidentes.backend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.acidentes.backend.Services.FirebaseService;

import models.APIAge;
import models.Placa;
import models.Radar;
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
	
	public Map<String, List<Radar>> radars = new HashMap<>();
	public List<Radar> getRadar(FirebaseService firebaseService) throws InterruptedException, ExecutionException {
		
		String hashKey = "radars";  
		
		List<Radar> object = radars.get(hashKey);
		if (object == null) {
			radars.put(hashKey, firebaseService.getRadar());
			System.out.println("fetched again");
			return radars.get(hashKey);
		} else {
			System.out.println("returned existing");
			return object;
		}
	}
	
	public Map<String, List<Placa>> placas = new HashMap<>();
	public List<Placa> getPlaca(FirebaseService firebaseService) throws InterruptedException, ExecutionException {
		
		String hashKey = "placas";  
		
		List<Placa> object = placas.get(hashKey);
		if (object == null) {
			placas.put(hashKey, firebaseService.getPlaca());
			System.out.println("fetched again");
			return placas.get(hashKey);
		} else {
			System.out.println("returned existing");
			return object;
		}
	}

}
