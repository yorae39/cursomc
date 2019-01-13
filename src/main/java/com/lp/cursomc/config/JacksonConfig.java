package com.lp.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lp.cursomc.domain.PagamentoComBoleto;
import com.lp.cursomc.domain.PagamentoComCartao;

@Configuration
public class JacksonConfig {

	
	@Bean
	public Jackson2ObjectMapperBuilder  objectMapperBuilder() {
		
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			
			public void configure(ObjectMapper objectMapper) {
				
				objectMapper.registerSubtypes(PagamentoComBoleto.class);
				objectMapper.registerSubtypes(PagamentoComCartao.class);
				super.configure(objectMapper);
			}
		};
		
		return builder;
	}
}
