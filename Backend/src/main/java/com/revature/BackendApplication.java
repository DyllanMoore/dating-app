package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
	}
	/*
	 *  Global CORS configuration
	 */

	@Bean
	WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	           /*
	            *  Disclaimer: these settings are not recommended in production. This is just for dev/demo purpose
	            *  Allow on all API endpoint paths
	            *  Allow all methods - GET, POST, PUT, DELETE, OPTIONS, and etc.
	            *  Allow cross-origin requests from http://localhost (Front-end). Add port number if front-end is running on a different port
	            *  Allow receiving of credentials (if using {withCredentials:true} option with http requests in angular)
	            */
	            registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost").allowCredentials(true);
	        }
	    };
	}
}
