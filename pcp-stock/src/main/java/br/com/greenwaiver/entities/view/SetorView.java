package br.com.greenwaiver.entities.view;

public class SetorView {

	private String idSetor;
	private String cdEmpresa;
	private String stControlaLote;
	private String dsSetor;

	public SetorView(String idSetor, String cdEmpresa, String stControlaLote, String dsSetor) {
		this.idSetor = idSetor;
		this.cdEmpresa = cdEmpresa;
		this.stControlaLote = stControlaLote;
		this.dsSetor = dsSetor;
	}

	public static SetorView fromRecord(Object[] record) {
		return new SetorView((String) record[0], (String) record[1], (String) record[2], (String) record[3]);

	}

	public String getIdSetor() {
		return idSetor;
	}

	public String getCdEmpresa() {
		return cdEmpresa;
	}

	public String getStControlaLote() {
		return stControlaLote;
	}

	public String getDsSetor() {
		return dsSetor;
	}

	public void setIdSetor(String idSetor) {
		this.idSetor = idSetor;
	}

	public void setCdEmpresa(String cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public void setStControlaLote(String stControlaLote) {
		this.stControlaLote = stControlaLote;
	}

	public void setDsSetor(String dsSetor) {
		this.dsSetor = dsSetor;
	}

}
