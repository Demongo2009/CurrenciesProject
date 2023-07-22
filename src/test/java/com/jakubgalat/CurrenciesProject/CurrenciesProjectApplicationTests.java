// package com.jakubgalat.CurrenciesProject;
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
// @SpringBootTest
// // @RunWith(MockitoJUnitRunner.class)
// class CurrenciesProjectApplicationTests {
//
// 	@Mock
// 	private RestTemplate restTemplate;
// 	@Mock
// 	private ObjectMapper objectMapper;
// 	@Mock
// 	private CurrencyRequestRepository currencyRequestRepository;
// 	@InjectMocks
// 	private CurrencyService currencyService;
//
// 	public CurrenciesProjectApplicationTests(){
// 		currencyService = spy(new CurrencyServiceImpl());
// 		// objectMapper = new ObjectMapper();
// 		// restTemplate = new RestTemplate();
// 	}
//
// 	@Test
// 	void contextLoads() {
// 	}
//
// 	@Test
// 	public void testGetCurrentCurrencyValueCommand(){
// 		String currency = "EUR";
// 		String name = "name";
//
// 		ValuePayload valuePayload = null;
//
// 		doReturn(Optional.of(new ValuePayload(0.5))).when(currencyService).extractValuePayloadFromCurrencyTableA(any(), any());
// 		when(currencyService.makeGetRequestAndGetCurrenciesString(any(),any())).thenReturn("s");
// 		when(objectMapper.readValue(any(),any())).thenReturn(new CurrencyTableA());
// 		when(currencyService.persistUserRequestDTO()).doNothing();
// 		try{
// 			valuePayload = currencyService.getCurrentCurrencyValueCommand(currency, name);
// 		} catch (Exception e) {
//
// 		}
//
// 		assertTrue(valuePayload.getValue() == 0.5);
//
// 	}
//
// 	@Test
// 	public void testMakeGetRequestAndGetCurrenciesString(){
// 		String currency = "EUR";
// 		String name = "name";
//
// 		String currenciesString = null;
//
// 		when(restTemplate.exchange(any(), any(), any(), any())).thenReturn(ResponseEntity.ok("Hello World!"));
// 		try{
// 			currenciesString = currencyService.makeGetRequestAndGetCurrenciesString(currency, name);
// 		} catch (Exception e) {
//
// 		}
//
// 		assertTrue(currenciesString.getValue() == 0.5);
// 	}
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
// 			result = currencyService.getAllRequests(currency, name);
// 		} catch (Exception e) {
//
// 		}
//
// 		assertTrue(result.getId().equals(id));
// 		assertTrue(result.getCurrency().equals(currency));
// 		assertTrue(result.getName().equals(name));
// 		assertTrue(result.getLocalDateTime().equals(localDateTime));
// 		assertTrue(result.getValue().equals(value));
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
