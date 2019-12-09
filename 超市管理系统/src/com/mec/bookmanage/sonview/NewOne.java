package com.mec.bookmanage.sonview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mec.bookmanage.core.DataSource;
import com.mec.bookmanage.core.Query;
import com.mec.bookmanage.fatherview.IBKmanageView;
import com.mec.bookmanage.model.PersonModel;

public class NewOne implements IBKmanageView {
	private JFrame jFrame;
	private JPanel jPanel1,jPanel2,jPanel3;
	private Container container;
	private JLabel jLabel,jLabel1,jLabel2,jLabel3,jLabel4,jLabel5;
	private JTextField jTextField1,jTextField2,jTextField3,jTextField4,jTextField5;
	private JButton jButton1,jButton2;
	
	public NewOne() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("新 增 商 品");
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
		
		jLabel = new JLabel("新 增 商 品",JLabel.CENTER);
		jLabel.setFont(topicFont);
		jLabel.setBounds(0, 40, 500, 80);
		jPanel1.add(jLabel);
		
		jPanel2 = new JPanel();
		jPanel2.setBounds(0,80,500,400);
		jPanel2.setLayout(null);
		container.add(jPanel2);
	
		jLabel1 = new JLabel("商品名称:");
		jLabel1.setFont(topicFont1);
		jLabel1.setBounds(0,0,200,80);
		jLabel1.setForeground(Color.red);
		jPanel2.add(jLabel1);
		
		jLabel2 = new JLabel("商品编号:");
		jLabel2.setFont(topicFont1);
		jLabel2.setBounds(0,80,200,80);
		jPanel2.add(jLabel2);
		
		jLabel3 = new JLabel("操作密码:");
		jLabel3.setFont(topicFont1);
		jLabel3.setBounds(0,160,200,80);
		jPanel2.add(jLabel3);
		
		jLabel4 = new JLabel("商品分类号:");
		jLabel4.setFont(topicFont1);
		jLabel4.setBounds(0,240,200,80);
		jPanel2.add(jLabel4);
		
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
		
		jTextField4 = new JTextField();
		jTextField4.setBounds(200, 250, 280, 50);
		jTextField4.setFont(new Font("微软雅黑", Font.BOLD, 27));
		jPanel2.add(jTextField4);
		
		
		
		
		jPanel3 = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("D:\\测试用图\\6.png");
                g.drawImage(icon.getImage(), 0, 0,500,100,jFrame);
            }
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
				String name = jTextField1.getText().toString();
				String number = jTextField2.getText().toString();
				String password = jTextField3.getText().toString();
				String id = jTextField4.getText().toString();
				
				
				DataSource.initDatabase("com.mec.bookmanage.model");			
				Query query = new Query();
				
				PersonModel check = query.get(PersonModel.class, number);
					if(check == null) {
						PersonModel Personinfo = new PersonModel();
						Personinfo.setId(id);
						Personinfo.setMoney("0");
						Personinfo.setName(name);
						Personinfo.setNumber(number);
						Personinfo.setPassword(password);					
						query.save(Personinfo);
						Success2 sc = new Success2();
						sc.showView();
					}
					else {
						Error5 er = new Error5();
						er.showView();
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
