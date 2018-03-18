package br.com.cinq.spring.data.sample.region;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DataController {

	@Transactional(readOnly = true)
	@RequestMapping(method = RequestMethod.POST, value = "/rest/cities/upload")
	@ResponseBody
	public void uploadCitiesCSV(@RequestParam("file") MultipartFile file) {
		
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(method = RequestMethod.POST, value = "/rest/countries/upload")
	@ResponseBody
	public void uploadCountriesCSV(@RequestParam("file") MultipartFile file) {
		
	}
	
}
