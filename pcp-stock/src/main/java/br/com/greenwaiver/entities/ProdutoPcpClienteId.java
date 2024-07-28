package br.com.greenwaiver.entities;
// Generated 18 de jun. de 2023 18:46:59 by Hibernate Tools 5.6.14.Final

/**
 * ProdutoPcpClienteId generated by hbm2java
 */
public class ProdutoPcpClienteId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idProduto;
	private String idPessoa;

	public ProdutoPcpClienteId() {
	}

	public ProdutoPcpClienteId(String idProduto, String idPessoa) {
		this.idProduto = idProduto;
		this.idPessoa = idPessoa;
	}

	public String getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(String idPessoa) {
		this.idPessoa = idPessoa;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProdutoPcpClienteId))
			return false;
		ProdutoPcpClienteId castOther = (ProdutoPcpClienteId) other;

		return ((this.getIdProduto() == castOther.getIdProduto()) || (this.getIdProduto() != null
				&& castOther.getIdProduto() != null && this.getIdProduto().equals(castOther.getIdProduto())))
				&& ((this.getIdPessoa() == castOther.getIdPessoa()) || (this.getIdPessoa() != null
						&& castOther.getIdPessoa() != null && this.getIdPessoa().equals(castOther.getIdPessoa())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdProduto() == null ? 0 : this.getIdProduto().hashCode());
		result = 37 * result + (getIdPessoa() == null ? 0 : this.getIdPessoa().hashCode());
		return result;
	}

}
