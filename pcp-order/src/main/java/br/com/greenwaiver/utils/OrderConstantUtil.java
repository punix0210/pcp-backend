package br.com.greenwaiver.utils;

public class OrderConstantUtil {
	
	public static final String SQL_ORDERS_PAGE = "SELECT OP.*,Isnull(SE.qtEstoque, 0) as QtEstoque, \r\n"
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
	
	public static final String SQL_ORDERS_MATERIAL_EMPENHO = "SELECT "
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
	
	public static final String SQL_ORDERS_MATERIAL_SAIDA_AND_ESTORNO_ENTRADA = "SELECT " + " *, QtProduzir - Isnull(QtEmpenhada,0) as QtEmpenhar " + "FROM (\r\n" + "SELECT \r\n"
			+ " OP.CdEmpresa,\r\n" + " OPI.IdOrdemProducaoItem,\r\n" + " OPI.IdOrdemProducao,\r\n"
			+ " RTRIM(OP.CdChamada) AS CdChamada,\r\n" + " CONVERT(date,OP.DtCadastro) as DtCadastro,\r\n"
			+ " OPI.IdListaProdutoItem,\r\n" + " OPI.StOrdemItem, \r\n" + " OPI.IdPosicao,\r\n"
			+ " OPI.IdProdutoComponente AS IdProduto,\r\n" + " RTRIM(VPP.CdProduto) AS CdProduto,\r\n"
			+ " VPP.NmProduto,\r\n" + " VPP.TpProduto,  \r\n" + " OP.QtProduto AS QtProdutoFinal, \r\n"
			+ " OPI.QtProdutoComponenteORI AS QtBase,\r\n" + " OPI.QtProduzir,\r\n"
			+ " IsNull(SE.QtEstoque,0) as QtEstoque,\r\n" + " CFG.IdSetorProducao as IdSetorSaida ,\r\n"
			+ " Case\r\n" + "     when VPP.TpProduto = 'V' then CFG.IdSetorProdutoAcabado  \r\n"
			+ "     when VPP.TpProduto = 'F' then CFG.IdSetorProdutoFabricado\r\n"
			+ "     when VPP.TpProduto = 'C' then CFG.IdSetorAlmoxarifado  \r\n"
			+ "     when VPP.TpProduto = 'P' then CFG.IdSetorProdutoPersonalizado                                                            \r\n"
			+ " End as IdSetorEntrada,\r\n" + " OPI.DtNecessidade,\r\n" + " OPI.StProdutoFantasma,\r\n"
			+ " OPI.StComponente,\r\n" + " Case \r\n"
			+ "	When Isnull(VPP.StControlaLote,'N') = 'N' and Isnull(VPP.StControlaNrSerie,'N') = 'N'  then 'N' \r\n"
			+ "	When Isnull(VPP.StControlaLote,'N') = 'N' and Isnull(VPP.StControlaNrSerie,'N') = 'S'  then 'S' \r\n"
			+ "	When Isnull(VPP.StControlaLote,'N') = 'S' and Isnull(VPP.StControlaNrSerie,'N') = 'N'  then 'L' \r\n"
			+ " end as TpLote, ISNULL(OPI.VlCustoBase,0) AS VlCustoBase, ISNULL(OPI.VlCusto,0) AS VlCusto, "
			+ "(SELECT SUM(QtMovimento) FROM wpcp.OrdemProducao_MovEstoque where IdOrdemProducaoItem = OPI.IdOrdemProducaoItem and TpMovimento ='E') AS QtEmpenhada, "
			+ "(SELECT SUM(QtMovimento) FROM wpcp.OrdemProducao_MovEstoque where IdOrdemProducaoItem = OPI.IdOrdemProducaoItem and TpMovimento ='S') AS QtProduzida "
			+ "FROM \r\n" + " wpcp.OrdemProducaoItem OPI (NOLOCK) JOIN\r\n"
			+ " wpcp.OrdemProducao      OP (NOLOCK) ON (OP.IdOrdemProducao = OPI.IdOrdemProducao AND OP.DtExclusao IS NULL) JOIN \r\n"
			+ " wpcp.vw_ProdutoPCP     VPP (NOLOCK) ON (VPP.IdProduto = OPI.IdProdutoComponente) JOIN\r\n"
			+ " wpcp.ConfiguracaoPCP   CFG (NOLOCK) ON (CFG.CdEmpresa = OP.CdEmpresa) LEFT JOIN                          \r\n"
			+ "                        (Select \r\n" + "                              ES.IdProduto,\r\n"
			+ "                              ES.QtEstoque,\r\n" + "                              S.CdEmpresa,\r\n"
			+ "                              S.IdSetor,\r\n" + "                              S.NmSetor\r\n"
			+ "                             From \r\n"
			+ "                              dbo.EstoqueSetor ES (NOLOCK) Join\r\n"
			+ "                              dbo.Setor S (NOLOCK) ON (S.IdSetor = ES.IdSetor) \r\n"
			+ "                             Where \r\n" + "                              ES.DtReferencia = (\r\n"
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
			+ "                                                  )\r\n" + ") T\r\n" + " WHERE \r\n"
			+ " T.IdOrdemProducao = :id " + " order by T.IdPosicao ";

}
