// package com.jakubgalat.CurrenciesProject.services;
//
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
// import com.jakubgalat.CurrenciesProject.services.CurrencyService;
// import com.jakubgalat.CurrenciesProject.domain.*;
// import com.jakubgalat.CurrenciesProject.repositories.*;
// import com.jakubgalat.CurrenciesProject.services.CurrencyServiceImpl;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.springframework.web.client.RestTemplate;
// import org.mockito.*;
// import static org.mockito.Mockito.*;
// import  org.springframework.util.*;
// import static org.junit.jupiter.api.Assertions.*;
// import org.springframework.http.*;
// import org.mockito.MockitoAnnotations;
// import static org.mockito.MockitoAnnotations.*;
// import java.util.Optional;
// import static org.mockito.ArgumentMatchers.any;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.util.*;
//
// import static org.assertj.core.api.Assertions.assertThat;
// import static org.mockito.Mockito.when;
//
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import java.time.LocalDate;
//
// @SpringBootTest
// class CurrencyServiceImplTests {
//
// 	@Mock
// 	private RestTemplate restTemplate;
// 	@Mock
// 	private ObjectMapper objectMapper;
// 	@Mock
// 	private CurrencyRequestRepository currencyRequestRepository;
// 	@InjectMocks
// 	private CurrencyServiceImpl currencyService;
//
// 	public CurrencyServiceImplTests(){
// 		currencyService = spy(new CurrencyServiceImpl());
// 		// objectMapper = new ObjectMapper();
// 		// restTemplate = new RestTemplate();
// 	}
//
// 	@Test
// 	public void testGetCurrentCurrencyValueCommand(){
// 		String currency = "EUR";
// 		String name = "name";
//
// 		ValuePayload valuePayload = null;
// 		try{
// 			doReturn(Optional.of(new ValuePayload(0.5))).when(currencyService).extractValuePayloadFromCurrencyTableA(any(), any());
// 			doReturn("s").when(currencyService).makeGetRequestAndGetCurrenciesString(any(),any());
// 			when(objectMapper.readValue("s",CurrencyTableA.class)).thenReturn(new CurrencyTableA());
// 			doNothing().when(currencyService).persistUserRequestDTO(any(), any(), any());
//
// 			valuePayload = currencyService.getCurrentCurrencyValueCommand(currency, name);
// 		} catch (Exception e) {
//
// 		}
//
// 		assertTrue(valuePayload.getValue() == 0.5);
//
// 	}
//
// // 	@Test
// // 	public void testMakeGetRequestAndGetCurrenciesString(){
// // 		String currency = "currency";
// // 		String name = "name";
// //
// // 		String currenciesString = null;
// // 		HttpHeaders headers = new HttpHeaders();
// // 		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
// // 		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
// // 		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//
// // 		/* [ERROR] /C:/Users/User/OneDrive/Documents/ProjektyPraca/CurrenciesProject/src/test/java/com/jakubgalat/CurrenciesProject/services/CurrencyServiceImplTests.java:[84,92] no suitable method found for thenReturn(org.springframework.http.ResponseEntity<java.lang.String>)
// // 		 [ERROR]     method org.mockito.stubbing.OngoingStubbing.thenReturn(org.springframework.http.ResponseEntity<capture#1 of ? extends java.lang.String>) is not applicable
// // [ERROR]       (argument mismatch; inference variable T has incompatible bounds
// // [ERROR]           equality constraints: capture#1 of ? extends java.lang.String
// // [ERROR]           lower bounds: java.lang.String)
// // [ERROR]     method org.mockito.stubbing.OngoingStubbing.thenReturn(org.springframework.http.ResponseEntity<capture#1 of ? extends java.lang.String>,org.springframework.http.ResponseEntity<capture#1 of ? extends java.lang.String>...) is not applicable
// // [ERROR]       (argument mismatch; inference variable T has incompatible bounds
// // [ERROR]           equality constraints: capture#1 of ? extends java.lang.String
// // [ERROR]           lower bounds: java.lang.String)
// // [ERROR] /C:/Users/User/OneDrive/Documents/ProjektyPraca/CurrenciesProject/src/test/java/com/jakubgalat/CurrenciesProject/services/CurrencyServiceImplTests.java:[86,107] incompatible types: java.lang.String cannot be converted to java.lang.Class<?>
// // */
//
// // 		when(restTemplate.exchange(any(), HttpMethod.GET, entity, name.getClass())).thenReturn(ResponseEntity.ok("Hello World!"));
// // 		try{
// // 			currenciesString = currencyService.makeGetRequestAndGetCurrenciesString(currency, name);
// // 		} catch (Exception e) {
// //
// // 		}
// //
// // 		assertTrue(currenciesString.equals("Hello World!"));
// // 	}
//
// 	@Test
// 	public void testGetAllRequests(){
//
// 		String str = "1986-04-08 12:30";
// 		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
// 		List<CurrencyRequestDTO> userRequestDTOList = new ArrayList<>();
//
// 		String id = "id";
// 		String currency = "currency";
// 		String name = "name";
// 		LocalDateTime localDateTime = LocalDateTime.parse(str, formatter);
// 		Double value = 0.5;
// 		userRequestDTOList.add(new CurrencyRequestDTO(id, currency, name, localDateTime, value));
// 		when(currencyRequestRepository.findAll()).thenReturn(userRequestDTOList);
// 		List<CurrencyRequestDTO> result = null;
// 		try{
// 			result = currencyService.getAllRequests();
// 		} catch (Exception e) {
//
// 		}
//
// 		assertTrue(result.size() == 1);
// 		assertTrue(result.get(0).getId().equals(id));
// 		assertTrue(result.get(0).getCurrency().equals(currency));
// 		assertTrue(result.get(0).getName().equals(name));
// 		assertTrue(result.get(0).getDate().equals(localDateTime));
// 		assertTrue(result.get(0).getValue().equals(value));
//
// 	}
//
//
// 	@Test
// 	public void testExtractValuePayloadFromCurrencyTableA(){
//
// 		String str = "1986-04-08 12:30";
// 		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
// 		LocalDateTime localDateTime = LocalDateTime.parse(str, formatter);
//
//
// 		String table = "A";
// 		String no = "no";
// 		LocalDate effectiveDate = localDateTime.toLocalDate();
// 		List<Rate> rates = new ArrayList<>();
// 		String currency = "currency";
// 		String code = "code";
// 		Double mid = 0.5;
// 		rates.add(new Rate(currency, code, mid));
// 		CurrencyTableA currencyTableA = new CurrencyTableA(table, no, effectiveDate, rates);
//
// 		Optional<ValuePayload> result = null;
//
// 		try{
// 			result = currencyService.extractValuePayloadFromCurrencyTableA(currency, currencyTableA);
// 		} catch (Exception e) {
//
// 		}
//
// 		assertTrue(result.isPresent());
// 		assertTrue(result.get().getValue().equals(mid));
//
// 	}
// }
