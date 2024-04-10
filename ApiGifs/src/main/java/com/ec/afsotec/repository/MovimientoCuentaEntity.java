package com.ec.afsotec.repository;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.ec.afsotec.entidad.MovimientoCuentaFech;
@Repository
public class MovimientoCuentaEntity {

	@PersistenceContext
	private EntityManager entityManager;

	public List<MovimientoCuentaFech> buscarPorNombre(BigDecimal idMov, Integer limit) {
		return entityManager
				.createQuery(
						"SELECT u FROM MovimientoCuentaFech u WHERE  u.socioId=:socioId",
						MovimientoCuentaFech.class)
				.setParameter("socioId", idMov).setMaxResults(limit).getResultList();
	}
}
