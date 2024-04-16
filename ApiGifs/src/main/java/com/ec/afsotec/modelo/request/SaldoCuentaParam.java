package com.ec.afsotec.modelo.request;

import java.math.BigDecimal;
import java.util.Date;

public class SaldoCuentaParam {
	private String identificacion;

	private BigDecimal numeroCuenta;

	public SaldoCuentaParam() {
		super();
	}

	public SaldoCuentaParam(String identificacion, BigDecimal numeroCuenta) {
		super();
		this.identificacion = identificacion;
		this.numeroCuenta = numeroCuenta;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public BigDecimal getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(BigDecimal numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

}
