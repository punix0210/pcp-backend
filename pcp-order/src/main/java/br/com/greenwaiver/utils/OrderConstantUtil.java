package br.com.greenwaiver.utils;

public class OrderConstantUtil {
	
	public static final String SQL_ORDERS_PAGE = 
			"SELECT "
					+ "    OP.*,"
					+ "    ISNULL(SE.qtEstoque, 0) AS QtEstoque,"
					+ "    CASE"
					+ "        WHEN OP.TpProduto = 'V' THEN CFG.IdSetorProdutoAcabado"
					+ "        WHEN OP.TpProduto = 'F' THEN CFG.IdSetorProdutoFabricado"
					+ "    END AS IdSetor,"
					+ "    SE.NmSetor "
					+ "FROM ("
					+ "    SELECT "
					+ "        op.IdOrdemProducao,"
					+ "        RTRIM(op.CdChamada) AS CdChamada,"
					+ "        CONVERT(DATE, op.DtCadastro) AS DtCadastro,"
					+ "        RTRIM(op.StOrdem) AS StOrdem,"
					+ "        ISNULL(op.QtAtendida, 0) AS QtAtendida,"
					+ "        op.DtPrevInicio,"
					+ "        op.DtPrevTerminio,"
					+ "        op.DtLimiteProducao,"
					+ "        op.CdEmpresa,"
					+ "        CASE "
					+ "            WHEN op.NmEntidadeOrigem = 'OrdemProducao' THEN CONVERT(BIT, 1) "
					+ "            ELSE CONVERT(BIT, 0) "
					+ "        END AS IsSubOrdem,"
					+ "        pp.IdProduto,"
					+ "        RTRIM(pp.cdProduto) AS CdProduto,"
					+ "        pp.NmProduto,"
					+ "        op.QtProduto,"
					+ "        op.IdInformacaoGeral,"
					+ "        CONVERT(VARCHAR(5), ig.TpInformacaoGeral) AS TpInformacaoGeralOP,"
					+ "        ig.DsInformacaoGeral,"
					+ "        op.TpFixacao,"
					+ "        CASE "
					+ "            WHEN op.TpAtendimento = 'T' THEN 'Total'"
					+ "            WHEN op.TpAtendimento = 'P' THEN 'Parcial'"
					+ "            WHEN op.TpAtendimento = 'X' THEN 'Com Corte'"
					+ "            WHEN op.TpAtendimento = 'L' THEN 'Liberado'"
					+ "        END AS TpAtendimento,"
					+ "        CASE "
					+ "            WHEN op.tpOrdemOrigem = 'PV' THEN 'Pedido de Venda'"
					+ "            WHEN op.tpOrdemOrigem = 'PD' THEN 'Produto Avulso'"
					+ "            WHEN op.tpOrdemOrigem = 'LT' THEN 'Lote de Producao'"
					+ "            WHEN op.tpOrdemOrigem = 'PC' THEN 'Pedido de Compra'"
					+ "        END AS tpOrdemOrigem,"
					+ "        op.QtProduto - ISNULL(op.QtAtendida, 0) AS QtAtender,"
					+ "        op.DtExclusao,"
					+ "        RTRIM(pp.CdSigla) AS CdSigla,"
					+ "        RTRIM(pp.TpProduto) AS TpProduto,"
					+ "        op.IdMaquina,"
					+ "        RTRIM(Maq.cdChamada) + ' - ' + Maq.DsMaquina AS DsMaquina,"
					+ "        CASE "
					+ "            WHEN ISNULL(op.seqPrioridade, '') = '' THEN '999' "
					+ "            ELSE op.seqPrioridade "
					+ "        END AS SeqPrioridade"
					+ "    FROM "
					+ "        wpcp.OrdemProducao op (NOLOCK)"
					+ "    JOIN "
					+ "        wpcp.vw_ProdutoPCP pp ON (pp.IdProduto = op.IdProduto)"
					+ "    JOIN "
					+ "        dbo.InformacaoGeral ig (NOLOCK) ON (ig.IdInformacaoGeral = op.IdInformacaoGeral)"
					+ "    LEFT JOIN "
					+ "        wpcp.Maquina Maq (NOLOCK) ON (Maq.idMaquina = op.idMaquina)"
					+ ") OP "
					+ "JOIN "
					+ "    wpcp.ConfiguracaoPCP CFG (NOLOCK) ON (CFG.CdEmpresa = OP.CdEmpresa) "
					+ "LEFT JOIN ("
					+ "    SELECT "
					+ "        ES.IdProduto,"
					+ "        ES.QtEstoque,"
					+ "        S.CdEmpresa,"
					+ "        S.IdSetor,"
					+ "        S.NmSetor"
					+ "    FROM "
					+ "        dbo.EstoqueSetor ES (NOLOCK)"
					+ "    JOIN "
					+ "        dbo.Setor S (NOLOCK) ON (S.IdSetor = ES.IdSetor)"
					+ "    WHERE "
					+ "        ES.DtReferencia = ("
					+ "            SELECT "
					+ "                TOP 1 MAX(ES1.DtReferencia)"
					+ "            FROM "
					+ "                dbo.EstoqueSetor ES1 (NOLOCK)"
					+ "            WHERE "
					+ "                ES1.IdProduto = ES.IdProduto AND "
					+ "                ES1.IdSetor = ES.IdSetor"
					+ "        )"
					+ ") SE ON "
					+ "    SE.IdProduto = OP.IdProduto AND "
					+ "    SE.CdEmpresa = OP.CdEmpresa AND "
					+ "    SE.IdSetor = CASE "
					+ "                    WHEN OP.TpProduto = 'V' THEN CFG.IdSetorProdutoAcabado"
					+ "                    WHEN OP.TpProduto = 'F' THEN CFG.IdSetorProdutoFabricado"
					+ "                 END "
					+ "WHERE "
					+ "    OP.CdEmpresa = :cdEmpresa AND "
					+ "    OP.DtCadastro BETWEEN :startDate AND :endDate AND "
					+ "    OP.StOrdem = CASE WHEN :stOrdem = '' THEN OP.StOrdem ELSE :stOrdem END AND "
					+ "    OP.TpInformacaoGeralOP LIKE :tpInformacaoGeralOP AND "
					+ "    OP.IsSubOrdem = CASE WHEN :isSubOrdem = '01' THEN OP.IsSubOrdem ELSE :isSubOrdem END AND("
					+ "    OP.NmProduto LIKE :value OR OP.CdChamada LIKE :value OR "
					+ "    OP.CdProduto LIKE :value OR ISNULL(OP.DsMaquina, '') LIKE :value) "
					+ " AND "
					+ "    OP.DtExclusao IS NULL"
					+ "";
	
	public static final String SQL_ORDERS_MATERIAL_EMPENHO = 
			"SELECT  "
					+ "    *,  "
					+ "    QtProduzir - ISNULL(QtEmpenhada, 0) AS QtEmpenhar  "
					+ "FROM ( "
					+ "    SELECT  "
					+ "        OP.CdEmpresa, "
					+ "        OPI.IdOrdemProducaoItem, "
					+ "        OPI.IdOrdemProducao, "
					+ "        RTRIM(OP.CdChamada) AS CdChamada, "
					+ "        CONVERT(DATE, OP.DtCadastro) AS DtCadastro, "
					+ "        OPI.IdListaProdutoItem, "
					+ "        OPI.StOrdemItem,  "
					+ "        OPI.IdPosicao, "
					+ "        OPI.IdProdutoComponente AS IdProduto, "
					+ "        RTRIM(VPP.CdProduto) AS CdProduto, "
					+ "        VPP.NmProduto, "
					+ "        VPP.TpProduto,   "
					+ "        OP.QtProduto AS QtProdutoFinal,  "
					+ "        OPI.QtProdutoComponenteORI AS QtBase, "
					+ "        OPI.QtProduzir, "
					+ "        ISNULL(SE.QtEstoque, 0) AS QtEstoque, "
					+ "        CASE "
					+ "            WHEN VPP.TpProduto = 'V' THEN CFG.IdSetorProdutoAcabado "
					+ "            WHEN VPP.TpProduto = 'F' THEN CFG.IdSetorProdutoFabricado "
					+ "            WHEN VPP.TpProduto = 'C' THEN CFG.IdSetorAlmoxarifado "
					+ "            WHEN VPP.TpProduto = 'P' THEN CFG.IdSetorProdutoPersonalizado "
					+ "        END AS IdSetorSaida, "
					+ "        CFG.IdSetorProducao AS IdSetorEntrada, "
					+ "        OPI.DtNecessidade, "
					+ "        OPI.StProdutoFantasma, "
					+ "        OPI.StComponente, "
					+ "        CASE  "
					+ "            WHEN ISNULL(VPP.StControlaLote, 'N') = 'N' AND ISNULL(VPP.StControlaNrSerie, 'N') = 'N' THEN 'N' "
					+ "            WHEN ISNULL(VPP.StControlaLote, 'N') = 'N' AND ISNULL(VPP.StControlaNrSerie, 'N') = 'S' THEN 'S' "
					+ "            WHEN ISNULL(VPP.StControlaLote, 'N') = 'S' AND ISNULL(VPP.StControlaNrSerie, 'N') = 'N' THEN 'L' "
					+ "        END AS TpLote, "
					+ "        ISNULL(OPI.VlCustoBase, 0) AS VlCustoBase, "
					+ "        ISNULL(OPI.VlCusto, 0) AS VlCusto, "
					+ "        (SELECT SUM(QtMovimento)  "
					+ "         FROM wpcp.OrdemProducao_MovEstoque  "
					+ "         WHERE IdOrdemProducaoItem = OPI.IdOrdemProducaoItem  "
					+ "           AND TpMovimento = 'E') AS QtEmpenhada, "
					+ "        (SELECT SUM(QtMovimento)  "
					+ "         FROM wpcp.OrdemProducao_MovEstoque  "
					+ "         WHERE IdOrdemProducaoItem = OPI.IdOrdemProducaoItem  "
					+ "           AND TpMovimento = 'S') AS QtProduzida "
					+ "    FROM  "
					+ "        wpcp.OrdemProducaoItem OPI (NOLOCK) "
					+ "    JOIN  "
					+ "        wpcp.OrdemProducao OP (NOLOCK) ON (OP.IdOrdemProducao = OPI.IdOrdemProducao AND OP.DtExclusao IS NULL) "
					+ "    JOIN  "
					+ "        wpcp.vw_ProdutoPCP VPP (NOLOCK) ON (VPP.IdProduto = OPI.IdProdutoComponente) "
					+ "    JOIN  "
					+ "        wpcp.ConfiguracaoPCP CFG (NOLOCK) ON (CFG.CdEmpresa = OP.CdEmpresa) "
					+ "    LEFT JOIN ( "
					+ "        SELECT  "
					+ "            ES.IdProduto, "
					+ "            ES.QtEstoque, "
					+ "            S.CdEmpresa, "
					+ "            S.IdSetor, "
					+ "            S.NmSetor "
					+ "        FROM  "
					+ "            dbo.EstoqueSetor ES (NOLOCK) "
					+ "        JOIN  "
					+ "            dbo.Setor S (NOLOCK) ON (S.IdSetor = ES.IdSetor) "
					+ "        WHERE  "
					+ "            ES.DtReferencia = ( "
					+ "                SELECT TOP 1  "
					+ "                    MAX(ES1.DtReferencia) "
					+ "                FROM  "
					+ "                    dbo.EstoqueSetor ES1 (NOLOCK) "
					+ "                WHERE  "
					+ "                    ES1.IdProduto = ES.IdProduto  "
					+ "                    AND ES1.IdSetor = ES.IdSetor "
					+ "            ) "
					+ "    ) SE ON ( "
					+ "        SE.IdProduto = OP.IdProduto  "
					+ "        AND SE.CdEmpresa = OP.CdEmpresa  "
					+ "        AND SE.IdSetor = CASE "
					+ "            WHEN VPP.TpProduto = 'V' THEN CFG.IdSetorProdutoAcabado "
					+ "            WHEN VPP.TpProduto = 'F' THEN CFG.IdSetorProdutoFabricado "
					+ "            WHEN VPP.TpProduto = 'C' THEN CFG.IdSetorAlmoxarifado "
					+ "            WHEN VPP.TpProduto = 'P' THEN CFG.IdSetorProdutoPersonalizado "
					+ "        END "
					+ "    ) "
					+ ") T "
					+ "WHERE  "
					+ "    T.CdEmpresa = :cdEmpresa  "
					+ "    AND T.DtCadastro BETWEEN :startDate AND :endDate  "
					+ "    AND (T.NmProduto LIKE :value  "
					+ "         OR T.CdChamada LIKE :value  "
					+ "         OR T.CdProduto LIKE :value) "
					+ "ORDER BY  "
					+ "    T.CdChamada, T.DtCadastro, T.IdPosicao "
					+ ""			;
	
	public static final String SQL_ORDERS_MATERIAL_SAIDA_AND_ESTORNO_ENTRADA = 
			"SELECT  "
					+ "    *,  "
					+ "    QtProduzir - ISNULL(QtEmpenhada, 0) AS QtEmpenhar  "
					+ "FROM ( "
					+ "    SELECT  "
					+ "        OP.CdEmpresa, "
					+ "        OPI.IdOrdemProducaoItem, "
					+ "        OPI.IdOrdemProducao, "
					+ "        RTRIM(OP.CdChamada) AS CdChamada, "
					+ "        CONVERT(DATE, OP.DtCadastro) AS DtCadastro, "
					+ "        OPI.IdListaProdutoItem, "
					+ "        OPI.StOrdemItem,  "
					+ "        OPI.IdPosicao, "
					+ "        OPI.IdProdutoComponente AS IdProduto, "
					+ "        RTRIM(VPP.CdProduto) AS CdProduto, "
					+ "        VPP.NmProduto, "
					+ "        VPP.TpProduto,   "
					+ "        OP.QtProduto AS QtProdutoFinal,  "
					+ "        OPI.QtProdutoComponenteORI AS QtBase, "
					+ "        OPI.QtProduzir, "
					+ "        ISNULL(SE.QtEstoque, 0) AS QtEstoque, "
					+ "        CFG.IdSetorProducao AS IdSetorSaida, "
					+ "        CASE "
					+ "            WHEN VPP.TpProduto = 'V' THEN CFG.IdSetorProdutoAcabado "
					+ "            WHEN VPP.TpProduto = 'F' THEN CFG.IdSetorProdutoFabricado "
					+ "            WHEN VPP.TpProduto = 'C' THEN CFG.IdSetorAlmoxarifado "
					+ "            WHEN VPP.TpProduto = 'P' THEN CFG.IdSetorProdutoPersonalizado "
					+ "        END AS IdSetorEntrada, "
					+ "        OPI.DtNecessidade, "
					+ "        OPI.StProdutoFantasma, "
					+ "        OPI.StComponente, "
					+ "        CASE  "
					+ "            WHEN ISNULL(VPP.StControlaLote, 'N') = 'N' AND ISNULL(VPP.StControlaNrSerie, 'N') = 'N' THEN 'N' "
					+ "            WHEN ISNULL(VPP.StControlaLote, 'N') = 'N' AND ISNULL(VPP.StControlaNrSerie, 'N') = 'S' THEN 'S' "
					+ "            WHEN ISNULL(VPP.StControlaLote, 'N') = 'S' AND ISNULL(VPP.StControlaNrSerie, 'N') = 'N' THEN 'L' "
					+ "        END AS TpLote, "
					+ "        ISNULL(OPI.VlCustoBase, 0) AS VlCustoBase, "
					+ "        ISNULL(OPI.VlCusto, 0) AS VlCusto, "
					+ "        (SELECT SUM(QtMovimento)  "
					+ "         FROM wpcp.OrdemProducao_MovEstoque  "
					+ "         WHERE IdOrdemProducaoItem = OPI.IdOrdemProducaoItem  "
					+ "           AND TpMovimento = 'E') AS QtEmpenhada, "
					+ "        (SELECT SUM(QtMovimento)  "
					+ "         FROM wpcp.OrdemProducao_MovEstoque  "
					+ "         WHERE IdOrdemProducaoItem = OPI.IdOrdemProducaoItem  "
					+ "           AND TpMovimento = 'S') AS QtProduzida "
					+ "    FROM  "
					+ "        wpcp.OrdemProducaoItem OPI (NOLOCK) "
					+ "    JOIN  "
					+ "        wpcp.OrdemProducao OP (NOLOCK) ON (OP.IdOrdemProducao = OPI.IdOrdemProducao AND OP.DtExclusao IS NULL) "
					+ "    JOIN  "
					+ "        wpcp.vw_ProdutoPCP VPP (NOLOCK) ON (VPP.IdProduto = OPI.IdProdutoComponente) "
					+ "    JOIN  "
					+ "        wpcp.ConfiguracaoPCP CFG (NOLOCK) ON (CFG.CdEmpresa = OP.CdEmpresa) "
					+ "    LEFT JOIN ( "
					+ "        SELECT  "
					+ "            ES.IdProduto, "
					+ "            ES.QtEstoque, "
					+ "            S.CdEmpresa, "
					+ "            S.IdSetor, "
					+ "            S.NmSetor "
					+ "        FROM  "
					+ "            dbo.EstoqueSetor ES (NOLOCK) "
					+ "        JOIN  "
					+ "            dbo.Setor S (NOLOCK) ON (S.IdSetor = ES.IdSetor) "
					+ "        WHERE  "
					+ "            ES.DtReferencia = ( "
					+ "                SELECT TOP 1  "
					+ "                    MAX(ES1.DtReferencia) "
					+ "                FROM  "
					+ "                    dbo.EstoqueSetor ES1 (NOLOCK) "
					+ "                WHERE  "
					+ "                    ES1.IdProduto = ES.IdProduto  "
					+ "                    AND ES1.IdSetor = ES.IdSetor "
					+ "            ) "
					+ "    ) SE ON ( "
					+ "        SE.IdProduto = OP.IdProduto  "
					+ "        AND SE.CdEmpresa = OP.CdEmpresa  "
					+ "        AND SE.IdSetor = CASE "
					+ "            WHEN VPP.TpProduto = 'V' THEN CFG.IdSetorProdutoAcabado "
					+ "            WHEN VPP.TpProduto = 'F' THEN CFG.IdSetorProdutoFabricado "
					+ "            WHEN VPP.TpProduto = 'C' THEN CFG.IdSetorAlmoxarifado "
					+ "            WHEN VPP.TpProduto = 'P' THEN CFG.IdSetorProdutoPersonalizado "
					+ "        END "
					+ "    ) "
					+ ") T "
					+ "WHERE  "
					+ "    T.IdOrdemProducao = :id  "
					+ "ORDER BY  "
					+ "    T.IdPosicao "
					+ ""			;

}
