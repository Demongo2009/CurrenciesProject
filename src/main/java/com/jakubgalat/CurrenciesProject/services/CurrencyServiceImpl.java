package com.jakubgalat.CurrenciesProject.services;

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

@Service
public class CurrencyServiceImpl implements CurrencyService {
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private ObjectMapper objectMapper;

  private Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);

	@Autowired
	private CurrencyRequestRepository currencyRequestRepository;

  @Autowired
  public CurrencyServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
    this.restTemplate = restTemplate;
    this.objectMapper = objectMapper;
  }

  public CurrencyServiceImpl(){

  }

  @PostConstruct
  public void init(){
    logger.info("CurrencyServiceImpl - Initialized.");
  }

	public ValuePayload getCurrentCurrencyValueCommand(String currency, String name)
    throws JsonProcessingException, HttpClientErrorException, GetHttpRequestFailedException,
    ValuePayloadExtractionException{

    String uri = getCurrencyExchangeRateURI();
    Optional<ValuePayload> valueFromURI = Optional.empty();

    String currenciesString = makeGetRequestAndGetCurrenciesString(uri, String.class);
    CurrencyTableA currenciesTableA = objectMapper.readValue(currenciesString.substring(1, currenciesString.length()-1), CurrencyTableA.class);

    valueFromURI = extractValuePayloadFromCurrencyTableA(currency, currenciesTableA);
    // thanks to optional we can decide to persist wrong requests or not
    valueFromURI.ifPresent((a)->{
      persistUserRequestDTO(a, currency, name);
    });

    if(!valueFromURI.isPresent()){
      throw new ValuePayloadExtractionException("Couldnt get currency: \"" + currency + "\" from URI: " + uri);
    }

    return valueFromURI.get();
	}

  public List<CurrencyRequestDTO> getAllRequests() {
    Optional<List<CurrencyRequestDTO>> currencyRequestDTOs = Optional.empty();

    try{
      currencyRequestDTOs = Optional.of(currencyRequestRepository.findAll());
    } catch (Exception e) {
      logger.error("Couldnt get UserRequestDTOs: " + currencyRequestDTOs);
      throw e;
    }

    return currencyRequestDTOs.get();

  }

  protected void persistUserRequestDTO(ValuePayload valuePayload, String currency, String name) {

    CurrencyRequestDTO currencyRequestDTO = new CurrencyRequestDTO(null,currency, name, LocalDateTime.now(), valuePayload.getValue());
    try{
      currencyRequestRepository.save(currencyRequestDTO);
    } catch (Exception e) {
      logger.error("Couldnt save UserRequestDTO: " + currencyRequestDTO);
      // decision if fail the API call
    }

    return;
  }

  protected Optional<ValuePayload> extractValuePayloadFromCurrencyTableA(String currency, CurrencyTableA currenciesTableA) {

    Double result = null;

    List<Rate> rates = currenciesTableA.getRates();

    // wouldnt work for some reason cannot find symbol [ERROR]   symbol:   variable stream
    // List<Rate> currencyRates = rates.stream.filter((a) -> {a.getCode().equals(currecny);}).collect(Collectors.toList());
    List<Rate> currencyRates = new ArrayList<>();
    for(Rate rate: rates){
      if(rate.getCode().equals(currency)){
        currencyRates.add(rate);
      }
    }

    if (currencyRates.size() > 1) {
      logger.error("Got too many currency rates for currency: " + currency);
      return Optional.empty();
    }
    if (currencyRates.size() <= 0) {
      logger.error("Couldnt get currency rate for currency: " + currency);
      return Optional.empty();
    }
    Rate rateForCurrency = currencyRates.get(0);

    Double mid = rateForCurrency.getMid();
    if(mid <= 0){
      logger.error("Mid value is negative or zero for currency: " + currency);
      return Optional.empty();
    }

    return Optional.of(new ValuePayload(mid));
  }

  protected String getCurrencyExchangeRateURI() {

    return "http://api.nbp.pl/api/exchangerates/tables/A?format=json";
  }

  protected String makeGetRequestAndGetCurrenciesString(String uri, Class<?> returnClass) throws HttpClientErrorException, RuntimeException, GetHttpRequestFailedException{

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
    ResponseEntity<?> result =
            restTemplate.exchange(uri, HttpMethod.GET, entity, returnClass);
    HttpStatus statusCode = result.getStatusCode();

    if(statusCode != HttpStatus.OK){
      throw new GetHttpRequestFailedException("GET Request to \"" + uri + "\" failed! StatusCode: " + statusCode.toString());
    }

    String currenciesString = (String) result.getBody();

    return currenciesString;
  }

}
