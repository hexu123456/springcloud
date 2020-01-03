package com.hx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@SpringBootApplication
@EnableConfigServer
public class CloudConfig {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfig.class, args);
	}
}
