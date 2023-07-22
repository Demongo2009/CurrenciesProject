package com.jakubgalat.CurrenciesProject.exceptions;

public class ErrorResponse extends Exception {
  public ErrorResponse(String errorMessage) {
      super(errorMessage);
  }

}
