package com.shopapi.ecommerceMini;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceMiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceMiniApplication.class, args);
	}

    @Bean
    CommandLineRunner run(ApplicationContext ctx) {
        return args -> System.out.println(
                ctx.getBeanDefinitionCount() + " beans");
    }

}
