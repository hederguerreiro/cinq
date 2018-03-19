package br.com.cinq.spring.data.sample.region;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;
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

	@Transactional(readOnly = true)
	@Test
	public void testGelAllCountries() {
		assertNotNull(countryRepository);
		Country country = new Country();
		country.setId(3); // Should be France
		try (Stream<Country> countries = countryRepository.findAll().stream()) {
			List<Country> list = countries.collect(Collectors.toList());
			assertNotNull(list);
		}
	}

	@Transactional(readOnly = true)
	@Test
	public void testFindOneCountry() {
		assertNotNull(countryRepository);
		try (Stream<Country> countries = countryRepository.findLikeName("Fra")) {
			List<Country> list = countries.collect(Collectors.toList());
			assertNotNull(list);
		}
	}

}
