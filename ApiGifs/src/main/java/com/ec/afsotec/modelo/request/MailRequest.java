package com.ec.afsotec.modelo.request;

public class MailRequest {
	private String address;
	private String asuntoInf;
	private String nombreCliente;
	private String numTransaccion;
	private String valor;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAsuntoInf() {
		return asuntoInf;
	}
	public void setAsuntoInf(String asuntoInf) {
		this.asuntoInf = asuntoInf;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getNumTransaccion() {
		return numTransaccion;
	}
	public void setNumTransaccion(String numTransaccion) {
		this.numTransaccion = numTransaccion;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
