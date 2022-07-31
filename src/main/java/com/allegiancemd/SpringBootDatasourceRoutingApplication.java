package com.allegiancemd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringBootDatasourceRoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDatasourceRoutingApplication.class, args);
	}

}
