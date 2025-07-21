package com.br.gov.ms.campogrande.apireme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiremeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiremeApplication.class, args);
	}

}
