package com.hx.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hx.entity.User;

@FeignClient(value="cloud-provid-erdept",fallbackFactory=DeptClientServiceFallbackFactory.class)
//@FeignClient(value="cloud-provid-erdept")
public interface DeptClienService {
	@RequestMapping(value="/admin/findUserById",method={RequestMethod.GET})
	public User findUserById(@RequestParam("id")int id)throws Exception;
	@RequestMapping(value="/admin/findUserList",method={RequestMethod.GET})
	public List<User> findUserList()throws Exception;
}
