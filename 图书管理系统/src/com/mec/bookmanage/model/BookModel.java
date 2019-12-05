package com.mec.bookmanage.model;

import com.mec.bookmanage.annotation.Column;
import com.mec.bookmanage.annotation.ID;
import com.mec.bookmanage.annotation.Table;

@Table(value="book_info")
public class BookModel {
	@ID
	@Column(value = "BKid")
	String bookid;
	@Column(value = "BKname")
	String bookname;
	@Column(value = "BKlocation")
	String booklocation;
	@Column(value = "BKstatus")
	String bookstatus;
	@Column(value = "BKprice")
	String bookprice;
	
	public BookModel() {
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBooklocation() {
		return booklocation;
	}

	public void setBooklocation(String booklocation) {
		this.booklocation = booklocation;
	}

	public String getBookstatus() {
		return bookstatus;
	}

	public void setBookstatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}

	public String getBookprice() {
		return bookprice;
	}

	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
		result = prime * result + ((booklocation == null) ? 0 : booklocation.hashCode());
		result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
		result = prime * result + ((bookprice == null) ? 0 : bookprice.hashCode());
		result = prime * result + ((bookstatus == null) ? 0 : bookstatus.hashCode());
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
		BookModel other = (BookModel) obj;
		if (bookid == null) {
			if (other.bookid != null)
				return false;
		} else if (!bookid.equals(other.bookid))
			return false;
		if (booklocation == null) {
			if (other.booklocation != null)
				return false;
		} else if (!booklocation.equals(other.booklocation))
			return false;
		if (bookname == null) {
			if (other.bookname != null)
				return false;
		} else if (!bookname.equals(other.bookname))
			return false;
		if (bookprice == null) {
			if (other.bookprice != null)
				return false;
		} else if (!bookprice.equals(other.bookprice))
			return false;
		if (bookstatus == null) {
			if (other.bookstatus != null)
				return false;
		} else if (!bookstatus.equals(other.bookstatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return bookid+","+bookname+","+booklocation+","+bookstatus+","+bookprice;
	}
	
	
}
