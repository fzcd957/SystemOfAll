package com.mec.bookmanage.model;

import java.sql.Timestamp;

import com.mec.bookmanage.annotation.ID;
import com.mec.bookmanage.annotation.Table;

@Table(value = "borrow_info2")
public class BorrowModel {
	String bkid;
	String bkname;
	String ppname;
	@ID
	Timestamp STtime;
	Timestamp SPtime;
	
	public BorrowModel() {
	}

	public String getBkid() {
		return bkid;
	}

	public void setBkid(String bkid) {
		this.bkid = bkid;
	}

	public String getBkname() {
		return bkname;
	}

	public void setBkname(String bkname) {
		this.bkname = bkname;
	}

	public String getPpname() {
		return ppname;
	}

	public void setPpname(String ppname) {
		this.ppname = ppname;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SPtime == null) ? 0 : SPtime.hashCode());
		result = prime * result + ((STtime == null) ? 0 : STtime.hashCode());
		result = prime * result + ((bkid == null) ? 0 : bkid.hashCode());
		result = prime * result + ((bkname == null) ? 0 : bkname.hashCode());
		result = prime * result + ((ppname == null) ? 0 : ppname.hashCode());
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
		BorrowModel other = (BorrowModel) obj;
		if (SPtime == null) {
			if (other.SPtime != null)
				return false;
		} else if (!SPtime.equals(other.SPtime))
			return false;
		if (STtime == null) {
			if (other.STtime != null)
				return false;
		} else if (!STtime.equals(other.STtime))
			return false;
		if (bkid == null) {
			if (other.bkid != null)
				return false;
		} else if (!bkid.equals(other.bkid))
			return false;
		if (bkname == null) {
			if (other.bkname != null)
				return false;
		} else if (!bkname.equals(other.bkname))
			return false;
		if (ppname == null) {
			if (other.ppname != null)
				return false;
		} else if (!ppname.equals(other.ppname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return bkid+","+bkname+","+ppname+","+STtime+","+SPtime;
	}
	
	
}
