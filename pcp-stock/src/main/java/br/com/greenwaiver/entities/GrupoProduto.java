package br.com.greenwaiver.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GrupoProduto", schema = "dbo")
public class GrupoProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String idGrupoProduto;
	private String cdChamada;
	private String nmGrupoProduto;
	
	public GrupoProduto() {}

	public GrupoProduto(String idGrupoProduto, String cdChamada, String nmGrupoProduto) {
		this.idGrupoProduto = idGrupoProduto;
		this.cdChamada = cdChamada;
		this.nmGrupoProduto = nmGrupoProduto;
	}

	public String getIdGrupoProduto() {
		return idGrupoProduto;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public String getNmGrupoProduto() {
		return nmGrupoProduto;
	}

	public void setIdGrupoProduto(String idGrupoProduto) {
		this.idGrupoProduto = idGrupoProduto;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public void setNmGrupoProduto(String nmGrupoProduto) {
		this.nmGrupoProduto = nmGrupoProduto;
	}

	@Override
	public String toString() {
		return "GrupoProduto [idGrupoProduto=" + idGrupoProduto + ", cdChamada=" + cdChamada + ", nmGrupoProduto="
				+ nmGrupoProduto + "]";
	}

}
