package com.mec.bookmanage.core;
/**
  * 这个类用来处理数据库字段与类中成员对应问题
 * @author 余生
 */
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyColumn {
	Field field;
	String column;
	
	PropertyColumn() {
	}

	void setField(Field field) {
		this.field = field;
	}
	
	void setField(ResultSet rs, Object object) throws Exception {
		try {
			Object value = rs.getObject(column);
			field.setAccessible(true);
			field.set(object, value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	Object getFieldValue(Object object) {
		field.setAccessible(true);
		try {
			return field.get(object);
		} catch (Exception e) {
			return null;
		}
	}
	
	String getColumn() {
		return column;
	}
	
	Field getField() {
		return field;
	}

	void setColumn(String column) {
		this.column = column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyColumn other = (PropertyColumn) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return field.getName() + " => " + column;
	}
	
}
