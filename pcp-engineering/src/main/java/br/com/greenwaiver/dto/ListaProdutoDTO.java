package br.com.greenwaiver.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.greenwaiver.entities.ListaProduto;

public class ListaProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idListaProduto;
	private String cdChamada;
	private String dsListaproduto;
	private Date dtUltimaAlteracao;
	private Character stPrincipal;
	private Character stAtivo;

	public ListaProdutoDTO(ListaProduto p) {
		this.idListaProduto = p.getIdListaProduto();
		this.cdChamada = p.getCdChamada();
		this.dsListaproduto = p.getDsListaproduto();
		this.dtUltimaAlteracao = p.getDtUltimaAlteracao();
		this.stPrincipal = p.getStPrincipal();
		this.stAtivo = p.getStAtivo();
	}

	public String getIdListaProduto() {
		return idListaProduto;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public String getDsListaproduto() {
		return dsListaproduto;
	}

	public Date getDtUltimaAlteracao() {
		return dtUltimaAlteracao;
	}

	public Character getStPrincipal() {
		return stPrincipal;
	}

	public Character getStAtivo() {
		return stAtivo;
	}

	public void setIdListaProduto(String idListaProduto) {
		this.idListaProduto = idListaProduto;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public void setDsListaproduto(String dsListaproduto) {
		this.dsListaproduto = dsListaproduto;
	}

	public void setDtUltimaAlteracao(Date dtUltimaAlteracao) {
		this.dtUltimaAlteracao = dtUltimaAlteracao;
	}

	public void setStPrincipal(Character stPrincipal) {
		this.stPrincipal = stPrincipal;
	}

	public void setStAtivo(Character stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Override
	public String toString() {
		return "ListaProdutoDTO [idListaProduto=" + idListaProduto + ", cdChamada=" + cdChamada + ", dsListaproduto="
				+ dsListaproduto + ", dtUltimaAlteracao=" + dtUltimaAlteracao + ", stPrincipal=" + stPrincipal
				+ ", stAtivo=" + stAtivo + "]";
	}

}
