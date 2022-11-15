package com.emse.spring.faircorp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.emse.spring.faircorp.hello.GreetingService;

@Configuration
public class FaircorpApplicationConfig {

    @Bean
    public CommandLineRunner greetingCommandLine(GreetingService gService){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("Hello, " + GreetingService.name + "!");
            }
        };
    }
}