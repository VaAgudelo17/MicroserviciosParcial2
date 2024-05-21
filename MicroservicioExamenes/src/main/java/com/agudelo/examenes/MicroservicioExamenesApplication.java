package com.agudelo.examenes;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.agudelo.commons.models.entity.*"})
@EnableJpaRepositories({"com.agudelo.commons.models.entity.*"})
@EntityScan({"com.agudelo.commons.models.entity.*"})
public class MicroservicioExamenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioExamenesApplication.class, args);
	}

}
