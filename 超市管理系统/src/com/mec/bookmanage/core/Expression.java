package com.mec.bookmanage.core;

/**
 * 这个类用来动态生成SQL语句，供Query类调用
 * @author 余生
 */
public class Expression {
	
	Expression() {
	}
	//登录
	public String selectByIdAndpassword(ClassTableDefinition ctd) {
		StringBuffer res = new StringBuffer();	
		res.append(baseSelectExpression(ctd)).append(" WHERE ").append("id ").append("=?")
											 .append(" AND ").append("password ").append("=?");
		
		return res.toString();
	}
	//查询全部信息
	String baseSelectExpression(ClassTableDefinition ctd) {
		// SELECT (表名称.字段)表 FROM 表名称
		StringBuffer res = new StringBuffer("SELECT ");	
		res.append(ctd.getColumnList()).append(' ')
		.append("FROM ").append(ctd.getTable());
		return res.toString();
		
	}
	
	//查询对应ID的信息
	String selectExpressionById(ClassTableDefinition ctd) {
		StringBuffer res = new StringBuffer();
		
		res.append(baseSelectExpression(ctd))
		.append(" WHERE ");
		PropertyColumn Id = ctd.getId();
		res.append(ctd.getTable()).append(".").append(Id.getColumn())
			.append("=?");
		
		return res.toString();
	}
	//
	String updateById(ClassTableDefinition ctd) {
		StringBuffer res = new StringBuffer("UPDATE ");
		PropertyColumn Id = ctd.getId();
		res.append(ctd.getTable()).append(' ').append("SET ")
		.append("p_money ").append("=? ").append("WHERE ").append(Id.getColumn()).append("=?");
		
		return res.toString();
	}
	String insertExpression(ClassTableDefinition ctd) {
		// INSERT INTO xxx (字段1，字段2，……，字段n) VALUES (值1，值2，……，值n)
		StringBuffer res = new StringBuffer("INSERT INTO ");
		res.append(ctd.getTable()).append(" (")
		.append(ctd.getColumnList()).append(") VALUES(")
		.append(ctd.getQuestionList()).append(')');
		
		return res.toString();
	}
	
	String delectRxpression(ClassTableDefinition ctd) {
		StringBuffer res = new StringBuffer("DELETE FROM ");
		PropertyColumn Id = ctd.getId();
		res.append(ctd.getTable()).append(' ').append("WHERE ").append(Id.getColumn()).append("=?");
		
		return res.toString();
	}
	
	//结束/还书
	String updateExpressionById(ClassTableDefinition ctd) {
		StringBuffer res = new StringBuffer("UPDATE ");
		PropertyColumn Id = ctd.getId();
		res.append(ctd.getTable()).append(' ').append("SET ")
		.append("BKstatus ").append("=? ").append("WHERE ").append(Id.getColumn()).append("=?");
		
		return res.toString();
	}
	
	
	//还书/借书(通过书名和人名)
	String updateExpressionByIdandpname(ClassTableDefinition ctd) {
		StringBuffer res = new StringBuffer("UPDATE ");
		res.append(ctd.getTable()).append(' ')
		.append("SET ").append("SPtime ").append("=? ")
		.append("WHERE ").append("bkid ").append("=? ").append("AND ")
						 .append("ppname ").append("=?");
		
		return res.toString();
	}
}
