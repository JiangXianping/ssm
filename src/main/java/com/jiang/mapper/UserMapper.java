package com.jiang.mapper;

import java.util.List;

import com.jiang.entity.User;

public interface UserMapper {
	
	//����idɾ��
    int deleteByPrimaryKey(Integer id);
    
    //����
    int insert(User record);
    
    
    int insertSelective(User record);
    
    //����id����
    User selectByPrimaryKey(Integer id);
    
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //�������ֲ�ѯ�������
    User selectByName(String username);
    
    //��ѯ�����û�
    List<User> selectAll();
}