package com.lp.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	public boolean instantiateDatBase() {
		
		//NÃO USADO POIS USO ARQUIVO import.sql
		
		return true;
	}
}
