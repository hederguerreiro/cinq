package br.com.cinq.spring.data.sample.region;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CountryTest {

	@Test
	public void whenCreateCountry_ThenShouldBeInstantiated() {
		Country country = new Country();
		assertNotNull(country);
	}

	@Test
	public void whenCreateCountry_WithName_ThenShouldBeInstantiated() {
		Country country = new Country("Brazil");
		assertNotNull(country);
	}

	@Test
	public void whenVerifyToString_UsingCountry_ThenShouldBeValid() {
		Country country = new Country("Brazil");
		assertNotNull(country);
		assertNotNull(country.toString());
	}

	@Test
	public void whenVerifyIfEquals_UsingCountries_ThenShouldBeEquals() {
		Country countryOne = new Country("Brazil");
		Country countryTwo = new Country("Brazil");
		assertEquals(countryOne, countryTwo);
	}

	@Test
	public void whenCheckHashCode_UsingCountry_ThenShouldBeGenerated() {
		Country country = new Country();
		assertNotNull(country.hashCode());
	}

}
