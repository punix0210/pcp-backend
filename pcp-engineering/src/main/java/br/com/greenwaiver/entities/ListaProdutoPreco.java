package br.com.greenwaiver.entities;
// Generated 18 de jun. de 2023 18:46:59 by Hibernate Tools 5.6.14.Final

/**
 * ListaProdutoPreco generated by hbm2java
 */
public class ListaProdutoPreco implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ListaProdutoPrecoId id;

	public ListaProdutoPreco() {
	}

	public ListaProdutoPreco(ListaProdutoPrecoId id) {
		this.id = id;
	}

	public ListaProdutoPrecoId getId() {
		return this.id;
	}

	public void setId(ListaProdutoPrecoId id) {
		this.id = id;
	}

}
