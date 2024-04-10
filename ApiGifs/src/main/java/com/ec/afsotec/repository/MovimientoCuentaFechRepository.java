package com.ec.afsotec.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ec.afsotec.entidad.MovimientoCuentaFech;
@SuppressWarnings("unused")
@Repository
public interface MovimientoCuentaFechRepository  extends JpaRepository<MovimientoCuentaFech, BigDecimal>{
//
//	@Query("SELECT u FROM MovimientoCuentaFech u WHERE  u.socioId=:mai")
//	List<MovimientoCuentaFech> findIdMovimiento(
//			@Param("mai") BigDecimal codTipoambiente);
//	List<MOVIMIENTO_CUENTA_FETCH> findByTITULAR_CUENTA_BANCO(String tITULAR_CUENTA_BANCO);
}
