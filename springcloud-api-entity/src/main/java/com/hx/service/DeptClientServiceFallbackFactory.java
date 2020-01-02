package com.hx.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hx.entity.User;

import feign.hystrix.FallbackFactory;

@Component  //必须添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClienService> {

	@Override
	public DeptClienService create(Throwable arg0) {
		return new DeptClienService() {
			@Override
			public List<User> findUserList() throws Exception {
				return null;
			}
			
			@Override
			public User findUserById(int id) throws Exception {
				return  new User(1, "服务跑异常了", null, null, null, null);
			}
		};
	}

}
