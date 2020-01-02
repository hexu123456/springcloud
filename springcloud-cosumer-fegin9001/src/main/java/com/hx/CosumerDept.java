package com.hx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
/*
 * @SpringBootApplication 来标注一个主程序，说明它是一个springboot应用
 * @SpringBootApplication 是springboot主配置类，springboot应该运行这个类的main方法来启动springboot项目
 * 
 * @SpringBootConfiguration:springboot配置类
 * @EnableAutoConfiguration:开启springboot自动配置功能
 * 
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages={"com.hx"})
@ComponentScan("com.hx")
public class CosumerDept {

	public static void main(String[] args) {
		SpringApplication.run(CosumerDept.class, args);
	}
}
