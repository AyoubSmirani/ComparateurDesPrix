package com.example.annuaire;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//import io.jsonwebtoken.lang.Collections;


@SpringBootApplication
public class SpringpfeApplication {

	public static void main(String[] args) {
		 SpringApplication app = new SpringApplication(SpringpfeApplication.class);
	        app.setDefaultProperties(Collections.singletonMap("jwt.secret", "123456"));
	     //   app.setDefaultProperties(Collections.singletonMap("jwt.expriration", "200000"));
	        app.run(args);
	}
	
}


