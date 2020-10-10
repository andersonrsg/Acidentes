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

import models.Carro;

@Service
public class FirebaseService {

	public String saveCarDetails(Carro carro) throws InterruptedException, ExecutionException {

		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("carros").document(carro.getLatitude())
				.set(carro);

		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public Carro getCarDetails2(String latitude) throws InterruptedException, ExecutionException {

		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("carros").document(latitude);
		
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		
		DocumentSnapshot document = future.get();
		
		Carro carro = null;
		
		if (document.exists()) {
			carro = document.toObject(Carro.class);
			return carro;
		} else {
			return null;
		}

	}

	public Carro getCarDetails(String latitude) throws InterruptedException, ExecutionException {


		// asynchronously retrieve multiple documents
		Firestore db = FirestoreClient.getFirestore();

		ApiFuture<QuerySnapshot> future = db.collection("carros").whereEqualTo("latitude", latitude).get();
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (DocumentSnapshot document : documents) {
			Carro carro = null;
			
			if (document.exists()) {
				carro = document.toObject(Carro.class);
				return carro;
			} 
		}
		return null;
	}
	
	
}
