package com.mec.bookmanage.model;

import java.sql.Timestamp;

import com.mec.bookmanage.annotation.Column;
import com.mec.bookmanage.annotation.ID;
import com.mec.bookmanage.annotation.Table;
@Table(value ="car_info")
public class CarModel {
	@Column(value ="car_number")
	private String cnumber;
	
	@Column(value ="pl_number")
	private String pnumber;
	@ID
	@Column(value ="st_time")
	private Timestamp STtime;
	@Column(value ="sp_time")
	private Timestamp SPtime;
	private double money;
	
	public String getCnumber() {
		return cnumber;
	}
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public Timestamp getSTtime() {
		return STtime;
	}
	public void setSTtime(Timestamp sTtime) {
		STtime = sTtime;
	}
	public Timestamp getSPtime() {
		return SPtime;
	}
	public void setSPtime(Timestamp sPtime) {
		SPtime = sPtime;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return cnumber+","+pnumber+","+STtime+","+SPtime+","+money;
	}
	
	
}
