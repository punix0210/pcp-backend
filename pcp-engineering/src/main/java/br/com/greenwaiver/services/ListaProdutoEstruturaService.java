package br.com.greenwaiver.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import br.com.greenwaiver.dto.EstruturaProdutoFinalDTO;
import br.com.greenwaiver.repositories.EstruturaProdutoRepository;

@Service
@EnableAsync
public class ListaProdutoEstruturaService {
	private final EstruturaProdutoRepository repository;

	Logger log = LoggerFactory.getLogger(ListaProdutoEstruturaService.class);

	public ListaProdutoEstruturaService(EstruturaProdutoRepository repository) {
		this.repository = repository;
	}

	public EstruturaProdutoFinalDTO findById(String id) {
		log.info("Find Lista by ID {} to create structure product", id);

		EstruturaProdutoFinalDTO dto = repository.findById(id).map(item -> new EstruturaProdutoFinalDTO(item)).get();

		repository.findAllById(id).stream().forEach(item -> {
			dto.addChildren(new EstruturaProdutoFinalDTO(item));
		});

		return construirHierarquia(dto);
	}

	@Async
	private EstruturaProdutoFinalDTO construirHierarquia(EstruturaProdutoFinalDTO produto) {

		produto.getChildren().stream().forEach(item -> {

			if (item.getIdListaChildren() != null) {

				try {
					repository.findAllById(item.getIdListaChildren()).stream().forEach(child -> {
						item.addChildren(new EstruturaProdutoFinalDTO(child));
					});

					construirHierarquia(item);
				} catch (Exception e) {

					e.printStackTrace();
				}

			}

		});
		return produto;
	}

}
