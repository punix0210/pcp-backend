package br.com.greenwaiver.entities.view;

import java.sql.Date;
import java.sql.Timestamp;

public class OrdemProducaoMaterialView {
	private Integer cdEmpresa;
    private String idOrdemProducaoItem;
    private String idOrdemProducao;
    private String cdChamada;
    private Date dtCadastro;
    private String idListaProdutoItem;
    private Character stOrdemItem;
    private String idPosicao;
    private String idProduto;
    private String cdProduto;
    private String nmProduto;
    private String tpProduto;
    private Double qtProdutoFinal;
    private Double qtBase;
    private Double qtProduzir;
    private Double qtEstoque;
    private String idSetorSaida;
    private String idSetorEntrada;
    private Timestamp dtNecessidade;
    private Character stProdutoFantasma;
    private Character stComponente;
    private String tpLote;
    private Double vlCustoBase;
    private Double vlCusto;
    private Double qtEmpenhada;
    private Double qtProduzida;
    private Double qtEmpenhar;

    // Construtor privado
    private OrdemProducaoMaterialView(Integer cdEmpresa, String idOrdemProducaoItem, String idOrdemProducao,
                                           String cdChamada, Date dtCadastro, String idListaProdutoItem,
                                           Character stOrdemItem, String idPosicao, String idProduto,
                                           String cdProduto, String nmProduto, String tpProduto,
                                           Double qtProdutoFinal, Double qtBase, Double qtProduzir,
                                           Double qtEstoque, String idSetorSaida, String idSetorEntrada,
                                           Timestamp dtNecessidade, Character stProdutoFantasma,
                                           Character stComponente, String tpLote, Double vlCustoBase,
                                           Double vlCusto, Double qtEmpenhada, Double qtProduzida,
                                           Double qtEmpenhar) {
        this.cdEmpresa = cdEmpresa;
        this.idOrdemProducaoItem = idOrdemProducaoItem;
        this.idOrdemProducao = idOrdemProducao;
        this.cdChamada = cdChamada;
        this.dtCadastro = dtCadastro;
        this.idListaProdutoItem = idListaProdutoItem;
        this.stOrdemItem = stOrdemItem;
        this.idPosicao = idPosicao;
        this.idProduto = idProduto;
        this.cdProduto = cdProduto;
        this.nmProduto = nmProduto;
        this.tpProduto = tpProduto;
        this.qtProdutoFinal = qtProdutoFinal;
        this.qtBase = qtBase;
        this.qtProduzir = qtProduzir;
        this.qtEstoque = qtEstoque;
        this.idSetorSaida = idSetorSaida;
        this.idSetorEntrada = idSetorEntrada;
        this.dtNecessidade = dtNecessidade;
        this.stProdutoFantasma = stProdutoFantasma;
        this.stComponente = stComponente;
        this.tpLote = tpLote;
        this.vlCustoBase = vlCustoBase;
        this.vlCusto = vlCusto;
        this.qtEmpenhada = qtEmpenhada;
        this.qtProduzida = qtProduzida;
        this.qtEmpenhar = qtEmpenhar;
    }

    // Método estático para criar a instância a partir de Object[]
    public static OrdemProducaoMaterialView fromRecord(Object[] record) {
        return new OrdemProducaoMaterialView(
            (Integer) record[0], // cdEmpresa
            (String) record[1],  // idOrdemProducaoItem
            (String) record[2],  // idOrdemProducao
            (String) record[3],  // cdChamada
            (Date) record[4],    // dtCadastro
            (String) record[5],  // idListaProdutoItem
            (Character) record[6],// stOrdemItem
            (String) record[7],  // idPosicao
            (String) record[8],  // idProduto
            (String) record[9],  // cdProduto
            (String) record[10], // nmProduto
            (String) record[11], // tpProduto
            (Double) record[12], // qtProdutoFinal
            (Double) record[13], // qtBase
            (Double) record[14], // qtProduzir
            (Double) record[15], // qtEstoque
            (String) record[16], // idSetorSaida
            (String) record[17], // idSetorEntrada
            (Timestamp) record[18], // dtNecessidade
            (Character) record[19], // stProdutoFantasma
            (Character) record[20], // stComponente
            (String) record[21], // tpLote
            (Double) record[22], // vlCustoBase
            (Double) record[23], // vlCusto
            (Double) record[24], // qtEmpenhada
            (Double) record[25], // qtProduzida
            (Double) record[26]  // qtEmpenhar
        );
    }

    // Métodos getters
    public Integer getCdEmpresa() {
        return cdEmpresa;
    }

    public String getIdOrdemProducaoItem() {
        return idOrdemProducaoItem;
    }

    public String getIdOrdemProducao() {
        return idOrdemProducao;
    }

    public String getCdChamada() {
        return cdChamada;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public String getIdListaProdutoItem() {
        return idListaProdutoItem;
    }

    public Character getStOrdemItem() {
        return stOrdemItem;
    }

    public String getIdPosicao() {
        return idPosicao;
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

    public String getTpProduto() {
        return tpProduto;
    }

    public Double getQtProdutoFinal() {
        return qtProdutoFinal;
    }

    public Double getQtBase() {
        return qtBase;
    }

    public Double getQtProduzir() {
        return qtProduzir;
    }

    public Double getQtEstoque() {
        return qtEstoque;
    }

    public String getIdSetorSaida() {
        return idSetorSaida;
    }

    public String getIdSetorEntrada() {
        return idSetorEntrada;
    }

    public Timestamp getDtNecessidade() {
        return dtNecessidade;
    }

    public Character getStProdutoFantasma() {
        return stProdutoFantasma;
    }

    public Character getStComponente() {
        return stComponente;
    }

    public String getTpLote() {
        return tpLote;
    }

    public Double getVlCustoBase() {
        return vlCustoBase;
    }

    public Double getVlCusto() {
        return vlCusto;
    }

    public Double getQtEmpenhada() {
        return qtEmpenhada;
    }

    public Double getQtProduzida() {
        return qtProduzida;
    }

    public Double getQtEmpenhar() {
        return qtEmpenhar;
    }	
	

//	Integer getCdEmpresa();
//
//	String getIdOrdemProducaoItem();
//
//	String getIdOrdemProducao();
//
//	String getCdChamada();
//
//	Date getDtCadastro();
//
//	String getIdListaProdutoItem();
//
//	Character getStOrdemItem();
//
//	String getIdPosicao();
//
//	String getIdProduto();
//
//	String getCdProduto();
//
//	String getNmProduto();
//
//	String getTpProduto();
//
//	Double getQtProdutoFinal();
//
//	Double getQtBase();
//
//	Double getQtProduzir();
//
//	Double getQtEstoque();
//
//	String getIdSetorSaida();
//
//	String getIdSetorEntrada();
//
//	Timestamp getDtNecessidade();
//
//	Character getStProdutoFantasma();
//
//	Character getStComponente();
//
//	String getTpLote();
//	
//	Double getVlCustoBase();
//	
//	Double getVlCusto();
//	
//	Double getQtEmpenhada();
//	
//	Double getQtProduzida();
//	
//	Double getQtEmpenhar();
}
