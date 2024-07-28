package br.com.greenwaiver.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrdemProducao_OperacaoRoteiro", schema = "wpcp")
public class OrdemOperacaoRoteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    private String idOperacaoRoteiro;	
	private String idOrdemProducao;
    private String idRoteiroProduto;
    private String idProduto;
    private String cdChamada;
    private String dsOperacao;
    private String idCentroTrabalho;
    private String dsCentroTrabalho;
    private String idRecurso;
    private String dsRecurso;
    private String timeSetup;
    private String timeOperacao;
    private String tpTempoOperacao;
    private String timeModSetup;
    private String timeModOperacao;
    private LocalDateTime dtInicio;
    private LocalDateTime dtFinal;	
	
}
