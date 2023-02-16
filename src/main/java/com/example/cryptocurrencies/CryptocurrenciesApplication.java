package com.example.cryptocurrencies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CryptocurrenciesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptocurrenciesApplication.class, args);
    }

}
