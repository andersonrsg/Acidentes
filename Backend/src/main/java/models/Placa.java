package models;

public class Placa {
	
	private String itemID;
	private Double latitude;
	private Double longitude;
	private String descricao;
	private String implantacao;
	private String nomeCruzamento;
	private String nomeLogradouro;
	
	public Placa(String itemID, Double latitude, Double longitude, String descricao,
			String implantacao, String nomeCruzamento, String nomeLogradouro) {
		super();
		this.itemID = itemID;
		this.latitude = latitude;
		this.longitude = longitude;
		this.descricao = descricao;
		this.implantacao = implantacao;
		this.nomeCruzamento = nomeCruzamento;
		this.nomeLogradouro = nomeLogradouro;
	}
	
	public Placa() {
		super();
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImplantacao() {
		return implantacao;
	}

	public void setImplantacao(String implantacao) {
		this.implantacao = implantacao;
	}

	public String getNomeCruzamento() {
		return nomeCruzamento;
	}

	public void setNomeCruzamento(String nomeCruzamento) {
		this.nomeCruzamento = nomeCruzamento;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	
}
