package com.jakubgalat.CurrenciesProject.exceptions;

public class GetHttpRequestFailedException extends Exception {
    public GetHttpRequestFailedException(String errorMessage) {
        super(errorMessage);
    }
}
