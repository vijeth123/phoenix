package com.vj.phoenix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.vj.phoenix"})
public class BootPhoenixServices {

    private static final Logger LOGGER =  LoggerFactory.getLogger(BootPhoenixServices.class);

    public static void main(String[] args) {
        SpringApplication.run(BootPhoenixServices.class, args);
        LOGGER.info("Phoenix services have started!");
    }
}
