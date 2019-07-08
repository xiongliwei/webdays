package com.atguigu.web.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class DaoUtil {
	
	private static ThreadLocal<Connection> tl;
	
	private static String url;
	private static String driverClass;
	private static String username;
	private static String password;
	
	private static java.util.Properties properties;
	
	
	
	static {
		
		tl = new ThreadLocal<Connection>();
		InputStream stream = DaoUtil.class.getClassLoader().getResourceAsStream("db.properties");
		properties = new java.util.Properties();
		try {
			properties.load(stream);
			username = properties.getProperty("user");
			password = properties.getProperty("password");
			url = properties.getProperty("jdbcUrl");
			driverClass = properties.getProperty("driverClass");

			try {
				Class.forName(driverClass);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Connection getConnection() throws Exception{
		Connection connection = tl.get();
		
		if (connection == null) {
			connection = DriverManager.getConnection(url, username, password);
				tl.set(connection);	
		}
		
		
		return connection;
		
	}
	
	public static void closeConnection() throws Exception {
		Connection connection = tl.get();
		
		if (connection != null) {
			connection.close();
			tl.remove();
		}
		
	}
	
	
}
