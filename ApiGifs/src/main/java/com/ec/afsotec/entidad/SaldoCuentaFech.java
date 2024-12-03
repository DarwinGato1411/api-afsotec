package com.ec.afsotec.entidad;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALDO_CUENTA_AHORRO_FETCH")
public class SaldoCuentaFech {


	@Id
	@Column(name = "NUMERO_CUENTA")
	private Integer numeroCuenta;
	
	@Column(name = "SOCIO_ID")
	private BigDecimal socioId;

	@Column(name = "TITULAR_CUENTA")
	private String titularCuenta;
	
	@Column(name = "MENSAJE")
	private String mensaje;
	
	@Column(name = "IDENTIFICACION")
	private String identificacion;

	@Column(name = "PRODUCTO")
	private BigDecimal producto;

	@Column(name = "ESTATUS_CUENTA")
	private String estatusCuenta;
	
	@Column(name = "SALDO_TOTAL")
	private BigDecimal saldoCuenta;
	
	@Column(name = "SALDO_DISPONIBLE")
	private BigDecimal saldoDisponible;

	@Column(name = "CELULAR")
	private String celular;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "EMPRESA_ID")
	private Integer empresa;
	
	
	public BigDecimal getSocioId() {
		return socioId;
	}

	public void setSocioId(BigDecimal socioId) {
		this.socioId = socioId;
	}

	public String getTitularCuenta() {
		return titularCuenta;
	}

	public void setTitularCuenta(String titularCuenta) {
		this.titularCuenta = titularCuenta;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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

	public BigDecimal getProducto() {
		return producto;
	}

	public void setProducto(BigDecimal producto) {
		this.producto = producto;
	}

	public String getEstatusCuenta() {
		return estatusCuenta;
	}

	public void setEstatusCuenta(String estatusCuenta) {
		this.estatusCuenta = estatusCuenta;
	}

	public BigDecimal getSaldoCuenta() {
		return saldoCuenta;
	}

	public void setSaldoCuenta(BigDecimal saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	public BigDecimal getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(BigDecimal saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}



}
