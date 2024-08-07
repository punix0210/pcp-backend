package br.com.greenwaiver.dto;

import java.time.LocalDate;
import java.util.List;

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
//	@JsonDeserialize(using = CustomStringToListDeserializer.class)
	List<String> itensNotIn;
}
