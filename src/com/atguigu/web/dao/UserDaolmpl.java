package com.atguigu.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atguigu.web.bean.User;
import com.atguigu.web.utils.DaoUtil;

public class UserDaolmpl implements UserDao {

	@Override
	public User findUserByNameAndPassword(String username, String password) throws Exception {
		User user = null;
		Connection conn = DaoUtil.getConnection();
		String sql = "select * from tbl_user where username=? and password=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet query = ps.executeQuery();
		
		
		while (query.next()) {
			user=new User();
			user.setId(query.getInt("id"));
			user.setUsername(query.getString("username"));
			user.setPassword(query.getString("password"));
					
		}
		return user;
		
	}

}
