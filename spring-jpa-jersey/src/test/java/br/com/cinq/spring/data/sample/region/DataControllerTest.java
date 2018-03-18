package br.com.cinq.spring.data.sample.region;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataControllerTest {

	@Autowired
	CityRepository cityRepository;

	@Autowired
	CountryRepository countryRepository;

	@Test
	public void whenUploadCities_thenVerifyIfItAllLoaded() {
		fail("Not yet implemented");
	}

	@Test
	public void whenUploadCountries_thenVerifyIfItAllLoaded() {
		fail("Not yet implemented");
	}

}
