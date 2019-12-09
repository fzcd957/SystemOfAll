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

public class Transfermoney implements IBKmanageView {
	private JFrame jFrame;
	private JPanel jPanel1,jPanel2,jPanel3;
	private Container container;
	private JLabel jLabel,jLabel1,jLabel2,jLabel3,jLabel4,jLabel5;
	private JTextField jTextField1,jTextField2,jTextField3,jTextField5;
	private JPasswordField jTextField4;
	private JButton jButton1,jButton2;
	
	public Transfermoney() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("替   换");
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
		jPanel1.setBounds(0,0,500,80);
		jPanel1.setBackground(Color.BLUE);
		container.add(jPanel1);
		
		jLabel = new JLabel("替 换 界 面",JLabel.CENTER);
		jLabel.setFont(topicFont);
		jLabel.setBounds(0, 40, 500, 80);
		jPanel1.add(jLabel);
		
		jPanel2 = new JPanel();
		jPanel2.setBounds(0,80,500,400);
		jPanel2.setLayout(null);
		container.add(jPanel2);
	
		jLabel1 = new JLabel("原商品编号:");
		jLabel1.setFont(topicFont1);
		jLabel1.setBounds(0,0,200,80);
		jLabel1.setForeground(Color.red);
		jPanel2.add(jLabel1);
		
		jLabel2 = new JLabel("现商品编号:");
		jLabel2.setFont(topicFont1);
		jLabel2.setBounds(0,80,200,80);
		jPanel2.add(jLabel2);
		
		jLabel3 = new JLabel("替换个数:");
		jLabel3.setFont(topicFont1);
		jLabel3.setBounds(0,160,200,80);
		jPanel2.add(jLabel3);
		
			
		jTextField1 = new JTextField();
		jTextField1.setBounds(200, 20, 280, 50);
		jTextField1.setFont(new Font("微软雅黑", Font.BOLD, 27));
		jPanel2.add(jTextField1);
		
		
		jTextField2 = new JTextField();
		jTextField2.setBounds(200, 100, 280, 50);
		jTextField2.setFont(new Font("微软雅黑", Font.BOLD, 27));
		jPanel2.add(jTextField2);
		
		jTextField3 = new JTextField();
		jTextField3.setBounds(200, 175, 280, 50);
		jTextField3.setFont(new Font("微软雅黑", Font.BOLD, 27));
		jPanel2.add(jTextField3);
		

		
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
		
		jButton1 = new JButton("确  定");
		jButton1.setBounds(125, 30, 100, 30);
		jButton1.setBackground(Color.red);
		jPanel3.add(jButton1);
		
		jButton2 = new JButton("清  空");
		jButton2.setBounds(250, 30, 100, 30);
		jButton2.setBackground(Color.blue);
		jPanel3.add(jButton2);
		
	}


	@Override
	public void dealAction() {
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String number1 = jTextField1.getText().toString();
				String number2 = jTextField2.getText().toString();
				String money = jTextField3.getText().toString();
				
				
				DataSource.initDatabase("com.mec.bookmanage.model");			
				Query query = new Query();
				
				PersonModel person1 = query.get(PersonModel.class, number1);
				PersonModel person2 = query.get(PersonModel.class, number2);
					if(person1 == null||person2 == null) {
						Error3 e3 = new Error3();
						e3.showView();
					}

					else {
						int p1money = Integer.valueOf(person1.getMoney());
						int p2money = Integer.valueOf(person2.getMoney());
						int tmoney = Integer.valueOf(money);
						int a = p1money-tmoney;
						int b = p2money+tmoney;
						
						query.updateById(PersonModel.class,String.valueOf(a),number1);
						query.updateById(PersonModel.class,String.valueOf(b),number2);
						
						Calendar cd =  Calendar.getInstance();
						Date data = cd.getTime();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String STtime = dateFormat.format(data);
						Timestamp T = Timestamp.valueOf(STtime);
						
						TransModel tm = new TransModel();
						tm.setName1(person1.getName());
						tm.setName2(person2.getName());
						tm.setNumber1(number1);
						tm.setNumber2(number2);
						tm.setMoney(money);
						tm.setTime(T);
						query.save(tm);
						
						Success1 s1 = new Success1();
						s1.showView();
						
					}
			}
		});
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jTextField1.setText("");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
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
