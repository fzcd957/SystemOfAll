package com.mec.bookmanage.sonview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mec.bookmanage.core.DataSource;
import com.mec.bookmanage.core.Query;
import com.mec.bookmanage.fatherview.IBKmanageView;
import com.mec.bookmanage.model.BookModel;
import com.mec.bookmanage.model.BorrowModel;

public class BorrowOrReturn implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private JPanel jPanel1,jPanel2,jPanel3;
	private JLabel jLabel,jLabel1,jLabel2;
	private JTextField jTextField1,jTextField2; 
	private JButton jButton1,jButton2;
	
	public BorrowOrReturn() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("借阅/归还");
		jFrame.setSize(800, 300);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jPanel1 = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("D:\\测试用图\\4.jpg");
                g.drawImage(icon.getImage(), 0, 0,800,100,jFrame);
            }
		};
		jPanel1.setBounds(0, 0, 800, 100);
		jPanel1.setLayout(null);
		container.add(jPanel1);
		
		jLabel = new JLabel("借阅/归还",JLabel.CENTER);
		jLabel.setFont(topicFont);
		jLabel.setForeground(Color.red);
		jLabel.setBounds(0, 0, 800, 80);
		jPanel1.add(jLabel);
		
		
		
		jPanel2 = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("D:\\测试用图\\4.jpg");
                g.drawImage(icon.getImage(), 0, 0,800,120,jFrame);
            }
		};
		jPanel2.setBounds(0, 80, 800, 120);
		jPanel2.setLayout(null);
		container.add(jPanel2);
		
		jLabel1 = new JLabel("书籍编号:",JLabel.RIGHT);
		jLabel1.setBounds(0, 12, 250, 50);
		jLabel1.setFont(TextTopicfont);
		jPanel2.add(jLabel1);
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(300, 12, 300, 50);
		jTextField1.setFont(TextTopicfont);
		jPanel2.add(jTextField1);
		
		
		jLabel2 = new JLabel("学生姓名:",JLabel.RIGHT);
		jLabel2.setBounds(0, 70, 250, 50);
		jLabel2.setFont(TextTopicfont);
		jPanel2.add(jLabel2);
		
		jTextField2 = new JTextField();
		jTextField2.setBounds(300, 70, 300, 50);
		jTextField2.setFont(TextTopicfont);
		jPanel2.add(jTextField2);
		
		jPanel3 = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("D:\\测试用图\\4.jpg");
                g.drawImage(icon.getImage(), 0, 0,800,100,jFrame);
            }
		};
		jPanel3.setBounds(0, 200, 800, 100);
		jPanel3.setLayout(null);
		container.add(jPanel3);
		
		jButton1 = new JButton("借 阅");
		jButton1.setBounds(300, 10, 100, 30);
		jPanel3.add(jButton1);
		
		jButton2 = new JButton("还 书");
		jButton2.setBounds(500, 10, 100, 30);
		jPanel3.add(jButton2);
		
		
	}

	@Override
	public void dealAction() {
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String bkid = jTextField1.getText().toString();
				String ppname  = jTextField2.getText().toString();
				Calendar cd =  Calendar.getInstance();
				Date data = cd.getTime();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String STtime = dateFormat.format(data);
				Timestamp T = Timestamp.valueOf(STtime);
				
				Query query = new Query();
				BorrowModel bw = new BorrowModel();
				
				DataSource.initDatabase("com.mec.bookmanage.model");
				BookModel borrow1 = query.get(BookModel.class, bkid);
				if(borrow1 != null) {
				String[] borrowinfoArray = borrow1.toString().split(",");
				
				String name = borrowinfoArray[1];
				System.out.println(name);
				
				bw.setBkid(bkid);
				bw.setPpname(ppname);
				bw.setBkname(name);
				bw.setSTtime(T);
				query.save(bw);		
				query.update(BookModel.class, "已被借阅", bkid);
				Success3 sc = new Success3();
				sc.showView();
				}
				else {
					Error2 er = new Error2();
					er.showView();
				}
			}
		});
		
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String bkid = jTextField1.getText().toString();
				String ppname  = jTextField2.getText().toString();
				Calendar cd =  Calendar.getInstance();
				Date data = cd.getTime();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String SPtime =dateFormat.format(data);
				
				DataSource.initDatabase("com.mec.bookmanage.model");
				Query query = new Query();

				if(query.getbyid(BorrowModel.class, bkid, ppname) != null) {
					query.update(BookModel.class, "未被借阅", bkid);
					query.updateid(BorrowModel.class,SPtime,bkid,ppname);
					Success4 sc = new Success4();
					sc.showView();
				}
				else {
					Error3 er = new Error3();
					er.showView();
				}
				
			}
			
		});
		
	}

	@Override
	public void showView() {
		jFrame.setVisible(true);
	}

	@Override
	public void exitView() {
		
	}
	
}
