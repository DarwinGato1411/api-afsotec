package com.ec.afsotec.modelo.base;

import java.math.BigDecimal;
import java.util.Date;

public class SaldoCuentaVDao {
	private Short empresarId;
	private String Producto;
	private Integer cuenta;
	private String titular;
	private BigDecimal saldoTotal;
	private BigDecimal saldoDisponible;
	private BigDecimal saldoBloqueado;
	private String estatusCuenta;

	public SaldoCuentaVDao() {
		super();
	}

	public SaldoCuentaVDao(Short empresarId, String producto, Integer cuenta, String titular, BigDecimal saldoTotal,
			BigDecimal saldoDisponible, BigDecimal saldoBloqueado, String estatusCuenta) {
		super();
		this.empresarId = empresarId;
		Producto = producto;
		this.cuenta = cuenta;
		this.titular = titular;
		this.saldoTotal = saldoTotal;
		this.saldoDisponible = saldoDisponible;
		this.saldoBloqueado = saldoBloqueado;
		this.estatusCuenta = estatusCuenta;
	}

	public Short getEmpresarId() {
		return empresarId;
	}

	public void setEmpresarId(Short empresarId) {
		this.empresarId = empresarId;
	}

	public String getProducto() {
		return Producto;
	}

	public void setProducto(String producto) {
		Producto = producto;
	}

	

	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public BigDecimal getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(BigDecimal saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public BigDecimal getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(BigDecimal saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	public BigDecimal getSaldoBloqueado() {
		return saldoBloqueado;
	}

	public void setSaldoBloqueado(BigDecimal saldoBloqueado) {
		this.saldoBloqueado = saldoBloqueado;
	}

	public String getEstatusCuenta() {
		return estatusCuenta;
	}

	public void setEstatusCuenta(String estatusCuenta) {
		this.estatusCuenta = estatusCuenta;
	}

	

}
