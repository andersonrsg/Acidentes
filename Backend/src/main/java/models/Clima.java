package models;

public class Clima {

	private String itemID;
	private String Data;
	private String Hora;
	private double PrecipitacaoTotal;
	private double UmidadeRelativaAr;
	private double UmidadeRelativaMax;
	private double UmidadeRelativaMin;
	private long Timestamp;
	
	public Clima(String itemID, String data, String hora, double precipitacaoTotal, double umidadeRelativaAr,
			double umidadeRelativaMax, double umidadeRelativaMin, long timestamp) {
		super();
		this.itemID = itemID;
		Data = data;
		Hora = hora;
		PrecipitacaoTotal = precipitacaoTotal;
		UmidadeRelativaAr = umidadeRelativaAr;
		UmidadeRelativaMax = umidadeRelativaMax;
		UmidadeRelativaMin = umidadeRelativaMin;
		Timestamp = timestamp;
	}
	
	public Clima() {
		super();
		
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public double getPrecipitacaoTotal() {
		return PrecipitacaoTotal;
	}

	public void setPrecipitacaoTotal(double precipitacaoTotal) {
		PrecipitacaoTotal = precipitacaoTotal;
	}

	public double getUmidadeRelativaAr() {
		return UmidadeRelativaAr;
	}

	public void setUmidadeRelativaAr(double umidadeRelativaAr) {
		UmidadeRelativaAr = umidadeRelativaAr;
	}

	public double getUmidadeRelativaMax() {
		return UmidadeRelativaMax;
	}

	public void setUmidadeRelativaMax(double umidadeRelativaMax) {
		UmidadeRelativaMax = umidadeRelativaMax;
	}

	public double getUmidadeRelativaMin() {
		return UmidadeRelativaMin;
	}

	public void setUmidadeRelativaMin(double umidadeRelativaMin) {
		UmidadeRelativaMin = umidadeRelativaMin;
	}

	public long getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(long timestamp) {
		Timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Clima [itemID=" + itemID + ", Data=" + Data + ", Hora=" + Hora + ", PrecipitacaoTotal="
				+ PrecipitacaoTotal + ", UmidadeRelativaAr=" + UmidadeRelativaAr + ", UmidadeRelativaMax="
				+ UmidadeRelativaMax + ", UmidadeRelativaMin=" + UmidadeRelativaMin + ", Timestamp=" + Timestamp + "]";
	}

	
}
