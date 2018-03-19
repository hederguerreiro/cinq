package br.com.cinq.spring.data.sample.region;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class EndpointTest {

	Logger logger = LoggerFactory.getLogger(EndpointTest.class);

	private final String localhost = "http://localhost:";

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate = new TestRestTemplate();

	@Transactional(readOnly = true)
	@Test
	public void testGetCities() throws InterruptedException {
		String country = "France";

		HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.localhost + this.port + "/rest/cities/")
				.queryParam("country", country);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<City[]> response = this.restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,
				entity, City[].class);

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

		Thread.sleep(2000L);

		City[] cities = response.getBody();

		Assert.assertEquals(2, cities.length);

	}
}
