package com.icai.practicas.controller;

import com.icai.practicas.controller.ProcessController.DataRequest;
import com.icai.practicas.controller.ProcessController.DataResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcessControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void given_app_when_process_control_using_right_credentials_then_ok() {

		//Given
		String address = "http://localhost:" + port + "/api/v1/process-step1";
		String fullName = "Emilio Kenji Hernandez Kuramata";
        String dni = "02572449Z";
        String telefono = "+34 688148129";
        DataRequest data = new DataRequest(fullName, dni, telefono);
        
		HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<DataRequest> request = new HttpEntity<>(data, headers);
        

		//When
		ResponseEntity<DataResponse> result = this.restTemplate.postForEntity(address, request, DataResponse.class);

		//Then
		String expectedResult = "OK";
		DataResponse expectedResponse = new DataResponse(expectedResult);

		then(result.getBody().result()).isEqualTo(expectedResult);
		then(result.getBody()).isEqualTo(expectedResponse);
	}

    @Test
	public void given_app_when_process_control_using_wrong_credentials_then_ko() {

		//Given
		String address = "http://localhost:" + port + "/api/v1/process-step1";
		String fullName = "Emilio Kenji Hernandez Kuramata";
        String dni = "23449F"; // DNI incorrecto
        String telefono = "+34 688148129";
        DataRequest data = new DataRequest(fullName, dni, telefono);
        
		HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<DataRequest> request = new HttpEntity<>(data, headers);
        

		//When
		ResponseEntity<DataResponse> result = this.restTemplate.postForEntity(address, request, DataResponse.class);

		//Then
		String expectedResult = "KO";
		DataResponse expectedResponse = new DataResponse(expectedResult);

		then(result.getBody().result()).isEqualTo(expectedResult);
		then(result.getBody()).isEqualTo(expectedResponse);
	}

    @Test
	public void given_app_when_process_control_using_empty_credentials_then_ko() {

		//Given
		String address = "http://localhost:" + port + "/api/v1/process-step1";
		String fullName = "Emilio Kenji Hernandez Kuramata";
        String dni = "02572449Z"; 
        String telefono = ""; // Telefono Vacio
        DataRequest data = new DataRequest(fullName, dni, telefono);
        
		HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<DataRequest> request = new HttpEntity<>(data, headers);
        

		//When
		ResponseEntity<DataResponse> result = this.restTemplate.postForEntity(address, request, DataResponse.class);

		//Then
		String expectedResult = "KO";
		DataResponse expectedResponse = new DataResponse(expectedResult);

		then(result.getBody().result()).isEqualTo(expectedResult);
		then(result.getBody()).isEqualTo(expectedResponse);
	}
    
}