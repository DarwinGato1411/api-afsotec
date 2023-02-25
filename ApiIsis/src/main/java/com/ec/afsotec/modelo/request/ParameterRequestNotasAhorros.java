package com.ec.afsotec.modelo.request;

import java.math.BigDecimal;

public class ParameterRequestNotasAhorros {
	private Integer idEmpresa;
	private Integer nCuenta;
	private BigDecimal valor;
	private String transaccion;
	private Integer concepto;
	private String comentario;
	private String codigo;
	private String mensaje;

	public ParameterRequestNotasAhorros() {
		super();
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public Integer getConcepto() {
		return concepto;
	}

	public void setConcepto(Integer concepto) {
		this.concepto = concepto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	

}
