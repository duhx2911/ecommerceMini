package com.shopapi.ecommerceMini;

import com.shopapi.ecommerceMini.service.CheckoutService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@ConfigurationPropertiesScan
public class EcommerceMiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceMiniApplication.class, args);
	}

    @Bean
    CommandLineRunner run(CheckoutService checkoutService) {
        return args -> System.out.println(
                "RUN OK.");
    }

}
