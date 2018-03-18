package br.com.cinq.spring.data.sample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cinq.spring.data.sample.region.CityController;
import br.com.cinq.spring.data.sample.region.DataController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJpaJerseyApplicationTests {

	@Autowired
	private CityController cityController;

	@Autowired
	private DataController dataController;

	@Test
	public void contextLoads() {
		assertThat(cityController).isNotNull();
		assertThat(dataController).isNotNull();
	}

}
