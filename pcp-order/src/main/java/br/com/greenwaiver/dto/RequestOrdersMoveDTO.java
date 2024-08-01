package br.com.greenwaiver.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class RequestOrdersMoveDTO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	List<ProductsMoveDTO> products = new ArrayList<>();
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	List<ProductsMoveDTO> materials = new ArrayList<>();
}
