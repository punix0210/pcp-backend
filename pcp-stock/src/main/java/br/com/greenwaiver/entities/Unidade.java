package br.com.greenwaiver.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Unidade", schema = "dbo")
public class Unidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idUnidade;
	private String cdChamada;
	private String cdSigla;
	private String tpUnidade;
	
	public Unidade() {}

	public Unidade(String idUnidade, String cdChamada, String cdSigla, String tpUnidade) {
		this.idUnidade = idUnidade;
		this.cdChamada = cdChamada;
		this.cdSigla = cdSigla;
		this.tpUnidade = tpUnidade;
	}

	public String getIdUnidade() {
		return idUnidade;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public String getCdSigla() {
		return cdSigla;
	}

	public String getTpUnidade() {
		return tpUnidade;
	}

	public void setIdUnidade(String idUnidade) {
		this.idUnidade = idUnidade;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public void setCdSigla(String cdSigla) {
		this.cdSigla = cdSigla;
	}

	public void setTpUnidade(String tpUnidade) {
		this.tpUnidade = tpUnidade;
	}

	@Override
	public String toString() {
		return "Unidade [idUnidade=" + idUnidade + ", cdChamada=" + cdChamada + ", cdSigla=" + cdSigla + ", tpUnidade="
				+ tpUnidade + "]";
	}

}
