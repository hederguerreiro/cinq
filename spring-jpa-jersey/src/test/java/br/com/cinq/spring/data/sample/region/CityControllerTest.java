package br.com.cinq.spring.data.sample.region;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityControllerTest {

	@Autowired
	CityController cityController;

	@Test
	public void whenFindAllByCountry_ThenShouldShowCitiesList() {
		assertThat(cityController.getAllCitiesByCountry("Uni")).isNotEmpty();
	}

}
