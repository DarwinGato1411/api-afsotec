package com.ec.afsotec.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ec.afsotec.controller.services.ServicioGenerico;
import com.ec.afsotec.modelo.base.MovimientoCuentaDao;
import com.ec.afsotec.modelo.base.SaldoCuentaVDao;
import com.ec.afsotec.modelo.request.ParameterRequest;
import com.ec.afsotec.modelo.request.ParameterRequestSaldoCuenta;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = " API Rest", tags = "Cuenta")
public class MovimientoCuentaController {

	
	@Autowired
	ServicioGenerico servioGenerico;
	
	
	@RequestMapping(value = "/movimiento-cuenta/", method = RequestMethod.POST)
	@ApiOperation(tags = "Movimiento cuenta ", value = "Movimento de cuenta EMPRESA=2,  nCuenta=2010000003, fInicio='2000-01-01', fFin='2023-02-23'  ")
	public ResponseEntity<?> movimientoCuenta(@RequestBody ParameterRequest param) {
		/* CAMBIAR EL MODELO DE RESPUESTA CON TRU O FALSE */
		/* Usuario y password para generar el TOKEN */
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
//		UserDTO parametroDto = new UserDTO(param.getUserName(), param.getUserPassword());
//		HttpEntity<UserDTO> requestBody = new HttpEntity<UserDTO>(parametroDto, headers);

		try {
			
			List<MovimientoCuentaDao> respuesta=servioGenerico.llamarProcedimiento("DB2ADMIN.SP_MOVIMIENTOS_CUENTA", param);
			/* URL DE CONSULTA */
//			String URLCONSULTA = ruta + "login-externo";
//			System.out.println("loginExterno " + URLCONSULTA);
//			UserDTO response = restTemplate.postForObject(URLCONSULTA, requestBody, UserDTO.class);
//			if (response.getUserPassword().toUpperCase().contains("VERIFIQUE")
//					|| response.getUserName().toUpperCase().contains("VERIFIQUE")) {
//				response.setEstadoPeticion(Boolean.FALSE);
//			} else {
//				response.setEstadoPeticion(Boolean.TRUE);
//
//			}

			List<String> prueba = new ArrayList();
			prueba.add("EJEMPLO");
			System.out.println("Respuesta  " + prueba);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}
	
	
	@RequestMapping(value = "/saldo-cuenta/", method = RequestMethod.POST)
	@ApiOperation(tags = "Saldo cuenta ", value = "Saldo de cuenta EMPRESA=2,  nCuenta=2010000003")
	public ResponseEntity<?> saldoCuenta(@RequestBody ParameterRequestSaldoCuenta param) {
		/* CAMBIAR EL MODELO DE RESPUESTA CON TRU O FALSE */
		/* Usuario y password para generar el TOKEN */
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
//		UserDTO parametroDto = new UserDTO(param.getUserName(), param.getUserPassword());
//		HttpEntity<UserDTO> requestBody = new HttpEntity<UserDTO>(parametroDto, headers);

		try {
			HashMap< String, Object> mapa = new HashMap<>();
			mapa.put("EMPRESA",param.getIdEmpresa());
			mapa.put("NCUENTA",param.getnCuenta());
			
			List<SaldoCuentaVDao> respuesta=servioGenerico.llamarProcedimientoSaldoCuenta("DB2ADMIN.SP_SALDO_CUENTA_V", mapa);

			
			
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}
}
