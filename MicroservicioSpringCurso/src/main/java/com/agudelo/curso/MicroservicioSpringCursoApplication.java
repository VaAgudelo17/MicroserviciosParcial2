package com.agudelo.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.agudelo.curso.models.entity", "com.agudelo.commons.models.entity"})
@EntityScan({"com.agudelo.commons.models.entity", "com.agudelo.curso.models.entity"})
@EnableJpaRepositories({"com.agudelo.curso.models.entity","com.agudelo.commons.models.entity"})

public class MicroservicioSpringCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioSpringCursoApplication.class, args);
	}

}
