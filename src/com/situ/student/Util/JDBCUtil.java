package com.situ.student.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtil {
//	private static final String url = "jdbc:mysql://localhost:3306/java";
//	private static final String userName = "root";
//	private static final String password = "root";
//	private static final String driverClass = "com.mysql.jdbc.Driver";
	
	private static final String url;
	private static final String userName;
	private static final String password;
	private static final String driverClass;
	
	static{
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("./src/db.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		url = properties.getProperty("url");
		userName = properties.getProperty("userName");
		password = properties.getProperty("password");
		driverClass = properties.getProperty("driverClass");
		
		// 1、连接驱动
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		// 2、获取连接对象
		Connection connection = null;
		try {
			connection = (Connection) DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void close(Connection connection, Statement statement) {
		// 6、后打开的先关闭
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		// 6、后打开的先关闭
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
