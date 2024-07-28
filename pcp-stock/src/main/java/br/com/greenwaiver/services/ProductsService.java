package br.com.greenwaiver.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.greenwaiver.dto.ProdutoDTO;
import br.com.greenwaiver.entities.Produto;
import br.com.greenwaiver.handler.MessageErrorEnum;
import br.com.greenwaiver.handler.MessageErrorException;
import br.com.greenwaiver.repositories.ProductsRepository;

@Service
public class ProductsService {
	private final ProductsRepository repository;

	Logger log = LoggerFactory.getLogger(ProductsService.class);

	public ProductsService(ProductsRepository repository) {
		this.repository = repository;
	}

	public Page<ProdutoDTO> findAll(int page, int size, String value) {
		log.info("Find all products by page {} and size {} and term {} ", page, size, value);
		return this.repository.search(value, PageRequest.of(page, size)).map(entity -> {
			return new ProdutoDTO(entity);
		});
	}

	public Produto findById(String id) {
		log.info("Find by ID {}", id);

		Optional<Produto> produto = this.repository.findById(id);

		if (!produto.isPresent()) {
			throw new MessageErrorException(MessageErrorEnum.NOT_FOUND);
		}

		return produto.get();
	}

	@Transactional
	public Produto save(Produto produto) {
		log.info("Save product {} ", produto.toString());
		Optional<Produto> p = Optional.of(this.repository.save(produto));

		if (!p.isPresent()) {
			throw new RuntimeException("Ocorreu um erro ao realizar gravacao do produto!");
		}

		return p.get();
	}

}
