package br.com.greenwaiver.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.greenwaiver.entities.Produto;

public interface ProductsRepository extends JpaRepository<Produto, String> {

	@Query(value = "SELECT p FROM Produto p JOIN p.codigos c WHERE p.stAtivo='S' and (p.nmProduto LIKE %:searchTerm% OR c.cdChamada LIKE %:searchTerm%) order by c.cdChamada")
	public Page<Produto> search(@Param("searchTerm") String value, Pageable pageable);

}