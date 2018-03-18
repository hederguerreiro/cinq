package br.com.cinq.spring.data.sample.region;

import static org.assertj.core.api.Assertions.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryRepositoryTest {

	@Autowired
	CountryRepository countryRepository;

	@Test
	public void whenUploadCountries_thenVerifyIfItAllLoaded() {
		fail("Not implemented");
	}

}
