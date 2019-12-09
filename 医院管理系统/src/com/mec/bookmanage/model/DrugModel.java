package com.mec.bookmanage.model;

import com.mec.bookmanage.annotation.ID;
import com.mec.bookmanage.annotation.Table;

@Table(value ="hospital_drug")
public class DrugModel {
	@ID
	private String Name;
	private String Money;
	private String Unit;
	private String Producer;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMoney() {
		return Money;
	}
	public void setMoney(String money) {
		Money = money;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public String getProducer() {
		return Producer;
	}
	public void setProducer(String producer) {
		Producer = producer;
	}
	@Override
	public String toString() {
		return Name+","+Money+","+Unit+","+Producer;
	}
	
	
}
