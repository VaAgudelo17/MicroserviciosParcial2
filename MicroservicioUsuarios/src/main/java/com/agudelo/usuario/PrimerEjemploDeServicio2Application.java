package com.agudelo.usuario;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class PrimerEjemploDeServicio2Application {

	public static void main(String[] args) {
		SpringApplication.run(PrimerEjemploDeServicio2Application.class, args);
	}

}
