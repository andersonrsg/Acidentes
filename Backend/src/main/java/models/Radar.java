package models;

public class Radar {

	private String itemID;
	private String Logradouro;
	private int Numero;
	private int Limite;
	private Double Latitude;
	private Double Longitude;
	
	public Radar() {
		super();
	}
	
	public Radar(String itemID, String logradouro, int numero, int limite, Double latitude, Double longitude) {
		super();
		this.itemID = itemID;
		Logradouro = logradouro;
		Numero = numero;
		Limite = limite;
		Latitude = latitude;
		Longitude = longitude;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public int getLimite() {
		return Limite;
	}

	public void setLimite(int limite) {
		Limite = limite;
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

	
}
