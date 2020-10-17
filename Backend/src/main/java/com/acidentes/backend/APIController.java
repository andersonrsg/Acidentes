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

import models.*;

@RestController
public class APIController {

	@Autowired
	FirebaseService firebaseService;
	
	@RequestMapping("/getAll")
	public @ResponseBody String getAll() {
		return "{\n\tGG\n}";
	}
	
	@GetMapping("/getSpeedMonitor") 
	public Lombada getSpeedMonitor() throws InterruptedException, ExecutionException {
		
		return firebaseService.getSpeedMonitorDetail("5");
	}
	
	@GetMapping("/getWeather") 
	public Clima getWeather() throws InterruptedException, ExecutionException {
		
		return firebaseService.getWeatherDetail("100");
	}
	
	@GetMapping("/getRadar") 
	public Radar getRadar() throws InterruptedException, ExecutionException {
		
		return firebaseService.getRadarDetails("5");
	}
	
	@GetMapping("/getTransitBoard") 
	public Placa getTransitBoard() throws InterruptedException, ExecutionException {
		
		return firebaseService.getTransitBoardDetails("5");
	}
	
	
}


