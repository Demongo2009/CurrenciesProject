package com.jakubgalat.CurrenciesProject.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.jakubgalat.CurrenciesProject.domain.CurrencyRequestDTO;
import java.util.List;
import java.util.Optional;

public interface CurrencyRequestRepository extends MongoRepository<CurrencyRequestDTO, String>{

  public Optional<CurrencyRequestDTO> findById(String id);
  public List<CurrencyRequestDTO> findAll();
  public CurrencyRequestDTO save(CurrencyRequestDTO currencyRequestDTO);
  public void delete(CurrencyRequestDTO currencyRequestDTO);

}
