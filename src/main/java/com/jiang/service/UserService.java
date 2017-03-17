package com.jiang.service;

import java.util.List;

import com.jiang.entity.User;


public interface UserService {
	
	//根据id获取user
	public User findById(int id);
	
	//查询所有用户信息
	public List<User> findAll();
	
	//登录
	public boolean login(String username,String password);
	
	//注册
	public int InsertUser(User user);
	
	//查找用户是否存在
	public boolean checkUser(String username);
}
