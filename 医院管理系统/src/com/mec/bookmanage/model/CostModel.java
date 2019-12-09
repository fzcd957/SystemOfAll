package com.mec.bookmanage.model;

import com.mec.bookmanage.annotation.ID;
import com.mec.bookmanage.annotation.Table;

@Table(value ="hospital_cost")
public class CostModel {
	@ID
	private String Id;
	private String money;
	private String status;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return Id+","+money+","+status;
	}
	
}
