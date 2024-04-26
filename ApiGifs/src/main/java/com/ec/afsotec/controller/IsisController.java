package com.ec.afsotec.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ec.afsotec.entidad.MailerClass;
import com.ec.afsotec.entidad.MovimientoCuentaFech;
import com.ec.afsotec.entidad.SaldoCreditoFech;
import com.ec.afsotec.entidad.SaldoCuentaFech;
import com.ec.afsotec.modelo.request.MailRequest;
import com.ec.afsotec.modelo.request.MovimientoCuentaParam;
import com.ec.afsotec.modelo.request.ParameterRequestServicios;
import com.ec.afsotec.modelo.request.SaldoCreditoParam;
import com.ec.afsotec.modelo.request.SaldoCuentaParam;
import com.ec.afsotec.repository.MovimientoCuentaFechRepository;
import com.ec.afsotec.repository.RepositoryGenerico;
import com.ec.afsotec.repository.ServicioBddEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Api GIFS", tags = "GIFS", description = "Web services para consumo externo")
public class IsisController {

	@Autowired
	ServicioGenerico servioGenerico;

	@Autowired
	RepositoryGenerico repositoryGenerico;

	@Autowired
	MovimientoCuentaFechRepository cuentaFechRepository;
	
	@Autowired
	ServicioBddEntity cuentaEntity;

	@RequestMapping(value = "/movimiento-cuenta/", method = RequestMethod.POST)
	@ApiOperation(tags = "Movimiento cuenta ", value = "Movimento de cuenta EMPRESA=2,  nCuenta=2010000003, fInicio='2000-01-01', fFin='2023-02-23'  ")
	public ResponseEntity<?> movimientoCuenta(@RequestBody MovimientoCuentaParam param) {
		/* CAMBIAR EL MODELO DE RESPUESTA CON TRU O FALSE */
		/* Usuario y password para generar el TOKEN */

		Calendar calendar = Calendar.getInstance();
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String fechaInicio = simpleDateFormat.format(param.getFechaInicio());
		String fechafin = simpleDateFormat.format(param.getFechaFin());
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {

//			List<MovimientoCuentaDao> respuesta = servioGenerico.llamarProcedimiento("DB2ADMIN.SP_MOVIMIENTOS_CUENTA",
//					param);
//
//			List<String> prueba = new ArrayList();
			List<MovimientoCuentaFech> lista = cuentaEntity.buscarMovi(param.getIdEmpresa(), param.getCuentaAhorrosId(),
					simpleDateFormat.parse(fechaInicio), simpleDateFormat.parse(fechaInicio));
//			prueba.add("EJEMPLO");
//			System.out.println("Respuesta  " + prueba);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/saldo-cuenta/", method = RequestMethod.POST)
	@ApiOperation(tags = "Saldo cuenta ", value = "Saldo cuenta")
	public ResponseEntity<?> saldoCuenta(@RequestBody SaldoCuentaParam param) {
		/* CAMBIAR EL MODELO DE RESPUESTA CON TRU O FALSE */
		/* Usuario y password para generar el TOKEN */
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			List<SaldoCuentaFech> lista = cuentaEntity.buscarPorNumeroIdentificacion(param.getNumeroCuenta(),
					param.getIdentificacion());

			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/saldo-credito/", method = RequestMethod.POST)
	@ApiOperation(tags = "Saldo  Credito", value = "Saldo del credito")
	public ResponseEntity<?> saldoCredito(@RequestBody SaldoCreditoParam param) {
		/* CAMBIAR EL MODELO DE RESPUESTA CON TRU O FALSE */
		/* Usuario y password para generar el TOKEN */
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			List<SaldoCreditoFech> lista = cuentaEntity.buscarSaldoCredito(param.getNumeroCredito(),
					param.getIdentificacion());

			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/servicio/", method = RequestMethod.POST)
	@ApiOperation(tags = "Servicios ", value = "Movimento de cuenta EMPRESA=2,   TIPO='I'")
	public ResponseEntity<?> servicios(@RequestBody ParameterRequestServicios param) {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		try {
			String valorRes = repositoryGenerico.callStoreProcedure("SP_NOTAS_AHORROS", param);
			if(valorRes.toUpperCase().contains("CORRECT")) {
				MailerClass mail = new MailerClass();
				mail.sendMailSimple(param.getMail(),"Transaccion exitosa", param.getNombreSocio(),
						param.getPar_valor());
				return new ResponseEntity<>(valorRes, HttpStatus.OK);
				
			}else {
				
				return new ResponseEntity<>(valorRes, HttpStatus.BAD_GATEWAY);
			}
		
			

		} catch (Exception e) {
			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/mail/", method = RequestMethod.POST)
	@ApiOperation(tags = "Mail ", value = "Envio de correo")
	public ResponseEntity<?> envioMail(@RequestBody MailRequest param) {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		try {
			MailerClass mail = new MailerClass();
			mail.sendMailSimple(param.getAddress(),param.getAsuntoInf(), param.getNombreCliente(),
					1);

			return new ResponseEntity<>("Correcto", HttpStatus.OK);

		} catch (Exception e) {
			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}

//	@RequestMapping(value = "/conceptos-notas/", method = RequestMethod.POST)
//	@ApiOperation(tags = "Concepto Notas", value = "Concepto Notas EMPRESA=2 , TRANSACCION='ANDB'")
//	public ResponseEntity<?> conceptosNotas(@RequestBody ParameterRequestConceptoNotas param) {
//		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
//				HttpClientBuilder.create().build());
//		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//
//		try {
//
//			List<ConceptoNotasDAO> res = servioGenerico.llamarProcedimientoConceptoNotas("DB2ADMIN.SP_CONCEPTOS_NOTAS",
//					param);
//
//			return new ResponseEntity<>(res, HttpStatus.OK);
//
//		} catch (Exception e) {
//			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
//			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
//		}
//
//	}
//	
//	
//	
//	@RequestMapping(value = "/notas-ahorro/", method = RequestMethod.POST)
//	@ApiOperation(tags = "Notas Ahorro", value = "Nota ahorro EMPRESA=2, NCUENTA=2010000003, VALOR=150, TRANSACCION='ANDB', CONCEPTO=2, COMENTARIO='PRUEBA DE NOTA DEBITO'")
//	public ResponseEntity<?> notasAhorros(@RequestBody ParameterRequestNotasAhorros param) {
//		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
//				HttpClientBuilder.create().build());
//		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//
//		try {
//
//			NotasAhorrosDao res = servioGenerico.llamarProcedimientoNotasAhorros("DB2ADMIN.SP_NOTAS_AHORROS",
//					param);
//
//			return new ResponseEntity<>(res, HttpStatus.OK);
//
//		} catch (Exception e) {
//			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
//			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
//		}
//
//	}
}
