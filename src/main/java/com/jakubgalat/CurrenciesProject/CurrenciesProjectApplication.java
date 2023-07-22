package com.jakubgalat.CurrenciesProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;
import com.jakubgalat.CurrenciesProject.domain.*;
import com.jakubgalat.CurrenciesProject.repositories.*;
import com.jakubgalat.CurrenciesProject.exceptions.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.boot.logging.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.lang.reflect.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.asm.TypeReference;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.stream.*;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class CurrenciesProjectApplication {

	private static ObjectMapper objectMapper;
	private static RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(CurrenciesProjectApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean
	public ObjectMapper getObjectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}
}
