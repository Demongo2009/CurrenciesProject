package com.jakubgalat.CurrenciesProject.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class JsonExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(JsonExceptionHandler.class);

    @ExceptionHandler(value = GetHttpRequestFailedException.class)
    @ResponseBody
    public ResponseEntity<Object> handleGetHttpRequestFailedException(GetHttpRequestFailedException exception) {
      logger.error(exception.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .contentType(MediaType.APPLICATION_JSON)
              .body(new ErrorResponse("INTERNAL_SERVER_ERROR! Message: " + exception.getMessage()));
    }

    @ExceptionHandler(value = ValuePayloadExtractionException.class)
    @ResponseBody
    public ResponseEntity<Object> handleValuePayloadExtractionException(ValuePayloadExtractionException exception) {
      logger.error(exception.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .contentType(MediaType.APPLICATION_JSON)
              .body(new ErrorResponse("Wrong currency supplied! Message: " + exception.getMessage()));
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    @ResponseBody
    public ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException exception) {
      logger.error(exception.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .contentType(MediaType.APPLICATION_JSON)
              .body(new ErrorResponse("INTERNAL_SERVER_ERROR! Message: " + exception.getMessage()));
    }

    @ExceptionHandler(value = JsonProcessingException.class)
    @ResponseBody
    public ResponseEntity<Object> handleJsonProcessingException(JsonProcessingException exception) {
      logger.error(exception.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .contentType(MediaType.APPLICATION_JSON)
              .body(new ErrorResponse("INTERNAL_SERVER_ERROR! Message: " + exception.getMessage()));
    }

}
