package br.com.greenwaiver.repositories;

import java.util.List;

import br.com.greenwaiver.dto.OrderFilterDTO;
import br.com.greenwaiver.entities.view.OrdemProducaoMaterialView;
import br.com.greenwaiver.entities.view.OrdemProducaoProductView;

public interface OrdemProducaoCustomRepository {
	List<OrdemProducaoProductView> search_product(OrderFilterDTO filter);
	List<OrdemProducaoMaterialView> search_material(OrderFilterDTO filter);
	List<OrdemProducaoMaterialView> findMaterialExitByIdOrdemProducao(String id);	
}
