package com.ec.afsotec.modelo.request;

public class ParameterRequestConceptoNotas {
	
	private Integer empresa;
	private String trans;
	
	public ParameterRequestConceptoNotas() {
		super();
	}
	
	public ParameterRequestConceptoNotas(Integer empresa, String trans) {
		super();
		this.empresa = empresa;
		this.trans = trans;
	}
	
	public Integer getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}
	
	public String getTrans() {
		return trans;
	}
	
	public void setTrans(String trans) {
		this.trans = trans;
	}
	
	
}
