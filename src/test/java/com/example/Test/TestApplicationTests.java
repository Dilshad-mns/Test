package com.example.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Test.controller.StudentsController;

@SpringBootTest()
@AutoConfigureMockMvc
class TestApplicationTests {
	
//	@LocalServerPort
//	private int port;
	
	@Autowired
	private MockMvc mockMvc;
	
//	@Autowired
//	private TestRestTemplate restTemplate;
	
//	@Autowired
//	private StudentsController studentsController;

//	@Test
//	void contextLoads() throws Exception{
//		assertThat(restTemplate.getForObject("http://localhost:"+port+"/hello", String.class)).contains("Hello There");
//	}
	
	@Test
	void checkEndpoint() throws Exception {
		this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Hello There")));
	}

}
