package br.com.greenwaiver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.greenwaiver.entities.OrdemProducao;

public interface OrdemProducaoRepository extends JpaRepository<OrdemProducao, String> , OrdemProducaoCustomRepository {


}
