package br.com.greenwaiver.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrdemProducao_ProcessoProducao", schema = "wpcp")
public class OrdemProcessoProducao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProcessoProducaoID id;
	private String cdSequencia;
	private String dsProcessoProducao;
	private String idProduto;
	private String idListaProduto;
	private String idCentroTrabalho;
	private String idRecurso;
	private Integer qtRecurso;
	private String leadTime;
	private BigDecimal vlCusto;
	private Double qtSolicitada;

}
