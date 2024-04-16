package com.ec.afsotec.entidad;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALDO_CREDTO_FETCH")
public class SaldoCreditoFech {
	@Id
	@Column(name = "NUMERO_CREDITO")
	private BigDecimal numeroCredito;

	@Column(name = "IDENTIFICACION")
	private String identificacion;
	@Column(name = "NOMBRES")
	private String nombres;
	@Column(name = "ESTATUS_CREDITO")
	private String estatusCredito;
	@Column(name = "SALDO_CAPITAL")
	private BigDecimal saldoCapital;
	@Column(name = "INTERES")
	private BigDecimal interes;
	@Column(name = "MORA")
	private BigDecimal mora;
	@Column(name = "GESTION")
	private BigDecimal gestion;
	@Column(name = "SEGURO")
	private BigDecimal seguro;
	@Column(name = "TOTAL")
	private BigDecimal total;
	@Column(name = "MAIL")
	private String mail;
	@Column(name = "CELULAR")
	private String celular;
	@Column(name = "CUENTA_AHORRO_ID")
	private Integer cuentaAhorrosId;
	@Column(name = "ESTATUS_CUENTA")
	private String estatusCuenta;
	public BigDecimal getNumeroCredito() {
		return numeroCredito;
	}
	public void setNumeroCredito(BigDecimal numeroCredito) {
		this.numeroCredito = numeroCredito;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getEstatusCredito() {
		return estatusCredito;
	}
	public void setEstatusCredito(String estatusCredito) {
		this.estatusCredito = estatusCredito;
	}
	public BigDecimal getSaldoCapital() {
		return saldoCapital;
	}
	public void setSaldoCapital(BigDecimal saldoCapital) {
		this.saldoCapital = saldoCapital;
	}
	public BigDecimal getInteres() {
		return interes;
	}
	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}
	public BigDecimal getMora() {
		return mora;
	}
	public void setMora(BigDecimal mora) {
		this.mora = mora;
	}
	public BigDecimal getGestion() {
		return gestion;
	}
	public void setGestion(BigDecimal gestion) {
		this.gestion = gestion;
	}
	public BigDecimal getSeguro() {
		return seguro;
	}
	public void setSeguro(BigDecimal seguro) {
		this.seguro = seguro;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Integer getCuentaAhorrosId() {
		return cuentaAhorrosId;
	}
	public void setCuentaAhorrosId(Integer cuentaAhorrosId) {
		this.cuentaAhorrosId = cuentaAhorrosId;
	}
	public String getEstatusCuenta() {
		return estatusCuenta;
	}
	public void setEstatusCuenta(String estatusCuenta) {
		this.estatusCuenta = estatusCuenta;
	}
	
	
	

}
