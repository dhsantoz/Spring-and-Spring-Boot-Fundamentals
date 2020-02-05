package com.example.demo.controller;

import com.example.demo.entities.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT )
public class HelloRestControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void greetWithoutName() {

        ResponseEntity<Greeting> entity = testRestTemplate.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        assertEquals("Hello Default!!", response.getMessage());

    }

    @Test
    void greetWithName() {
        Greeting response = testRestTemplate.getForObject("/rest?name=Elfz", Greeting.class);
        assertEquals("Hello Elfz!!", response.getMessage());
    }
}
