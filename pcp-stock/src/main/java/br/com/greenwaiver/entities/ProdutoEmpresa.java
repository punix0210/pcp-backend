package br.com.greenwaiver.entities;
// Generated 18 de jun. de 2023 18:46:59 by Hibernate Tools 5.6.14.Final

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ProdutoEmpresa generated by hbm2java
 */
@Entity
@Table(name = "Produto_Empresa", schema = "dbo")
public class ProdutoEmpresa implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ProdutoEmpresaId id;
	private String dsLocalizacao;
	private Double qtCritica;
	private Double qtMinima;
	private Double qtMaxima;
	private Double alLucro;
	private Date dtUltimaAtualizacao;
	private Double qtPedidoCompra;
	private Double qtPedidoVenda;
	private Date dtInventario;
	private Double alLucroProduto;
	private Character tpClassificacaoAbc;
	private Integer nrRanking;
	private Date dtEstoqueEmpresa;
	private Character stComercializacao;
	private Double qtExposicaoMinima;
	private Double alIpicompra;
	private Double vlOutrasDespesas;
	private Double alIcmscompra;
	private Double alOutros;
	private Double alMarkup;
	private Double alIcmsvenda;
	private Double vlPrecoCusto;
	private Double vlPrecoSugerido;
	private Date dtUltimoInventario;
	private Double qtReservada;
	private Date dtCalculoConsumoMedio;
	private Double qtConsumoMedio;
	private Double qtProcessamento;
	private Double qtDiferencaAcumulada;
	private Double alLucroPretendido;
	private Character stAtivoCompra;
	private Character stAtivoVenda;
	private Character stCalculaIss;
	private Character tpTributacaoIss;
	private Character stTributadoMunicipioTomador;
	private Double alPiscompra;
	private Double alCofinscompra;
	private Integer nrSequencial;
	private Date dtLimiteVendaEmpresa;
	private Date dtLimiteCompraEmpresa;
	private byte[] versaoRegistro;
	private Integer nrDiasVendaMediaDiaria;
	private Integer nrDiasMovimentacao;
	private Integer nrDiasMaximoEstoque;
	private Integer nrDiasMinimoEstoque;
	private Date dtMovimentoEstoqueItem;
	private Date dtDescontoMedio;
	private Double qtCompraAcumulada;
	private Double alDescontoMedio;
	private Double alAcrescimoQuantidade;
	private String idCodigoTributacaoMunicipio;
	private String cdSituacaoOperacaoSn;
	private Character stTributacaoEspecificaPis;
	private Character stCalculaPis;
	private String cdSituacaoTributariaPis;
	private Double alPis;
	private Character stTributacaoEspecificaCofins;
	private Character stCalculaCofins;
	private String cdSituacaoTributariaCofins;
	private Double alCofins;
	private String cdSitTributPissaida;
	private String cdSitTributCofinssaida;
	private String cdSitTributPisentrada;
	private String cdSitTributCofinsentrada;
	private char tpCalculoIpicompra;
	private char tpCalculoIcmscompra;
	private char tpCalculoPiscompra;
	private char tpCalculoCofinscompra;
	private char tpCalculoOutrosValores;
	private char tpCalculoSubstituicaoTributaria;
	private char tpCalculoFrete;
	private char tpCalculoIcmsvenda;
	private char tpCalculoEncargosVenda;
	private Double vlLargura;
	private Double vlAltura;
	private Double vlProfundidade;
	private char stObrigaPreenchimentoFci;
	private String cdSituacaoOperacaoSnentrada;
	private Double vlAliquotaPis;
	private Double vlAliquotaCofins;
	private Double alIcmssubstTributaria;
	private Double vlOperacional;
	private Double alFrete;
	private Date dtUltimaAtualizacaoEstoque;
	private String cdSituacaoOperacaoSnsaidaPdv;

	public ProdutoEmpresa() {
	}

	public ProdutoEmpresa(ProdutoEmpresaId id, char tpCalculoIpicompra, char tpCalculoIcmscompra,
			char tpCalculoPiscompra, char tpCalculoCofinscompra, char tpCalculoOutrosValores,
			char tpCalculoSubstituicaoTributaria, char tpCalculoFrete, char tpCalculoIcmsvenda,
			char tpCalculoEncargosVenda, char stObrigaPreenchimentoFci) {
		this.id = id;
		this.tpCalculoIpicompra = tpCalculoIpicompra;
		this.tpCalculoIcmscompra = tpCalculoIcmscompra;
		this.tpCalculoPiscompra = tpCalculoPiscompra;
		this.tpCalculoCofinscompra = tpCalculoCofinscompra;
		this.tpCalculoOutrosValores = tpCalculoOutrosValores;
		this.tpCalculoSubstituicaoTributaria = tpCalculoSubstituicaoTributaria;
		this.tpCalculoFrete = tpCalculoFrete;
		this.tpCalculoIcmsvenda = tpCalculoIcmsvenda;
		this.tpCalculoEncargosVenda = tpCalculoEncargosVenda;
		this.stObrigaPreenchimentoFci = stObrigaPreenchimentoFci;
	}

	public ProdutoEmpresa(ProdutoEmpresaId id, String dsLocalizacao, Double qtCritica, Double qtMinima, Double qtMaxima,
			Double alLucro, Date dtUltimaAtualizacao, Double qtPedidoCompra, Double qtPedidoVenda, Date dtInventario,
			Double alLucroProduto, Character tpClassificacaoAbc, Integer nrRanking, Date dtEstoqueEmpresa,
			Character stComercializacao, Double qtExposicaoMinima, Double alIpicompra, Double vlOutrasDespesas,
			Double alIcmscompra, Double alOutros, Double alMarkup, Double alIcmsvenda, Double vlPrecoCusto,
			Double vlPrecoSugerido, Date dtUltimoInventario, Double qtReservada, Date dtCalculoConsumoMedio,
			Double qtConsumoMedio, Double qtProcessamento, Double qtDiferencaAcumulada, Double alLucroPretendido,
			Character stAtivoCompra, Character stAtivoVenda, Character stCalculaIss, Character tpTributacaoIss,
			Character stTributadoMunicipioTomador, Double alPiscompra, Double alCofinscompra, Integer nrSequencial,
			Date dtLimiteVendaEmpresa, Date dtLimiteCompraEmpresa, byte[] versaoRegistro,
			Integer nrDiasVendaMediaDiaria, Integer nrDiasMovimentacao, Integer nrDiasMaximoEstoque,
			Integer nrDiasMinimoEstoque, Date dtMovimentoEstoqueItem, Date dtDescontoMedio, Double qtCompraAcumulada,
			Double alDescontoMedio, Double alAcrescimoQuantidade, String idCodigoTributacaoMunicipio,
			String cdSituacaoOperacaoSn, Character stTributacaoEspecificaPis, Character stCalculaPis,
			String cdSituacaoTributariaPis, Double alPis, Character stTributacaoEspecificaCofins,
			Character stCalculaCofins, String cdSituacaoTributariaCofins, Double alCofins, String cdSitTributPissaida,
			String cdSitTributCofinssaida, String cdSitTributPisentrada, String cdSitTributCofinsentrada,
			char tpCalculoIpicompra, char tpCalculoIcmscompra, char tpCalculoPiscompra, char tpCalculoCofinscompra,
			char tpCalculoOutrosValores, char tpCalculoSubstituicaoTributaria, char tpCalculoFrete,
			char tpCalculoIcmsvenda, char tpCalculoEncargosVenda, Double vlLargura, Double vlAltura,
			Double vlProfundidade, char stObrigaPreenchimentoFci, String cdSituacaoOperacaoSnentrada,
			Double vlAliquotaPis, Double vlAliquotaCofins, Double alIcmssubstTributaria, Double vlOperacional,
			Double alFrete, Date dtUltimaAtualizacaoEstoque, String cdSituacaoOperacaoSnsaidaPdv) {
		this.id = id;
		this.dsLocalizacao = dsLocalizacao;
		this.qtCritica = qtCritica;
		this.qtMinima = qtMinima;
		this.qtMaxima = qtMaxima;
		this.alLucro = alLucro;
		this.dtUltimaAtualizacao = dtUltimaAtualizacao;
		this.qtPedidoCompra = qtPedidoCompra;
		this.qtPedidoVenda = qtPedidoVenda;
		this.dtInventario = dtInventario;
		this.alLucroProduto = alLucroProduto;
		this.tpClassificacaoAbc = tpClassificacaoAbc;
		this.nrRanking = nrRanking;
		this.dtEstoqueEmpresa = dtEstoqueEmpresa;
		this.stComercializacao = stComercializacao;
		this.qtExposicaoMinima = qtExposicaoMinima;
		this.alIpicompra = alIpicompra;
		this.vlOutrasDespesas = vlOutrasDespesas;
		this.alIcmscompra = alIcmscompra;
		this.alOutros = alOutros;
		this.alMarkup = alMarkup;
		this.alIcmsvenda = alIcmsvenda;
		this.vlPrecoCusto = vlPrecoCusto;
		this.vlPrecoSugerido = vlPrecoSugerido;
		this.dtUltimoInventario = dtUltimoInventario;
		this.qtReservada = qtReservada;
		this.dtCalculoConsumoMedio = dtCalculoConsumoMedio;
		this.qtConsumoMedio = qtConsumoMedio;
		this.qtProcessamento = qtProcessamento;
		this.qtDiferencaAcumulada = qtDiferencaAcumulada;
		this.alLucroPretendido = alLucroPretendido;
		this.stAtivoCompra = stAtivoCompra;
		this.stAtivoVenda = stAtivoVenda;
		this.stCalculaIss = stCalculaIss;
		this.tpTributacaoIss = tpTributacaoIss;
		this.stTributadoMunicipioTomador = stTributadoMunicipioTomador;
		this.alPiscompra = alPiscompra;
		this.alCofinscompra = alCofinscompra;
		this.nrSequencial = nrSequencial;
		this.dtLimiteVendaEmpresa = dtLimiteVendaEmpresa;
		this.dtLimiteCompraEmpresa = dtLimiteCompraEmpresa;
		this.versaoRegistro = versaoRegistro;
		this.nrDiasVendaMediaDiaria = nrDiasVendaMediaDiaria;
		this.nrDiasMovimentacao = nrDiasMovimentacao;
		this.nrDiasMaximoEstoque = nrDiasMaximoEstoque;
		this.nrDiasMinimoEstoque = nrDiasMinimoEstoque;
		this.dtMovimentoEstoqueItem = dtMovimentoEstoqueItem;
		this.dtDescontoMedio = dtDescontoMedio;
		this.qtCompraAcumulada = qtCompraAcumulada;
		this.alDescontoMedio = alDescontoMedio;
		this.alAcrescimoQuantidade = alAcrescimoQuantidade;
		this.idCodigoTributacaoMunicipio = idCodigoTributacaoMunicipio;
		this.cdSituacaoOperacaoSn = cdSituacaoOperacaoSn;
		this.stTributacaoEspecificaPis = stTributacaoEspecificaPis;
		this.stCalculaPis = stCalculaPis;
		this.cdSituacaoTributariaPis = cdSituacaoTributariaPis;
		this.alPis = alPis;
		this.stTributacaoEspecificaCofins = stTributacaoEspecificaCofins;
		this.stCalculaCofins = stCalculaCofins;
		this.cdSituacaoTributariaCofins = cdSituacaoTributariaCofins;
		this.alCofins = alCofins;
		this.cdSitTributPissaida = cdSitTributPissaida;
		this.cdSitTributCofinssaida = cdSitTributCofinssaida;
		this.cdSitTributPisentrada = cdSitTributPisentrada;
		this.cdSitTributCofinsentrada = cdSitTributCofinsentrada;
		this.tpCalculoIpicompra = tpCalculoIpicompra;
		this.tpCalculoIcmscompra = tpCalculoIcmscompra;
		this.tpCalculoPiscompra = tpCalculoPiscompra;
		this.tpCalculoCofinscompra = tpCalculoCofinscompra;
		this.tpCalculoOutrosValores = tpCalculoOutrosValores;
		this.tpCalculoSubstituicaoTributaria = tpCalculoSubstituicaoTributaria;
		this.tpCalculoFrete = tpCalculoFrete;
		this.tpCalculoIcmsvenda = tpCalculoIcmsvenda;
		this.tpCalculoEncargosVenda = tpCalculoEncargosVenda;
		this.vlLargura = vlLargura;
		this.vlAltura = vlAltura;
		this.vlProfundidade = vlProfundidade;
		this.stObrigaPreenchimentoFci = stObrigaPreenchimentoFci;
		this.cdSituacaoOperacaoSnentrada = cdSituacaoOperacaoSnentrada;
		this.vlAliquotaPis = vlAliquotaPis;
		this.vlAliquotaCofins = vlAliquotaCofins;
		this.alIcmssubstTributaria = alIcmssubstTributaria;
		this.vlOperacional = vlOperacional;
		this.alFrete = alFrete;
		this.dtUltimaAtualizacaoEstoque = dtUltimaAtualizacaoEstoque;
		this.cdSituacaoOperacaoSnsaidaPdv = cdSituacaoOperacaoSnsaidaPdv;
	}

	public ProdutoEmpresaId getId() {
		return this.id;
	}

	public void setId(ProdutoEmpresaId id) {
		this.id = id;
	}

	public String getDsLocalizacao() {
		return this.dsLocalizacao;
	}

	public void setDsLocalizacao(String dsLocalizacao) {
		this.dsLocalizacao = dsLocalizacao;
	}

	public Double getQtCritica() {
		return this.qtCritica;
	}

	public void setQtCritica(Double qtCritica) {
		this.qtCritica = qtCritica;
	}

	public Double getQtMinima() {
		return this.qtMinima;
	}

	public void setQtMinima(Double qtMinima) {
		this.qtMinima = qtMinima;
	}

	public Double getQtMaxima() {
		return this.qtMaxima;
	}

	public void setQtMaxima(Double qtMaxima) {
		this.qtMaxima = qtMaxima;
	}

	public Double getAlLucro() {
		return this.alLucro;
	}

	public void setAlLucro(Double alLucro) {
		this.alLucro = alLucro;
	}

	public Date getDtUltimaAtualizacao() {
		return this.dtUltimaAtualizacao;
	}

	public void setDtUltimaAtualizacao(Date dtUltimaAtualizacao) {
		this.dtUltimaAtualizacao = dtUltimaAtualizacao;
	}

	public Double getQtPedidoCompra() {
		return this.qtPedidoCompra;
	}

	public void setQtPedidoCompra(Double qtPedidoCompra) {
		this.qtPedidoCompra = qtPedidoCompra;
	}

	public Double getQtPedidoVenda() {
		return this.qtPedidoVenda;
	}

	public void setQtPedidoVenda(Double qtPedidoVenda) {
		this.qtPedidoVenda = qtPedidoVenda;
	}

	public Date getDtInventario() {
		return this.dtInventario;
	}

	public void setDtInventario(Date dtInventario) {
		this.dtInventario = dtInventario;
	}

	public Double getAlLucroProduto() {
		return this.alLucroProduto;
	}

	public void setAlLucroProduto(Double alLucroProduto) {
		this.alLucroProduto = alLucroProduto;
	}

	public Character getTpClassificacaoAbc() {
		return this.tpClassificacaoAbc;
	}

	public void setTpClassificacaoAbc(Character tpClassificacaoAbc) {
		this.tpClassificacaoAbc = tpClassificacaoAbc;
	}

	public Integer getNrRanking() {
		return this.nrRanking;
	}

	public void setNrRanking(Integer nrRanking) {
		this.nrRanking = nrRanking;
	}

	public Date getDtEstoqueEmpresa() {
		return this.dtEstoqueEmpresa;
	}

	public void setDtEstoqueEmpresa(Date dtEstoqueEmpresa) {
		this.dtEstoqueEmpresa = dtEstoqueEmpresa;
	}

	public Character getStComercializacao() {
		return this.stComercializacao;
	}

	public void setStComercializacao(Character stComercializacao) {
		this.stComercializacao = stComercializacao;
	}

	public Double getQtExposicaoMinima() {
		return this.qtExposicaoMinima;
	}

	public void setQtExposicaoMinima(Double qtExposicaoMinima) {
		this.qtExposicaoMinima = qtExposicaoMinima;
	}

	public Double getAlIpicompra() {
		return this.alIpicompra;
	}

	public void setAlIpicompra(Double alIpicompra) {
		this.alIpicompra = alIpicompra;
	}

	public Double getVlOutrasDespesas() {
		return this.vlOutrasDespesas;
	}

	public void setVlOutrasDespesas(Double vlOutrasDespesas) {
		this.vlOutrasDespesas = vlOutrasDespesas;
	}

	public Double getAlIcmscompra() {
		return this.alIcmscompra;
	}

	public void setAlIcmscompra(Double alIcmscompra) {
		this.alIcmscompra = alIcmscompra;
	}

	public Double getAlOutros() {
		return this.alOutros;
	}

	public void setAlOutros(Double alOutros) {
		this.alOutros = alOutros;
	}

	public Double getAlMarkup() {
		return this.alMarkup;
	}

	public void setAlMarkup(Double alMarkup) {
		this.alMarkup = alMarkup;
	}

	public Double getAlIcmsvenda() {
		return this.alIcmsvenda;
	}

	public void setAlIcmsvenda(Double alIcmsvenda) {
		this.alIcmsvenda = alIcmsvenda;
	}

	public Double getVlPrecoCusto() {
		return this.vlPrecoCusto;
	}

	public void setVlPrecoCusto(Double vlPrecoCusto) {
		this.vlPrecoCusto = vlPrecoCusto;
	}

	public Double getVlPrecoSugerido() {
		return this.vlPrecoSugerido;
	}

	public void setVlPrecoSugerido(Double vlPrecoSugerido) {
		this.vlPrecoSugerido = vlPrecoSugerido;
	}

	public Date getDtUltimoInventario() {
		return this.dtUltimoInventario;
	}

	public void setDtUltimoInventario(Date dtUltimoInventario) {
		this.dtUltimoInventario = dtUltimoInventario;
	}

	public Double getQtReservada() {
		return this.qtReservada;
	}

	public void setQtReservada(Double qtReservada) {
		this.qtReservada = qtReservada;
	}

	public Date getDtCalculoConsumoMedio() {
		return this.dtCalculoConsumoMedio;
	}

	public void setDtCalculoConsumoMedio(Date dtCalculoConsumoMedio) {
		this.dtCalculoConsumoMedio = dtCalculoConsumoMedio;
	}

	public Double getQtConsumoMedio() {
		return this.qtConsumoMedio;
	}

	public void setQtConsumoMedio(Double qtConsumoMedio) {
		this.qtConsumoMedio = qtConsumoMedio;
	}

	public Double getQtProcessamento() {
		return this.qtProcessamento;
	}

	public void setQtProcessamento(Double qtProcessamento) {
		this.qtProcessamento = qtProcessamento;
	}

	public Double getQtDiferencaAcumulada() {
		return this.qtDiferencaAcumulada;
	}

	public void setQtDiferencaAcumulada(Double qtDiferencaAcumulada) {
		this.qtDiferencaAcumulada = qtDiferencaAcumulada;
	}

	public Double getAlLucroPretendido() {
		return this.alLucroPretendido;
	}

	public void setAlLucroPretendido(Double alLucroPretendido) {
		this.alLucroPretendido = alLucroPretendido;
	}

	public Character getStAtivoCompra() {
		return this.stAtivoCompra;
	}

	public void setStAtivoCompra(Character stAtivoCompra) {
		this.stAtivoCompra = stAtivoCompra;
	}

	public Character getStAtivoVenda() {
		return this.stAtivoVenda;
	}

	public void setStAtivoVenda(Character stAtivoVenda) {
		this.stAtivoVenda = stAtivoVenda;
	}

	public Character getStCalculaIss() {
		return this.stCalculaIss;
	}

	public void setStCalculaIss(Character stCalculaIss) {
		this.stCalculaIss = stCalculaIss;
	}

	public Character getTpTributacaoIss() {
		return this.tpTributacaoIss;
	}

	public void setTpTributacaoIss(Character tpTributacaoIss) {
		this.tpTributacaoIss = tpTributacaoIss;
	}

	public Character getStTributadoMunicipioTomador() {
		return this.stTributadoMunicipioTomador;
	}

	public void setStTributadoMunicipioTomador(Character stTributadoMunicipioTomador) {
		this.stTributadoMunicipioTomador = stTributadoMunicipioTomador;
	}

	public Double getAlPiscompra() {
		return this.alPiscompra;
	}

	public void setAlPiscompra(Double alPiscompra) {
		this.alPiscompra = alPiscompra;
	}

	public Double getAlCofinscompra() {
		return this.alCofinscompra;
	}

	public void setAlCofinscompra(Double alCofinscompra) {
		this.alCofinscompra = alCofinscompra;
	}

	public Integer getNrSequencial() {
		return this.nrSequencial;
	}

	public void setNrSequencial(Integer nrSequencial) {
		this.nrSequencial = nrSequencial;
	}

	public Date getDtLimiteVendaEmpresa() {
		return this.dtLimiteVendaEmpresa;
	}

	public void setDtLimiteVendaEmpresa(Date dtLimiteVendaEmpresa) {
		this.dtLimiteVendaEmpresa = dtLimiteVendaEmpresa;
	}

	public Date getDtLimiteCompraEmpresa() {
		return this.dtLimiteCompraEmpresa;
	}

	public void setDtLimiteCompraEmpresa(Date dtLimiteCompraEmpresa) {
		this.dtLimiteCompraEmpresa = dtLimiteCompraEmpresa;
	}

	public byte[] getVersaoRegistro() {
		return this.versaoRegistro;
	}

	public void setVersaoRegistro(byte[] versaoRegistro) {
		this.versaoRegistro = versaoRegistro;
	}

	public Integer getNrDiasVendaMediaDiaria() {
		return this.nrDiasVendaMediaDiaria;
	}

	public void setNrDiasVendaMediaDiaria(Integer nrDiasVendaMediaDiaria) {
		this.nrDiasVendaMediaDiaria = nrDiasVendaMediaDiaria;
	}

	public Integer getNrDiasMovimentacao() {
		return this.nrDiasMovimentacao;
	}

	public void setNrDiasMovimentacao(Integer nrDiasMovimentacao) {
		this.nrDiasMovimentacao = nrDiasMovimentacao;
	}

	public Integer getNrDiasMaximoEstoque() {
		return this.nrDiasMaximoEstoque;
	}

	public void setNrDiasMaximoEstoque(Integer nrDiasMaximoEstoque) {
		this.nrDiasMaximoEstoque = nrDiasMaximoEstoque;
	}

	public Integer getNrDiasMinimoEstoque() {
		return this.nrDiasMinimoEstoque;
	}

	public void setNrDiasMinimoEstoque(Integer nrDiasMinimoEstoque) {
		this.nrDiasMinimoEstoque = nrDiasMinimoEstoque;
	}

	public Date getDtMovimentoEstoqueItem() {
		return this.dtMovimentoEstoqueItem;
	}

	public void setDtMovimentoEstoqueItem(Date dtMovimentoEstoqueItem) {
		this.dtMovimentoEstoqueItem = dtMovimentoEstoqueItem;
	}

	public Date getDtDescontoMedio() {
		return this.dtDescontoMedio;
	}

	public void setDtDescontoMedio(Date dtDescontoMedio) {
		this.dtDescontoMedio = dtDescontoMedio;
	}

	public Double getQtCompraAcumulada() {
		return this.qtCompraAcumulada;
	}

	public void setQtCompraAcumulada(Double qtCompraAcumulada) {
		this.qtCompraAcumulada = qtCompraAcumulada;
	}

	public Double getAlDescontoMedio() {
		return this.alDescontoMedio;
	}

	public void setAlDescontoMedio(Double alDescontoMedio) {
		this.alDescontoMedio = alDescontoMedio;
	}

	public Double getAlAcrescimoQuantidade() {
		return this.alAcrescimoQuantidade;
	}

	public void setAlAcrescimoQuantidade(Double alAcrescimoQuantidade) {
		this.alAcrescimoQuantidade = alAcrescimoQuantidade;
	}

	public String getIdCodigoTributacaoMunicipio() {
		return this.idCodigoTributacaoMunicipio;
	}

	public void setIdCodigoTributacaoMunicipio(String idCodigoTributacaoMunicipio) {
		this.idCodigoTributacaoMunicipio = idCodigoTributacaoMunicipio;
	}

	public String getCdSituacaoOperacaoSn() {
		return this.cdSituacaoOperacaoSn;
	}

	public void setCdSituacaoOperacaoSn(String cdSituacaoOperacaoSn) {
		this.cdSituacaoOperacaoSn = cdSituacaoOperacaoSn;
	}

	public Character getStTributacaoEspecificaPis() {
		return this.stTributacaoEspecificaPis;
	}

	public void setStTributacaoEspecificaPis(Character stTributacaoEspecificaPis) {
		this.stTributacaoEspecificaPis = stTributacaoEspecificaPis;
	}

	public Character getStCalculaPis() {
		return this.stCalculaPis;
	}

	public void setStCalculaPis(Character stCalculaPis) {
		this.stCalculaPis = stCalculaPis;
	}

	public String getCdSituacaoTributariaPis() {
		return this.cdSituacaoTributariaPis;
	}

	public void setCdSituacaoTributariaPis(String cdSituacaoTributariaPis) {
		this.cdSituacaoTributariaPis = cdSituacaoTributariaPis;
	}

	public Double getAlPis() {
		return this.alPis;
	}

	public void setAlPis(Double alPis) {
		this.alPis = alPis;
	}

	public Character getStTributacaoEspecificaCofins() {
		return this.stTributacaoEspecificaCofins;
	}

	public void setStTributacaoEspecificaCofins(Character stTributacaoEspecificaCofins) {
		this.stTributacaoEspecificaCofins = stTributacaoEspecificaCofins;
	}

	public Character getStCalculaCofins() {
		return this.stCalculaCofins;
	}

	public void setStCalculaCofins(Character stCalculaCofins) {
		this.stCalculaCofins = stCalculaCofins;
	}

	public String getCdSituacaoTributariaCofins() {
		return this.cdSituacaoTributariaCofins;
	}

	public void setCdSituacaoTributariaCofins(String cdSituacaoTributariaCofins) {
		this.cdSituacaoTributariaCofins = cdSituacaoTributariaCofins;
	}

	public Double getAlCofins() {
		return this.alCofins;
	}

	public void setAlCofins(Double alCofins) {
		this.alCofins = alCofins;
	}

	public String getCdSitTributPissaida() {
		return this.cdSitTributPissaida;
	}

	public void setCdSitTributPissaida(String cdSitTributPissaida) {
		this.cdSitTributPissaida = cdSitTributPissaida;
	}

	public String getCdSitTributCofinssaida() {
		return this.cdSitTributCofinssaida;
	}

	public void setCdSitTributCofinssaida(String cdSitTributCofinssaida) {
		this.cdSitTributCofinssaida = cdSitTributCofinssaida;
	}

	public String getCdSitTributPisentrada() {
		return this.cdSitTributPisentrada;
	}

	public void setCdSitTributPisentrada(String cdSitTributPisentrada) {
		this.cdSitTributPisentrada = cdSitTributPisentrada;
	}

	public String getCdSitTributCofinsentrada() {
		return this.cdSitTributCofinsentrada;
	}

	public void setCdSitTributCofinsentrada(String cdSitTributCofinsentrada) {
		this.cdSitTributCofinsentrada = cdSitTributCofinsentrada;
	}

	public char getTpCalculoIpicompra() {
		return this.tpCalculoIpicompra;
	}

	public void setTpCalculoIpicompra(char tpCalculoIpicompra) {
		this.tpCalculoIpicompra = tpCalculoIpicompra;
	}

	public char getTpCalculoIcmscompra() {
		return this.tpCalculoIcmscompra;
	}

	public void setTpCalculoIcmscompra(char tpCalculoIcmscompra) {
		this.tpCalculoIcmscompra = tpCalculoIcmscompra;
	}

	public char getTpCalculoPiscompra() {
		return this.tpCalculoPiscompra;
	}

	public void setTpCalculoPiscompra(char tpCalculoPiscompra) {
		this.tpCalculoPiscompra = tpCalculoPiscompra;
	}

	public char getTpCalculoCofinscompra() {
		return this.tpCalculoCofinscompra;
	}

	public void setTpCalculoCofinscompra(char tpCalculoCofinscompra) {
		this.tpCalculoCofinscompra = tpCalculoCofinscompra;
	}

	public char getTpCalculoOutrosValores() {
		return this.tpCalculoOutrosValores;
	}

	public void setTpCalculoOutrosValores(char tpCalculoOutrosValores) {
		this.tpCalculoOutrosValores = tpCalculoOutrosValores;
	}

	public char getTpCalculoSubstituicaoTributaria() {
		return this.tpCalculoSubstituicaoTributaria;
	}

	public void setTpCalculoSubstituicaoTributaria(char tpCalculoSubstituicaoTributaria) {
		this.tpCalculoSubstituicaoTributaria = tpCalculoSubstituicaoTributaria;
	}

	public char getTpCalculoFrete() {
		return this.tpCalculoFrete;
	}

	public void setTpCalculoFrete(char tpCalculoFrete) {
		this.tpCalculoFrete = tpCalculoFrete;
	}

	public char getTpCalculoIcmsvenda() {
		return this.tpCalculoIcmsvenda;
	}

	public void setTpCalculoIcmsvenda(char tpCalculoIcmsvenda) {
		this.tpCalculoIcmsvenda = tpCalculoIcmsvenda;
	}

	public char getTpCalculoEncargosVenda() {
		return this.tpCalculoEncargosVenda;
	}

	public void setTpCalculoEncargosVenda(char tpCalculoEncargosVenda) {
		this.tpCalculoEncargosVenda = tpCalculoEncargosVenda;
	}

	public Double getVlLargura() {
		return this.vlLargura;
	}

	public void setVlLargura(Double vlLargura) {
		this.vlLargura = vlLargura;
	}

	public Double getVlAltura() {
		return this.vlAltura;
	}

	public void setVlAltura(Double vlAltura) {
		this.vlAltura = vlAltura;
	}

	public Double getVlProfundidade() {
		return this.vlProfundidade;
	}

	public void setVlProfundidade(Double vlProfundidade) {
		this.vlProfundidade = vlProfundidade;
	}

	public char getStObrigaPreenchimentoFci() {
		return this.stObrigaPreenchimentoFci;
	}

	public void setStObrigaPreenchimentoFci(char stObrigaPreenchimentoFci) {
		this.stObrigaPreenchimentoFci = stObrigaPreenchimentoFci;
	}

	public String getCdSituacaoOperacaoSnentrada() {
		return this.cdSituacaoOperacaoSnentrada;
	}

	public void setCdSituacaoOperacaoSnentrada(String cdSituacaoOperacaoSnentrada) {
		this.cdSituacaoOperacaoSnentrada = cdSituacaoOperacaoSnentrada;
	}

	public Double getVlAliquotaPis() {
		return this.vlAliquotaPis;
	}

	public void setVlAliquotaPis(Double vlAliquotaPis) {
		this.vlAliquotaPis = vlAliquotaPis;
	}

	public Double getVlAliquotaCofins() {
		return this.vlAliquotaCofins;
	}

	public void setVlAliquotaCofins(Double vlAliquotaCofins) {
		this.vlAliquotaCofins = vlAliquotaCofins;
	}

	public Double getAlIcmssubstTributaria() {
		return this.alIcmssubstTributaria;
	}

	public void setAlIcmssubstTributaria(Double alIcmssubstTributaria) {
		this.alIcmssubstTributaria = alIcmssubstTributaria;
	}

	public Double getVlOperacional() {
		return this.vlOperacional;
	}

	public void setVlOperacional(Double vlOperacional) {
		this.vlOperacional = vlOperacional;
	}

	public Double getAlFrete() {
		return this.alFrete;
	}

	public void setAlFrete(Double alFrete) {
		this.alFrete = alFrete;
	}

	public Date getDtUltimaAtualizacaoEstoque() {
		return this.dtUltimaAtualizacaoEstoque;
	}

	public void setDtUltimaAtualizacaoEstoque(Date dtUltimaAtualizacaoEstoque) {
		this.dtUltimaAtualizacaoEstoque = dtUltimaAtualizacaoEstoque;
	}

	public String getCdSituacaoOperacaoSnsaidaPdv() {
		return this.cdSituacaoOperacaoSnsaidaPdv;
	}

	public void setCdSituacaoOperacaoSnsaidaPdv(String cdSituacaoOperacaoSnsaidaPdv) {
		this.cdSituacaoOperacaoSnsaidaPdv = cdSituacaoOperacaoSnsaidaPdv;
	}

}
