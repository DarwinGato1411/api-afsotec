package com.ec.afsotec.entidad;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOCIO_FETCH")
public class MovimientoCuentaFech {
	
	@Id
	@Column(name = "SOCIO_ID")
	private BigDecimal  socioId;
	
	
	@Column(name = "NOMBRE")
	private String  nombreSocio;
	
	public BigDecimal getSocioId() {
		return socioId;
	}

	public void setSocioId(BigDecimal socioId) {
		this.socioId = socioId;
	}

	public String getNombreSocio() {
		return nombreSocio;
	}

	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}

	



//	@Column(name = "TITULAR_CUENTA_BANCO")
//	private String TITULAR_CUENTA_BANCO;
//	
//	@Column(name = "SALDO_TOTAL")
//	private BigDecimal SALDO_TOTAL;

	

//	public String getTITULAR_CUENTA_BANCO() {
//		return TITULAR_CUENTA_BANCO;
//	}
//
//	public void setTITULAR_CUENTA_BANCO(String tITULAR_CUENTA_BANCO) {
//		TITULAR_CUENTA_BANCO = tITULAR_CUENTA_BANCO;
//	}
//
//	public BigDecimal getSALDO_TOTAL() {
//		return SALDO_TOTAL;
//	}
//
//	public void setSALDO_TOTAL(BigDecimal sALDO_TOTAL) {
//		SALDO_TOTAL = sALDO_TOTAL;
//	}
	
	

}
