package com.jakubgalat.CurrenciesProject.domain;

import lombok.*;

//@RequiredArgsConstructor
//@Getter
public class ValuePayload {

	private final Double value;

	public ValuePayload(Double value){
		this.value = value;
	}

	public Double getValue(){
		return this.value;
	}

}
