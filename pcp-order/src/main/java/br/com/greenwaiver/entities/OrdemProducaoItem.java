package br.com.greenwaiver.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrdemProducaoItem", schema = "wpcp")
public class OrdemProducaoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String idOrdemProducaoItem;
	private String idOrdemProducao;

	@ManyToOne
	@JoinColumn(name = "IdProduto", referencedColumnName = "IdProduto")
	private Produto componente;

	private Double qtProduzir;
	private String idListaProduto;
	private String stComponentePrincipal;
	private String stProdutoFantasma;
	private Double qtProdutoComponente;
	private String idListaProdutoItem;
	private String tpProduto;
	private String idPosicao;
	private Double qtMedHorizontal;
	private Double qtMedVertical;
	private String dsModelo;
	private String stComponente;
	private String stOrdemItem;
	private String idProduto;
	private Double qtSolicitada;
	private BigDecimal vlCusto;
	private BigDecimal vlCustoBase;
	private BigDecimal vlCustoTotal;
	private BigDecimal vlPerdaHorizontal;
	private BigDecimal vlPerdaVertical;
	private LocalDateTime dtNecessidade;
	private Double qtProdutoComponenteORI;
	private Double qtFatorRendimento;
	private Double qtAproveitamento;
	private Double qtRendimento;
	private Double qtTotRendimento;
	private Double qtPecaM2;
	private Double alDesperdicio;

}
