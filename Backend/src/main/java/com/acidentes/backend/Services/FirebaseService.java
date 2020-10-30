package com.acidentes.backend.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import models.Clima;
import models.Lombada;
import models.Placa;
import models.Radar;
import models.WeatherAccident;
import utils.ApiUtils;
import utils.ApiUtils.APIClass;

@Service
public class FirebaseService {


	// Fetch radar Details
	public List<Radar> getRadar() throws InterruptedException, ExecutionException {

		Firestore db = FirestoreClient.getFirestore();
		// Working Query
		//ApiFuture<QuerySnapshot> future = db.collection("radares").whereEqualTo("itemID", itemId).limit(1).get();
		
		
		ApiFuture<QuerySnapshot> future = db.collection("radares").orderBy("itemID").startAt(0).get();
		
		
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();

		List<Radar> radares = new ArrayList<Radar>();
		
		for (DocumentSnapshot document : documents) {
			if (document.exists()) {
				radares.add(document.toObject(Radar.class));
			}
		}
		if(radares.size() > 0) return radares;
		else return null;
	}

		public Placa getTransitBoardDetails(String itemId) throws InterruptedException, ExecutionException {

			Firestore db = FirestoreClient.getFirestore();
			// Working Query
			//ApiFuture<QuerySnapshot> future = db.collection("radares").whereEqualTo("itemID", itemId).limit(1).get();
			
			
			ApiFuture<QuerySnapshot> future = db.collection("placas").orderBy("itemID").startAt(itemId).limit(1).get();
			
			
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			
			for (DocumentSnapshot document: documents) {
				Placa transitBoard = null;
				
				if (document.exists()) {
					transitBoard = document.toObject(Placa.class);
					return transitBoard;
				} 
			}
			return null;
		}

		public Lombada getSpeedMonitorDetail(String itemId) throws InterruptedException, ExecutionException {

			Firestore db = FirestoreClient.getFirestore();
			// Working Query
			//ApiFuture<QuerySnapshot> future = db.collection("radares").whereEqualTo("itemID", itemId).limit(1).get();
			
			
			ApiFuture<QuerySnapshot> future = db.collection("mapaRadares").orderBy("itemID").startAt(itemId).limit(1).get();
			
			
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			
			for (DocumentSnapshot document: documents) {
				Lombada lombada = null;
				
				if (document.exists()) {
					lombada = document.toObject(Lombada.class);
					return lombada;
				} 
			}
			return null;
		}


		public Clima getWeatherDetail(String itemId) throws InterruptedException, ExecutionException {

			Firestore db = FirestoreClient.getFirestore();
			// Working Query
			//ApiFuture<QuerySnapshot> future = db.collection("radares").whereEqualTo("itemID", itemId).limit(1).get();
			
			
			ApiFuture<QuerySnapshot> future = db.collection("mapaRadares").orderBy("itemID").startAt(itemId).limit(1).get();
			
			
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			
			for (DocumentSnapshot document: documents) {
				Clima weather = null;
				
				if (document.exists()) {
					weather = document.toObject(Clima.class);
					return weather;
				} 
			}
			return null;
		}
		
		public WeatherAccident getWeatherAccidentDetail(String startDate, String endDate) throws InterruptedException, ExecutionException {

			
			// Weather
			String startDateWeatherFirebaseString = ApiUtils.dateToAPIString(APIClass.weather, startDate);
			String endDateWeatherFirebaseString = ApiUtils.dateToAPIString(APIClass.weather, endDate);
			
			// Accidents
			String startDateAccidentsFirebaseString = ApiUtils.dateToAPIString(APIClass.accident, startDate);
			String endDateAccidentsFirebaseString = ApiUtils.dateToAPIString(APIClass.accident, endDate);
			
			
			
			Firestore db = FirestoreClient.getFirestore();
			
			// Weather
//			ApiFuture<QuerySnapshot> future = db.collection("inmet_2015_2020").whereGreaterThan("Data", startDateWeatherFirebaseString).whereLessThan("Data", endDateWeatherFirebaseString).limit(10).get();
			ApiFuture<QuerySnapshot> future = db.collection("inmet_2015_2020").limit(10).get();			
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			WeatherAccident weatherAccident = new WeatherAccident();
			System.out.println("Documents: " + documents);
			for (DocumentSnapshot document: documents) {
				Clima weather = null;
				System.out.println(document);	
				if (document.exists()) {
					weather = document.toObject(Clima.class);
					weatherAccident.weathers.add(weather);
				} 
			}
			
			// Aciddents
//			ApiFuture<QuerySnapshot> future = db.collection("radares").whereGreaterThan("data", ApiUtils.dateToAPIString(ApiUtils.APIClass.accident, startDate)).whereLessThan("data", ApiUtils.dateToAPIString(ApiUtils.APIClass.accident, endDate)).limit(10).get();			
//			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
//			WeatherAccident weatherAccident = new WeatherAccident();
//			
//			for (DocumentSnapshot document: documents) {
//				Clima weather = null;
//				
//				if (document.exists()) {
//					weather = document.toObject(Clima.class);
//					weatherAccident.weathers.add(weather);
//				} 
//			}
			
			
			
			return weatherAccident;
		}
		
		
		
		

}
