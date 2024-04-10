package com.ec.afsotec.security.model;

import com.ec.afsotec.security.JwtUser;



public class UsuarioAutenticadoDao {
	private JwtUser usuario;
	private String jwt;

	public UsuarioAutenticadoDao(JwtUser usuario, String jwt) {
		super();
		this.usuario = usuario;
		this.jwt = jwt;
		
	}

	public JwtUser getUsuario() {
		return usuario;
	}

	public void setUsuario(JwtUser usuario) {
		this.usuario = usuario;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}


}
