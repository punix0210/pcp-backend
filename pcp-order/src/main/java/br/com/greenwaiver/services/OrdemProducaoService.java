package br.com.greenwaiver.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.greenwaiver.dto.OrderFilterDTO;
import br.com.greenwaiver.dto.ProductsMoveDTO;
import br.com.greenwaiver.dto.RequestOrdersMoveDTO;
import br.com.greenwaiver.entities.OrdemProducao;
import br.com.greenwaiver.entities.view.OrdemProducaoMaterialView;
import br.com.greenwaiver.entities.view.OrdemProducaoProductView;
import br.com.greenwaiver.repositories.OrdemProducaoRepository;

@Service
public class OrdemProducaoService {
	Logger log = LoggerFactory.getLogger(OrdemProducaoService.class);

	private final OrdemProducaoRepository repository;

	public OrdemProducaoService(OrdemProducaoRepository repository) {
		this.repository = repository;
	}

	public Page<OrdemProducaoProductView> search_product(int page, int size, OrderFilterDTO filter) {
		log.info("search order :: page e size :: {} - {}", page, size);
		return repository.search_product(filter, PageRequest.of(page, size));
	}

	public List<OrdemProducaoMaterialView> search_material(OrderFilterDTO filter) {
		return repository.search_material(filter);
	}

	public OrdemProducao findById(String id) {
		log.info("Find by order :: ID :: {}", id);

		Optional<OrdemProducao> ordem = repository.findById(id);

		if (!ordem.isPresent()) {
			throw new RuntimeException("Ordem de Produção não localizada, Verifique!");
		}

		return ordem.get();
	}

	public Map<String, String> toProductReport(RequestOrdersMoveDTO request) {
		Stream<ProductsMoveDTO> products = request.getProducts().stream();

		products.forEach(product -> {
			List<OrdemProducaoMaterialView> materiais = repository
					.findMaterialExitByIdOrdemProducao(product.getIdOrdemProducao());

			for (OrdemProducaoMaterialView material : materiais) {
				material.setQtProduzir(product.getQtAtender() * material.getQtBase());
			}

		});

		return null;
	}

	public Map<String, String> toProductEmpenho(RequestOrdersMoveDTO request) {
		return null;
	}

}
