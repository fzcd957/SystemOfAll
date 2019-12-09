package com.mec.bookmanage.core;
/*
 * 这个类中提供了方法调用DatabaseConnectionPool.initDatabase()方法
 * 以及初始化类表对应关系的添加模式(XML|Annotation)
 */
public class DataSource {

	public DataSource() {
	}
	
	public static void initDatabase(String packageName) {
		try {
			DatabaseConnectionPool.initDatabase("/database.cfg.properties");
			new ClassPathAnnotationApplicationContext(packageName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
