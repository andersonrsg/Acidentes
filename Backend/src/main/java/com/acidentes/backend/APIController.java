package com.acidentes.backend;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.internal.FirebaseScheduledExecutor;
import com.acidentes.backend.Services.*;

import models.*;
import utils.ApiUtils;
import utils.ApiUtils.APIClass;



@RestController
@CrossOrigin
@RequestMapping(path = "acidentes")
public class APIController {

	@Autowired
	FirebaseService firebaseService;

	@GetMapping(path = "getAll")
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

	@GetMapping(path = "getRadar")
	public @ResponseBody List<Radar> getRadar() throws InterruptedException, ExecutionException {
		
		return firebaseService.getRadar();
	}
	
	@GetMapping(path = "getPlaca")
	public @ResponseBody List<Placa> getPlaca() throws InterruptedException, ExecutionException {
		
		return firebaseService.getPlaca();
	}
	
	@GetMapping("/getTransitBoard") 
	public Placa getTransitBoard() throws InterruptedException, ExecutionException {
		
		return firebaseService.getTransitBoardDetails("5");
	}
	
	@GetMapping("/getWeatherAccidentsGraph/{startDate}/{endDate}") 
	public WeatherAccident getWeatherAccidents(@PathVariable String startDate, @PathVariable String endDate) throws InterruptedException, ExecutionException {

		firebaseService.updateTimestamp();
		return firebaseService.getWeatherAccidentDetail(startDate, endDate);
	}
	
	
}


