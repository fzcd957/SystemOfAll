package com.mec.bookmanage.model;

import com.mec.bookmanage.annotation.Column;
import com.mec.bookmanage.annotation.ID;
import com.mec.bookmanage.annotation.Table;

@Table(value="place_info")
public class PlaceModel {
	@ID
	@Column(value="place_number")
	private String number;
	@Column(value="place_location")
	private String location;
	@Column(value="place_status")
	private String status;
	@Column(value ="place_money")
	private int money;
	@Column(value ="place_size")
	private String size;
	@Column(value = "place_kind")
	private String kind;
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return number+","+location+","+status+","+money;
	}
	
	
}
