package br.com.cinq.spring.data.sample.region;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

	@Autowired
	private CityRepository cityRepository;

	@Transactional(readOnly = true)
	@RequestMapping(method = RequestMethod.GET, value = "/rest/cities")
	@ResponseBody
	public List<City> getAllCitiesByCountry(@RequestParam("country") String country) {
		List<City> cities = Collections.emptyList();
		try (Stream<City> streamResult = cityRepository.findAllByCountryName(country)) {
			cities = streamResult.collect(Collectors.toList());
		}
		return cities;
	}

}
