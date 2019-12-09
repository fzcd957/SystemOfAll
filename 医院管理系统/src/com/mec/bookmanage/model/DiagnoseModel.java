package com.mec.bookmanage.model;

import com.mec.bookmanage.annotation.ID;
import com.mec.bookmanage.annotation.Table;
@Table(value ="hospital_diagnose")
public class DiagnoseModel {
	@ID
	private String Id;
	private String Illness;
	private String history;
	private String Result;
	private String money;
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getIllness() {
		return Illness;
	}
	public void setIllness(String illness) {
		Illness = illness;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	@Override
	public String toString() {
		return Id+","+Illness+","+history+","+Result+","+money;
	}
	
	
}
