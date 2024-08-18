package br.com.greenwaiver.entities.view;

public class SetorView {

	private String idSetor;
	private Integer cdEmpresa;
	private Character stControlaLote;
	private String dsSetor;

	public SetorView(String idSetor, Integer cdEmpresa, Character stControlaLote, String dsSetor) {
		this.idSetor = idSetor;
		this.cdEmpresa = cdEmpresa;
		this.stControlaLote = stControlaLote;
		this.dsSetor = dsSetor;
	}

	public static SetorView fromRecord(Object[] record) {
		return new SetorView((String) record[0], (Integer) record[1], (Character) record[2], (String) record[3]);

	}

	public String getIdSetor() {
		return idSetor;
	}

	public Integer getCdEmpresa() {
		return cdEmpresa;
	}

	public Character getStControlaLote() {
		return stControlaLote;
	}

	public String getDsSetor() {
		return dsSetor;
	}

	public void setIdSetor(String idSetor) {
		this.idSetor = idSetor;
	}

	public void setCdEmpresa(Integer cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public void setStControlaLote(Character stControlaLote) {
		this.stControlaLote = stControlaLote;
	}

	public void setDsSetor(String dsSetor) {
		this.dsSetor = dsSetor;
	}

}
