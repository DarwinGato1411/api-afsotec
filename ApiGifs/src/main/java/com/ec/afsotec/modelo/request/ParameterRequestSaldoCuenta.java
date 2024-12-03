package com.ec.afsotec.modelo.request;

// al parecer hay que eliminar esta clase

public class ParameterRequestSaldoCuenta {
	private Integer idEmpresa;
	private Integer nCuenta;


	public ParameterRequestSaldoCuenta() {
		super();
	}

	public ParameterRequestSaldoCuenta(Integer idEmpresa, Integer nCuenta	) {
		super();
		this.idEmpresa = idEmpresa;
		this.nCuenta = nCuenta;
		
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

	

}
