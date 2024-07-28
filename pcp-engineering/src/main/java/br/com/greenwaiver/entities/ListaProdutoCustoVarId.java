package br.com.greenwaiver.entities;

import javax.persistence.Embeddable;

// Generated 18 de jun. de 2023 18:46:59 by Hibernate Tools 5.6.14.Final

/**
 * ListaProdutoCustoVarId generated by hbm2java
 */
@Embeddable
public class ListaProdutoCustoVarId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String idListaCusto;
	private String idListaProduto;
	private String idCustoVariavel;
	private String cdChamada;
	private String dsCustoVariavel;
	private Double alCustoVariavel;

	public ListaProdutoCustoVarId() {
	}

	public ListaProdutoCustoVarId(String idListaCusto, String idListaProduto, String idCustoVariavel, String cdChamada,
			String dsCustoVariavel, Double alCustoVariavel) {
		this.idListaCusto = idListaCusto;
		this.idListaProduto = idListaProduto;
		this.idCustoVariavel = idCustoVariavel;
		this.cdChamada = cdChamada;
		this.dsCustoVariavel = dsCustoVariavel;
		this.alCustoVariavel = alCustoVariavel;
	}

	public String getIdListaCusto() {
		return this.idListaCusto;
	}

	public void setIdListaCusto(String idListaCusto) {
		this.idListaCusto = idListaCusto;
	}

	public String getIdListaProduto() {
		return this.idListaProduto;
	}

	public void setIdListaProduto(String idListaProduto) {
		this.idListaProduto = idListaProduto;
	}

	public String getIdCustoVariavel() {
		return this.idCustoVariavel;
	}

	public void setIdCustoVariavel(String idCustoVariavel) {
		this.idCustoVariavel = idCustoVariavel;
	}

	public String getCdChamada() {
		return this.cdChamada;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public String getDsCustoVariavel() {
		return this.dsCustoVariavel;
	}

	public void setDsCustoVariavel(String dsCustoVariavel) {
		this.dsCustoVariavel = dsCustoVariavel;
	}

	public Double getAlCustoVariavel() {
		return this.alCustoVariavel;
	}

	public void setAlCustoVariavel(Double alCustoVariavel) {
		this.alCustoVariavel = alCustoVariavel;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ListaProdutoCustoVarId))
			return false;
		ListaProdutoCustoVarId castOther = (ListaProdutoCustoVarId) other;

		return ((this.getIdListaCusto() == castOther.getIdListaCusto()) || (this.getIdListaCusto() != null
				&& castOther.getIdListaCusto() != null && this.getIdListaCusto().equals(castOther.getIdListaCusto())))
				&& ((this.getIdListaProduto() == castOther.getIdListaProduto())
						|| (this.getIdListaProduto() != null && castOther.getIdListaProduto() != null
								&& this.getIdListaProduto().equals(castOther.getIdListaProduto())))
				&& ((this.getIdCustoVariavel() == castOther.getIdCustoVariavel())
						|| (this.getIdCustoVariavel() != null && castOther.getIdCustoVariavel() != null
								&& this.getIdCustoVariavel().equals(castOther.getIdCustoVariavel())))
				&& ((this.getCdChamada() == castOther.getCdChamada()) || (this.getCdChamada() != null
						&& castOther.getCdChamada() != null && this.getCdChamada().equals(castOther.getCdChamada())))
				&& ((this.getDsCustoVariavel() == castOther.getDsCustoVariavel())
						|| (this.getDsCustoVariavel() != null && castOther.getDsCustoVariavel() != null
								&& this.getDsCustoVariavel().equals(castOther.getDsCustoVariavel())))
				&& ((this.getAlCustoVariavel() == castOther.getAlCustoVariavel())
						|| (this.getAlCustoVariavel() != null && castOther.getAlCustoVariavel() != null
								&& this.getAlCustoVariavel().equals(castOther.getAlCustoVariavel())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdListaCusto() == null ? 0 : this.getIdListaCusto().hashCode());
		result = 37 * result + (getIdListaProduto() == null ? 0 : this.getIdListaProduto().hashCode());
		result = 37 * result + (getIdCustoVariavel() == null ? 0 : this.getIdCustoVariavel().hashCode());
		result = 37 * result + (getCdChamada() == null ? 0 : this.getCdChamada().hashCode());
		result = 37 * result + (getDsCustoVariavel() == null ? 0 : this.getDsCustoVariavel().hashCode());
		result = 37 * result + (getAlCustoVariavel() == null ? 0 : this.getAlCustoVariavel().hashCode());
		return result;
	}

}
