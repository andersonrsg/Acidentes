package models;

// Non Fatal Accident
public class Accident {

	private String data;
	private int diaSemana;
	private String hora;
	private String idacidente;
	private String itemID;
	private Double Latitude;
	private Double Longitude;
	private String log1;
	private String log2;
	private int numero;
	private int periodo;
	private int tipoAcid;
	
	public Accident(String data, int diaSemana, String hora, String idacidente, String itemID, Double latitude,
			Double longitude, String log1, String log2, int numero, int periodo, int tipoAcid) {
		super();
		this.data = data;
		this.diaSemana = diaSemana;
		this.hora = hora;
		this.idacidente = idacidente;
		this.itemID = itemID;
		Latitude = latitude;
		Longitude = longitude;
		this.log1 = log1;
		this.log2 = log2;
		this.numero = numero;
		this.periodo = periodo;
		this.tipoAcid = tipoAcid;
	}
	
	public Accident() {
		super();
		
	}
	
	
}
