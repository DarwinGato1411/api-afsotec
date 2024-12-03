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
@Table(name = "CONCILIACION_FACILITO_FETCH")
public class ConciliacionFech {

	@Id
	@Column(name = "ID_ORDENANTE")
	private Integer ordenanteId;
	@Column(name = "REFERENCIA")
	private String referencia;
	@Column(name = "FECHA")
	//@Temporal(TemporalType.DATE)
	private Date fecha;
//	@Column(name = "HORA")
//	@Temporal(TemporalType.TIME)
//	private Date hora;
	@Column(name = "VALOR")
	private BigDecimal valor;
//	@Column(name = "RETIRO")
//	private BigDecimal retiro;
//	@Column(name = "SALDO_DISPONIBLE")
//	private BigDecimal saldoDisponible;
//	@Column(name = "SALDO_TOTAL")
//	private BigDecimal saldoTotal;
	@Column(name = "TIPO_TRANSACCION")
	private String tipoTransaccion;
	@Column(name = "FECHASTR")
	private String fechaSTR;
//	@Column(name = "CONCEPTO_TRANSACCION")
//	private String conceptoTransaccion;
	@Column(name = "EMPRESA_ID")
	private Integer empresaId;
	@Column(name = "ID_FACILITO")
	private Integer facilitoId;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}
	public Integer getOrdenanteId() {
		return ordenanteId;
	}
	public void setOrdenanteId(Integer ordenanteId) {
		this.ordenanteId = ordenanteId;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public Integer getFacilitoId() {
		return facilitoId;
	}
	public void setFacilitoId(Integer facilitoId) {
		this.facilitoId = facilitoId;
	}
	public String getFechaSTR() {
		return fechaSTR;
	}
	public void setFechaSTR(String fechaSTR) {
		this.fechaSTR = fechaSTR;
	}


}
