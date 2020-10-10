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

import models.Radar;

@Service
public class FirebaseService {

//	public String saveCarDetails(Radar carro) throws InterruptedException, ExecutionException {
//
//		Firestore dbFirestore = FirestoreClient.getFirestore();
//		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("carros").document(carro.getLatitude())
//				.set(carro);
//
//		return collectionsApiFuture.get().getUpdateTime().toString();
//	}

//	public Radar getCarDetails2(String latitude) throws InterruptedException, ExecutionException {
//
//		Firestore dbFirestore = FirestoreClient.getFirestore();
//		DocumentReference documentReference = dbFirestore.collection("carros").document(latitude);
//		
//		ApiFuture<DocumentSnapshot> future = documentReference.get();
//		
//		DocumentSnapshot document = future.get();
//		
//		Radar carro = null;
//		
//		if (document.exists()) {
//			carro = document.toObject(Radar.class);
//			return carro;
//		} else {
//			return null;
//		}
//
//	}

	// Fetch radar Details
	public Radar getRadarDetails(String itemId) throws InterruptedException, ExecutionException {


		// asynchronously retrieve multiple documents
		Firestore db = FirestoreClient.getFirestore();

		ApiFuture<QuerySnapshot> future = db.collection("radares").whereEqualTo("itemID", itemId).get();
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (DocumentSnapshot document : documents) {
			Radar carro = null;
			
			if (document.exists()) {
				carro = document.toObject(Radar.class);
				return carro;
			} 
		}
		return null;
	}
	
	
}
