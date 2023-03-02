package com.ec.afsotec.modelo.base;

public class Usuario {

	private  String usuario = "isis";
	private  String password = "$2a$10$uZJZIiGVSrWelQfu25zxteg5rmsa2C1ccGjUaQ7VbZD3fdLyApWBG";
//	private List<com.ec.afsotec.security.Autorizacion> authorities;
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public List<com.ec.afsotec.security.Autorizacion> getAuthorities() {
//		return authorities;
//	}
//	public void setAuthorities(List<com.ec.afsotec.security.Autorizacion> authorities) {
//		this.authorities = authorities;
//	}
	
	
}
