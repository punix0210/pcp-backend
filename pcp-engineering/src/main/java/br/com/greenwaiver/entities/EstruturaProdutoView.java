package br.com.greenwaiver.entities;

public class EstruturaProdutoView {

	private String idListaDad;
	private String idListaChildren;
	private String idParent;
	private String idProduto;
	private String cdProduto;
	private String nmProduto;
	private Double qtProduto;
	private String stComponentePrincipal;
	private String tpProduto;
	private String idPosicao;
	private Double qtMedHorizontal;
	private Double qtMedVertical;
	private String dsModelo;
	private String stComponente;
	private String stProdutoFantasma;
	private Double vlPerdaHorizontal;
	private Double vlPerdaVertical;
	private Double qtRendimento;
	private Double qtPecaM2;
	private Double qtAproveitamento;
	private Double qtTotRendimento;
	private Double qtBase;
	private Double vlFator;
	private Integer cdEmpresaOp;

	public EstruturaProdutoView() {
	}

	public EstruturaProdutoView(String idListaDad, String idListaChildren, String idParent, String idProduto,
			String cdProduto, String nmProduto, Double qtProduto, String stComponentePrincipal, String tpProduto,
			String idPosicao, Double qtMedHorizontal, Double qtMedVertical, String dsModelo, String stComponente,
			String stProdutoFantasma, Double vlPerdaHorizontal, Double vlPerdaVertical, Double qtRendimento,
			Double qtPecaM2, Double qtAproveitamento, Double qtTotRendimento, Double qtBase, Double vlFator,
			Integer cdEmpresaOp) {
		this.idListaDad = idListaDad;
		this.idListaChildren = idListaChildren;
		this.idParent = idParent;
		this.idProduto = idProduto;
		this.cdProduto = cdProduto;
		this.nmProduto = nmProduto;
		this.qtProduto = qtProduto;
		this.stComponentePrincipal = stComponentePrincipal;
		this.tpProduto = tpProduto;
		this.idPosicao = idPosicao;
		this.qtMedHorizontal = qtMedHorizontal;
		this.qtMedVertical = qtMedVertical;
		this.dsModelo = dsModelo;
		this.stComponente = stComponente;
		this.stProdutoFantasma = stProdutoFantasma;
		this.vlPerdaHorizontal = vlPerdaHorizontal;
		this.vlPerdaVertical = vlPerdaVertical;
		this.qtRendimento = qtRendimento;
		this.qtPecaM2 = qtPecaM2;
		this.qtAproveitamento = qtAproveitamento;
		this.qtTotRendimento = qtTotRendimento;
		this.qtBase = qtBase;
		this.vlFator = vlFator;
		this.cdEmpresaOp = cdEmpresaOp;
	}

	public String getIdListaDad() {
		return idListaDad;
	}

	public String getIdListaChildren() {
		return idListaChildren;
	}

	public String getIdParent() {
		return idParent;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public String getCdProduto() {
		return cdProduto;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public Double getQtProduto() {
		return qtProduto;
	}

	public String getStComponentePrincipal() {
		return stComponentePrincipal;
	}

	public String getTpProduto() {
		return tpProduto;
	}

	public String getIdPosicao() {
		return idPosicao;
	}

	public Double getQtMedHorizontal() {
		return qtMedHorizontal;
	}

	public Double getQtMedVertical() {
		return qtMedVertical;
	}

	public String getDsModelo() {
		return dsModelo;
	}

	public String getStComponente() {
		return stComponente;
	}

	public String getStProdutoFantasma() {
		return stProdutoFantasma;
	}

	public Double getVlPerdaHorizontal() {
		return vlPerdaHorizontal;
	}

	public Double getVlPerdaVertical() {
		return vlPerdaVertical;
	}

	public Double getQtRendimento() {
		return qtRendimento;
	}

	public Double getQtPecaM2() {
		return qtPecaM2;
	}

	public Double getQtAproveitamento() {
		return qtAproveitamento;
	}

	public Double getQtTotRendimento() {
		return qtTotRendimento;
	}

	public Double getQtBase() {
		return qtBase;
	}

	public Double getVlFator() {
		return vlFator;
	}

	public Integer getCdEmpresaOp() {
		return cdEmpresaOp;
	}

	public void setIdListaDad(String idListaDad) {
		this.idListaDad = idListaDad;
	}

	public void setIdListaChildren(String idListaChildren) {
		this.idListaChildren = idListaChildren;
	}

	public void setIdParent(String idParent) {
		this.idParent = idParent;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public void setQtProduto(Double qtProduto) {
		this.qtProduto = qtProduto;
	}

	public void setStComponentePrincipal(String stComponentePrincipal) {
		this.stComponentePrincipal = stComponentePrincipal;
	}

	public void setTpProduto(String tpProduto) {
		this.tpProduto = tpProduto;
	}

	public void setIdPosicao(String idPosicao) {
		this.idPosicao = idPosicao;
	}

	public void setQtMedHorizontal(Double qtMedHorizontal) {
		this.qtMedHorizontal = qtMedHorizontal;
	}

	public void setQtMedVertical(Double qtMedVertical) {
		this.qtMedVertical = qtMedVertical;
	}

	public void setDsModelo(String dsModelo) {
		this.dsModelo = dsModelo;
	}

	public void setStComponente(String stComponente) {
		this.stComponente = stComponente;
	}

	public void setStProdutoFantasma(String stProdutoFantasma) {
		this.stProdutoFantasma = stProdutoFantasma;
	}

	public void setVlPerdaHorizontal(Double vlPerdaHorizontal) {
		this.vlPerdaHorizontal = vlPerdaHorizontal;
	}

	public void setVlPerdaVertical(Double vlPerdaVertical) {
		this.vlPerdaVertical = vlPerdaVertical;
	}

	public void setQtRendimento(Double qtRendimento) {
		this.qtRendimento = qtRendimento;
	}

	public void setQtPecaM2(Double qtPecaM2) {
		this.qtPecaM2 = qtPecaM2;
	}

	public void setQtAproveitamento(Double qtAproveitamento) {
		this.qtAproveitamento = qtAproveitamento;
	}

	public void setQtTotRendimento(Double qtTotRendimento) {
		this.qtTotRendimento = qtTotRendimento;
	}

	public void setQtBase(Double qtBase) {
		this.qtBase = qtBase;
	}

	public void setVlFator(Double vlFator) {
		this.vlFator = vlFator;
	}

	public void setCdEmpresaOp(Integer cdEmpresaOp) {
		this.cdEmpresaOp = cdEmpresaOp;
	}

}
