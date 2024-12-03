package com.ec.afsotec.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ec.afsotec.modelo.request.ParameterRequestConfirmaRetiro;
import com.ec.afsotec.modelo.request.ParameterRequestRetiro;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class RepositoryConfirmaRetiro {
	@PersistenceContext
	EntityManager entityManager;

//	@Transactional
	public String callStoreProcedure(String procedureName, ParameterRequestConfirmaRetiro param) {
		JsonObject jsonObject = new JsonObject();
		String json = "";
		try {
			StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(procedureName);

			query.registerStoredProcedureParameter("par_empresa_id", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("par_cuenta_id", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("par_ntransaccion", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("par_transaccion_id", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("par_nreferencia", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("par_otp", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("par_concepto_id", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("par_valor", BigDecimal.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("json_param", String.class, ParameterMode.OUT);
			query.setParameter("par_empresa_id", param.getPar_empresa_id());
			query.setParameter("par_cuenta_id", param.getPar_cuenta_id());
			query.setParameter("par_ntransaccion", param.getPar_ntransaccion()); // getPar_nreferencia());
			query.setParameter("par_transaccion_id", param.getPar_transaccion_id());
			query.setParameter("par_concepto_id", param.getPar_concepto_id());
			query.setParameter("par_valor", param. getPar_valor());
			query.setParameter("par_otp", param.getPar_otp());
			query.setParameter("par_nreferencia", param.getPar_nreferencia());


			query.execute();
			json = (String) query.getOutputParameterValue("json_param");
			jsonObject = new Gson().fromJson(json, JsonObject.class);

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("ERROR " + e.getMessage());
			return "{\"estado\":false, \"message\":\"error en el procedimiento Java\"}";
		}

		return json;
	}

}
