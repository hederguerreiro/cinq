package br.com.cinq.spring.data.sample.region;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class EndpointTest {

	@Autowired
	CityController cityController;

	@Autowired
	private MockMvc mockMvc;

	@Transactional(readOnly = true)
	@Test
	public void testGetCities() throws UnsupportedEncodingException, Exception {
		final String country = "France";
		String result = mockMvc
				.perform(get("/rest/cities").param("country", country).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		List<City> cities = new ObjectMapper().readValue(result, new TypeReference<List<City>>() {
		});
		assertEquals(2, cities.size());
	}
}
