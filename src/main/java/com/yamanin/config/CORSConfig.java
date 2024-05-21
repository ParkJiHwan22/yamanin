package com.yamanin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
			.allowedOriginPatterns("*")
			.allowCredentials(true)
			.exposedHeaders("*")
			.maxAge(3600); // Preflight Caching
	}
	
	

}
