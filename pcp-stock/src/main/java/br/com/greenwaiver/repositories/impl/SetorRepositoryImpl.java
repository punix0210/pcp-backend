package br.com.greenwaiver.repositories.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.greenwaiver.entities.view.SetorView;
import br.com.greenwaiver.repositories.SetorRepository;

@Repository
public class SetorRepositoryImpl implements SetorRepository {

	@Autowired
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<SetorView> findByCdEmpresa(String cdEmpresa) {
		String sql = "SELECT IdSetor,CdEmpresa,StControlaLote, RTRIM(CdChamada)+' - '+NmSetor as DsSetor "
				+ "FROM Setor s WHERE StAtivo= :status and CdEmpresa= :cdEmpresa  ";

		Query query = manager.createNativeQuery(sql);
		query.setParameter("status", "S");
		query.setParameter("cdEmpresa", Integer.parseInt(cdEmpresa));		

		List<Object[]> resultList = query.getResultList();

		return resultList.stream().map(SetorView::fromRecord).collect(Collectors.toList());
	}
}
