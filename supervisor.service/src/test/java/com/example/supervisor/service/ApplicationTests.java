package com.example.supervisor.service;

import com.example.supervisor.service.dto.SupervisorRequest;
import com.example.supervisor.service.repository.SupervisorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ApplicationTests {
	@Container
	static MongoDBContainer mongoDBContainer=new MongoDBContainer("mongo:4.4.2");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	//object to json json to object
	private ObjectMapper objectMapper;
	@Autowired
	SupervisorRepository supervisorRepository;
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
	}
	@Test
	void shouldCreateSupervisor() throws Exception {

		SupervisorRequest supervisorRequest= getSupervisorRequest();
		 String supervisorRequestString=objectMapper.writeValueAsString(supervisorRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/supervisor")
				.contentType(MediaType.APPLICATION_JSON)
				.content(supervisorRequestString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, supervisorRepository.findAll().size());

	}

	private SupervisorRequest getSupervisorRequest() {
		return SupervisorRequest.builder().FirstName("Asma").LastName("BenSaid").Organisation("Ana Yakedh").build();
	}

}
