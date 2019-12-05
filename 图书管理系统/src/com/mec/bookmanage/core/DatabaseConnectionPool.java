package com.mec.bookmanage.core;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.mec.util.PropertiesParser;
/**
 * 这个类是数据库连接池类，它的思路就是为了避免频繁的创建和销毁数据库连接
 * 这是很耗时耗资源的一种操作，解决办法是刚开始我们就创建一些连接，加入到connectionPool
 * 给这些connection增加一个boolean属性isused，若被使用则更改属性为true
 * 以后如果需要得到一个connection，我们先检测pool中是否有isused = false的connection
 * 若存在就返回这个conneciton，若不存在则创建一个新的conneciton加入pool，再检测pool是否存在isused = false的connection
 * @author 余生
 */
public class DatabaseConnectionPool {
	static final List<Connection> connectionPool = new ArrayList<>();
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	private static int minCount;
	private static int maxCount;
	private static int deltaCount;
	private static long timeout = 2000;
	
	public DatabaseConnectionPool() {
	}
	
	private static boolean createConnection(int count) throws Exception {
		int i = 0;
		
		while (connectionPool.size() < maxCount && i < count) {
			Connection connection = new Connection();
			connection.setConnection(DriverManager.getConnection(url, user, password));
			connectionPool.add(connection);
			i++;
		}
		return connectionPool.size() < maxCount;
	}
	
	long timeout() {
		return timeout;
	}
	
	Connection getConnection() throws Exception {
		for (int i = 0; i < connectionPool.size(); i++) {
			Connection connection = connectionPool.get(i);
			if (!connection.isUsed()) {
				return connection.getConnection();
			}
		}
		if (createConnection(deltaCount)) {
			return getConnection();
		}
		
		return null;
	}
	
	static void initDatabase(String path) throws Exception {
		PropertiesParser.loadProperties(path);
		driver = PropertiesParser.value("driver");
		url = PropertiesParser.value("url");
		user = PropertiesParser.value("user");
		password = PropertiesParser.value("password");
		
		String minCountStr = PropertiesParser.value("minCount");
		minCount = minCountStr == null ? 3 : Integer.valueOf(minCountStr);
		
		String maxCountStr = PropertiesParser.value("maxCount");
		maxCount = maxCountStr == null ? 50 : Integer.valueOf(maxCountStr);
		
		String deltaCountStr = PropertiesParser.value("deltaCount");
		deltaCount = deltaCountStr == null ? 3 : Integer.valueOf(deltaCountStr);
		
		String timeoutStr = PropertiesParser.value("timeout");
		timeout = timeoutStr == null ? 60000 : Long.valueOf(timeoutStr);
		
		try {
			Class.forName(driver);
			createConnection(minCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
