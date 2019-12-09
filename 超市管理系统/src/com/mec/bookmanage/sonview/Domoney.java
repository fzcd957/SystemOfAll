package com.mec.bookmanage.sonview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mec.bookmanage.core.DataSource;
import com.mec.bookmanage.core.Query;
import com.mec.bookmanage.fatherview.IBKmanageView;
import com.mec.bookmanage.model.PersonModel;
import com.mec.bookmanage.model.TransModel;

public class Domoney implements IBKmanageView {
	private JFrame jFrame;
	private JPanel jPanel1,jPanel2,jPanel3;
	private Container container;
	private JLabel jLabel,jLabel1,jLabel2,jLabel3;
	private JTextField jTextField1,jTextField2,jTextField3;
	private JPasswordField jTextField4;
	private JButton jButton1,jButton2;
	
	public Domoney() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("进货/出货");
		jFrame.setSize(500,600);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jPanel1 = new JPanel() {
//			public void paintComponent(Graphics g) {
//                ImageIcon icon =new ImageIcon("D:\\测试用图\\6.png");
//                g.drawImage(icon.getImage(), 0, 0,500,80,jFrame);
//            }
		};
		jPanel1.setBounds(0,0,500,50);
		jPanel1.setBackground(Color.BLUE);
		container.add(jPanel1);
		
		jLabel = new JLabel("进货/出货",JLabel.CENTER);
		jLabel.setFont(topicFont);
		jLabel.setBounds(0, 40, 500, 80);
		jPanel1.add(jLabel);
		
		jPanel2 = new JPanel();
		jPanel2.setBounds(0,80,500,400);
		jPanel2.setLayout(null);
		container.add(jPanel2);
	
		jLabel1 = new JLabel("商品编号:");
		jLabel1.setFont(topicFont1);
		jLabel1.setBounds(0,0,200,80);
		jLabel1.setForeground(Color.red);
		jPanel2.add(jLabel1);
		
		jLabel2 = new JLabel("进货/出货数量:");
		jLabel2.setFont(topicFont1);
		jLabel2.setBounds(0,80,200,80);
		jPanel2.add(jLabel2);
				
			
		jTextField1 = new JTextField();
		jTextField1.setBounds(200, 20, 280, 50);
		jTextField1.setFont(new Font("微软雅黑", Font.BOLD, 27));
		jPanel2.add(jTextField1);
		
		
		jTextField2 = new JTextField();
		jTextField2.setBounds(200, 100, 280, 50);
		jTextField2.setFont(new Font("微软雅黑", Font.BOLD, 27));
		jPanel2.add(jTextField2);
		

		
		jPanel3 = new JPanel() {
//			public void paintComponent(Graphics g) {
//                ImageIcon icon =new ImageIcon("D:\\测试用图\\6.png");
//                g.drawImage(icon.getImage(), 0, 0,500,100,jFrame);
//            }
		};
		jPanel3.setBounds(0,480,500,100);
		jPanel3.setBackground(Color.green);
		jPanel3.setLayout(null);
		container.add(jPanel3);
		
		jButton1 = new JButton("进   货");
		jButton1.setBounds(125, 30, 100, 30);
		jButton1.setBackground(Color.red);
		jPanel3.add(jButton1);
		
		jButton2 = new JButton("出   货");
		jButton2.setBounds(250, 30, 100, 30);
		jButton2.setBackground(Color.blue);
		jPanel3.add(jButton2);
		
	}


	@Override
	public void dealAction() {
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String number = jTextField1.getText().toString();
				String money = jTextField2.getText().toString();
				
				
				DataSource.initDatabase("com.mec.bookmanage.model");			
				Query query = new Query();
				
				PersonModel person = query.get(PersonModel.class, number);
					if(person == null) {
						Error3 e3 = new Error3();
						e3.showView();
					}
					else {
						int pmoney = Integer.valueOf(person.getMoney());
						int tmoney = Integer.valueOf(money);
						int b = pmoney+tmoney;						
						
						query.updateById(PersonModel.class,String.valueOf(b),number);		
						
						Success1 s1 = new Success1();
						s1.showView();
						
					}
			}
		});
		
		jButton2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String number = jTextField1.getText().toString();
				String money = jTextField2.getText().toString();
				
				
				DataSource.initDatabase("com.mec.bookmanage.model");			
				Query query = new Query();
				
				PersonModel person = query.get(PersonModel.class, number);
					if(person == null) {
						Error3 e3 = new Error3();
						e3.showView();
					}
					else {
						int pmoney = Integer.valueOf(person.getMoney());
						int tmoney = Integer.valueOf(money);
						int a = pmoney-tmoney;						
						query.updateById(PersonModel.class,String.valueOf(a),number);			
						Success1 s1 = new Success1();
						s1.showView();
						
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
