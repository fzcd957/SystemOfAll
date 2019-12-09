package com.mec.bookmanage.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
  * 这个类提供了数据库操作对应的全套方法，从获取连接一直到对数据进行操作
  *  其中调用了Expression类生成SQL语句，从factory的map中取出ctd，从ctd的map中取出字段名
  *  再调用getFieldValue()方法设置该成员的值
 * @author 余生
 */
public class Query {
	
	public Query() {
	}
	//登录
	@SuppressWarnings("unchecked")
	public <T> T getbyiorp(Class<?> klass, Object id,Object name) {
		try {
			Connection connection = DataSource.getConneciton();
			ClassTableDefinition ctd = ClassTableFactory.getClassTable(klass);
			String SQLSelect = new Expression().selectByIdAndpassword(ctd);
			PreparedStatement state = connection.prepareStatement(SQLSelect);
			state.setObject(1, id);
			state.setObject(2, name);
			ResultSet rs = state.executeQuery();
			
			if (rs.next()) {
				Object obj = klass.newInstance();
				ctd.setField(rs, obj);
				return (T) obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getsomething(Class<?> klass, Object carnumber,Object plnumber) {
		try {
			Connection connection = DataSource.getConneciton();
			ClassTableDefinition ctd = ClassTableFactory.getClassTable(klass);
			String SQLSelect = new Expression().getsomethings(ctd);
			PreparedStatement state = connection.prepareStatement(SQLSelect);
			state.setObject(1, carnumber);
			state.setObject(2, plnumber);
			ResultSet rs = state.executeQuery();
			
			if (rs.next()) {
				Object obj = klass.newInstance();
				ctd.setField(rs, obj);
				return (T) obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public int updateById(Class<?> klass,Object object1,Object object2) {
		ClassTableDefinition ctd = ClassTableFactory.getClassTable(klass);
		if (ctd == null) {
			return 0;
		}
		String SQLString = new Expression().updateById(ctd);
		try {
			Connection connection = DataSource.getConneciton();
			PreparedStatement state = connection.prepareStatement(SQLString);
			
			state.setObject(1, object1);
			state.setObject(2, object2);
			
			return state.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			}
		return 0;
		
	}
	
	public int updateBynumber(Class<?> klass,Object object1,Object object2) {
		ClassTableDefinition ctd = ClassTableFactory.getClassTable(klass);
		if (ctd == null) {
			return 0;
		}
		String SQLString = new Expression().updateBynumber(ctd);
		try {
			Connection connection = DataSource.getConneciton();
			PreparedStatement state = connection.prepareStatement(SQLString);
			
			state.setObject(1, object1);
			state.setObject(2, object2);
			
			return state.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			}
		return 0;
		
	}
	

	public int updateBysome(Class<?> klass,Object object1,Object object2,Object object3,Object object4) {
		ClassTableDefinition ctd = ClassTableFactory.getClassTable(klass);
		if (ctd == null) {
			return 0;
		}
		String SQLString = new Expression().updateExpressionById(ctd);
		try {
			Connection connection = DataSource.getConneciton();
			PreparedStatement state = connection.prepareStatement(SQLString);
			
			state.setObject(1, object1);
			state.setObject(2, object2);
			state.setObject(3, object3);
			state.setObject(4, object4);
			
			return state.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			}
		return 0;
		
	}
	
	// 对数据库表中增加一条信息的操作
	public int save(Object object) {
		Class<?> klass = object.getClass();
		
		ClassTableDefinition ctd = ClassTableFactory.getClassTable(klass);
		if (ctd == null) {
			return 0;
		}
		String SQLString = new Expression().insertExpression(ctd);
		try {
			Connection connection = DataSource.getConneciton();
			PreparedStatement state = connection.prepareStatement(SQLString);
			
			Map<String, PropertyColumn> pcMap = ctd.getPorperties();
			int index = 1;
			for (String property : pcMap.keySet()) {
				PropertyColumn propertyColumn = pcMap.get(property);
				state.setObject(index++, propertyColumn.getFieldValue(object));
			}
			return state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	// 对数据库表中某个对应id值的信息的查找操作
	@SuppressWarnings("unchecked")
	public <T> T get(Class<?> klass, Object id) {
		try {
			Connection connection = DataSource.getConneciton();
			ClassTableDefinition ctd = ClassTableFactory.getClassTable(klass);
			String SQLSelect = new Expression().selectExpressionById(ctd);
			PreparedStatement preparedStatement = connection.prepareStatement(SQLSelect);
			// SELECT * FROM ... WHERE id = ?
			preparedStatement.setObject(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				Object obj = klass.newInstance();
				ctd.setField(rs, obj);
				return (T) obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 对数据库表的所有字段的查询操作
	@SuppressWarnings("unchecked")
	public <T> List<T> get(Class<?> klass) {
		List<T> res = new ArrayList<>();
		
		try {
			Connection connection = DataSource.getConneciton();
			
			ClassTableDefinition ctd = ClassTableFactory.getClassTable(klass);
			String SQLSelect = new Expression().baseSelectExpression(ctd);
			
			PreparedStatement preparedStatement = connection.prepareStatement(SQLSelect);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Object obj = klass.newInstance();
				ctd.setField(rs, obj);
				res.add((T) obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
}
