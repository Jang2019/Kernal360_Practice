package com.example.rest_API;

import com.example.rest_API.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.internal.creation.SuspendMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;
	@Test
	void contextLoads() throws JsonProcessingException {

		var user = new UserRequest();
		user.setNameValue("홍길동");
		user.setNumber("10");
		user.setEmail("g@naver.com");
		user.setIsKorean(true);

		var json = objectMapper.writeValueAsString(user);

		System.out.println((json));

		var dto = objectMapper.readValue(json, UserRequest.class);
		System.out.print(dto);
	}

}
