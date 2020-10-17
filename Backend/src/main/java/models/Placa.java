package models;

public class Placa {
	
	private String itemID;
	private Double latitude;
	private Double longitude;
	private String complemento;
	private int defronte;
	private String descricao;
	private String estado;
	private String fluxo;
	private String implantacao;
	private int lado;
	private String localInstalacao;
	private String nomeCruzamento;
	private String nomeLogradouro;
	private int numFinal;
	private int numInicial;
	
	public Placa(String itemID, Double latitude, Double longitude, String complemento, int defronte, String descricao,
			String estado, String fluxo, String implantacao, int lado, String localInstalacao, String nomeCruzamento,
			String nomeLogradouro, int numFinal, int numInicial) {
		super();
		this.itemID = itemID;
		this.latitude = latitude;
		this.longitude = longitude;
		this.complemento = complemento;
		this.defronte = defronte;
		this.descricao = descricao;
		this.estado = estado;
		this.fluxo = fluxo;
		this.implantacao = implantacao;
		this.lado = lado;
		this.localInstalacao = localInstalacao;
		this.nomeCruzamento = nomeCruzamento;
		this.nomeLogradouro = nomeLogradouro;
		this.numFinal = numFinal;
		this.numInicial = numInicial;
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

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getDefronte() {
		return defronte;
	}

	public void setDefronte(int defronte) {
		this.defronte = defronte;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFluxo() {
		return fluxo;
	}

	public void setFluxo(String fluxo) {
		this.fluxo = fluxo;
	}

	public String getImplantacao() {
		return implantacao;
	}

	public void setImplantacao(String implantacao) {
		this.implantacao = implantacao;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	public String getLocalInstalacao() {
		return localInstalacao;
	}

	public void setLocalInstalacao(String localInstalacao) {
		this.localInstalacao = localInstalacao;
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

	public int getNumFinal() {
		return numFinal;
	}

	public void setNumFinal(int numFinal) {
		this.numFinal = numFinal;
	}

	public int getNumInicial() {
		return numInicial;
	}

	public void setNumInicial(int numInicial) {
		this.numInicial = numInicial;
	}
	
	

	
}
