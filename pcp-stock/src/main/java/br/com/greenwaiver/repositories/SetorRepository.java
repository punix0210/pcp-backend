package br.com.greenwaiver.repositories;

import java.util.List;

import br.com.greenwaiver.entities.view.SetorView;

public interface SetorRepository {

	public List<SetorView> findByCdEmpresa(String cdEmpresa);
}
