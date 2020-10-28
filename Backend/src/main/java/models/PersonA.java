package models;

// Person related to accidents
public class PersonA {

	private String idacidente;
	private String idade;
	private String itemID;
	private int situacaoVitima;
	private int tipoVeiculo;
	
	public PersonA(String idacidente, String idade, String itemID, int situacaoVitima, int tipoVeiculo) {
		super();
		this.idacidente = idacidente;
		this.idade = idade;
		this.itemID = itemID;
		this.situacaoVitima = situacaoVitima;
		this.tipoVeiculo = tipoVeiculo;
	}

	public PersonA() {
		super();
	}

	public String getIdacidente() {
		return idacidente;
	}

	public void setIdacidente(String idacidente) {
		this.idacidente = idacidente;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public int getSituacaoVitima() {
		return situacaoVitima;
	}

	public void setSituacaoVitima(int situacaoVitima) {
		this.situacaoVitima = situacaoVitima;
	}

	public int getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(int tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	
}
