package com.acidentes.backend;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.internal.FirebaseScheduledExecutor;
import com.acidentes.backend.Services.*;

import models.Radar;

@RestController
public class APIController {

	@Autowired
	FirebaseService firebaseService;
	
	@RequestMapping("/getAll")
	public @ResponseBody String getAll() {
		return "{\n\tGG\n}";
	}
	
//	@PostMapping("/createCar")
//	public String createCar(@RequestBody Radar car) throws InterruptedException, ExecutionException {
//		return firebaseService.saveCarDetails(car);
//	}
	
	@GetMapping("/getRadar") 
	public Radar getCar(@RequestHeader() String itemId) throws InterruptedException, ExecutionException {
		
		return firebaseService.getRadarDetails(itemId);
	}
	
	
}


