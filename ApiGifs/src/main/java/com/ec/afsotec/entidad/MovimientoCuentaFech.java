package com.ec.afsotec.entidad;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MOVIMIENTO_CUENTA_FETCH")
public class MovimientoCuentaFech {

	@Id
	@Column(name = "MOVIMIENTO_AHORRO_ID")
	private Integer movimientoAhorroId;
	@Column(name = "TITULAR_CUENTA_BANCO")
	private String titularCuentaBanco;
	@Column(name = "FECHA")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name = "HORA")
	@Temporal(TemporalType.TIME)
	private Date hora;
	@Column(name = "DEPOSITO")
	private BigDecimal deposito;
	@Column(name = "RETIRO")
	private BigDecimal retiro;
	@Column(name = "SALDO_DISPONIBLE")
	private BigDecimal saldoDisponible;
	@Column(name = "SALDO_TOTAL")
	private BigDecimal saldoTotal;
	@Column(name = "TRANSACCION_SISTEMA_ID")
	private String transaccionSistemaId;
	@Column(name = "DESCRIPCION_TRANSACCION")
	private String descripcionTransaccion;
	@Column(name = "CONCEPTO_TRANSACCION")
	private String conceptoTransaccion;
	@Column(name = "EMPRESA_ID")
	private BigDecimal empresaId;
	@Column(name = "CUENTA_AHORRO_ID")
	private BigDecimal cuentaAhorrosId;
	
	public Integer getMovimientoAhorroId() {
		return movimientoAhorroId;
	}
	public void setMovimientoAhorroId(Integer movimientoAhorroId) {
		this.movimientoAhorroId = movimientoAhorroId;
	}
	public String getTitularCuentaBanco() {
		return titularCuentaBanco;
	}
	public void setTitularCuentaBanco(String titularCuentaBanco) {
		this.titularCuentaBanco = titularCuentaBanco;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
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
	public BigDecimal getSaldoDisponible() {
		return saldoDisponible;
	}
	public void setSaldoDisponible(BigDecimal saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	public BigDecimal getSaldoTotal() {
		return saldoTotal;
	}
	public void setSaldoTotal(BigDecimal saldoTotal) {
		this.saldoTotal = saldoTotal;
	}
	public String getTransaccionSistemaId() {
		return transaccionSistemaId;
	}
	public void setTransaccionSistemaId(String transaccionSistemaId) {
		this.transaccionSistemaId = transaccionSistemaId;
	}
	public String getDescripcionTransaccion() {
		return descripcionTransaccion;
	}
	public void setDescripcionTransaccion(String descripcionTransaccion) {
		this.descripcionTransaccion = descripcionTransaccion;
	}
	public String getConceptoTransaccion() {
		return conceptoTransaccion;
	}
	public void setConceptoTransaccion(String conceptoTransaccion) {
		this.conceptoTransaccion = conceptoTransaccion;
	}
	public BigDecimal getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(BigDecimal empresaId) {
		this.empresaId = empresaId;
	}
	public BigDecimal getCuentaAhorrosId() {
		return cuentaAhorrosId;
	}
	public void setCuentaAhorrosId(BigDecimal cuentaAhorrosId) {
		this.cuentaAhorrosId = cuentaAhorrosId;
	}

	

}
