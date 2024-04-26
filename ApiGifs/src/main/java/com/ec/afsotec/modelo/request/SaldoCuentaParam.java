package com.ec.afsotec.modelo.request;

import java.math.BigDecimal;
import java.util.Date;

public class SaldoCuentaParam {
	private String identificacion;

	private Integer numeroCuenta;

	public SaldoCuentaParam() {
		super();
	}

	public SaldoCuentaParam(String identificacion, Integer numeroCuenta) {
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

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

}
