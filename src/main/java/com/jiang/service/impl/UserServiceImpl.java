package com.jiang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiang.entity.User;
import com.jiang.mapper.UserMapper;
import com.jiang.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	public User findById(int id) {
		
		return this.userMapper.selectByPrimaryKey(id);
		
	}
	
	//��֤��¼
	public boolean login(String username, String password) {
		User user = userMapper.selectByName(username);
		if(user != null){
			if(user.getUsername().equals(username)&&
					user.getPassword().equals(password)){
				return true;
			}
		}
		
		return false;
	}
	
	//获取所有
	public List<User> findAll() {
		return this.userMapper.selectAll();
	}
	
	
	public int InsertUser(User user) {
		return this.userMapper.insert(user);
	}
	
	//�����û��Ƿ����
	public boolean checkUser(String username) {
		User user = this.userMapper.selectByName(username);
		if(user != null){
			return true;
		}else{
			return false;
		}
	}



}
