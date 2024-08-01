package br.com.greenwaiver.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ProductsMoveDTO {
	private String idOrdemProducao;
	private String cdChamada;
	private Date dtCadastro;
	private String stOrdem;
	private Double qtAtendida;
	private Timestamp dtPrevInicio;
	private Timestamp dtPrevTerminio;
	private Timestamp dtLimiteProducao;
	private Integer cdEmpresa;
	private Boolean isSubOrdem;
	private String idProduto;
	private String cdProduto;
	private String nmProduto;
	private Double qtProduto;
	private String idInformacaoGeral;
	private String tpInformacaoGeralOP;
	private String dsInformacaoGeral;
	private String tpFixacao;
	private String tpAtendimento;
	private String tpOrdemOrigem;
	private Double qtAtender;
	private Timestamp dtExclusao;
	private String cdSigla;
	private String tpProduto;
	private String idMaquina;
	private String dsMaquina;
	private String seqPrioridade;
	private Double qtEstoque;
	private String idSetor;
	private String nmSetor;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ProdutoLoteSerie> lotes = new ArrayList<>();
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ProdutoLoteSerie> series = new ArrayList<>();
	
	@Data
	public class ProdutoLoteSerie {
		private String id;
		private String quatidade;
	}
}
