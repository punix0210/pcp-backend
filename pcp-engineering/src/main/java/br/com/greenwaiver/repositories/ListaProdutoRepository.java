package br.com.greenwaiver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.greenwaiver.entities.ListaProduto;

public interface ListaProdutoRepository extends JpaRepository<ListaProduto, String> {

	@Query(value="select l from ListaProduto l join l.produto p where p.idProduto = :idProduto ")
	List<ListaProduto> findByIdProduto(@Param("idProduto") String idProduto);
}
