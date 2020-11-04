package models;

// Non Fatal Accident
public class WeatherAccidentAccidents {

	private String data;
	private String hora;
	private long Timestamp;
	private String itemID;
	
	public WeatherAccidentAccidents(String data, String hora, String itemID, long timestamp) {
		super();
		this.data = data;
		this.hora = hora;
		this.itemID = itemID;
		this.Timestamp = timestamp;
	}
	
	public WeatherAccidentAccidents() {
		super();
		
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public long getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.Timestamp = timestamp;
	}

}
