package com.jakubgalat.CurrenciesProject.domain;

import lombok.*;

//@RequiredArgsConstructor
//@Getter
public class UserRequestBody {

	private final String currency;
  private final String name;

	public UserRequestBody(){
		currency = null;
		name = null;
	};

	public UserRequestBody(String currency, String name){
		this.currency = currency;
		this.name = name;
	}

	public String getCurrency(){
		return this.currency;
	}

	public String getName(){
		return this.name;
	}

}
