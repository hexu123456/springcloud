package com.hx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hx.dao.UserDao;
import com.hx.entity.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;

	@RequestMapping("/admin/findUserById")
	@ResponseBody
	public User findUserById(@RequestParam("id")Integer id){
		
		try {
			return userDao.findUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/admin/findUserList")
	@ResponseBody
	public List<User> findUserList(){
		try {
			return userDao.findUserList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
