package com.mec.bookmanage.model;

import com.mec.bookmanage.annotation.Column;
import com.mec.bookmanage.annotation.ID;
import com.mec.bookmanage.annotation.Table;

@Table(value = "p_info")
public class PersonModel {
	@Column(value = "p_name")
	private String name;
	@ID
	@Column(value = "p_number")
	private String number;
	@Column(value = "p_money")
	private String money;	
	private String password;
	private String id;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return name + ","+number + "," + money+","+id+","+password;
	}
	
	
}
