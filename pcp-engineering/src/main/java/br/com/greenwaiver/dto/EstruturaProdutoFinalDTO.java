package br.com.greenwaiver.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.greenwaiver.entities.EstruturaProdutoView;

public class EstruturaProdutoFinalDTO {

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
	private List<EstruturaProdutoFinalDTO> children = new ArrayList<EstruturaProdutoFinalDTO>();

	public EstruturaProdutoFinalDTO(EstruturaProdutoView view) {
		this.idListaDad = view.getIdListaDad();
        this.idListaChildren = view.getIdListaChildren();
        this.idParent = view.getIdParent();
        this.idProduto = view.getIdProduto();
        this.cdProduto = view.getCdProduto();
        this.nmProduto = view.getNmProduto();
        this.qtProduto = view.getQtProduto();
        this.stComponentePrincipal = view.getStComponentePrincipal();
        this.tpProduto = view.getTpProduto();
        this.idPosicao = view.getIdPosicao();
        this.qtMedHorizontal = view.getQtMedHorizontal();
        this.qtMedVertical = view.getQtMedVertical();
        this.dsModelo = view.getDsModelo();
        this.stComponente = view.getStComponente();
        this.stProdutoFantasma = view.getStProdutoFantasma();
        this.vlPerdaHorizontal = view.getVlPerdaHorizontal();
        this.vlPerdaVertical = view.getVlPerdaVertical();
        this.qtRendimento = view.getQtRendimento();
        this.qtPecaM2 = view.getQtPecaM2();
        this.qtAproveitamento = view.getQtAproveitamento();
        this.qtTotRendimento = view.getQtTotRendimento();
        this.qtBase = view.getQtBase();
        this.vlFator = view.getVlFator();
        this.cdEmpresaOp = view.getCdEmpresaOp();
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

	public List<EstruturaProdutoFinalDTO> getChildren() {
		return children;
	}

	public void addChildren(EstruturaProdutoFinalDTO children) {
		this.children.add(children);
	}

}
