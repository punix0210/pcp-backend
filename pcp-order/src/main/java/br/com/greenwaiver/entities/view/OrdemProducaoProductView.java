package br.com.greenwaiver.entities.view;

import java.sql.Date;
import java.sql.Timestamp;

public class OrdemProducaoProductView {

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

	// Construtor privado
	private OrdemProducaoProductView(String idOrdemProducao, String cdChamada, Date dtCadastro, String stOrdem,
			Double qtAtendida, Timestamp dtPrevInicio, Timestamp dtPrevTerminio, Timestamp dtLimiteProducao,
			Integer cdEmpresa, Boolean isSubOrdem, String idProduto, String cdProduto, String nmProduto,
			Double qtProduto, String idInformacaoGeral, String tpInformacaoGeralOP, String dsInformacaoGeral,
			String tpFixacao, String tpAtendimento, String tpOrdemOrigem, Double qtAtender, Timestamp dtExclusao,
			String cdSigla, String tpProduto, String idMaquina, String dsMaquina, String seqPrioridade,
			Double qtEstoque, String idSetor, String nmSetor) {
		this.idOrdemProducao = idOrdemProducao;
		this.cdChamada = cdChamada;
		this.dtCadastro = dtCadastro;
		this.stOrdem = stOrdem;
		this.qtAtendida = qtAtendida;
		this.dtPrevInicio = dtPrevInicio;
		this.dtPrevTerminio = dtPrevTerminio;
		this.dtLimiteProducao = dtLimiteProducao;
		this.cdEmpresa = cdEmpresa;
		this.isSubOrdem = isSubOrdem;
		this.idProduto = idProduto;
		this.cdProduto = cdProduto;
		this.nmProduto = nmProduto;
		this.qtProduto = qtProduto;
		this.idInformacaoGeral = idInformacaoGeral;
		this.tpInformacaoGeralOP = tpInformacaoGeralOP;
		this.dsInformacaoGeral = dsInformacaoGeral;
		this.tpFixacao = tpFixacao;
		this.tpAtendimento = tpAtendimento;
		this.tpOrdemOrigem = tpOrdemOrigem;
		this.qtAtender = qtAtender;
		this.dtExclusao = dtExclusao;
		this.cdSigla = cdSigla;
		this.tpProduto = tpProduto;
		this.idMaquina = idMaquina;
		this.dsMaquina = dsMaquina;
		this.seqPrioridade = seqPrioridade;
		this.qtEstoque = qtEstoque;
		this.idSetor = idSetor;
		this.nmSetor = nmSetor;
	}

	// Método estático para criar a instância a partir de Object[]
	public static OrdemProducaoProductView fromRecord(Object[] record) {
		return new OrdemProducaoProductView((String) record[0], // idOrdemProducao
				(String) record[1], // cdChamada
				(Date) record[2], // dtCadastro
				(String) record[3], // stOrdem
				(Double) record[4], // qtAtendida
				(Timestamp) record[5], // dtPrevInicio
				(Timestamp) record[6], // dtPrevTerminio
				(Timestamp) record[7], // dtLimiteProducao
				(Integer) record[8], // cdEmpresa
				(Boolean) record[9], // isSubOrdem
				(String) record[10], // idProduto
				(String) record[11], // cdProduto
				(String) record[12], // nmProduto
				(Double) record[13], // qtProduto
				(String) record[14], // idInformacaoGeral
				(String) record[15], // tpInformacaoGeralOP
				(String) record[16], // dsInformacaoGeral
				(String) record[17], // tpFixacao
				(String) record[18], // tpAtendimento
				(String) record[19], // tpOrdemOrigem
				(Double) record[20], // qtAtender
				(Timestamp) record[21], // dtExclusao
				(String) record[22], // cdSigla
				(String) record[23], // tpProduto
				(String) record[24], // idMaquina
				(String) record[25], // dsMaquina
				(String) record[26], // seqPrioridade
				(Double) record[27], // qtEstoque
				(String) record[28], // idSetor
				(String) record[29] // nmSetor
		);
	}
	
	// Métodos getters
	public String getIdOrdemProducao() {
		return idOrdemProducao;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public String getStOrdem() {
		return stOrdem;
	}

	public Double getQtAtendida() {
		return qtAtendida;
	}

	public Timestamp getDtPrevInicio() {
		return dtPrevInicio;
	}

	public Timestamp getDtPrevTerminio() {
		return dtPrevTerminio;
	}

	public Timestamp getDtLimiteProducao() {
		return dtLimiteProducao;
	}

	public Integer getCdEmpresa() {
		return cdEmpresa;
	}

	public Boolean getIsSubOrdem() {
		return isSubOrdem;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public String getCdProduto() {
		return cdProduto;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public Double getQtProduto() {
		return qtProduto;
	}

	public String getIdInformacaoGeral() {
		return idInformacaoGeral;
	}

	public String getTpInformacaoGeralOP() {
		return tpInformacaoGeralOP;
	}

	public String getDsInformacaoGeral() {
		return dsInformacaoGeral;
	}

	public String getTpFixacao() {
		return tpFixacao;
	}

	public String getTpAtendimento() {
		return tpAtendimento;
	}

	public String getTpOrdemOrigem() {
		return tpOrdemOrigem;
	}

	public Double getQtAtender() {
		return qtAtender;
	}

	public Timestamp getDtExclusao() {
		return dtExclusao;
	}

	public String getCdSigla() {
		return cdSigla;
	}

	public String getTpProduto() {
		return tpProduto;
	}

	public String getIdMaquina() {
		return idMaquina;
	}

	public String getDsMaquina() {
		return dsMaquina;
	}

	public String getSeqPrioridade() {
		return seqPrioridade;
	}

	public Double getQtEstoque() {
		return qtEstoque;
	}

	public String getIdSetor() {
		return idSetor;
	}

	public String getNmSetor() {
		return nmSetor;
	}
	
	public boolean getSelected() {
		return false;
	}

//	String getIdOrdemProducao();
//    String getCdChamada();
//    Date getDtCadastro();
//    String getStOrdem();
//    Double getQtAtendida();
//    Timestamp getDtPrevInicio();
//    Timestamp getDtPrevTerminio();
//    Timestamp getDtLimiteProducao();
//    Integer getCdEmpresa();
//    Boolean getIsSubOrdem();
//    String getIdProduto();
//    String getCdProduto();
//    String getNmProduto();
//    Double getQtProduto();
//    String getIdInformacaoGeral();
//    String getTpInformacaoGeralOP();
//    String getDsInformacaoGeral();
//    String getTpFixacao();
//    String getTpAtendimento();
//    String getTpOrdemOrigem();
//    Double getQtAtender();
//    Timestamp getDtExclusao();
//    String getCdSigla();
//    String getTpProduto();
//    String getIdMaquina();
//    String getDsMaquina();    
//    String getSeqPrioridade();
//    Double getQtEstoque();
//    String getIdSetor() ;
//    String getNmSetor();
}
