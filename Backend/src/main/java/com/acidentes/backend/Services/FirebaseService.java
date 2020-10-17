package com.acidentes.backend.Services;

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

@Service
public class FirebaseService {


	// Fetch radar Details
	public Radar getRadarDetails(String itemId) throws InterruptedException, ExecutionException {

		Firestore db = FirestoreClient.getFirestore();
		// Working Query
		//ApiFuture<QuerySnapshot> future = db.collection("radares").whereEqualTo("itemID", itemId).limit(1).get();
		
		
		ApiFuture<QuerySnapshot> future = db.collection("radares").orderBy("itemID").startAt(itemId).limit(1).get();
		
		
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		
		for (DocumentSnapshot document : documents) {
			
			Radar radar = null;
			
			if (document.exists()) {
				radar = document.toObject(Radar.class);
				return radar;
			} 
		}
		return null;
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

}
