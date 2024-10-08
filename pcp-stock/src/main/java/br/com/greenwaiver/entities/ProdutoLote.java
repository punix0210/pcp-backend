package br.com.greenwaiver.entities;
// Generated 18 de jun. de 2023 18:46:59 by Hibernate Tools 5.6.14.Final

import java.util.Date;

/**
 * ProdutoLote generated by hbm2java
 */
public class ProdutoLote implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idProdutoLote;
	private String idProduto;
	private String cdLoteProduto;
	private String cdLote;
	private Date dtFabricacao;
	private Date dtValidade;
	private Character stLoteGenerico;
	private String dsObservacao;
	private Double vlPesoBruto;
	private Double vlPesoLiquido;
	private Character stLotePerecivel;
	private Character stLoteAuxiliar;
	private String cdLoteEspecifico;
	private Date dtEntrada;
	private Character stLoteNovo;
	private char tpLote;
	private byte[] versaoRegistro;
	private String idProdutoLoteOrigem;

	public ProdutoLote() {
	}

	public ProdutoLote(String idProdutoLote, String idProduto, char tpLote) {
		this.idProdutoLote = idProdutoLote;
		this.idProduto = idProduto;
		this.tpLote = tpLote;
	}

	public ProdutoLote(String idProdutoLote, String idProduto, String cdLoteProduto, String cdLote, Date dtFabricacao,
			Date dtValidade, Character stLoteGenerico, String dsObservacao, Double vlPesoBruto, Double vlPesoLiquido,
			Character stLotePerecivel, Character stLoteAuxiliar, String cdLoteEspecifico, Date dtEntrada,
			Character stLoteNovo, char tpLote, byte[] versaoRegistro, String idProdutoLoteOrigem) {
		this.idProdutoLote = idProdutoLote;
		this.idProduto = idProduto;
		this.cdLoteProduto = cdLoteProduto;
		this.cdLote = cdLote;
		this.dtFabricacao = dtFabricacao;
		this.dtValidade = dtValidade;
		this.stLoteGenerico = stLoteGenerico;
		this.dsObservacao = dsObservacao;
		this.vlPesoBruto = vlPesoBruto;
		this.vlPesoLiquido = vlPesoLiquido;
		this.stLotePerecivel = stLotePerecivel;
		this.stLoteAuxiliar = stLoteAuxiliar;
		this.cdLoteEspecifico = cdLoteEspecifico;
		this.dtEntrada = dtEntrada;
		this.stLoteNovo = stLoteNovo;
		this.tpLote = tpLote;
		this.versaoRegistro = versaoRegistro;
		this.idProdutoLoteOrigem = idProdutoLoteOrigem;
	}

	public String getIdProdutoLote() {
		return this.idProdutoLote;
	}

	public void setIdProdutoLote(String idProdutoLote) {
		this.idProdutoLote = idProdutoLote;
	}

	public String getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getCdLoteProduto() {
		return this.cdLoteProduto;
	}

	public void setCdLoteProduto(String cdLoteProduto) {
		this.cdLoteProduto = cdLoteProduto;
	}

	public String getCdLote() {
		return this.cdLote;
	}

	public void setCdLote(String cdLote) {
		this.cdLote = cdLote;
	}

	public Date getDtFabricacao() {
		return this.dtFabricacao;
	}

	public void setDtFabricacao(Date dtFabricacao) {
		this.dtFabricacao = dtFabricacao;
	}

	public Date getDtValidade() {
		return this.dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public Character getStLoteGenerico() {
		return this.stLoteGenerico;
	}

	public void setStLoteGenerico(Character stLoteGenerico) {
		this.stLoteGenerico = stLoteGenerico;
	}

	public String getDsObservacao() {
		return this.dsObservacao;
	}

	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}

	public Double getVlPesoBruto() {
		return this.vlPesoBruto;
	}

	public void setVlPesoBruto(Double vlPesoBruto) {
		this.vlPesoBruto = vlPesoBruto;
	}

	public Double getVlPesoLiquido() {
		return this.vlPesoLiquido;
	}

	public void setVlPesoLiquido(Double vlPesoLiquido) {
		this.vlPesoLiquido = vlPesoLiquido;
	}

	public Character getStLotePerecivel() {
		return this.stLotePerecivel;
	}

	public void setStLotePerecivel(Character stLotePerecivel) {
		this.stLotePerecivel = stLotePerecivel;
	}

	public Character getStLoteAuxiliar() {
		return this.stLoteAuxiliar;
	}

	public void setStLoteAuxiliar(Character stLoteAuxiliar) {
		this.stLoteAuxiliar = stLoteAuxiliar;
	}

	public String getCdLoteEspecifico() {
		return this.cdLoteEspecifico;
	}

	public void setCdLoteEspecifico(String cdLoteEspecifico) {
		this.cdLoteEspecifico = cdLoteEspecifico;
	}

	public Date getDtEntrada() {
		return this.dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Character getStLoteNovo() {
		return this.stLoteNovo;
	}

	public void setStLoteNovo(Character stLoteNovo) {
		this.stLoteNovo = stLoteNovo;
	}

	public char getTpLote() {
		return this.tpLote;
	}

	public void setTpLote(char tpLote) {
		this.tpLote = tpLote;
	}

	public byte[] getVersaoRegistro() {
		return this.versaoRegistro;
	}

	public void setVersaoRegistro(byte[] versaoRegistro) {
		this.versaoRegistro = versaoRegistro;
	}

	public String getIdProdutoLoteOrigem() {
		return this.idProdutoLoteOrigem;
	}

	public void setIdProdutoLoteOrigem(String idProdutoLoteOrigem) {
		this.idProdutoLoteOrigem = idProdutoLoteOrigem;
	}

}
