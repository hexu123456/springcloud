package com.hx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient//将服务注册到eureka注册中心
@MapperScan(value=("com.hx.dao"))
@SpringBootApplication
public class CloudProviderDeptApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudProviderDeptApplication.class, args);
	}

}
