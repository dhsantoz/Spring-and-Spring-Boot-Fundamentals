package com.example.demo.controller;

import com.example.demo.entities.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRestController {

    @GetMapping(value = "/rest")
    public Greeting greet(@RequestParam(required = false, defaultValue = "Default") String name){
        return new Greeting(String.format("Hello %s!!", name));
    }

}
