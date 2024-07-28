package br.com.greenwaiver.repositories.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.greenwaiver.dto.OrderFilterDTO;
import br.com.greenwaiver.entities.view.OrdemProducaoMaterialView;
import br.com.greenwaiver.entities.view.OrdemProducaoProductView;
import br.com.greenwaiver.repositories.OrdemProducaoCustomRepository;

@Repository
public class OrdemProducaoCustomRepositoryImpl implements OrdemProducaoCustomRepository {
	
	@Autowired
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemProducaoProductView> search_product(OrderFilterDTO filter) {
		String sql = "SELECT OP.*,Isnull(SE.qtEstoque, 0) as QtEstoque, \r\n"
				+ "Case\r\n"
				+ " when OP.TpProduto = 'V' then CFG.IdSetorProdutoAcabado  \r\n"
				+ " when OP.TpProduto = 'F' then CFG.IdSetorProdutoFabricado end as IdSetor, SE.NmSetor FROM (SELECT " +
                "op.IdOrdemProducao, " +
                "Rtrim(op.CdChamada) as CdChamada, " +
                "CONVERT(date, op.DtCadastro) as DtCadastro, " +
                "Rtrim(op.StOrdem) as StOrdem, " +
                "Isnull(op.QtAtendida,0) as QtAtendida, " +
                "op.DtPrevInicio, " +
                "op.DtPrevTerminio, " +
                "op.DtLimiteProducao, " +
                "op.CdEmpresa, " +
                "CASE WHEN op.NmEntidadeOrigem = 'OrdemProducao' THEN CONVERT(bit, 1) ELSE CONVERT(bit, 0) END as IsSubOrdem, " +
                "pp.IdProduto, " +
                "Rtrim(pp.cdProduto) as CdProduto, " +
                "pp.NmProduto, " +
                "op.QtProduto, " +
                "op.IdInformacaoGeral, " +
                "convert(varchar(5),ig.TpInformacaoGeral) as TpInformacaoGeralOP, " +
                "ig.DsInformacaoGeral, " +
                "op.TpFixacao, " 
                + "case "
                + "   when op.TpAtendimento = 'T' then 'Total' "
                + "   when op.TpAtendimento = 'P' then 'Parcial' "
                + "   when op.TpAtendimento = 'X' then 'Com Corte' "
                + "   when op.TpAtendimento = 'L' then 'Liberado' "
                + "end as TpAtendimento, " +
                "case "
                + "   when op.tpOrdemOrigem = 'PV' then 'Pedido de Venda' "
                + "   when op.tpOrdemOrigem = 'PD' then 'Produto Avulso' "
                + "   when op.tpOrdemOrigem = 'LT' then 'Lote de Producao' "
                + "   when op.tpOrdemOrigem = 'PC' then 'Pedido de Compra' "
                + "end as tpOrdemOrigem, "+                
                "op.QtProduto - ISNULL(op.QtAtendida, 0) as QtAtender,"
                + " op.DtExclusao, RTrim(pp.CdSigla) as CdSigla, RTrim(pp.TpProduto) as TpProduto, "
                + "op.IdMaquina, DsMaquina = Rtrim(Maq.cdChamada) + ' - '+Maq.DsMaquina, "
                + "SeqPrioridade = case when isnull(op.seqPrioridade,'') = '' then '999' else op.seqPrioridade end " +
                "FROM wpcp.OrdemProducao op (NOLOCK) " +
                "JOIN wpcp.vw_ProdutoPCP pp on (pp.IdProduto = op.IdProduto) " +
                "JOIN dbo.InformacaoGeral ig   (NOLOCK) ON (ig.IdInformacaoGeral = op.IdInformacaoGeral) "+
                "LEFT JOIN wpcp.Maquina Maq    (NOLOCK) ON (Maq.idMaquina = op.idMaquina) ) OP  "+
                "JOIN wpcp.ConfiguracaoPCP CFG (NOLOCK) ON (CFG.CdEmpresa = OP.CdEmpresa) "+
                "LEFT JOIN                          \r\n"
                + "                        (Select \r\n"
                + "                              ES.IdProduto,\r\n"
                + "                              ES.QtEstoque,\r\n"
                + "                              S.CdEmpresa,\r\n"
                + "                              S.IdSetor,\r\n"
                + "                              S.NmSetor\r\n"
                + "                             From \r\n"
                + "                              dbo.EstoqueSetor ES (NOLOCK) Join\r\n"
                + "                              dbo.Setor S (NOLOCK) ON (S.IdSetor = ES.IdSetor) \r\n"
                + "                             Where \r\n"
                + "                              ES.DtReferencia = (\r\n"
                + "                                                 Select top 1\r\n"
                + "                                                  MAX(ES1.DtReferencia)\r\n"
                + "                                                 From \r\n"
                + "                                                  dbo.EstoqueSetor ES1 (NOLOCK)  \r\n"
                + "                                                 Where \r\n"
                + "                                                  (ES1.IdProduto = ES.IdProduto) AND \r\n"
                + "                                                  (ES1.IdSetor   = ES.IdSetor) )) SE ON (SE.IdProduto = OP.IdProduto) AND \r\n"
                + "                                                  (SE.CdEmpresa  = OP.CdEmpresa) AND \r\n"
                + "                                                  (SE.IdSetor = \r\n"
                + "                                                        Case\r\n"
                + "                                                            when OP.TpProduto = 'V' then CFG.IdSetorProdutoAcabado  \r\n"
                + "                                                            when OP.TpProduto = 'F' then CFG.IdSetorProdutoFabricado end\r\n"
                + "                                                  ) " +
                "WHERE OP.CdEmpresa = :cdEmpresa " +
                "  AND OP.DtCadastro BETWEEN :startDate AND :endDate " +
                "  AND OP.StOrdem = CASE WHEN :stOrdem = '' THEN OP.StOrdem ELSE :stOrdem END " +
                "  AND OP.TpInformacaoGeralOP LIKE :tpInformacaoGeralOP " +
                "  AND OP.IsSubOrdem = CASE WHEN :isSubOrdem = '01' THEN OP.IsSubOrdem ELSE :isSubOrdem END " +
                "  AND (OP.NmProduto LIKE :value or OP.CdChamada LIKE :value or "
                + "OP.CdProduto LIKE :value OR ISNULL(OP.DsMaquina,'') LIKE :value) and OP.DtExclusao IS NULL ";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("cdEmpresa", filter.getCdEmpresa());
        query.setParameter("startDate", filter.getDataInicio());
        query.setParameter("endDate", filter.getDataFinal());
        query.setParameter("stOrdem", filter.getStOrdem());
        query.setParameter("tpInformacaoGeralOP", filter.getTpInformacaoGeralOP()+ "%");
        query.setParameter("isSubOrdem", filter.getIsSubOrdem() );
        query.setParameter("value", "%" + filter.getValue() + "%");

        List<Object[]> resultList = query.getResultList();

        return resultList.stream().map(record -> new OrdemProducaoProductView() {
            @Override
            public String getIdOrdemProducao() {
                return ((String) record[0]);
            }
            @Override
            public String getCdChamada() {
                return (String) record[1];
            }
            @Override
            public Date getDtCadastro() {
                return (Date) record[2];
            }
            @Override
            public String getStOrdem() {
                return (String) record[3];
            }
            @Override
            public Double getQtAtendida() {
                return (Double) record[4];
            }
            @Override
            public Timestamp getDtPrevInicio() {
                return (Timestamp) record[5];
            }
            @Override
            public Timestamp getDtPrevTerminio() {
                return (Timestamp) record[6];
            }
            @Override
            public Timestamp getDtLimiteProducao() {
                return (Timestamp) record[7];
            }
            @Override
            public Integer getCdEmpresa() {
                return (Integer) record[8];
            }
            @Override
            public Boolean getIsSubOrdem() {
                return (Boolean) record[9];
            }
            @Override
            public String getIdProduto() {
                return ((String) record[10]);
            }
            @Override
            public String getCdProduto() {
                return (String) record[11];
            }
            @Override
            public String getNmProduto() {
                return (String) record[12];
            }
            @Override
            public Double getQtProduto() {
                return (Double) record[13];
            }
            @Override
            public String getIdInformacaoGeral() {
                return ((String) record[14]);
            }
            @Override
            public String getTpInformacaoGeralOP() {
                return (String) record[15];
            }
            @Override
            public String getDsInformacaoGeral() {
                return (String) record[16];
            }
            @Override
            public String getTpFixacao() {
                return (String) record[17];
            }
            @Override
            public String getTpAtendimento() {
                return (String) record[18];
            }
            @Override
            public String getTpOrdemOrigem() {
                return (String) record[19];
            }
            @Override
            public Double getQtAtender() {
                return (Double) record[20];
            }
            @Override
            public Timestamp getDtExclusao() {
                return (Timestamp) record[21];
            }
            @Override
            public String getCdSigla() {
                return (String) record[22];
            }
            @Override
            public String getTpProduto() {
                return (String) record[23];
            }   
            @Override
            public String getIdMaquina() {
                return (String) record[24];
            }  
            @Override
            public String getDsMaquina() {
                return (String) record[25];
            }              
            @Override
            public String getSeqPrioridade() {
                return (String) record[26];
            }   
            
            @Override
            public Double getQtEstoque() {
                return (Double) record[27];
            }  
            @Override
            public String getIdSetor() {
                return (String) record[28];
            }              
            @Override
            public String getNmSetor() {
                return (String) record[29];
            }             
        }).collect(Collectors.toList());		 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemProducaoMaterialView> search_material(OrderFilterDTO filter) {
		String sql = "SELECT "
				+ "  *, QtProduzir - Isnull(QtEmpenhada,0) as QtEmpenhar "
				+ "FROM (\r\n"
				+ "SELECT \r\n"
				+ " OP.CdEmpresa,\r\n"
				+ " OPI.IdOrdemProducaoItem,\r\n"
				+ " OPI.IdOrdemProducao,\r\n"
				+ " RTRIM(OP.CdChamada) AS CdChamada,\r\n"
				+ " CONVERT(date,OP.DtCadastro) as DtCadastro,\r\n"
				+ " OPI.IdListaProdutoItem,\r\n"
				+ " OPI.StOrdemItem, \r\n"
				+ " OPI.IdPosicao,\r\n"
				+ " OPI.IdProdutoComponente AS IdProduto,\r\n"
				+ " RTRIM(VPP.CdProduto) AS CdProduto,\r\n"
				+ " VPP.NmProduto,\r\n"
				+ " VPP.TpProduto,  \r\n"
				+ " OP.QtProduto AS QtProdutoFinal, \r\n"
				+ " OPI.QtProdutoComponenteORI AS QtBase,\r\n"
				+ " OPI.QtProduzir,\r\n"
				+ " IsNull(SE.QtEstoque,0) as QtEstoque,\r\n"
				+ " Case\r\n"
				+ "     when VPP.TpProduto = 'V' then CFG.IdSetorProdutoAcabado  \r\n"
				+ "     when VPP.TpProduto = 'F' then CFG.IdSetorProdutoFabricado\r\n"
				+ "     when VPP.TpProduto = 'C' then CFG.IdSetorAlmoxarifado  \r\n"
				+ "     when VPP.TpProduto = 'P' then CFG.IdSetorProdutoPersonalizado                                                            \r\n"
				+ " End as IdSetorSaida,\r\n"
				+ " CFG.IdSetorProducao as IdSetorEntrada,\r\n"
				+ " OPI.DtNecessidade,\r\n"
				+ " OPI.StProdutoFantasma,\r\n"
				+ " OPI.StComponente,\r\n"
				+ " Case \r\n"
				+ "	When Isnull(VPP.StControlaLote,'N') = 'N' and Isnull(VPP.StControlaNrSerie,'N') = 'N'  then 'N' \r\n"
				+ "	When Isnull(VPP.StControlaLote,'N') = 'N' and Isnull(VPP.StControlaNrSerie,'N') = 'S'  then 'S' \r\n"
				+ "	When Isnull(VPP.StControlaLote,'N') = 'S' and Isnull(VPP.StControlaNrSerie,'N') = 'N'  then 'L' \r\n"
				+ " end as TpLote, ISNULL(OPI.VlCustoBase,0) AS VlCustoBase, ISNULL(OPI.VlCusto,0) AS VlCusto, "
				+ "(SELECT SUM(QtMovimento) FROM wpcp.OrdemProducao_MovEstoque where IdOrdemProducaoItem = OPI.IdOrdemProducaoItem and TpMovimento ='E') AS QtEmpenhada, "
				+ "(SELECT SUM(QtMovimento) FROM wpcp.OrdemProducao_MovEstoque where IdOrdemProducaoItem = OPI.IdOrdemProducaoItem and TpMovimento ='S') AS QtProduzida "
				+ "FROM \r\n"
				+ " wpcp.OrdemProducaoItem OPI (NOLOCK) JOIN\r\n"
				+ " wpcp.OrdemProducao      OP (NOLOCK) ON (OP.IdOrdemProducao = OPI.IdOrdemProducao AND OP.DtExclusao IS NULL) JOIN \r\n"
				+ " wpcp.vw_ProdutoPCP     VPP (NOLOCK) ON (VPP.IdProduto = OPI.IdProdutoComponente) JOIN\r\n"
				+ " wpcp.ConfiguracaoPCP   CFG (NOLOCK) ON (CFG.CdEmpresa = OP.CdEmpresa) LEFT JOIN                          \r\n"
				+ "                        (Select \r\n"
				+ "                              ES.IdProduto,\r\n"
				+ "                              ES.QtEstoque,\r\n"
				+ "                              S.CdEmpresa,\r\n"
				+ "                              S.IdSetor,\r\n"
				+ "                              S.NmSetor\r\n"
				+ "                             From \r\n"
				+ "                              dbo.EstoqueSetor ES (NOLOCK) Join\r\n"
				+ "                              dbo.Setor S (NOLOCK) ON (S.IdSetor = ES.IdSetor) \r\n"
				+ "                             Where \r\n"
				+ "                              ES.DtReferencia = (\r\n"
				+ "                                                 Select top 1\r\n"
				+ "                                                  MAX(ES1.DtReferencia)\r\n"
				+ "                                                 From \r\n"
				+ "                                                  dbo.EstoqueSetor ES1 (NOLOCK)\r\n"
				+ "                                                 Where \r\n"
				+ "                                                  (ES1.IdProduto = ES.IdProduto) AND \r\n"
				+ "                                                  (ES1.IdSetor   = ES.IdSetor) )) SE ON (SE.IdProduto = OP.IdProduto) AND \r\n"
				+ "                                                  (SE.CdEmpresa  = OP.CdEmpresa) AND \r\n"
				+ "                                                  (SE.IdSetor = \r\n"
				+ "                                                        Case\r\n"
				+ "                                                            when VPP.TpProduto = 'V' then CFG.IdSetorProdutoAcabado  \r\n"
				+ "                                                            when VPP.TpProduto = 'F' then CFG.IdSetorProdutoFabricado\r\n"
				+ "                                                            when VPP.TpProduto = 'C' then CFG.IdSetorAlmoxarifado  \r\n"
				+ "                                                            when VPP.TpProduto = 'P' then CFG.IdSetorProdutoPersonalizado                                                            \r\n"
				+ "                                                        End\r\n"
				+ "                                                  )\r\n"
				+ ") T\r\n"
				+ " WHERE \r\n"
				+ "  T.CdEmpresa = :cdEmpresa AND \r\n"
				+ "  T.DtCadastro BETWEEN :startDate AND :endDate AND "
				+ "  (T.NmProduto LIKE :value or T.CdChamada LIKE :value or T.CdProduto LIKE :value)  "
				+ " order by T.CdChamada,T.DtCadastro,T.IdPosicao ";
		

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("cdEmpresa", filter.getCdEmpresa());
        query.setParameter("startDate", filter.getDataInicio());
        query.setParameter("endDate", filter.getDataFinal());
        query.setParameter("value", "%" + filter.getValue() + "%");

        List<Object[]> resultList = query.getResultList();

        return resultList.stream().map(record -> new OrdemProducaoMaterialView() {
            @Override
            public Integer getCdEmpresa() {
                return ((Integer) record[0]);
            }
            @Override
            public String getIdOrdemProducaoItem() {
                return (String) record[1];
            }
            @Override
            public String getIdOrdemProducao() {
                return (String) record[2];
            }
            @Override
            public String getCdChamada() {
                return (String) record[3];
            }
            @Override
            public Date getDtCadastro() {
                return (Date) record[4];
            }
            @Override
            public String getIdListaProdutoItem() {
                return (String) record[5];
            }
            @Override
            public Character getStOrdemItem() {
                return (Character) record[6];
            }
            @Override
            public String getIdPosicao() {
                return (String) record[7];
            }
            @Override
            public String getIdProduto() {
                return (String) record[8];
            }
            @Override
            public String getCdProduto() {
                return (String) record[9];
            }
            @Override
            public String getNmProduto() {
                return ((String) record[10]);
            }
            @Override
            public String getTpProduto() {
                return (String) record[11];
            }
            @Override
            public Double getQtProdutoFinal() {
                return (Double) record[12];
            }
            @Override
            public Double getQtBase() {
                return (Double) record[13];
            }
            @Override
            public Double getQtProduzir() {
                return ((Double) record[14]);
            }
            @Override
            public Double getQtEstoque() {
                return (Double) record[15];
            }
            @Override
            public String getIdSetorSaida() {
                return (String) record[16];
            }
            @Override
            public String getIdSetorEntrada() {
                return (String) record[17];
            }
            @Override
            public Timestamp getDtNecessidade() {
                return (Timestamp) record[18];
            }
            @Override
            public Character getStProdutoFantasma() {
                return (Character) record[19];
            }
            @Override
            public Character getStComponente() {
                return (Character) record[20];
            }
            @Override
            public String getTpLote() {
                return (String) record[21];
            }
            
            @Override
            public Double getVlCustoBase() {
                return (Double) record[22];
            }
            
            @Override
            public Double getVlCusto() {
                return (Double) record[23];
            }  
            
            @Override
            public Double getQtEmpenhada() {
                return (Double) record[24];
            }  
            
            @Override
            public Double getQtProduzida() {
                return (Double) record[25];
            }  
            
            @Override
            public Double getQtEmpenhar() {
                return (Double) record[26];
            }              
                         
        }).collect(Collectors.toList());		 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemProducaoMaterialView> findMaterialExitByIdOrdemProducao(String id) {
		String sql = "SELECT "
				+ " *, QtProduzir - Isnull(QtEmpenhada,0) as QtEmpenhar "
				+ "FROM (\r\n"
				+ "SELECT \r\n"
				+ " OP.CdEmpresa,\r\n"
				+ " OPI.IdOrdemProducaoItem,\r\n"
				+ " OPI.IdOrdemProducao,\r\n"
				+ " RTRIM(OP.CdChamada) AS CdChamada,\r\n"
				+ " CONVERT(date,OP.DtCadastro) as DtCadastro,\r\n"
				+ " OPI.IdListaProdutoItem,\r\n"
				+ " OPI.StOrdemItem, \r\n"
				+ " OPI.IdPosicao,\r\n"
				+ " OPI.IdProdutoComponente AS IdProduto,\r\n"
				+ " RTRIM(VPP.CdProduto) AS CdProduto,\r\n"
				+ " VPP.NmProduto,\r\n"
				+ " VPP.TpProduto,  \r\n"
				+ " OP.QtProduto AS QtProdutoFinal, \r\n"
				+ " OPI.QtProdutoComponenteORI AS QtBase,\r\n"
				+ " OPI.QtProduzir,\r\n"
				+ " IsNull(SE.QtEstoque,0) as QtEstoque,\r\n"
				+ " CFG.IdSetorProducao as IdSetorSaida ,\r\n"				
				+ " Case\r\n"
				+ "     when VPP.TpProduto = 'V' then CFG.IdSetorProdutoAcabado  \r\n"
				+ "     when VPP.TpProduto = 'F' then CFG.IdSetorProdutoFabricado\r\n"
				+ "     when VPP.TpProduto = 'C' then CFG.IdSetorAlmoxarifado  \r\n"
				+ "     when VPP.TpProduto = 'P' then CFG.IdSetorProdutoPersonalizado                                                            \r\n"
				+ " End as IdSetorEntrada,\r\n"
				+ " OPI.DtNecessidade,\r\n"
				+ " OPI.StProdutoFantasma,\r\n"
				+ " OPI.StComponente,\r\n"
				+ " Case \r\n"
				+ "	When Isnull(VPP.StControlaLote,'N') = 'N' and Isnull(VPP.StControlaNrSerie,'N') = 'N'  then 'N' \r\n"
				+ "	When Isnull(VPP.StControlaLote,'N') = 'N' and Isnull(VPP.StControlaNrSerie,'N') = 'S'  then 'S' \r\n"
				+ "	When Isnull(VPP.StControlaLote,'N') = 'S' and Isnull(VPP.StControlaNrSerie,'N') = 'N'  then 'L' \r\n"
				+ " end as TpLote, ISNULL(OPI.VlCustoBase,0) AS VlCustoBase, ISNULL(OPI.VlCusto,0) AS VlCusto, "
				+ "(SELECT SUM(QtMovimento) FROM wpcp.OrdemProducao_MovEstoque where IdOrdemProducaoItem = OPI.IdOrdemProducaoItem and TpMovimento ='E') AS QtEmpenhada, "
				+ "(SELECT SUM(QtMovimento) FROM wpcp.OrdemProducao_MovEstoque where IdOrdemProducaoItem = OPI.IdOrdemProducaoItem and TpMovimento ='S') AS QtProduzida "
				+ "FROM \r\n"
				+ " wpcp.OrdemProducaoItem OPI (NOLOCK) JOIN\r\n"
				+ " wpcp.OrdemProducao      OP (NOLOCK) ON (OP.IdOrdemProducao = OPI.IdOrdemProducao AND OP.DtExclusao IS NULL) JOIN \r\n"
				+ " wpcp.vw_ProdutoPCP     VPP (NOLOCK) ON (VPP.IdProduto = OPI.IdProdutoComponente) JOIN\r\n"
				+ " wpcp.ConfiguracaoPCP   CFG (NOLOCK) ON (CFG.CdEmpresa = OP.CdEmpresa) LEFT JOIN                          \r\n"
				+ "                        (Select \r\n"
				+ "                              ES.IdProduto,\r\n"
				+ "                              ES.QtEstoque,\r\n"
				+ "                              S.CdEmpresa,\r\n"
				+ "                              S.IdSetor,\r\n"
				+ "                              S.NmSetor\r\n"
				+ "                             From \r\n"
				+ "                              dbo.EstoqueSetor ES (NOLOCK) Join\r\n"
				+ "                              dbo.Setor S (NOLOCK) ON (S.IdSetor = ES.IdSetor) \r\n"
				+ "                             Where \r\n"
				+ "                              ES.DtReferencia = (\r\n"
				+ "                                                 Select top 1\r\n"
				+ "                                                  MAX(ES1.DtReferencia)\r\n"
				+ "                                                 From \r\n"
				+ "                                                  dbo.EstoqueSetor ES1 (NOLOCK)\r\n"
				+ "                                                 Where \r\n"
				+ "                                                  (ES1.IdProduto = ES.IdProduto) AND \r\n"
				+ "                                                  (ES1.IdSetor   = ES.IdSetor) )) SE ON (SE.IdProduto = OP.IdProduto) AND \r\n"
				+ "                                                  (SE.CdEmpresa  = OP.CdEmpresa) AND \r\n"
				+ "                                                  (SE.IdSetor = \r\n"
				+ "                                                        Case\r\n"
				+ "                                                            when VPP.TpProduto = 'V' then CFG.IdSetorProdutoAcabado  \r\n"
				+ "                                                            when VPP.TpProduto = 'F' then CFG.IdSetorProdutoFabricado\r\n"
				+ "                                                            when VPP.TpProduto = 'C' then CFG.IdSetorAlmoxarifado  \r\n"
				+ "                                                            when VPP.TpProduto = 'P' then CFG.IdSetorProdutoPersonalizado                                                            \r\n"
				+ "                                                        End\r\n"
				+ "                                                  )\r\n"
				+ ") T\r\n"
				+ " WHERE \r\n"
				+ " T.IdOrdemProducao = :id "
				+ " order by T.IdPosicao ";
		

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);

        List<Object[]> resultList = query.getResultList();

        return resultList.stream().map(record -> new OrdemProducaoMaterialView() {
            @Override
            public Integer getCdEmpresa() {
                return ((Integer) record[0]);
            }
            @Override
            public String getIdOrdemProducaoItem() {
                return (String) record[1];
            }
            @Override
            public String getIdOrdemProducao() {
                return (String) record[2];
            }
            @Override
            public String getCdChamada() {
                return (String) record[3];
            }
            @Override
            public Date getDtCadastro() {
                return (Date) record[4];
            }
            @Override
            public String getIdListaProdutoItem() {
                return (String) record[5];
            }
            @Override
            public Character getStOrdemItem() {
                return (Character) record[6];
            }
            @Override
            public String getIdPosicao() {
                return (String) record[7];
            }
            @Override
            public String getIdProduto() {
                return (String) record[8];
            }
            @Override
            public String getCdProduto() {
                return (String) record[9];
            }
            @Override
            public String getNmProduto() {
                return ((String) record[10]);
            }
            @Override
            public String getTpProduto() {
                return (String) record[11];
            }
            @Override
            public Double getQtProdutoFinal() {
                return (Double) record[12];
            }
            @Override
            public Double getQtBase() {
                return (Double) record[13];
            }
            @Override
            public Double getQtProduzir() {
                return ((Double) record[14]);
            }
            @Override
            public Double getQtEstoque() {
                return (Double) record[15];
            }
            @Override
            public String getIdSetorSaida() {
                return (String) record[16];
            }
            @Override
            public String getIdSetorEntrada() {
                return (String) record[17];
            }
            @Override
            public Timestamp getDtNecessidade() {
                return (Timestamp) record[18];
            }
            @Override
            public Character getStProdutoFantasma() {
                return (Character) record[19];
            }
            @Override
            public Character getStComponente() {
                return (Character) record[20];
            }
            @Override
            public String getTpLote() {
                return (String) record[21];
            }
            
            @Override
            public Double getVlCustoBase() {
                return (Double) record[22];
            }
            
            @Override
            public Double getVlCusto() {
                return (Double) record[23];
            }  
            
            @Override
            public Double getQtEmpenhada() {
                return (Double) record[24];
            }  
            
            @Override
            public Double getQtProduzida() {
                return (Double) record[25];
            }  
            
            @Override
            public Double getQtEmpenhar() {
                return (Double) record[26];
            }             
                         
        }).collect(Collectors.toList());
	}	

}
