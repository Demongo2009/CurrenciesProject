package com.jakubgalat.CurrenciesProject.controllers;

import com.jakubgalat.CurrenciesProject.services.CurrencyService;
import com.jakubgalat.CurrenciesProject.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.jakubgalat.CurrenciesProject.exceptions.*;
import org.springframework.web.client.HttpClientErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value="/api/currencies")
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	@RequestMapping(value = "/get-current-currency-value-command", method = RequestMethod.POST)
	public ValuePayload getCurrentCurrencyValueCommand(@RequestBody UserRequestBody userRequestBody)
		throws HttpClientErrorException, JsonProcessingException, GetHttpRequestFailedException,
		ValuePayloadExtractionException{
		return currencyService.getCurrentCurrencyValueCommand(userRequestBody.getCurrency(), userRequestBody.getName());
	}

	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	public List<CurrencyRequestDTO> getRequests() {
		return currencyService.getAllRequests();
	}
}
