package br.com.greenwaiver.repositories;

import java.util.List;
import java.util.Optional;

import br.com.greenwaiver.entities.EstruturaProdutoView;


public interface EstruturaProdutoRepository  {

	public List<EstruturaProdutoView> findAllById(String id);
	public Optional<EstruturaProdutoView> findById(String id);
	
}
