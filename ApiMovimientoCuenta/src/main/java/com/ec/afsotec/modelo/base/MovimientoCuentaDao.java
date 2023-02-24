package com.ec.afsotec.modelo.base;

import java.math.BigDecimal;
import java.util.Date;

public class MovimientoCuentaDao {
private Date Fecha;
private Date hora;
private String conceptoTransaccion;
private String observacion;
private BigDecimal deposito;
private BigDecimal retiro;
private BigDecimal saldoTotal;
private BigDecimal saldoDisponible;


public MovimientoCuentaDao() {
	super();
}


public MovimientoCuentaDao(Date fecha, Date hora, String conceptoTransaccion, String observacion, BigDecimal deposito,
		BigDecimal retiro, BigDecimal saldoTotal, BigDecimal saldoDisponible) {
	super();
	Fecha = fecha;
	this.hora = hora;
	this.conceptoTransaccion = conceptoTransaccion;
	this.observacion = observacion;
	this.deposito = deposito;
	this.retiro = retiro;
	this.saldoTotal = saldoTotal;
	saldoDisponible = saldoDisponible;
}


public Date getFecha() {
	return Fecha;
}


public void setFecha(Date fecha) {
	Fecha = fecha;
}


public Date getHora() {
	return hora;
}


public void setHora(Date hora) {
	this.hora = hora;
}


public String getConceptoTransaccion() {
	return conceptoTransaccion;
}


public void setConceptoTransaccion(String conceptoTransaccion) {
	this.conceptoTransaccion = conceptoTransaccion;
}


public String getObservacion() {
	return observacion;
}


public void setObservacion(String observacion) {
	this.observacion = observacion;
}


public BigDecimal getDeposito() {
	return deposito;
}


public void setDeposito(BigDecimal deposito) {
	this.deposito = deposito;
}


public BigDecimal getRetiro() {
	return retiro;
}


public void setRetiro(BigDecimal retiro) {
	this.retiro = retiro;
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





}
