package com.mec.bookmanage.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mec.util.PropertiesParser;

/*
 * 这个类中提供了方法调用DatabaseConnectionPool.initDatabase()方法
 * 以及初始化类表对应关系的添加模式(XML|Annotation)
 */
public class DataSource {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static Connection connection;

	public DataSource() {
	}
	
	public static void init(String path) throws Exception {
		PropertiesParser.loadProperties(path);
		driver = PropertiesParser.value("driver");
		url = PropertiesParser.value("url");
		user = PropertiesParser.value("user");
		password = PropertiesParser.value("password");
		
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConneciton() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void initDatabase(String packageName) {
		try {
			init("/database.cfg.properties");
			new ClassPathAnnotationApplicationContext(packageName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
