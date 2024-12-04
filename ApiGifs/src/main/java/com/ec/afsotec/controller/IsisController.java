package com.ec.afsotec.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.ec.afsotec.entidad.ConciliacionFech;
import com.ec.afsotec.entidad.MailerClass;
import com.ec.afsotec.entidad.MovimientoCuentaFech;
import com.ec.afsotec.entidad.SaldoCreditoFech;
import com.ec.afsotec.entidad.SaldoCuentaFech;
import com.ec.afsotec.modelo.request.ConciliacionParam;
import com.ec.afsotec.modelo.request.MailRequest;
import com.ec.afsotec.modelo.request.MovimientoCuentaParam;
import com.ec.afsotec.modelo.request.ParameterRequestConfirmaRetiro;
import com.ec.afsotec.modelo.request.ParameterRequestRetiro;
import com.ec.afsotec.modelo.request.ParameterRequestServicios;
import com.ec.afsotec.modelo.request.SaldoCreditoParam;
import com.ec.afsotec.modelo.request.SaldoCuentaParam;
import com.ec.afsotec.repository.RepositoryConfirmaRetiro;
import com.ec.afsotec.repository.RepositoryGenerico;
import com.ec.afsotec.repository.RepositoryRetiro;
import com.ec.afsotec.repository.ServicioBddEntity;
import com.ec.afsotec.services.ServicioGeneral;
import com.ec.afsotec.sms.ParamSms;
import com.ec.afsotec.sms.RequestSms;
import com.ec.afsotec.sms.ResponseSms;
import com.ec.afsotec.sms.RespuestaWsRetiro;

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
	RepositoryRetiro repositoryRetiro;

	@Autowired
	RepositoryConfirmaRetiro repositoryConfirmaRetiro;

//	@Autowired
//	MovimientoCuentaFechRepository cuentaFechRepository;

	@Autowired
	ServicioBddEntity cuentaEntity;

	/* ENVIO SMS */
	@Autowired
	ServicioGeneral servicioGeneral;
	@Value("${webservices.messageId}")
	private Integer messageId;

	@Value("${webservices.transactionId}")
	private String transactionId;

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

// horozco metodo de conciliacion

	@RequestMapping(value = "/conciliacion/", method = RequestMethod.POST)
	@ApiOperation(tags = "Conciliacion Movimientos", value = "Movimentos EMPRESA=1,  fCorte='2000-01-01'")
	public ResponseEntity<?> conciliacion(@RequestBody ConciliacionParam param) {

		Calendar calendar = Calendar.getInstance();
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String fCorte = simpleDateFormat.format(param.getfCorte());
		System.out.println(fCorte);
//		String fechafin = simpleDateFormat.format(param.getFechaFin());
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
			List<ConciliacionFech> lista = cuentaEntity.buscarMovimientos(param.getIdEmpresa(),
					simpleDateFormat.parse(fCorte));
//			prueba.add("EJEMPLO");
//			System.out.println("Respuesta  " + prueba);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}

// fin horozco	

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
			List<SaldoCuentaFech> lista = cuentaEntity.buscarPorNumeroIdentificacion(param.getEmpresa(),
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
			List<SaldoCreditoFech> lista = cuentaEntity.buscarSaldoCredito(param.getEmpresa(),
					param.getIdentificacion());

			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/notas-ahorros/", method = RequestMethod.POST)
	@ApiOperation(tags = "Notas CR-DB Ahorros", value = "Movimento de cuenta EMPRESA=1,   TIPO='I'")
	public ResponseEntity<?> servicios(@RequestBody ParameterRequestServicios param) {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		try {
			String valorRes = repositoryGenerico.callStoreProcedure("SP_NOTAS_AHORROS", param);

			if (valorRes.toUpperCase().contains("CORRECT")) {
//				MailerClass mail = new MailerClass();
//				mail.sendMailSimple(param.getMail(),"Transaccion exitosa", param.getNombreSocio(),
//						param.getPar_valor());
				return new ResponseEntity<>(valorRes, HttpStatus.OK);

			} else {

				return new ResponseEntity<>(valorRes, HttpStatus.BAD_GATEWAY);
			}
		} catch (Exception e) {
			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}

	// Servicio de horozco RETIROS CON OTP

	@RequestMapping(value = "/retiro/", method = RequestMethod.POST)
	@ApiOperation(tags = "Retiro Ahorros", value = "Movimento de retiros de cuenta con código OTP EMPRESA=1,   TIPO='I'")
	public ResponseEntity<?> retiros(@RequestBody ParameterRequestRetiro parame) {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RespuestaWsRetiro respWs =new  RespuestaWsRetiro();

		try {
			String valorRes = repositoryRetiro.callStoreProcedure("SP_RETIRO_INTERFAZ", parame); //
			// System.out.print(valorRes);
			String oTP = valorRes.substring(1, 11);
			// System.out.print(oTP);
			if (valorRes.toUpperCase().contains("CORRECT")) {
				ResponseSms respuesta = new ResponseSms();
				/* ENVIA EL SMS */
				RequestSms param = new RequestSms();
				ArrayList<String> mensaje = new ArrayList<>();
				mensaje.add(oTP);
				param.setDataVariable(mensaje);
				param.setPhoneNumber(parame.getCelular());
				param.setMessageId(messageId);
				param.setTransactionId(transactionId);
				respuesta = servicioGeneral.invocarSms(param);
				if (respuesta.getDesError().contains("OK")) {
					respWs.setStatusSms("SMS enviado");
				}else {
					
					respWs.setStatusSms("Error al enviar SMS");
				}

				/* ENVIA EL MAIL */
				MailerClass mail = new MailerClass();
				String estado=mail.sendMailSimple(parame.getMail(), oTP, parame.getNombreSocio(), parame.getPar_valor());
				if (estado.contains("correcto")) {
					respWs.setStatusMail(estado);
				}else {
					
					respWs.setStatusMail("Error al enviar Mail");
				}
				
				return new ResponseEntity<>(respWs, HttpStatus.OK);

			} else {

				return new ResponseEntity<>(valorRes, HttpStatus.BAD_GATEWAY);
			}

		} catch (Exception e) {
			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}

	// Fin servicio horozco

	// Servicio de horozco COONFIRMACION DE RETIROS MEDIANTE OTP

	@RequestMapping(value = "/confirma-retiro/", method = RequestMethod.POST)
	@ApiOperation(tags = "Confirmacion Retiro", value = "Retiros de cuenta con código OTP")
	public ResponseEntity<?> confirmaRetiro(@RequestBody ParameterRequestConfirmaRetiro param) {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		try {
//			String valorRes = repositoryConfirmaRetiro.callStoreProcedure("SP_RETIRO_INTERFAZ", parame);  

			String valorRes = repositoryConfirmaRetiro.callStoreProcedure("SP_CONFIRMA_RETIRO", param);
			if (valorRes.toUpperCase().contains("CORRECT")) {
				MailerClass mail = new MailerClass();
				mail.sendMailSimple(param.getMail(), "Transaccion exitosa", param.getNombreSocio(),
						param.getPar_valor());
				return new ResponseEntity<>(valorRes, HttpStatus.OK);

			} else {

				return new ResponseEntity<>(valorRes, HttpStatus.BAD_GATEWAY);
			}

		} catch (Exception e) {
			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			return new ResponseEntity<String>("Error al consumir: " + e.getMessage(), HttpStatus.OK);
		}

	}

	// Fin servicio horozco CONFIRMACION RETIRO

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
			mail.sendMailSimple(param.getAddress(), param.getAsuntoInf(), param.getNombreCliente(), BigDecimal.ZERO);

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

	@RequestMapping(value = "/envio-sms/", method = RequestMethod.POST)
	@ApiOperation(tags = "Envio sms solo", value = "Envia el sms solo celular=0993530018 mensaje=Texto del mensaje")
	public ResponseEntity<?> envioSMS(@RequestBody ParamSms parametro) {
		ResponseSms respuesta = new ResponseSms();

		try {

			RequestSms param = new RequestSms();
			ArrayList<String> mensaje = new ArrayList<>();
			mensaje.add(parametro.getMensaje());
			param.setDataVariable(mensaje);
			param.setPhoneNumber(parametro.getCelular());
			param.setMessageId(messageId);
			param.setTransactionId(transactionId);
			respuesta = servicioGeneral.invocarSms(param);

			return new ResponseEntity<>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println("ERROR AL CONSULTAR " + e.getMessage());
			return new ResponseEntity<String>("Error al enviar sms: " + e.getMessage(), HttpStatus.OK);
		}

	}
}
