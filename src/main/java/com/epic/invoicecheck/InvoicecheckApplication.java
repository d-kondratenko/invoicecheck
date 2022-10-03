package com.epic.invoicecheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.epic.invoicecheck")
public class InvoicecheckApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder confi(SpringApplicationBuilder application){
		return application.sources(InvoicecheckApplication.class); }

	public static void main(String[] args) {
		SpringApplication.run(InvoicecheckApplication.class, args);
	}

}
