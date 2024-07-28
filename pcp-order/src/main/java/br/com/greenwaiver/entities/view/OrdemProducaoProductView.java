package br.com.greenwaiver.entities.view;

import java.sql.Date;
import java.sql.Timestamp;


public interface OrdemProducaoProductView {

	String getIdOrdemProducao();
    String getCdChamada();
    Date getDtCadastro();
    String getStOrdem();
    Double getQtAtendida();
    Timestamp getDtPrevInicio();
    Timestamp getDtPrevTerminio();
    Timestamp getDtLimiteProducao();
    Integer getCdEmpresa();
    Boolean getIsSubOrdem();
    String getIdProduto();
    String getCdProduto();
    String getNmProduto();
    Double getQtProduto();
    String getIdInformacaoGeral();
    String getTpInformacaoGeralOP();
    String getDsInformacaoGeral();
    String getTpFixacao();
    String getTpAtendimento();
    String getTpOrdemOrigem();
    Double getQtAtender();
    Timestamp getDtExclusao();
    String getCdSigla();
    String getTpProduto();
    String getIdMaquina();
    String getDsMaquina();    
    String getSeqPrioridade();
    Double getQtEstoque();
    String getIdSetor() ;
    String getNmSetor();
}
