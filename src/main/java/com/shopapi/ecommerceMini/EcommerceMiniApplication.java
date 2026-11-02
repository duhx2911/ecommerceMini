package com.shopapi.ecommerceMini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@ConfigurationPropertiesScan
public class EcommerceMiniApplication {
    Logger log = LoggerFactory.getLogger(EcommerceMiniApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EcommerceMiniApplication.class, args);
	}

    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {
        log.info("RUN OK.");
    }

}
