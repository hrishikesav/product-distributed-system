package com.hrishi.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@OpenAPIDefinition
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
