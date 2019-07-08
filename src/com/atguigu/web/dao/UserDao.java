package com.atguigu.web.dao;

import com.atguigu.web.bean.User;

public interface UserDao {
	User findUserByNameAndPassword(String username,String password) throws Exception;
}
