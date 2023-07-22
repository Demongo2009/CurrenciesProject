package com.jakubgalat.CurrenciesProject.domain;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

// lombok doesnt work with Pulsar IDE ;( it needs Eclipse based IDE or netbeans
//@Getter
@JsonIgnoreProperties(value = { "id" })
@Document
//@AllArgsConstructor
public class CurrencyRequestDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private final String id;

	private final String currency;
	private final String name;
	private final LocalDateTime date;
	private final Double value;

	public CurrencyRequestDTO(String id, String currency, String name, LocalDateTime date, Double value){
		this.id = id;
		this.currency = currency;
		this.name = name;
		this.date = date;
		this.value = value;
	}

	public String getId(){
		return this.id;
	}

	public String getCurrency(){
		return this.currency;
	}

	public String getName(){
		return this.name;
	}

	public LocalDateTime getDate(){
		return this.date;
	}

	public Double getValue(){
		return this.value;
	}

}
