package com.kodluyoruz.dogukanaligundoganhm4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class DogukanAliGundoganHm4Application {

    public static void main(String[] args) {
        SpringApplication.run(DogukanAliGundoganHm4Application.class, args);
    }

}
