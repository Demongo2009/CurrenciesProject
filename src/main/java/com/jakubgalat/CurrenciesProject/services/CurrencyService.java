package com.jakubgalat.CurrenciesProject.services;

import com.jakubgalat.CurrenciesProject.domain.*;
import java.util.List;
import com.jakubgalat.CurrenciesProject.exceptions.*;
import org.springframework.web.client.HttpClientErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CurrencyService {

	public ValuePayload getCurrentCurrencyValueCommand(String currency, String name)
		throws HttpClientErrorException, JsonProcessingException, GetHttpRequestFailedException,
		ValuePayloadExtractionException;
	public List<CurrencyRequestDTO> getAllRequests();

}
