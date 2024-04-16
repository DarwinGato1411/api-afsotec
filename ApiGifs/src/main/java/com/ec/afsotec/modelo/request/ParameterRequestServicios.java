package com.ec.afsotec.modelo.request;

public class ParameterRequestServicios {
	Integer par_empresa_id;
	Integer par_cuenta_id;
	String par_transaccion_id;
	Integer par_concepto_id;
	Integer par_valor;
	String par_observacion;
	public Integer getPar_empresa_id() {
		return par_empresa_id;
	}
	public void setPar_empresa_id(Integer par_empresa_id) {
		this.par_empresa_id = par_empresa_id;
	}
	public Integer getPar_cuenta_id() {
		return par_cuenta_id;
	}
	public void setPar_cuenta_id(Integer par_cuenta_id) {
		this.par_cuenta_id = par_cuenta_id;
	}
	public String getPar_transaccion_id() {
		return par_transaccion_id;
	}
	public void setPar_transaccion_id(String par_transaccion_id) {
		this.par_transaccion_id = par_transaccion_id;
	}
	public Integer getPar_concepto_id() {
		return par_concepto_id;
	}
	public void setPar_concepto_id(Integer par_concepto_id) {
		this.par_concepto_id = par_concepto_id;
	}
	public Integer getPar_valor() {
		return par_valor;
	}
	public void setPar_valor(Integer par_valor) {
		this.par_valor = par_valor;
	}
	public String getPar_observacion() {
		return par_observacion;
	}
	public void setPar_observacion(String par_observacion) {
		this.par_observacion = par_observacion;
	}

}
