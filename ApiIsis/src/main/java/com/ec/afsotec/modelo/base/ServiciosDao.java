package com.ec.afsotec.modelo.base;

public class ServiciosDao {
	private Short empresaID;
	private Short servicioID;
	private String descripcion;
	
	public ServiciosDao() {
		super();
	}

	public ServiciosDao(Short empresaID, Short servicioID, String descripcion) {
		super();
		this.empresaID = empresaID;
		this.servicioID = servicioID;
		this.descripcion = descripcion;
	}

	public Short getEmpresaID() {
		return empresaID;
	}

	public void setEmpresaID(Short empresaID) {
		this.empresaID = empresaID;
	}

	public Short getServicioID() {
		return servicioID;
	}

	public void setServicioID(Short servicioID) {
		this.servicioID = servicioID;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	
}
