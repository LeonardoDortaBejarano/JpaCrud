package com.formacion.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formacion.jpa.Partner.PartnerService;
import com.formacion.jpa.Sailor.SailorRepository;

@SpringBootApplication
public class JpaApplication { 

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}
