package br.com.greenwaiver.repositories.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.greenwaiver.entities.EstruturaProdutoView;
import br.com.greenwaiver.repositories.EstruturaProdutoRepository;
import br.com.greenwaiver.utils.EstruturaProdutoUtil;

@Repository
public class EstruturaProdutoRepositoryImpl implements EstruturaProdutoRepository {

	@Autowired
	EntityManager manager;

	@Override
	@SuppressWarnings("unchecked")
	public List<EstruturaProdutoView> findAllById(String id) {
		String sql = EstruturaProdutoUtil.SQL_CHILD;

		List<Object[]> results = manager.createNativeQuery(sql).setParameter("idListaProduto", id).getResultList();

		List<EstruturaProdutoView> res = results.stream().map(result -> EstruturaProdutoUtil.toObject(result))
				.collect(Collectors.toList());
		
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<EstruturaProdutoView> findById(String id) {
		String jpql = EstruturaProdutoUtil.SQL_DAD;

		Query query = manager.createNativeQuery(jpql);
		query.setParameter("idListaProduto", id);

		List<Object[]> results = query.getResultList();

		Optional<EstruturaProdutoView> res = results.stream().map(result -> EstruturaProdutoUtil.toObject(result)).findFirst();
		
		if (!res.isPresent()) {
			throw new RuntimeException("Lista de Produto não encontrada. Verifique!");
		}		
				
		return res;
	}

}
