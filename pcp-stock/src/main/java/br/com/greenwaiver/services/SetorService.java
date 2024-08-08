package br.com.greenwaiver.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.greenwaiver.entities.view.SetorView;
import br.com.greenwaiver.repositories.SetorRepository;

@Service
public class SetorService {

	private final SetorRepository repository;

	public SetorService(SetorRepository repository) {
		this.repository = repository;
	}

	public List<SetorView> findByCdEmpresa(String cdEmpresa) {
		return repository.findByCdEmpresa(cdEmpresa);
	}
}
