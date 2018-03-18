package br.com.cinq.spring.data.sample.region;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CityTest {

	@Test
	public void whenCreateCity_ThenShouldBeInstantiated() {
		City city = new City();
		assertNotNull(city);
	}

	@Test
	public void whenCreateCity_WithName_ThenShouldBeInstantiated() {
		City city = new City("Curitiba", new Country("Brazil"));
		assertNotNull(city);
	}

	@Test
	public void whenVerifyToString_UsingCity_ThenShouldBeValid() {
		City city = new City("Curitiba", new Country("Brazil"));
		assertNotNull(city);
		assertNotNull(city.toString());
	}

	@Test
	public void whenVerifyIfEquals_UsingCities_ThenShouldBeEquals() {
		City cityOne = new City("Curitiba", new Country("Brazil"));
		City cityTwo = new City("Curitiba", new Country("Brazil"));
		assertEquals(cityOne, cityTwo);
	}

	@Test
	public void whenCheckHashCode_UsingCity_ThenShouldBeGenerated() {
		City city = new City();
		assertNotNull(city.hashCode());
	}

}
