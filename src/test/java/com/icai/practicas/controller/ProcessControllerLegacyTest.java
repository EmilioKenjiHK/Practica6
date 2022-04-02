package com.icai.practicas.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcessControllerLegacyTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void given_app_when_process_control_using_right_credentials_then_ok() {

		//Given
		String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
		String fullName = "Emilio Kenji Hernandez Kuramata";
        String dni = "02572449Z";
        String telefono = "+34 688148129";
        MultiValueMap <String,String> data = new LinkedMultiValueMap<>();

        data.add("fullName",fullName);
        data.add("dni",dni);
        data.add("telefono",telefono);
        
		HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(data, headers);
        

		//When
		ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

		//Then
		then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

    @Test
	public void given_app_when_process_control_using_wrong_credentials_then_ko() {

		//Given
		String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
		String fullName = "Emilio Kenji Hernandez Kuramata";
        String dni = "02132G"; // Dni Incorrecto
        String telefono = "+34 688148129";
        MultiValueMap <String,String> data = new LinkedMultiValueMap<>();

        data.add("fullName",fullName);
        data.add("dni",dni);
        data.add("telefono",telefono);
        
		HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(data, headers);
        

		//When
		ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

		//Then
		then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

    @Test
	public void given_app_when_process_control_using_empty_credentials_then_ko() {

		//Given
		String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
		String fullName = "Emilio Kenji Hernandez Kuramata";
        String dni = "02572449Z";
        String telefono = ""; // Vacio
        MultiValueMap <String,String> data = new LinkedMultiValueMap<>();

        data.add("fullName",fullName);
        data.add("dni",dni);
        data.add("telefono",telefono);
        
		HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(data, headers);
        

		//When
		ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

		//Then
		then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

    @Test
	public void given_app_when_process_control_using_wrong_address_then_ko() {

		//Given
		String address = "http://localhost:" + port + "/api/"; // Mala direccion
		String fullName = "Emilio Kenji Hernandez Kuramata";
        String dni = "02572449Z";
        String telefono = "+34 688148129";
        MultiValueMap <String,String> data = new LinkedMultiValueMap<>();

        data.add("fullName",fullName);
        data.add("dni",dni);
        data.add("telefono",telefono);
        
		HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(data, headers);
        

		//When
		ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

		//Then
		then(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}
