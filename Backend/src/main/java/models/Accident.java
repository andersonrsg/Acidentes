package models;

// Non Fatal Accident
public class Accident {

	private String data;
	private int diaSemana;
	private String hora;
	private long idacidente;
	private String itemID;
	private Double Latitude;
	private Double Longitude;
	private String log1;
	private String log2;
	private int numero;
	private int periodo;
	private int tipoAcid;
	
	public Accident(String data, int diaSemana, String hora, long idacidente, String itemID, Double latitude,
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public long getIdacidente() {
		return idacidente;
	}

	public void setIdacidente(long idacidente) {
		this.idacidente = idacidente;
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

	public String getLog1() {
		return log1;
	}

	public void setLog1(String log1) {
		this.log1 = log1;
	}

	public String getLog2() {
		return log2;
	}

	public void setLog2(String log2) {
		this.log2 = log2;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getTipoAcid() {
		return tipoAcid;
	}

	public void setTipoAcid(int tipoAcid) {
		this.tipoAcid = tipoAcid;
	}

	@Override
	public String toString() {
		return "Accident [data=" + data + ", diaSemana=" + diaSemana + ", hora=" + hora + ", idacidente=" + idacidente
				+ ", itemID=" + itemID + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", log1=" + log1
				+ ", log2=" + log2 + ", numero=" + numero + ", periodo=" + periodo + ", tipoAcid=" + tipoAcid + "]";
	}
	
	
	
}
