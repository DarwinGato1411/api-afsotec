package com.ec.afsotec.controller.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.ec.afsotec.modelo.base.ConceptoNotasDAO;
import com.ec.afsotec.modelo.base.MovimientoCuentaDao;
import com.ec.afsotec.modelo.base.NotasAhorrosDao;
import com.ec.afsotec.modelo.base.SaldoCuentaVDao;
import com.ec.afsotec.modelo.base.ServiciosDao;
import com.ec.afsotec.modelo.request.ParameterRequest;
import com.ec.afsotec.modelo.request.ParameterRequestConceptoNotas;
import com.ec.afsotec.modelo.request.ParameterRequestNotasAhorros;
import com.ec.afsotec.modelo.request.ParameterRequestServicios;

@Service
public class ServicioGenerico {

	@PersistenceContext
	EntityManager entityManager;

	public List<MovimientoCuentaDao> llamarProcedimiento(String procedureName, ParameterRequest param) {

		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

		StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(procedureName);

		query.registerStoredProcedureParameter("EMPRESA", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("NCUENTA", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("FINICIO", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("FFIN", String.class, ParameterMode.IN);

		String inicio = sm.format(param.getfInicio());
		String fin = sm.format(param.getfFin());
		System.out.println("inicio " + inicio);
		System.out.println("fin " + fin);
		query.setParameter("EMPRESA", param.getIdEmpresa());
		query.setParameter("NCUENTA", param.getnCuenta());
		query.setParameter("FINICIO", inicio);
		query.setParameter("FFIN", fin);
		query.execute();
		List<Object[]> json = (List<Object[]>) query.getResultList();
		List<MovimientoCuentaDao> listRespuesta = new ArrayList<>();
		for (Object[] tupla : json) {
			Date fecha = (Date) tupla[0];
			Date hora = (Date) tupla[1];
			String concep = (String) tupla[2];
			String obser = (String) tupla[3];
			BigDecimal dep = (BigDecimal) tupla[4];
			BigDecimal ret = (BigDecimal) tupla[5];
			BigDecimal sal = (BigDecimal) tupla[6];
			BigDecimal salDisp = (BigDecimal) tupla[7];

			listRespuesta.add(new MovimientoCuentaDao(fecha, hora, concep, obser, dep, ret, sal, salDisp));
		}

		return listRespuesta;
	}

	public List<SaldoCuentaVDao> llamarProcedimientoSaldoCuenta(String procedureName, HashMap<String, Object> param) {

		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		Iterator iterator = param.entrySet().iterator();

		StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(procedureName);

		while (iterator.hasNext()) {

			Map.Entry entry = (Map.Entry) iterator.next();
			Class<?> clazz = entry.getValue().getClass();
			query.registerStoredProcedureParameter(entry.getKey().toString(), clazz, ParameterMode.IN);
//			query.registerStoredProcedureParameter(entry.getKey().toString(), Integer.class, ParameterMode.IN);
			System.out.println("Clave: " + entry.getKey() + ", valor: " + entry.getValue());

		}

		iterator = param.entrySet().iterator();
		while (iterator.hasNext()) {

			Map.Entry entry = (Map.Entry) iterator.next();

			query.setParameter(entry.getKey().toString(), (Integer) entry.getValue());
			System.out.println("Clave: " + entry.getKey() + ", valor: " + entry.getValue());
		}

		query.execute();
		List<Object[]> json = (List<Object[]>) query.getResultList();
		List<SaldoCuentaVDao> listRespuesta = new ArrayList<>();
		for (Object[] tupla : json) {
			Short idEmpresa = (Short) tupla[0];
			String product = (String) tupla[1];
			Integer cuenta = (Integer) tupla[2];
			String titular = (String) tupla[3];

			BigDecimal saldoT = (BigDecimal) tupla[4];
			BigDecimal saldoDi = (BigDecimal) tupla[5];
			BigDecimal saldoBloq = (BigDecimal) tupla[6];
			String estado = (String) tupla[7];

			listRespuesta
					.add(new SaldoCuentaVDao(idEmpresa, product, cuenta, titular, saldoT, saldoDi, saldoBloq, estado));
		}
		return listRespuesta;
	}

//	public List<ServiciosDao> llamarProcedimientoServios(String procedureName, ParameterRequestServicios param) {
//
//		StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(procedureName);
//		query.registerStoredProcedureParameter("EMPRESA", Integer.class, ParameterMode.IN);
//		query.registerStoredProcedureParameter("TIPO", String.class, ParameterMode.IN);
//
//		query.setParameter("EMPRESA", param.getEmpresa());
//		query.setParameter("TIPO", param.getTipo());
//		query.execute();
//
//		List<Object[]> json = (List<Object[]>) query.getResultList();
//		List<ServiciosDao> listRespuesta = new ArrayList<>();
//		for (Object[] tupla : json) {
//
//			Short empresaId = (Short) tupla[0];
//			Short servicioId = (Short) tupla[1];
//			String decripcion = (String) tupla[2];
//
//			ServiciosDao servicios = new ServiciosDao(empresaId, servicioId, decripcion);
//			listRespuesta.add(servicios);
//		}
//
//		return listRespuesta;
//	}

	public List<ConceptoNotasDAO> llamarProcedimientoConceptoNotas(String procedureName,
			ParameterRequestConceptoNotas param) {

		StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(procedureName);
		query.registerStoredProcedureParameter("EMPRESA", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRANSACCION", String.class, ParameterMode.IN);

		query.setParameter("EMPRESA", param.getEmpresa());
		query.setParameter("TRANSACCION", param.getTrans());
		query.execute();

		List<Object[]> json = (List<Object[]>) query.getResultList();
		List<ConceptoNotasDAO> listRespuesta = new ArrayList<>();
		for (Object[] tupla : json) {

			Short empresaId = (Short) tupla[0];
			Short conceptoTransID = (Short) tupla[1];
			String conceptoTrans = (String) tupla[2];

			ConceptoNotasDAO servicios = new ConceptoNotasDAO(empresaId, conceptoTransID, conceptoTrans);
			listRespuesta.add(servicios);
		}

		return listRespuesta;
	}

	public NotasAhorrosDao llamarProcedimientoNotasAhorros(String procedureName,
			ParameterRequestNotasAhorros param) {

		StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(procedureName);
		query.registerStoredProcedureParameter("EMPRESA", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("NCUENTA", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("VALOR", BigDecimal.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRANSACCION", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CONCEPTO", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("COMENTARIO", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CODIGO", String.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);

		query.setParameter("EMPRESA", param.getIdEmpresa());
		query.setParameter("NCUENTA", param.getnCuenta());
		query.setParameter("VALOR", param.getValor());
		query.setParameter("TRANSACCION", param.getTransaccion());
		query.setParameter("CONCEPTO", param.getConcepto());
		query.setParameter("COMENTARIO", param.getComentario());
		
		query.execute();


		List<NotasAhorrosDao> listRespuesta = new ArrayList<>();

			String codigo = (String) query.getOutputParameterValue("CODIGO");
			String mensaje = (String) query.getOutputParameterValue("MENSAJE");

			


		return new NotasAhorrosDao(codigo, mensaje);
	}

}
