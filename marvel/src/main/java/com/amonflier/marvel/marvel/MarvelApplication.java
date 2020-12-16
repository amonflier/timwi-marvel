package com.amonflier.marvel.marvel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.amonflier.marvel.marvel")
public class MarvelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelApplication.class, args);
	}

}
