package com.ec.afsotec.modelo.request;

import java.math.BigDecimal;
import java.util.Date;

public class ParameterRequest {
	private Integer idEmpresa;
	private Integer nCuenta;
	private Date fInicio;
	private Date fFin;
	private BigDecimal idMovimiento;

	public ParameterRequest() {
		super();
	}

	public ParameterRequest(Integer idEmpresa, Integer nCuenta, Date fInicio, Date fFin) {
		super();
		this.idEmpresa = idEmpresa;
		this.nCuenta = nCuenta;
		this.fInicio = fInicio;
		this.fFin = fFin;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Integer getnCuenta() {
		return nCuenta;
	}

	public void setnCuenta(Integer nCuenta) {
		this.nCuenta = nCuenta;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}

	public BigDecimal getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(BigDecimal idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	

	
	
}
