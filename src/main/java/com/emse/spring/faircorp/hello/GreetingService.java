package com.emse.spring.faircorp.hello;

import org.springframework.stereotype.Service;

@Service
public interface GreetingService {
    public String name = "Spring";
    void greet(String name);
}