package com.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientImplApplication.class, args);
	}

}
