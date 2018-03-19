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
public class CityRepositoryTest {

	@Autowired
	private CityRepository cityRepository;

	@Transactional(readOnly = true)
	@Test
	public void whenFindAllCities_ByCountryName_thenShouldVerifyIfIsNotNull() {
		try (Stream<City> cities = cityRepository.findAllByCountryName("Brazil")) {
			cities.forEach(city -> assertNotNull(city.getName()));
		}
	}

	@Transactional(readOnly = true)
	@Test
	public void testQueryPerson() {
		assertNotNull(cityRepository);
		Country country = new Country();
		country.setId(3); // Should be France
		try (Stream<City> cities = cityRepository.findAllByCountryId(country)) {
			List<City> list = cities.collect(Collectors.toList());
			assertNotNull(list);
		}
	}

}
