package models;

public class Radar {

	private String itemID;
	private String Logradouro;
	private int Numero;
	private int Limite;
	private String Latitude;
	private String Longitude;
	
	public Radar() {
		super();
	}
	
	public Radar(String itemID, String logradouro, int numero, int limite, String latitude, String longitude) {
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

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	
}
