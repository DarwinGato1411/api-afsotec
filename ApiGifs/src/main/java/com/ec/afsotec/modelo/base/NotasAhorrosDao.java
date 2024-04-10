package com.ec.afsotec.modelo.base;

public class NotasAhorrosDao {
	private String codigo;
	private String mensaje;

	public NotasAhorrosDao() {
		super();
	}

	public NotasAhorrosDao(String codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
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
