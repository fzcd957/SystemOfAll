package com.mec.UspPackage.core;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
/**
  * 这个类用来处理类表对应问题
 * @author 余生
 */
public class ClassTableDefinition {
	String table;
	Class<?> klass;
	Map<String, PropertyColumn> properties;
	PropertyColumn id;
	String columnList;
	String questionList;
	
	ClassTableDefinition() {
		this.properties = new HashMap<>();
	}

	 String getColumnList() {
		if (columnList == null) {
			StringBuffer res = new StringBuffer();
			boolean first = true;
			for (String property : properties.keySet()) {
				PropertyColumn propertyColumn = properties.get(property);
				res.append(first ? "" : ",");
				res.append(table).append(".").append(propertyColumn.getColumn());
				first = false;
			}
			columnList = res.toString();
		}
		
		return columnList;
	}
	
	String getQuestionList() {
		if (questionList == null) {
			int columnCount = properties.size();
			StringBuffer res = new StringBuffer();
			
			for (int i = 0; i < columnCount; i++) {
				res.append(i == 0 ? "" : ",")
				.append('?');
			}
			questionList = res.toString();
		}
		
		return questionList;
	}
	
	void setField(ResultSet rs, Object object) throws Exception {
		for (PropertyColumn pc : properties.values()) {
			pc.setField(rs, object);
		}
	}
	
	void addColumn(PropertyColumn propertyColumn) {
		if (properties.containsValue(propertyColumn)) {
			return;
		}
		properties.put(propertyColumn.getField().getName(), propertyColumn);
	}
	
	PropertyColumn getPropertyColumn(Field field) {
		return properties.get(field.getName());
	}
	
	Map<String, PropertyColumn> getPorperties() {
		return properties;
	}
	
	void setKlass(Class<?> klass) {
		this.klass = klass;
	}

	String getTable() {
		return table;
	}

	void setTable(String table) {
		this.table = table;
	}

	PropertyColumn getId() {
		return id;
	}

	void setId(PropertyColumn id) {
		this.id = id;
	}

	Class<?> getKlass() {
		return klass;
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer("class:");
		res.append(klass.getName()).append('\n')
		.append("table:").append(table).append('\n')
		.append("fields:\n");
		
		for (String key : properties.keySet()) {
			PropertyColumn pc = properties.get(key);
			res.append('\t').append(pc).append('\n');
		}
		
		res.append("id:").append(id);
		
		return res.toString();
	}
	
}
