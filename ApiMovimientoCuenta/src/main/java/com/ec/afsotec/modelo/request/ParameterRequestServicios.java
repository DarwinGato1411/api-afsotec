package com.ec.afsotec.modelo.request;

public class ParameterRequestServicios {
	private Integer empresa;
	private String tipo;
	
	public ParameterRequestServicios() {
		super();
	}

	public ParameterRequestServicios(Integer empresa, String tipo) {
		super();
		this.empresa = empresa;
		this.tipo = tipo;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
