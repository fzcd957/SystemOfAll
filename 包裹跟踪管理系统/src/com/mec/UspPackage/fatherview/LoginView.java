package com.mec.UspPackage.fatherview;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mec.UspPackage.core.DataSource;
import com.mec.UspPackage.core.Query;
import com.mec.UspPackage.model.LoginModel;
import com.mec.UspPackage.sonview.Error1;

public class LoginView implements IBKmanageView {
	private JFrame jFrame;
	private Container container;
	private JPanel jPanel1,jPanel2,jPanel3;
	private JLabel jLabel,jLabel1,jLabel2;
	private JTextField jTextField1;
	private JPasswordField jTextField2;
	private JButton jButton1,jButton2;
	
	public LoginView() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("登录");
		jFrame.setSize(800, 300);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jPanel1 = new JPanel();
		jPanel1.setBounds(0, 0, 800, 100);
		jPanel1.setLayout(null);
		container.add(jPanel1);
		
		jLabel = new JLabel("登   录",JLabel.CENTER);
		jLabel.setFont(topicFont);
		jLabel.setForeground(Color.red);
		jLabel.setBounds(0, 0, 800, 80);
		jPanel1.add(jLabel);
		
		
		
		jPanel2 = new JPanel();
		jPanel2.setBounds(0, 80, 800, 120);
		jPanel2.setLayout(null);
		container.add(jPanel2);
		
		jLabel1 = new JLabel("账  号:",JLabel.RIGHT);
		jLabel1.setBounds(0, 12, 250, 50);
		jLabel1.setFont(TextTopicfont);
		jPanel2.add(jLabel1);
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(300, 12, 300, 50);
		jTextField1.setFont(TextTopicfont);
		jPanel2.add(jTextField1);
		
		
		jLabel2 = new JLabel("密  码:",JLabel.RIGHT);
		jLabel2.setBounds(0, 70, 250, 50);
		jLabel2.setFont(TextTopicfont);
		jPanel2.add(jLabel2);
		
		jTextField2 = new JPasswordField();
		jTextField2.setEchoChar('*');
		jTextField2.setBounds(300, 70, 300, 50);
		jTextField2.setFont(TextTopicfont);
		jPanel2.add(jTextField2);
		
		jPanel3 = new JPanel();
		jPanel3.setBounds(0, 200, 800, 100);
		jPanel3.setLayout(null);
		container.add(jPanel3);
		
		jButton1 = new JButton("登  录");
		jButton1.setBounds(300, 10, 100, 30);
		jPanel3.add(jButton1);
		
		jButton2 = new JButton("清  空");
		jButton2.setBounds(500, 10, 100, 30);
		jPanel3.add(jButton2);
		
		
	}

	@Override
	public void dealAction() {
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = jTextField1.getText().toString();
				char[] a = jTextField2.getPassword();
				String password = String.valueOf(a);
				
				DataSource.initDatabase("com.mec.UspPackage.model");
				Query query = new Query();
				LoginModel lm = query.getbyiorp(LoginModel.class, name, password);
				if(lm != null) {
					USPmanageView bv = new USPmanageView();
					jFrame.setVisible(false);
					bv.showView();
				}
				else {
					Error1 er = new Error1();
					er.showView();
				}
			}
		});
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jTextField1.setText("");
				jTextField2.setText("");
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
