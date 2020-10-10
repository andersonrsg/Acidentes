package com.acidentes.backend;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) throws IOException {


		SpringApplication.run(BackendApplication.class, args);



	}

}
