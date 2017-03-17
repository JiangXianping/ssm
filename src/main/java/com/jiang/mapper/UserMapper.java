package com.jiang.mapper;

import java.util.List;

import com.jiang.entity.User;

public interface UserMapper {
	
	//根据id删除
    int deleteByPrimaryKey(Integer id);
    
    //增加
    int insert(User record);
    
    
    int insertSelective(User record);
    
    //根据id查找
    User selectByPrimaryKey(Integer id);
    
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //根据名字查询具体对象
    User selectByName(String username);
    
    //查询所有用户
    List<User> selectAll();
}