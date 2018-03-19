package br.com.cinq.spring.data.sample.region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.java.Log;

@RestController
@Log
public class DataController {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;

	private static String COMMA_SEPARATED = ",";

	@Transactional(readOnly = true)
	@RequestMapping(method = RequestMethod.POST, value = "/rest/data/upload")
	@ResponseBody
	public ResponseEntity<?> uploadDataCSV(@RequestParam("file") MultipartFile file) {
		List<Map<Country, City>> data = new ArrayList<>();
		try (InputStream inputStream = file.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

			// skip header of CSV
			data = bufferedReader.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			bufferedReader.close();

			// file is empty
			if (data.isEmpty()) {
				return ResponseEntity.badRequest().build();
			}

			// save countries and cities
			data.stream().forEach(d -> {
				d.keySet().forEach(co -> {
					countryRepository.save(co);
				});
				d.values().forEach(ci -> {
					cityRepository.save(ci);
				});
			});
			return ResponseEntity.ok().build();
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return ResponseEntity.badRequest().build();
	}

	private Function<String, Map<Country, City>> mapToItem = (line) -> {
		Map<Country, City> data = new HashMap<Country, City>();
		String[] columns = line.split(COMMA_SEPARATED);
		Country country = columns[0] != null ? new Country(columns[0]) : null;
		City city = columns[1] != null ? new City(columns[1], country) : null;
		data.put(country, city);
		return data;
	};

}
