package br.com.greenwaiver.entities.view;

import java.sql.Date;
import java.sql.Timestamp;

public interface OrdemProducaoMaterialView {

	Integer getCdEmpresa();

	String getIdOrdemProducaoItem();

	String getIdOrdemProducao();

	String getCdChamada();

	Date getDtCadastro();

	String getIdListaProdutoItem();

	Character getStOrdemItem();

	String getIdPosicao();

	String getIdProduto();

	String getCdProduto();

	String getNmProduto();

	String getTpProduto();

	Double getQtProdutoFinal();

	Double getQtBase();

	Double getQtProduzir();

	Double getQtEstoque();

	String getIdSetorSaida();

	String getIdSetorEntrada();

	Timestamp getDtNecessidade();

	Character getStProdutoFantasma();

	Character getStComponente();

	String getTpLote();
	
	Double getVlCustoBase();
	
	Double getVlCusto();
	
	Double getQtEmpenhada();
	
	Double getQtProduzida();
	
	Double getQtEmpenhar();
}
