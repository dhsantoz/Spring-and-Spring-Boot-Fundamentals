package com.example.demo.controller;


import com.example.demo.entities.Greeting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HelloRestControllerUnitTest {

    @Test
    void greetWithName() {
        HelloRestController controller = new HelloRestController();
        Greeting greet = controller.greet("Name1");
        assertNotNull(greet);
        assertEquals(greet.getMessage(), "Hello Name1!!");
    }

}
