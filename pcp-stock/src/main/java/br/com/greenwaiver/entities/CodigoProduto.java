package br.com.greenwaiver.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CodigoProduto", schema = "dbo")
public class CodigoProduto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	String idCodigoProduto;
	
	String cdChamada;
	
	String idProduto;
	
	String idTipoCodigoProduto;
	
	String stCodigoPrincipal;

	public CodigoProduto() {
	}

	public CodigoProduto(String idCodigoProduto, String cdChamada, String idProduto, String idTipoCodigoProduto,
			String stCodigoPrincipal) {
		this.idCodigoProduto = idCodigoProduto;
		this.cdChamada = cdChamada;
		this.idProduto = idProduto;
		this.idTipoCodigoProduto = idTipoCodigoProduto;
		this.stCodigoPrincipal = stCodigoPrincipal;
	}

	public String getIdCodigoProduto() {
		return idCodigoProduto;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public String getIdTipoCodigoProduto() {
		return idTipoCodigoProduto;
	}

	public String getStCodigoPrincipal() {
		return stCodigoPrincipal;
	}

	@Override
	public String toString() {
		return "CodigoProduto [cdChamada=" + cdChamada + ", stCodigoPrincipal=" + stCodigoPrincipal + "]";
	}

	
}
