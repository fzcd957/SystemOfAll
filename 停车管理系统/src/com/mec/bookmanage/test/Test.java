package com.mec.bookmanage.test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mec.bookmanage.core.DataSource;
import com.mec.bookmanage.core.Query;
import com.mec.bookmanage.model.CarModel;
import com.mec.bookmanage.model.PlaceModel;

public class Test {

	public static void main(String[] args) {
		DataSource.initDatabase("com.mec.bookmanage.model");
		Query query = new Query();
		
		Calendar cd =  Calendar.getInstance();
		Date data = cd.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String STtime = dateFormat.format(data);
		Timestamp T = Timestamp.valueOf(STtime);
		
		
		CarModel cm = query.getsomething(new CarModel().getClass(), "陕C14789", "004");
		double result = (T.getTime()-cm.getSTtime().getTime())/(1000 * 60.0 * 60);
		double c = result*3;
		BigDecimal b = new BigDecimal(c);
		double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(f1);
		
		
//		System.out.println(T.getTime());

//		query.updateBysome(new CarModel().getClass(), T, 100.00, "陕A88888","001");
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

