package br.com.greenwaiver.entities;
// Generated 18 de jun. de 2023 18:46:59 by Hibernate Tools 5.6.14.Final

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ListaProdutoItem generated by hbm2java
 */
@Table(name = "ListaProdutoItem", schema = "wpcp")
@Entity
public class ListaProdutoItem implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String idListaProdutoItem;
	private String idListaProduto;

	@ManyToOne
	@JoinColumn(name = "IdProdutoComponente", referencedColumnName = "IdProduto")
	private Produto componente;
	private Double qtProdutoComponente;
	private Character stComponentePrincipal;
	private Character tpProduto;
	private String idPosicao;
	private Double qtMedHorizontal;
	private Double qtMedVertical;
	private String dsModelo;
	private Character stComponente;
	private Character stProdutoFantasma;
	private Double vlPerdaHorizontal;
	private Double vlPerdaVertical;
	private Double qtRendimento;
	private Double qtPecaM2;
	private Double qtAproveitamento;
	private Double qtTotRendimento;
	private Date dtExclusao;
	private String idUsuarioExclusao;
	private Double qtBase;
	private Double vlFator;
	private Integer cdEmpresaOp;

	public ListaProdutoItem() {
	}

	public ListaProdutoItem(String idListaProdutoItem) {
		this.idListaProdutoItem = idListaProdutoItem;
	}

	public ListaProdutoItem(String idListaProdutoItem, String idListaProduto, Produto componente,
			Double qtProdutoComponente, Character stComponentePrincipal, Character tpProduto, String idPosicao,
			Double qtMedHorizontal, Double qtMedVertical, String dsModelo, Character stComponente,
			Character stProdutoFantasma, Double vlPerdaHorizontal, Double vlPerdaVertical, Double qtRendimento,
			Double qtPecaM2, Double qtAproveitamento, Double qtTotRendimento, Date dtExclusao, String idUsuarioExclusao,
			Double qtBase, Double vlFator, Integer cdEmpresaOp) {
		this.idListaProdutoItem = idListaProdutoItem;
		this.idListaProduto = idListaProduto;
		this.componente = componente;
		this.qtProdutoComponente = qtProdutoComponente;
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
		this.dtExclusao = dtExclusao;
		this.idUsuarioExclusao = idUsuarioExclusao;
		this.qtBase = qtBase;
		this.vlFator = vlFator;
		this.cdEmpresaOp = cdEmpresaOp;
	}

	public String getIdListaProdutoItem() {
		return this.idListaProdutoItem;
	}

	public void setIdListaProdutoItem(String idListaProdutoItem) {
		this.idListaProdutoItem = idListaProdutoItem;
	}

	public String getIdListaProduto() {
		return this.idListaProduto;
	}

	public void setIdListaProduto(String idListaProduto) {
		this.idListaProduto = idListaProduto;
	}

	public Produto getComponente() {
		return componente;
	}

	public void setComponente(Produto componente) {
		this.componente = componente;
	}

	public Double getQtProdutoComponente() {
		return this.qtProdutoComponente;
	}

	public void setQtProdutoComponente(Double qtProdutoComponente) {
		this.qtProdutoComponente = qtProdutoComponente;
	}

	public Character getStComponentePrincipal() {
		return this.stComponentePrincipal;
	}

	public void setStComponentePrincipal(Character stComponentePrincipal) {
		this.stComponentePrincipal = stComponentePrincipal;
	}

	public Character getTpProduto() {
		return this.tpProduto;
	}

	public void setTpProduto(Character tpProduto) {
		this.tpProduto = tpProduto;
	}

	public String getIdPosicao() {
		return this.idPosicao;
	}

	public void setIdPosicao(String idPosicao) {
		this.idPosicao = idPosicao;
	}

	public Double getQtMedHorizontal() {
		return this.qtMedHorizontal;
	}

	public void setQtMedHorizontal(Double qtMedHorizontal) {
		this.qtMedHorizontal = qtMedHorizontal;
	}

	public Double getQtMedVertical() {
		return this.qtMedVertical;
	}

	public void setQtMedVertical(Double qtMedVertical) {
		this.qtMedVertical = qtMedVertical;
	}

	public String getDsModelo() {
		return this.dsModelo;
	}

	public void setDsModelo(String dsModelo) {
		this.dsModelo = dsModelo;
	}

	public Character getStComponente() {
		return this.stComponente;
	}

	public void setStComponente(Character stComponente) {
		this.stComponente = stComponente;
	}

	public Character getStProdutoFantasma() {
		return this.stProdutoFantasma;
	}

	public void setStProdutoFantasma(Character stProdutoFantasma) {
		this.stProdutoFantasma = stProdutoFantasma;
	}

	public Double getVlPerdaHorizontal() {
		return this.vlPerdaHorizontal;
	}

	public void setVlPerdaHorizontal(Double vlPerdaHorizontal) {
		this.vlPerdaHorizontal = vlPerdaHorizontal;
	}

	public Double getVlPerdaVertical() {
		return this.vlPerdaVertical;
	}

	public void setVlPerdaVertical(Double vlPerdaVertical) {
		this.vlPerdaVertical = vlPerdaVertical;
	}

	public Double getQtRendimento() {
		return this.qtRendimento;
	}

	public void setQtRendimento(Double qtRendimento) {
		this.qtRendimento = qtRendimento;
	}

	public Double getQtPecaM2() {
		return this.qtPecaM2;
	}

	public void setQtPecaM2(Double qtPecaM2) {
		this.qtPecaM2 = qtPecaM2;
	}

	public Double getQtAproveitamento() {
		return this.qtAproveitamento;
	}

	public void setQtAproveitamento(Double qtAproveitamento) {
		this.qtAproveitamento = qtAproveitamento;
	}

	public Double getQtTotRendimento() {
		return this.qtTotRendimento;
	}

	public void setQtTotRendimento(Double qtTotRendimento) {
		this.qtTotRendimento = qtTotRendimento;
	}

	public Date getDtExclusao() {
		return this.dtExclusao;
	}

	public void setDtExclusao(Date dtExclusao) {
		this.dtExclusao = dtExclusao;
	}

	public String getIdUsuarioExclusao() {
		return this.idUsuarioExclusao;
	}

	public void setIdUsuarioExclusao(String idUsuarioExclusao) {
		this.idUsuarioExclusao = idUsuarioExclusao;
	}

	public Double getQtBase() {
		return this.qtBase;
	}

	public void setQtBase(Double qtBase) {
		this.qtBase = qtBase;
	}

	public Double getVlFator() {
		return this.vlFator;
	}

	public void setVlFator(Double vlFator) {
		this.vlFator = vlFator;
	}

	public Integer getCdEmpresaOp() {
		return this.cdEmpresaOp;
	}

	public void setCdEmpresaOp(Integer cdEmpresaOp) {
		this.cdEmpresaOp = cdEmpresaOp;
	}

	@Override
	public String toString() {
		return "ListaProdutoItem [idListaProdutoItem=" + idListaProdutoItem + ", idListaProduto=" + idListaProduto
				+ ", componente=" + componente + ", qtProdutoComponente=" + qtProdutoComponente
				+ ", stComponentePrincipal=" + stComponentePrincipal + ", tpProduto=" + tpProduto + ", idPosicao="
				+ idPosicao + ", qtMedHorizontal=" + qtMedHorizontal + ", qtMedVertical=" + qtMedVertical
				+ ", dsModelo=" + dsModelo + ", stComponente=" + stComponente + ", stProdutoFantasma="
				+ stProdutoFantasma + ", vlPerdaHorizontal=" + vlPerdaHorizontal + ", vlPerdaVertical="
				+ vlPerdaVertical + ", qtRendimento=" + qtRendimento + ", qtPecaM2=" + qtPecaM2 + ", qtAproveitamento="
				+ qtAproveitamento + ", qtTotRendimento=" + qtTotRendimento + ", dtExclusao=" + dtExclusao
				+ ", idUsuarioExclusao=" + idUsuarioExclusao + ", qtBase=" + qtBase + ", vlFator=" + vlFator
				+ ", cdEmpresaOp=" + cdEmpresaOp + "]";
	}

}
