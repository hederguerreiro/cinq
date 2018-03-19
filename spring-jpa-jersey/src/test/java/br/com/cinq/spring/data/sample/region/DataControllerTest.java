package br.com.cinq.spring.data.sample.region;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DataControllerTest {

	@Value("classpath:regions.csv")
	private Resource dataCSV;

	@Autowired
	DataController dataController;

	@Autowired
	private MockMvc mockMvc;

	@Transactional(readOnly = true)
	@Test
	public void whenUploadData_thenVerifyIfItAllLoaded() throws Exception {
		MockMultipartFile multipartFile = new MockMultipartFile("file", dataCSV.getFilename(),
				MediaType.TEXT_PLAIN_VALUE, dataCSV.getInputStream());
		mockMvc.perform(MockMvcRequestBuilders.multipart("/rest/data/upload").file(multipartFile))
				.andExpect(status().is2xxSuccessful());
	}

}
