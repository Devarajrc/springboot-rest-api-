package com.cts.emp.empapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public org.modelmapper.ModelMapper modelmapper() {
		return new org.modelmapper.ModelMapper();
	}

}
