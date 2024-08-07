package br.com.greenwaiver.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.greenwaiver.dto.OrderFilterDTO;
import br.com.greenwaiver.entities.view.OrdemProducaoMaterialView;
import br.com.greenwaiver.entities.view.OrdemProducaoProductView;

public interface OrdemProducaoCustomRepository {
	Page<OrdemProducaoProductView> search_product(OrderFilterDTO filter, Pageable pageable);
	Page<OrdemProducaoMaterialView> search_material(OrderFilterDTO filter, Pageable pageable);
	List<OrdemProducaoMaterialView> findMaterialExitByIdOrdemProducao(String id);	
}
