package com.hx.dao;

import java.util.List;

import com.hx.entity.User;

public interface UserDao {
	public User findUserById(int id)throws Exception;
	public List<User> findUserList()throws Exception;
}
