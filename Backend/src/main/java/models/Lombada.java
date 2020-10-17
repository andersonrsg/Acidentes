package models;

public class Lombada {
	
	private String itemID;
	private Double Latitude;
	private Double Longitude;
	private int tipo;
	private int velocidadeMaxima;
	
	public Lombada(String itemID, Double latitude, Double longitude, int tipo, int velocidadeMaxima) {
		super();
		this.itemID = itemID;
		Latitude = latitude;
		Longitude = longitude;
		this.tipo = tipo;
		this.velocidadeMaxima = velocidadeMaxima;
	}
	
	public Lombada() {
		super();
		
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public Double getLatitude() {
		return Latitude;
	}

	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(int velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}
	
	
	
}
