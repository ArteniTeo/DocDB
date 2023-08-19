package com.DocDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DocDBApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocDBApplication.class, args);
	}

}
