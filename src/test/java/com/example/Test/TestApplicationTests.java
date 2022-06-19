package com.example.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.example.Test.controller.StudentsController;

@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
class TestApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
//	@Autowired
//	private StudentsController studentsController;

	@Test
	void contextLoads() throws Exception{
		assertThat(restTemplate.getForObject("http://localhost:"+port+"/hello", String.class)).contains("Hello There");
	}

}
