package com.acidentes.backend.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;

import models.*;
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

	public List<Placa> getPlaca() throws InterruptedException, ExecutionException {

		Firestore db = FirestoreClient.getFirestore();
		
//		ApiFuture<QuerySnapshot> future = db.collection("placas").whereEqualTo("descricao", "1ADA OBRIGAT�RIA").get();
		ApiFuture<QuerySnapshot> future = db.collection("placas").orderBy("itemID").startAt(0).get();
		
		
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();

		List<Placa> placas = new ArrayList<Placa>();
		
		System.out.print(placas.size());
		
		for (DocumentSnapshot document : documents) {
			if (document.exists()) {
				placas.add(document.toObject(Placa.class));
			}
		}
		if(placas.size() > 0) return placas;
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
		
		public APIAge getAccidentsByAgeGroup(boolean fatal, String startDate, String endDate) throws InterruptedException, ExecutionException {

			long startDateWeatherFirebaseString = ApiUtils.dateToAPILong(startDate);
			long endDateWeatherFirebaseString = ApiUtils.dateToAPILong(endDate);
			
			Firestore db = FirestoreClient.getFirestore();
			
//			if (!fatal) {
//				return new APIAge();
//			}
			
			
//			String collection = fatal ? "acidentesFataisPessoas" : "acidentesPessoas";
			String collection = "acidentesFataisPessoas";
			ApiFuture<QuerySnapshot> future = db.collection(collection).limit(50).get();
			
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			
			APIAge ages = new APIAge();
			
			for (DocumentSnapshot document: documents) {
				APIAgeParser age = null;
				
				if (document.exists()) {
					age = document.toObject(APIAgeParser.class);
					
					ages.insertValue(age.idade);
				} 
			}
			return ages;
		}
		
		public WeatherAccident getWeatherAccidentDetail(String startDate, String endDate) throws InterruptedException, ExecutionException {

			long startDateWeatherFirebaseString = ApiUtils.dateToAPILong(startDate);
			long endDateWeatherFirebaseString = ApiUtils.dateToAPILong(endDate);
			
			Firestore db = FirestoreClient.getFirestore();
			
			// Weather
			ApiFuture<QuerySnapshot> future = db.collection("clima")
					.whereGreaterThan("Timestamp", startDateWeatherFirebaseString)
					.whereLessThan("Timestamp", endDateWeatherFirebaseString)
					.get();
			
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			WeatherAccident weatherAccident = new WeatherAccident(startDate, endDate);
			System.out.println("Documents: " + documents);
			for (DocumentSnapshot document: documents) {
				Map<String, Object> docData = new HashMap<>();
				long date = 0;
				
				Clima weather = null;	
				if (document.exists()) {
					weather = document.toObject(Clima.class);
					if (weather.getPrecipitacaoTotal() >= 0) {
						weatherAccident.weathers.add(weather);	
					} else {
						weather.setPrecipitacaoTotal(0);
						weatherAccident.weathers.add(weather);
					}
				} 				
			}
			
			
			// Aciddents
			ApiFuture<QuerySnapshot> futureAccidents = db.collection("acidentesAll")
					.whereGreaterThan("Timestamp", startDateWeatherFirebaseString)
					.whereLessThan("Timestamp", endDateWeatherFirebaseString)
					.get();
			
			List<QueryDocumentSnapshot> documentsAccidents = futureAccidents.get().getDocuments();
			
			for (DocumentSnapshot document: documentsAccidents) {
				WeatherAccidentAccidents accident = null;
				
				if (document.exists()) {
					
					accident = document.toObject(WeatherAccidentAccidents.class);
					weatherAccident.accidents.add(accident);
					System.out.println(accident.toString());	
					
				} 
			}
			
			for (WeatherAccidentAccidents a: weatherAccident.accidents) {
				String d = a.getData();
				weatherAccident.insertDate(d);
			}
			
			return weatherAccident;
		}
		

		public AccidentSpeedMonitor getAccidentSpeedMonitor(String startDate, String endDate) throws InterruptedException, ExecutionException {
			
			return new AccidentSpeedMonitor();
		
		}
		
		
		public void updateTimestamp() throws InterruptedException, ExecutionException {

			Firestore db = FirestoreClient.getFirestore();
			
			ApiFuture<QuerySnapshot> future = db.collection("cat_acidentes").whereLessThan("latitude", 0).limit(10).get();			
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
//			WeatherAccident weatherAccident = new WeatherAccident();
			
			List<Accident> accidents = new ArrayList<Accident>();
			
			System.out.println("Documents: " + documents);
			for (DocumentSnapshot document: documents) {
				System.out.println("value:" + document.getString("latitude"));
				Map<String, Object> docData = new HashMap<>();
				long date = 0;
				Accident accident = null;	
				
				if (document.exists()) {
					accident = document.toObject(Accident.class);
					accidents.add(accident);
					System.out.println(accident.toString());
					
					docData.put("Timestamp", ApiUtils.getDate(accident.getData(), accident.getHora(), ApiUtils.APIClass.accident));
					
					
					ApiFuture<WriteResult> write = db.collection("cat_acidentes").document(document.getId()).set(docData, SetOptions.merge());
					
					System.out.println(document.toObject(Accident.class).toString());
					
					write.get();
					
				} 				
				

			}
			
		}
		
		
		public APIAccidentType getAccidentsType(boolean fatal, String startDate, String endDate) throws InterruptedException, ExecutionException {

			long startDateWeatherFirebaseString = ApiUtils.dateToAPILong(startDate);
			long endDateWeatherFirebaseString = ApiUtils.dateToAPILong(endDate);
			
			Firestore db = FirestoreClient.getFirestore();
			
			String collection = fatal ? "acidentesFatais" : "acidentesAll";

			
			ApiFuture<QuerySnapshot> future = db.collection(collection)
					.whereGreaterThan("Timestamp", startDateWeatherFirebaseString)
					.whereLessThan("Timestamp", endDateWeatherFirebaseString)
					.get();
			
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			
			APIAccidentType accidentsType = new APIAccidentType();
			
			for (DocumentSnapshot document: documents) {
				// Gambi
				APIAccientAllTypeParser type = null;
				APIFatalAccidentTypeParser typeFatal = null;
				
				if (document.exists()) {
					if (fatal) {
						typeFatal = document.toObject(APIFatalAccidentTypeParser.class);
						accidentsType.insertValue(typeFatal);	
					} else {
						type = document.toObject(APIAccientAllTypeParser.class);
						accidentsType.insertValue(type);
					}
					
				} 
			}
			System.out.println(accidentsType);
			return accidentsType;
		}
}
