package br.com.greenwaiver.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.com.greenwaiver.entities.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idProduto;
//	private List<Map<String, Object>> codigos = new ArrayList<>();
	private String codigoPrincipal;
	private String nmProduto;
	private String nmCurto;
	private String grupo;
	private String familia;
	private String unidade;
	private Character stAtivo;
	private Double vlPesoLiquido;
	private Double vlPesoBruto;
	private Double vlAltura;
	private Double vlProfundidade;
	private Double vlDiametro;
	private Double vlLargura;
	private Double vlRendimento;
	private Map<String, Object> pcp;

	public ProdutoDTO() {
	}

	public ProdutoDTO(Produto produto) {

		produto.getCodigos().stream().forEach(item -> {
//			Map<String, Object> codigo = new HashMap<>();
//			codigo.put("cdChamada", item.getCdChamada());
//			codigo.put("stCodigoPrincipal", item.getStCodigoPrincipal());
//			this.codigos.add(codigo);

			if ("S".equals(item.getStCodigoPrincipal())) {
				codigoPrincipal = item.getCdChamada();
			}

		});

		if (produto.getPcp() != null) {
			this.pcp = new HashMap<>();
			pcp.put("vlEspessura", produto.getPcp().getVlEspessura());
			pcp.put("vlConstante", produto.getPcp().getVlConstante());
			pcp.put("vlPesoAcrescido", produto.getPcp().getVlPesoAcrescido());
			pcp.put("vlLado", produto.getPcp().getVlLado());
			pcp.put("vlArea", produto.getPcp().getVlArea());
			pcp.put("qtEmbalagemProducao", produto.getPcp().getQtEmbalagemProducao());
			pcp.put("idTipoFabricacao", produto.getPcp().getIdTipoFabricacao());

			pcp.put("alIneficiencia", produto.getPcp().getAlIneficiencia());
			pcp.put("alPerda", produto.getPcp().getAlPerda());
			pcp.put("stCalcularMetro2", produto.getPcp().getStCalcularMetro2());
			pcp.put("stProdutoFantasma", produto.getPcp().getStProdutoFantasma());
			pcp.put("cor", produto.getPcp().getCor());
			pcp.put("diametroT", produto.getPcp().getDiametroT());
			pcp.put("diametroE", produto.getPcp().getDiametroE());
			pcp.put("diametroI", produto.getPcp().getDiametroI());
			pcp.put("diametroH", produto.getPcp().getDiametroH());
			pcp.put("diametroB", produto.getPcp().getDiametroB());
			pcp.put("diametroHt", produto.getPcp().getDiametroHt());
			pcp.put("limiteDiametroT", produto.getPcp().getLimiteDiametroT());
			pcp.put("limiteDiametroE", produto.getPcp().getLimiteDiametroE());
			pcp.put("limiteDiametroI", produto.getPcp().getLimiteDiametroI());
			pcp.put("limiteDiametroH", produto.getPcp().getLimiteDiametroH());
			pcp.put("limiteDiametroB", produto.getPcp().getLimiteDiametroB());
			pcp.put("limiteDiametroHt", produto.getPcp().getLimiteDiametroHt());
			pcp.put("trefila", produto.getPcp().getTrefila());
			pcp.put("macho", produto.getPcp().getMacho());
			pcp.put("ponteira", produto.getPcp().getPonteira());
			pcp.put("bucha", produto.getPcp().getBucha());
			pcp.put("anel", produto.getPcp().getAnel());
			pcp.put("pino", produto.getPcp().getPino());
			pcp.put("cabecote", produto.getPcp().getCabecote());
			pcp.put("entreCentro", produto.getPcp().getEntreCentro());
			pcp.put("pesoEspecifico", produto.getPcp().getPesoEspecifico());
			pcp.put("limitePesoEspecifico", produto.getPcp().getLimitePesoEspecifico());
			pcp.put("volumeEspecifico", produto.getPcp().getVolumeEspecifico());
			pcp.put("limiteVolumeEspec", produto.getPcp().getLimiteVolumeEspec());
			pcp.put("qtdEstrutura", produto.getPcp().getQtdEstrutura());
			pcp.put("gargalo", produto.getPcp().getGargalo());
			pcp.put("ciclo", produto.getPcp().getCiclo());
			pcp.put("cavidade", produto.getPcp().getCavidade());
			pcp.put("espessura", produto.getPcp().getEspessura());
			pcp.put("limiteEspessura", produto.getPcp().getLimiteEspessura());
			pcp.put("diametroH1", produto.getPcp().getDiametroH1());
			pcp.put("limiteDiametroH1", produto.getPcp().getLimiteDiametroH1());
			pcp.put("molde", produto.getPcp().getMolde());
			pcp.put("setup", produto.getPcp().getSetup());
			pcp.put("tpSetup", produto.getPcp().getTpSetup());
			pcp.put("tpCiclo", produto.getPcp().getTpCiclo());
		}

		this.familia = Optional.of(produto.getFamiliaProduto().getNmFamiliaProduto()).orElse("");
		this.grupo = Optional.of(produto.getGrupoProduto().getNmGrupoProduto()).orElse("");
		this.unidade = Optional.of(produto.getUnidade().getCdSigla()).orElse("");
		this.idProduto = produto.getIdProduto();
		this.nmProduto = produto.getNmProduto();
		this.nmCurto = produto.getNmCurto();
		this.stAtivo = produto.getStAtivo();
		this.vlPesoLiquido = produto.getVlPesoLiquido();
		this.vlPesoBruto = produto.getVlPesoBruto();
		this.vlAltura = produto.getVlAltura();
		this.vlProfundidade = produto.getVlProfundidade();
		this.vlDiametro = produto.getVlDiametro();
		this.vlLargura = produto.getVlLargura();
		this.vlRendimento = produto.getVlRendimento();

	}

	public String getCodigoPrincipal() {
		return codigoPrincipal;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public Character getStAtivo() {
		return stAtivo;
	}

	public Double getVlPesoLiquido() {
		return vlPesoLiquido;
	}

	public Double getVlPesoBruto() {
		return vlPesoBruto;
	}

	public Double getVlAltura() {
		return vlAltura;
	}

	public Double getVlProfundidade() {
		return vlProfundidade;
	}

	public Double getVlDiametro() {
		return vlDiametro;
	}

	public String getNmCurto() {
		return nmCurto;
	}

	public Double getVlLargura() {
		return vlLargura;
	}

	public Double getVlRendimento() {
		return vlRendimento;
	}

//	public List<Map<String, Object>> getCodigos() {
//		return codigos;
//	}

	public Map<String, Object> getPcp() {
		return pcp;
	}

	public String getGrupo() {
		return grupo;
	}

	public String getUnidade() {
		return unidade;
	}

	public String getFamilia() {
		return familia;
	}

}
