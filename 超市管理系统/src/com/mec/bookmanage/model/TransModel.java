package com.mec.bookmanage.model;

import java.sql.Timestamp;

import com.mec.bookmanage.annotation.Column;
import com.mec.bookmanage.annotation.ID;
import com.mec.bookmanage.annotation.Table;

@Table(value = "transfer_info")
public class TransModel {
	@Column(value="p_name1")
	private String name1;
	@Column(value="p_name2")
	private String name2;
	@Column(value="p_number1")
	private String number1;
	@Column(value="p_number2")
	private String number2;
	@ID
	private Timestamp time;
	@Column(value="p_money")
	private String money;
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getNumber1() {
		return number1;
	}
	public void setNumber1(String number1) {
		this.number1 = number1;
	}
	public String getNumber2() {
		return number2;
	}
	public void setNumber2(String number2) {
		this.number2 = number2;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return name1 + ","+ name2 +"," + number1+ ","+number2+
				 ","+ time+ "," + money;
	}
	
	
}
