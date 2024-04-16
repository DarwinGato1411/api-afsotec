package com.ec.afsotec.modelo.request;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MovimientoCuentaParam {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date fechaInicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date fechaFin;

	private BigDecimal idEmpresa;
	private BigDecimal cuentaAhorrosId;
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public BigDecimal getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(BigDecimal idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public BigDecimal getCuentaAhorrosId() {
		return cuentaAhorrosId;
	}
	public void setCuentaAhorrosId(BigDecimal cuentaAhorrosId) {
		this.cuentaAhorrosId = cuentaAhorrosId;
	}
	
	
}
