package com.hx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigClientRest {

	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/myconfig")
	@ResponseBody
	public String getConfig(){
		System.out.println("11111");
		String str="applicationName:"+applicationName+"\t eurekaServers:"+eurekaServers+"\t port: "+port;
	    System.out.println("*******str:"+str);
	    return "applicationName:"+applicationName+"<br> eurekaServers:"+eurekaServers+"<br> port: "+port;
	}
}
