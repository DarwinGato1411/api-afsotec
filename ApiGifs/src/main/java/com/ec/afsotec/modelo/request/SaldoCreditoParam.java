package com.ec.afsotec.modelo.request;

import java.math.BigDecimal;
import java.util.Date;

public class SaldoCreditoParam {
	private String identificacion;

	private Integer empresa;

	public SaldoCreditoParam() {
		super();
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}


	
}
