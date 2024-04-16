package com.ec.afsotec.modelo.request;

import java.math.BigDecimal;
import java.util.Date;

public class SaldoCreditoParam {
	private String identificacion;

	private BigDecimal numeroCredito;

	public SaldoCreditoParam() {
		super();
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public BigDecimal getNumeroCredito() {
		return numeroCredito;
	}

	public void setNumeroCredito(BigDecimal numeroCredito) {
		this.numeroCredito = numeroCredito;
	}

	
}
