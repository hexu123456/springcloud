package com.hx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
public class CosumerDept {

	public static void main(String[] args) {
		SpringApplication.run(CosumerDept.class, args);
	}
}
