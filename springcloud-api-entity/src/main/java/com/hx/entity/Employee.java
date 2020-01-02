package com.hx.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")//去掉警告
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String lastName;
	private String email;
	private String gender;
	private int uid;
}
