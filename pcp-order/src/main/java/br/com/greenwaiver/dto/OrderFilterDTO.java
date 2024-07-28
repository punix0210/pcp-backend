package br.com.greenwaiver.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrderFilterDTO {

	LocalDate dataInicio;
	LocalDate dataFinal;
	String StOrdem;
	String CdEmpresa;
	String IsSubOrdem;
	String TpInformacaoGeralOP;
	String value;
}
