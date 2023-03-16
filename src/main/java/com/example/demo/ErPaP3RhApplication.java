package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.IMatriculaSer;

@SpringBootApplication
public class ErPaP3RhApplication implements CommandLineRunner{
	
	@Autowired
	private IMatriculaSer matriculaSer;

	public static void main(String[] args) {
		SpringApplication.run(ErPaP3RhApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.matriculaSer.buscarDTO();
	}

}
