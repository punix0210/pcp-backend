package br.com.greenwaiver.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProcessoProducaoID  implements Serializable {
	private static final long serialVersionUID = 1L;

    private String idOrdemProducao;
    private String idProcessoProducao;
    
}
