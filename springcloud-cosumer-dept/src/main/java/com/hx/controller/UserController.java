package com.hx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.hx.entity.User;

@Controller
public class UserController {
	
	//提供方的服务地址，也就是提供者http://ip:端口号/(如果是war包，此处还加上提供者项目名称)
	//private static String REST_URL="http://localhost:8002/";
	//使用Ribbot负载均衡客户端工具之后，这里就要使用我们提供者的名称了springcloud-provider-deptsspring:
	  //application:
		   // name: cloud-provider-dept #eureka对外暴露的微服务名字
	private static String REST_URL="http://cloud-provid-erdept/";
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/cusumer/findUserById")
	@ResponseBody
	public User findUserById(@RequestParam("id")Integer id){
		ResponseEntity<User> postForEntity =restTemplate.getForEntity(REST_URL+"admin/findUserById?id="+id, User.class);
		return postForEntity.getBody();
	}
	
	@RequestMapping("/cusumer/findUserList")
	@ResponseBody
	public List<User> findUserList(){
		ResponseEntity<List> forEntity = restTemplate.getForEntity(REST_URL+"admin/findUserList", List.class);
		return forEntity.getBody();
	}
}
