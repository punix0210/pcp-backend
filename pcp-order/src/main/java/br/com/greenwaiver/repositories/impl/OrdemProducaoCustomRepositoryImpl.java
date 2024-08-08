package br.com.greenwaiver.repositories.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.greenwaiver.dto.OrderFilterDTO;
import br.com.greenwaiver.entities.view.OrdemProducaoMaterialView;
import br.com.greenwaiver.entities.view.OrdemProducaoProductView;
import br.com.greenwaiver.repositories.OrdemProducaoCustomRepository;
import br.com.greenwaiver.utils.OrderConstantUtil;

@Repository
public class OrdemProducaoCustomRepositoryImpl implements OrdemProducaoCustomRepository {

	@Autowired
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public Page<OrdemProducaoProductView> search_product(OrderFilterDTO filter, Pageable pageable) {
		String sql = OrderConstantUtil.SQL_ORDERS_PAGE;

		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("cdEmpresa", filter.getCdEmpresa());
		query.setParameter("startDate", filter.getDataInicio());
		query.setParameter("endDate", filter.getDataFinal());
		query.setParameter("stOrdem", filter.getStOrdem());
		query.setParameter("tpInformacaoGeralOP", filter.getTpInformacaoGeralOP() + "%");
		query.setParameter("isSubOrdem", filter.getIsSubOrdem());
		query.setParameter("value", "%" + filter.getValue() + "%");

		query.setFirstResult((int) pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());

		// Criação da query para contar o total de resultados
		Query countQuery = entityManager.createNativeQuery("SELECT COUNT(*) FROM (" + sql + ") as countQuery");
		countQuery.setParameter("cdEmpresa", filter.getCdEmpresa());
		countQuery.setParameter("startDate", filter.getDataInicio());
		countQuery.setParameter("endDate", filter.getDataFinal());
		countQuery.setParameter("stOrdem", filter.getStOrdem());
		countQuery.setParameter("tpInformacaoGeralOP", filter.getTpInformacaoGeralOP() + "%");
		countQuery.setParameter("isSubOrdem", filter.getIsSubOrdem());
		countQuery.setParameter("value", "%" + filter.getValue() + "%");

		long totalElements = ((Number) countQuery.getSingleResult()).longValue();

		List<Object[]> resultList = query.getResultList();

		List<OrdemProducaoProductView> results = resultList.stream().map(OrdemProducaoProductView::fromRecord)
				.collect(Collectors.toList());

		return new PageImpl<>(results, pageable, totalElements);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<OrdemProducaoMaterialView> search_material(OrderFilterDTO filter, Pageable pageable) {
		System.out.println(filter.toString());
		List<String> orders = filter.getItensNotIn();
		
		StringBuilder sqlBuilder = new StringBuilder(OrderConstantUtil.SQL_ORDERS_MATERIAL_EMPENHO);
		sqlBuilder.append(" AND (T.DtCadastro BETWEEN :startDate AND :endDate)");
		sqlBuilder.append(" AND (T.StOrdemItem = CASE WHEN :stOrdem = '' THEN T.StOrdemItem ELSE :stOrdem END)");
		sqlBuilder.append(" AND (T.NmProduto LIKE :value OR T.CdProduto LIKE :value OR T.CdChamada LIKE :value ) ");
		
        if (orders != null && !orders.isEmpty()) {
        	sqlBuilder.append(" AND T.IdOrdemProducaoItem NOT IN (");
            for (int i = 0; i < orders.size(); i++) {
            	sqlBuilder.append(":ordensNotIn").append(i);
                if (i < orders.size() - 1) {
                	sqlBuilder.append(", ");
                }
            }
            sqlBuilder.append(")");
        }
		
		Query query = entityManager.createNativeQuery(sqlBuilder.toString());
		query.setParameter("cdEmpresa", filter.getCdEmpresa());
		query.setParameter("startDate", filter.getDataInicio());
		query.setParameter("endDate", filter.getDataFinal());
		query.setParameter("stOrdem", filter.getStOrdem());
		query.setParameter("value", "%" + filter.getValue() + "%");
		
        if (orders != null && !orders.isEmpty()) {
            for (int i = 0; i < orders.size(); i++) {
                query.setParameter("ordensNotIn" + i, orders.get(i)); 
            }
        }		
				
		query.setFirstResult((int) pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());	
		
		System.out.println(sqlBuilder.toString());
	
		// Criação da query para contar o total de resultados
		Query countQuery = entityManager.createNativeQuery("SELECT COUNT(*) FROM (" + sqlBuilder.toString() + ") as countQuery");
		countQuery.setParameter("cdEmpresa", filter.getCdEmpresa());
		countQuery.setParameter("startDate", filter.getDataInicio());
		countQuery.setParameter("endDate", filter.getDataFinal());
		countQuery.setParameter("stOrdem", filter.getStOrdem());
		countQuery.setParameter("value", "%" + filter.getValue() + "%");
        if (orders != null && !orders.isEmpty()) {
            for (int i = 0; i < orders.size(); i++) {
            	countQuery.setParameter("ordensNotIn"+i, orders.get(i)); 
            }
        }		

		long totalElements = ((Number) countQuery.getSingleResult()).longValue();

		List<Object[]> resultList = query.getResultList();

		List<OrdemProducaoMaterialView> results = resultList.stream().map(OrdemProducaoMaterialView::fromRecord)
				.collect(Collectors.toList());

		return new PageImpl<>(results, pageable, totalElements);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemProducaoMaterialView> findMaterialExitByIdOrdemProducao(String id) {
		String sql = OrderConstantUtil.SQL_ORDERS_MATERIAL_SAIDA_AND_ESTORNO_ENTRADA;

		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("id", id);

		List<Object[]> resultList = query.getResultList();

		return resultList.stream().map(OrdemProducaoMaterialView::fromRecord).collect(Collectors.toList());

	}

}
