package com.ec.afsotec.services;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.ec.afsotec.sms.RequestSms;
import com.ec.afsotec.sms.ResponseSms;


@Service
public class ServicioGeneral {

	@Value("${webservices.ruta}")
	private String ruta;

	


	public ResponseSms invocarSms(RequestSms param) {

		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		// create auth credentials
//		CredentialToken credentialToken = new CredentialToken(userToken, passwordToken);
//		TokenResponse token = GestionToken.obtenerToken(credentialToken, rutatoken);

		// create headers
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
			headers.set("Authorization", "Basic OTk5OTkwMjI2Ok5oVzFqOG1TZHYwRzFRYlY=");

			// create request
			HttpEntity<RequestSms> requestBody = new HttpEntity<RequestSms>(param, headers);
			ResponseEntity<ResponseSms> response = restTemplate.postForEntity(ruta, requestBody, ResponseSms.class);
			
			return response.getBody();
		} catch (HttpStatusCodeException e) {
			
			
			// TODO: handle exception
			System.out.println("ERROR " + e.getMessage());
			ResponseSms error = new ResponseSms();
			error.setCodError(500);
			error.setDesError(e.getMessage());
//			error=e.get
			return error;
		}

	}

	

}
