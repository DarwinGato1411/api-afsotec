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
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.ec.afsotec.Exceptions.ApiRequestException;
import com.ec.afsotec.modelo.base.MovimientoCuentaDao;
import com.ec.afsotec.modelo.base.SaldoCuentaVDao;
import com.ec.afsotec.modelo.request.ParameterRequest;
import com.ec.afsotec.modelo.request.ParameterRequestSaldoCuenta;

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

}
