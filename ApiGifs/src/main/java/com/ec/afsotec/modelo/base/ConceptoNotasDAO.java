package com.ec.afsotec.modelo.base;

public class ConceptoNotasDAO {
	private Short empresaID;
	private Short conceptoTransID;
	private String conecptoTrans;
	
	
	
	
	public ConceptoNotasDAO() {
		super();
	}

	public ConceptoNotasDAO(Short empresaID, Short conceptoTransID, String conecptoTrans) {
		super();
		this.empresaID = empresaID;
		this.conceptoTransID = conceptoTransID;
		this.conecptoTrans = conecptoTrans;
	}

	public Short getEmpresaID() {
		return empresaID;
	}

	public void setEmpresaID(Short empresaID) {
		this.empresaID = empresaID;
	}

	public Short getConceptoTransID() {
		return conceptoTransID;
	}

	public void setConceptoTransID(Short conceptoTransID) {
		this.conceptoTransID = conceptoTransID;
	}

	public String getConecptoTrans() {
		return conecptoTrans;
	}

	public void setConecptoTrans(String conecptoTrans) {
		this.conecptoTrans = conecptoTrans;
	}
	
}
