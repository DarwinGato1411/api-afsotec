package com.ec.afsotec.modelo.request;

//import java.math.BigDecimal;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ConciliacionParam {
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")//"dd/MM/yyyy")
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")//, locale = "pt-BR", timezone = "Brazil/East")
	private Date fCorte;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//	private Date fechaFin;

	private Integer idEmpresa;
//	private BigDecimal cuentaAhorrosId;
	
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Date getfCorte() {
		return fCorte;
	}
	public void setfCorte(Date fCorte) {
		this.fCorte = fCorte;
	}

	
}
