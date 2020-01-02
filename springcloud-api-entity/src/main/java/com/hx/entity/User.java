package com.hx.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")//去掉警告
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String dept;
	private String website;
	private String phone;
	private Employee employee;
}
