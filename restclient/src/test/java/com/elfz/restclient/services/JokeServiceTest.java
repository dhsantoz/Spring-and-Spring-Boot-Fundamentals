package com.elfz.restclient.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JokeServiceTest {

    @Autowired
    private JokeService jokeService;

    private Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

    @Test
    void getJoke() {
        String joke = jokeService.getJoke("Elfz", "Santos");
        logger.info(joke);
        assertTrue(joke.contains("Elfz"));
        assertTrue(joke.contains("Santos"));
    }
}