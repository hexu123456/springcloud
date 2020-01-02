package com.hx.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hx.dao.UserDao;
import com.hx.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/admin/findUserById_Hystrix/{id}")
	@ResponseBody
	@HystrixCommand(fallbackMethod = "findUserById_Hystrix")
	public User findUserByIdHystrix(@PathVariable("id") Integer id) {
		User user = userDao.findUserById(id);
		if (user == null) {
			throw new RuntimeException("没有改" + id + "信息"); 
		}
		return user;
	}
	@RequestMapping("/admin/findUserById")
	@ResponseBody
	public User findUserById(@RequestParam("id")Integer id){
		System.out.println("被调用了");
		try {
			return userDao.findUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public User findUserById_Hystrix(@PathVariable("id") Integer id) {
		System.out.println("测试熔断");
		return new User(1, "服务跑异常了", null, null, null, null);
	}
	
}
