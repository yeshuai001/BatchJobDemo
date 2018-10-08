package com.hsjry.cc.batch.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations= {"classpath:application-bean.xml"})
@EnableAutoConfiguration(exclude = BatchAutoConfiguration.class)
public class HsjryCcBatchSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(HsjryCcBatchSpringApplication.class, args);
	}
}
