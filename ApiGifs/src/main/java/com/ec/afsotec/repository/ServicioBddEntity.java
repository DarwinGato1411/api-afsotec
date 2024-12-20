package com.ec.afsotec.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ec.afsotec.entidad.ConciliacionFech;
import com.ec.afsotec.entidad.MovimientoCuentaFech;
import com.ec.afsotec.entidad.SaldoCreditoFech;
import com.ec.afsotec.entidad.SaldoCuentaFech;

@Repository
public class ServicioBddEntity {

	@PersistenceContext
	private EntityManager entityManager;

	public List<SaldoCuentaFech> buscarPorNumeroIdentificacion(Integer empresa, String identificacion) {

		Query query = entityManager.createQuery(
				"SELECT u FROM SaldoCuentaFech u WHERE  (u.empresa=:empresa and u.identificacion=:identificacion)",
				SaldoCuentaFech.class).setParameter("empresa", empresa)
				.setParameter("identificacion", identificacion);
//				.setMaxResults(limit);
		List<SaldoCuentaFech> datos = (List<SaldoCuentaFech>) query.getResultList();
		return datos;
	}

	public List<SaldoCreditoFech> buscarSaldoCredito(Integer empresa, String identificacion) {
		 Query query = entityManager.createQuery(
				"SELECT u FROM SaldoCreditoFech u WHERE  (u.empresa=:empresa and u.identificacion=:identificacion)",
				SaldoCreditoFech.class)
				 .setParameter("empresa", empresa)
				.setParameter("identificacion", identificacion);
		 
				List<SaldoCreditoFech> datos = (List<SaldoCreditoFech>) query.getResultList();
		 return datos;
	}

	public List<MovimientoCuentaFech> buscarMovi(BigDecimal idEmpresa, BigDecimal cuentaAhorrosId,Date fechaInicio, Date fechaFin) {
		return entityManager.createQuery(
				"SELECT u FROM MovimientoCuentaFech u WHERE  (u.empresaId=:empresaId and u.cuentaAhorrosId=:cuentaAhorrosId and trunc(u.fecha) BETWEEN :inicio and :fin)",
				MovimientoCuentaFech.class)
				.setParameter("empresaId", idEmpresa)
				.setParameter("cuentaAhorrosId", cuentaAhorrosId)
				.setParameter("inicio", fechaInicio)
				.setParameter("fin", fechaFin)
				.getResultList();
	}


	public List<ConciliacionFech> buscarMovimientos(Integer idEmpresa, Date fCorte) {
		return entityManager.createQuery(
				"SELECT u FROM ConciliacionFech u WHERE  (u.empresaId=:empresaId and trunc(u.fecha) = :corte)",
				ConciliacionFech.class)
				.setParameter("empresaId", idEmpresa)
				.setParameter("corte", fCorte)
				.getResultList();
	}


}
