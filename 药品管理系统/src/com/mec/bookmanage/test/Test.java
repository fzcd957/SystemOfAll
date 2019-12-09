package com.mec.bookmanage.test;

import com.mec.bookmanage.core.DataSource;
import com.mec.bookmanage.core.Query;
import com.mec.bookmanage.model.BookModel;
import com.mec.bookmanage.model.BorrowModel;

public class Test {

	public static void main(String[] args) {
		DataSource.initDatabase("com.mec.bookmanage.model");
		Query query = new Query();
		
		
//		query.updateid(BorrowModel.class, "2019-05-18 06:27:46", "AA001", "kai");
		
		
		BorrowModel bm = query.getbyid(BorrowModel.class,"AA001","li");
		System.out.println(bm);
//		System.out.println("------------------------------------------");
//		BookModel Book = query.get(BookModel.class, "3");
//		System.out.println(Book);
		
		
//		query.update(BookModel.class, "被借阅", "4");
				
//		BookModel book = new BookModel();			
//		book.setBookid("1");
//		book.setBookname("1");
//		book.setBookprice("1");
//		book.setBooklocation("1");
//		book.setBookstatus("1");
//		query.save(book);
		
//		query.delete(StudentinfoModel.class,"06173015");
//
//		
//		List<BookModel> BookModellist = query.get(BookModel.class);
//		for (BookModel Book : BookModellist) {
//			System.out.println(Book);
//		}
		
		
//		/*
//		 * 注入攻击：
//		 * SELECT * FROM xxx WHERE condition
//		 * SQLString = "SELECT * FROM xxx WHERE id = '" + id + "'"
//		 * 如果id的值是这样的：
//		 * *'; DROP ALL;  
//		 * */
//		System.out.println("----------------------------------------");
//		StudentinfoModel student = new StudentinfoModel();
//		student.setId("610322199807051542");
//		student.setName("张jiu");
//		student.setStudentId("06173015");
//		student.setSex("女");
//		student.setStatus("1");
//		student.setBrithday("1998/11/05");
//		query.save(student);
	}

}

