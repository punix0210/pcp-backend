package br.com.greenwaiver.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.greenwaiver.dto.ListaProdutoDTO;
import br.com.greenwaiver.entities.ListaProduto;
import br.com.greenwaiver.handler.MessageErrorEnum;
import br.com.greenwaiver.handler.MessageErrorException;
import br.com.greenwaiver.repositories.ListaProdutoRepository;

@Service
public class ListaProdutoService {
	private final ListaProdutoRepository repository;

	Logger log = LoggerFactory.getLogger(ListaProdutoService.class);

	public ListaProdutoService(ListaProdutoRepository repository) {
		this.repository = repository;
	}

	public ListaProduto findById(String id) {
		log.info("Find by ID {}", id);
		return this.repository.findById(id).orElseThrow(() -> new MessageErrorException(MessageErrorEnum.NOT_FOUND));

	}

	public List<ListaProdutoDTO> findByIdProduto(String idProduto) {
		log.info("Find by engineering :: IDPRODUTO :: {}", idProduto);
		return this.repository.findByIdProduto(idProduto).stream().map(p -> new ListaProdutoDTO(p))
				.collect(Collectors.toList());
	}

	@Transactional
	public ListaProduto save(ListaProduto lista) {
		log.info("Save engineering {} ", lista.toString());
		return this.repository.save(lista);
	}
}
