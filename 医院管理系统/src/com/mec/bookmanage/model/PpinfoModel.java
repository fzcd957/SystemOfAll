package com.mec.bookmanage.model;

import com.mec.bookmanage.annotation.ID;
import com.mec.bookmanage.annotation.Table;
@Table(value ="hospital_ppinfo")
public class PpinfoModel {
	@ID
	private String Id;
	private String Name;
	private String Sex;
	private String Age;
	private String History;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getHistory() {
		return History;
	}
	public void setHistory(String history) {
		History = history;
	}
	@Override
	public String toString() {
		return Id+","+Name+","+Sex+","+Age+","+History;
	}
	
	
}
