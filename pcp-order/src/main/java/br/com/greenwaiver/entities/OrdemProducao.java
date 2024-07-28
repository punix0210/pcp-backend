package br.com.greenwaiver.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrdemProducao", schema = "wpcp")
public class OrdemProducao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String idOrdemProducao;
	private String cdChamada;
	private String idEntidadeOrigem;
	private String nmEntidadeOrigem;
	private String dsOrdemProducao;
	private String idUsuario;
	private LocalDateTime dtCadastro;

	@ManyToOne
	@JoinColumn(name = "IdProduto", referencedColumnName = "IdProduto")
	private Produto produto;
	
	private Double qtProduto;
	private String stOrdem;
	private String idListaProduto;
	private Double qtSolicitada;
	private Double qtAtendida;
	private Double qtEstoque;
	private LocalDateTime dtPrevInicio;
	private LocalDateTime dtPrevTerminio;
	private Integer cdEmpresa;
	private String tpOrdemOrigem;
	private String idEntidadeOrigemItem;
	private String tpAtendimento;
	private Double qtPendente;
	private String tpFixacao;
	private Double qtEmpenho;
	private String stProdutoFantasma;
	private String dsListaproduto;
	private Double vlCusto;
	private String stOrdemComplementar;
	private String tpCusto;
	private String idPrecoCusto;
	private LocalDateTime dtExclusao;
	private String idOrdemProducaoAglutinacao;
	private LocalDateTime dtCustoReferencia;
	private Double qtInfGeral;
	private LocalDateTime dtLimiteProducao;
	private String idInformacaoGeral;
	private String idMaquina;
	private String seqPrioridade;
	private String idSituacaoOrdemMaq;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "IdOrdemProducao", referencedColumnName = "IdOrdemProducao")
	private List<OrdemProducaoItem> itens = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "IdOrdemProducao", referencedColumnName = "IdOrdemProducao")
	private List<OrdemOperacaoRoteiro> operacoes = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "IdOrdemProducao", referencedColumnName = "IdOrdemProducao")
	private List<OrdemProcessoProducao> processos = new ArrayList<>();	

}
