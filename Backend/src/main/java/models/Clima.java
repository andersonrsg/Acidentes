package models;

public class Clima {

	private String itemID;
	private String Data;
	private String Hora;
	private long PrecipitacaoTotal;
	private int UmidadeRelativaAr;
	private int UmidadeRelativaMax;
	private int UmidadeRelativaMin;
	
//	public Clima(String itemID, String data, String hora, String precipitacaoTotal, int umidadeRelativaAr,
//			int umidadeRelativaMax, int umidadeRelativaMin) {
//		super();
//		this.itemID = itemID;
//		Data = data;
//		Hora = hora;
//		PrecipitacaoTotal = precipitacaoTotal;
//		UmidadeRelativaAr = umidadeRelativaAr;
//		UmidadeRelativaMax = umidadeRelativaMax;
//		UmidadeRelativaMin = umidadeRelativaMin;
//	}
	
	public Clima(String itemID, String data, String hora, long precipitacaoTotal, int umidadeRelativaAr,
			int umidadeRelativaMax, int umidadeRelativaMin) {
		super();
		this.itemID = itemID;
		Data = data;
		Hora = hora;
		PrecipitacaoTotal = precipitacaoTotal;
		UmidadeRelativaAr = umidadeRelativaAr;
		UmidadeRelativaMax = umidadeRelativaMax;
		UmidadeRelativaMin = umidadeRelativaMin;
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

//	public String getPrecipitacaoTotal() {
//		return PrecipitacaoTotal;
//	}
//
//	public void setPrecipitacaoTotal(String precipitacaoTotal) {
//		PrecipitacaoTotal = precipitacaoTotal;
//	}

	public int getUmidadeRelativaAr() {
		return UmidadeRelativaAr;
	}

	public void setUmidadeRelativaAr(int umidadeRelativaAr) {
		UmidadeRelativaAr = umidadeRelativaAr;
	}

	public int getUmidadeRelativaMax() {
		return UmidadeRelativaMax;
	}

	public void setUmidadeRelativaMax(int umidadeRelativaMax) {
		UmidadeRelativaMax = umidadeRelativaMax;
	}

	public int getUmidadeRelativaMin() {
		return UmidadeRelativaMin;
	}

	public void setUmidadeRelativaMin(int umidadeRelativaMin) {
		UmidadeRelativaMin = umidadeRelativaMin;
	}
	
	
	
	
}
