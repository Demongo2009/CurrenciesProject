package com.jakubgalat.CurrenciesProject.domain;

import lombok.*;
import java.time.LocalDate;
import java.util.*;

//@RequiredArgsConstructor
//@Getter
public class CurrencyTableA {

	private final String table;
  private final String no;
  private final LocalDate effectiveDate;
  private final List<Rate> rates;

  public CurrencyTableA(){
    this.table = null;
    this.no = null;
    this.effectiveDate = null;
    this.rates = null;
  }

  public CurrencyTableA(String table, String no, LocalDate effectiveDate, List<Rate> rates){
    this.table = table;
    this.no = no;
    this.effectiveDate = effectiveDate;
    this.rates = rates;
  };

  public String getTable(){
    return this.table;
  }

  public String getNo(){
    return this.no;
  }

  public LocalDate getEffectiveDate(){
    return this.effectiveDate;
  }

  public List<Rate> getRates(){
    return this.rates;
  }

}
