package com.example.JPAElBuenSabor;

import com.example.JPAElBuenSabor.entities.*;
import com.example.JPAElBuenSabor.repositories.ClienteRepository;
import com.example.JPAElBuenSabor.repositories.EmpleadoRepository;
import com.example.JPAElBuenSabor.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaElBuenSaborApplication{

	/*@Autowired
	private EmpleadoRepository empleadoRepository;*/

	/*@Autowired
	private ClienteRepository clienteRepository;*/

	/*@Autowired
	private RolRepository rolRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(JpaElBuenSaborApplication.class, args);
	}



	@Bean
	CommandLineRunner init() {
		return args -> {

		};
	}
}