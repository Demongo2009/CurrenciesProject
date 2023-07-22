package com.jakubgalat.CurrenciesProject.domain;

import lombok.*;
import java.time.LocalDate;

//@RequiredArgsConstructor
//@Getter
public class Rate {

	private final String currency;
  private final String code;
  private final Double mid;

  public Rate(){
    this.currency = null;
    this.code = null;
    this.mid = null;
  }

  public Rate(String currency, String code, Double mid){
    this.currency = currency;
    this.code = code;
    this.mid = mid;
  }

  public String getCurrency(){
    return this.currency;
  }

  public String getCode(){
    return this.code;
  }

  public Double getMid(){
    return this.mid;
  }

}
