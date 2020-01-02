package com.hx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hx.entity.User;
import com.hx.service.DeptClienService;

@Controller
public class UserController {
	@Autowired
	private DeptClienService deptClienService;

	@RequestMapping(value="/cusumer/findUserById",method={RequestMethod.GET})
	@ResponseBody
	public User findUserById(@RequestParam("id")int id){
		try {
			return deptClienService.findUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/cusumer/findUserList",method={RequestMethod.GET})
	@ResponseBody
	public List<User> findUserList(){
		try {
			return deptClienService.findUserList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
