package br.com.greenwaiver.entities;
// Generated 18 de jun. de 2023 18:46:59 by Hibernate Tools 5.6.14.Final

/**
 * ProdutoPcpEmpresaId generated by hbm2java
 */
public class ProdutoPcpEmpresaId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cdEmpresa;
	private String idProduto;
	private Character tpProduto;

	public ProdutoPcpEmpresaId() {
	}

	public ProdutoPcpEmpresaId(Integer cdEmpresa, String idProduto, Character tpProduto) {
		this.cdEmpresa = cdEmpresa;
		this.idProduto = idProduto;
		this.tpProduto = tpProduto;
	}

	public Integer getCdEmpresa() {
		return this.cdEmpresa;
	}

	public void setCdEmpresa(Integer cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public Character getTpProduto() {
		return this.tpProduto;
	}

	public void setTpProduto(Character tpProduto) {
		this.tpProduto = tpProduto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProdutoPcpEmpresaId))
			return false;
		ProdutoPcpEmpresaId castOther = (ProdutoPcpEmpresaId) other;

		return ((this.getCdEmpresa() == castOther.getCdEmpresa()) || (this.getCdEmpresa() != null
				&& castOther.getCdEmpresa() != null && this.getCdEmpresa().equals(castOther.getCdEmpresa())))
				&& ((this.getIdProduto() == castOther.getIdProduto()) || (this.getIdProduto() != null
						&& castOther.getIdProduto() != null && this.getIdProduto().equals(castOther.getIdProduto())))
				&& ((this.getTpProduto() == castOther.getTpProduto()) || (this.getTpProduto() != null
						&& castOther.getTpProduto() != null && this.getTpProduto().equals(castOther.getTpProduto())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCdEmpresa() == null ? 0 : this.getCdEmpresa().hashCode());
		result = 37 * result + (getIdProduto() == null ? 0 : this.getIdProduto().hashCode());
		result = 37 * result + (getTpProduto() == null ? 0 : this.getTpProduto().hashCode());
		return result;
	}

}
