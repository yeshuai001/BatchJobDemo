package com.hsjry.cc.batch.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations= {"classpath:application-bean.xml"})
public class HsjryCcBatchSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HsjryCcBatchSpringApplication.class, args);
	}
}
