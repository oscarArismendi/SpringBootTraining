package com.j3appdemo.j3_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
@PropertySource(value="classpath:values.properties",encoding = "UTF-8")
})
public class J3AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(J3AppApplication.class, args);
	}

}
