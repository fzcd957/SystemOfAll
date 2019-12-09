package com.mec.UspPackage.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
  *这个类首先是让用户需要使用Connection的地方直接使用我们这个类
  *相当于重写Connection，但只完成现在我们用到的方法，增加了一些方法
  *用来让用户调用产生prepareStatement的方法，以及判断是否有无效的连接需要超时收回
 * @author 余生
 */
public class Connection {
	private java.sql.Connection connection;
	private boolean isUsed;
	private long time;
	
	public Connection() {
		isUsed = false;
	}

	Connection getConnection() {
		time = System.currentTimeMillis();
		isUsed = true;
		return this;
	}
	
	void forceClose(long timeout, long curTime) {
		if (!isUsed) {
			return;
		}
		long delayTime = curTime - time;
		if (timeout <= delayTime) {
			isUsed = false;
		}
	}

	PreparedStatement prepareStatement(String SQLString) throws SQLException {
		return connection.prepareStatement(SQLString);
	}
	
	void setConnection(java.sql.Connection connection) {
		this.connection = connection;
	}
	
	boolean isUsed() {
		return isUsed;
	}

	void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	void close() {
		isUsed = false;
	}
	
}
