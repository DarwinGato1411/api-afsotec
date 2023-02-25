package com.ec.afsotec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;



@SpringBootApplication
@EnableScheduling
public class WsCustomerApplication extends SpringBootServletInitializer {



	public static void main(String[] args) {
		SpringApplication.run(WsCustomerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(WsCustomerApplication.class);
	}


}