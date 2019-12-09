package com.mec.bookmanage.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mec.bookmanage.core.DataSource;
import com.mec.bookmanage.core.Query;
import com.mec.bookmanage.model.LoginModel;
import com.mec.bookmanage.model.PersonModel;
import com.mec.bookmanage.model.TransModel;

public class Test {

	public static void main(String[] args) {
		DataSource.initDatabase("com.mec.bookmanage.model");
		Query query = new Query();
		query.getbyiorp(new LoginModel().getClass(), "001", "123456");
		
		
		
//
//		Calendar cd =  Calendar.getInstance();
//		Date data = cd.getTime();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String STtime = dateFormat.format(data);
//		Timestamp T = Timestamp.valueOf(STtime);
//		
//		TransModel tm = new TransModel();
//		tm.setName1("123456");
//		tm.setName2("1234562");
//		tm.setNumber1("15151");
//		tm.setNumber2("1231321");
//		tm.setMoney("1000");
//		tm.setTime(T);
//		query.save(tm);

		
//		BorrowModel bm = query.getbyid(BorrowModel.class,"AA001","li");
//		System.out.println(bm);
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

