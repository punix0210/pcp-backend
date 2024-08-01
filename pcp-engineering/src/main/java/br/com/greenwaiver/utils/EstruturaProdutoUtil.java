package br.com.greenwaiver.utils;

import br.com.greenwaiver.entities.EstruturaProdutoView;

public class EstruturaProdutoUtil {

	public static String SQL_CHILD = "SELECT " + "lpi.idListaProduto as idListaDad, "
			+ "lp2.idListaProduto as idListaChildren, " + "lp.idProduto AS idParent, " + "vpp.idProduto, "
			+ "vpp.cdChamada AS cdProduto, " + "vpp.nmProduto, " + "lpi.qtProdutoComponente AS qtProduto, "
			+ " CAST(lpi.stComponentePrincipal as varchar(100)) as stComponentePrincipal, " 
			+ " CAST(lpi.tpProduto as varchar(100)) as tpProduto, " + "lpi.idPosicao, " + "lpi.qtMedHorizontal, "
			+ "lpi.qtMedVertical, " + "lpi.dsModelo, " 
			+ " CAST(lpi.stComponente as varchar(100)) as stComponente, " 
			+ " CAST(lpi.stProdutoFantasma as varchar(100)) as stProdutoFantasma , "
			+ "lpi.vlPerdaHorizontal, " + "lpi.vlPerdaVertical, " + "lpi.qtRendimento, " + "lpi.qtPecaM2, "
			+ "lpi.qtAproveitamento, " + "lpi.qtTotRendimento, " + "lpi.qtBase, " + "lpi.vlFator, "
			+ "COALESCE(lpi.cdEmpresaOp, 0) AS cdEmpresaOp " + "FROM wpcp.ListaProdutoItem lpi "
			+ "JOIN wpcp.ListaProduto lp ON lp.idListaProduto = lpi.idListaProduto AND lpi.idUsuarioExclusao IS NULL "
			+ "JOIN dbo.vw_ProdutoPrincipal vpp ON vpp.idProduto = lpi.idProdutoComponente "
			+ "LEFT JOIN wpcp.ListaProduto lp2 ON lp2.idProduto = lpi.idProdutoComponente "
			+ "    AND lp2.stPrincipal = lp.stPrincipal " + "    AND lp2.stAtivo = lp.stAtivo "
			+ "WHERE lp.idListaProduto = :idListaProduto " + "    AND lp.stPrincipal = 'S' "
			+ "    AND lp.stAtivo = 'S' " + "ORDER BY lpi.idPosicao";

	public static String SQL_DAD = "SELECT " + " lp.idListaProduto AS idListaDad, " + " '' AS idListaChildren, "
			+ " '' AS idParent, " + " vpp.idProduto, " + " vpp.cdChamada AS cdProduto, " + " vpp.nmProduto, "
			+ " CAST(1 AS float) AS qtProduto, " + " 'N' AS stComponentePrincipal, " + " pp.tpProduto AS tpProduto, "
			+ " '000' AS idPosicao, " + " CAST(0 AS float) AS qtMedHorizontal, "
			+ " CAST(0 AS float) AS qtMedVertical, " + " '' AS dsModelo, " + " 'N' AS stComponente, "
			+ " 'N' AS stProdutoFantasma, " + " CAST(0 AS float) AS vlPerdaHorizontal, "
			+ " CAST(0 AS float) AS vlPerdaVertical, " + " CAST(0 AS float) AS qtRendimento, "
			+ " CAST(0 AS float) AS qtPecaM2, " + " CAST(0 AS float) AS qtAproveitamento, "
			+ " CAST(0 AS float) AS qtTotRendimento, " + " CAST(1 AS float) AS qtBase, "
			+ " CAST(0 AS float) AS vlFator, " + " 0 AS cdEmpresaOp "
			+ "FROM wpcp.ListaProduto lp, dbo.vw_ProdutoPrincipal vpp, wpcp.ProdutoPCP pp "
			+ "WHERE lp.idProduto = vpp.idProduto " + "    AND vpp.idProduto = pp.idProduto "
			+ "    AND lp.idListaProduto = :idListaProduto " + "    AND lp.stPrincipal = 'S' "
			+ "    AND lp.stAtivo = 'S' " + "ORDER BY lp.idListaProduto";

	public static EstruturaProdutoView toObject(Object[] result) {
		return new EstruturaProdutoView((String) result[0], // idListaDad
				(String) result[1], // idListaChildren
				(String) result[2], // idParent
				(String) result[3], // idProduto
				(String) result[4], // cdProduto
				(String) result[5], // nmProduto
				(Double) result[6], // qtProduto
				(String) result[7], // stComponentePrincipal
				(String) result[8], // tpProduto
				(String) result[9], // idPosicao
				(Double) result[10], // qtMedHorizontal
				(Double) result[11], // qtMedVertical
				(String) result[12], // dsModelo
				(String) result[13], // stComponente
				(String) result[14], // stProdutoFantasma
				(Double) result[15], // vlPerdaHorizontal
				(Double) result[16], // vlPerdaVertical
				(Double) result[17], // qtRendimento
				(Double) result[18], // qtPecaM2
				(Double) result[19], // qtAproveitamento
				(Double) result[20], // qtTotRendimento
				(Double) result[21], // qtBase
				(Double) result[22], // vlFator
				(Integer) result[23] // cdEmpresaOp				
		);
	}

//	public static String SQL_DAD = "SELECT "
//			+ " lp.idListaProduto AS idListaDad, "
//	        + " '' AS idListaChildren, "
//	        + " '' AS idParent, "
//	        + " vpp.idProduto, "
//	        + " vpp.cdChamada AS cdProduto, "
//	        + " vpp.nmProduto, "
//	        + " 1 AS qtProduto, "
//	        + " 'N' AS stComponentePrincipal, "
//	        + " pp.tpProduto AS tpProduto, "
//	        + " '000' AS idPosicao, "
//	        + " 0 AS qtMedHorizontal, "
//	        + " 0 AS qtMedVertical, "
//	        + " '' AS dsModelo, "
//	        + " 'N' AS stComponente, "
//	        + " 'N' AS stProdutoFantasma, "
//	        + " 0 AS vlPerdaHorizontal, "
//	        + " 0 AS vlPerdaVertical, "
//	        + " 0 AS qtRendimento, "
//	        + " 0 AS qtPecaM2, "
//	        + " 0 AS qtAproveitamento, "
//	        + " 0 AS qtTotRendimento, "
//	        + " 1 AS qtBase, "
//	        + " 0 AS vlFator, "
//	        + " 0 AS cdEmpresaOp "
//	        + "FROM ListaProduto lp "
//	        + "JOIN ProdutoPrincipal vpp ON vpp.idProduto = lp.idProduto "
//	        + "JOIN ProdutoPCP pp ON pp.idProduto = vpp.idProduto "
//            + "WHERE lp.idListaProduto = :idListaProduto "
//            + "    AND lp.stPrincipal = 'S' "
//            + "    AND lp.stAtivo = 'S' "
//            + "ORDER BY lpi.idPosicao";

}
