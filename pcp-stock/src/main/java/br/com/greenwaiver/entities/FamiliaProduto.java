package br.com.greenwaiver.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FamiliaProduto", schema = "dbo")
public class FamiliaProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idFamiliaProduto;
	private String cdChamada;
	private String nmFamiliaProduto;
	private String tpClassificacao;

	public FamiliaProduto() {
	}

	public FamiliaProduto(String idFamiliaProduto, String cdChamada, String nmFamiliaProduto, String tpClassificacao) {
		this.idFamiliaProduto = idFamiliaProduto;
		this.cdChamada = cdChamada;
		this.nmFamiliaProduto = nmFamiliaProduto;
		this.tpClassificacao = tpClassificacao;
	}

	public String getIdFamiliaProduto() {
		return idFamiliaProduto;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public String getNmFamiliaProduto() {
		return nmFamiliaProduto;
	}

	public String getTpClassificacao() {
		return tpClassificacao;
	}

	public void setIdFamiliaProduto(String idFamiliaProduto) {
		this.idFamiliaProduto = idFamiliaProduto;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public void setNmFamiliaProduto(String nmFamiliaProduto) {
		this.nmFamiliaProduto = nmFamiliaProduto;
	}

	public void setTpClassificacao(String tpClassificacao) {
		this.tpClassificacao = tpClassificacao;
	}

	@Override
	public String toString() {
		return "FamiliaProduto [idFamiliaProduto=" + idFamiliaProduto + ", cdChamada=" + cdChamada
				+ ", nmFamiliaProduto=" + nmFamiliaProduto + ", tpClassificacao=" + tpClassificacao + "]";
	}

}
