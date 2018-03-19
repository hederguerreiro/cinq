package br.com.cinq.spring.data.sample.region;

import static org.junit.Assert.assertNotNull;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryRepositoryTest {

	@Autowired
	CountryRepository countryRepository;

	@Transactional(readOnly = true)
	@Test
	public void whenFindAllCountries_thenVerifyIfItAllLoaded() {
		try (Stream<Country> countries = countryRepository.findAll().stream()) {
			countries.forEach(country -> assertNotNull(country.getName()));
		}
	}

}
