package com.mec.Bank.sonview;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mec.Bank.fatherview.IBKmanageView;
import com.mec.Bank.model.PersonModel;

public class Oneinfo implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private PersonModel model;
	private JLabel jLabel1,jLabel2,jLabel3;
	
	public Oneinfo(PersonModel pm) {
		this.model = pm;
		init();
		dealAction();
	}
	
	@Override
	public void init() {
		jFrame = new JFrame("查询个人信息");
		jFrame.setSize(800, 500);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jLabel1 = new JLabel("",JLabel.CENTER);
		jLabel1.setBounds(0, 0, 800, 160);
		jLabel1.setFont(topicFont);
		jLabel1.setText("客户名称:   "+model.getName());
		container.add(jLabel1);
		
		jLabel2 = new JLabel("",JLabel.CENTER);
		jLabel2.setBounds(0, 170, 800, 160);
		jLabel2.setFont(topicFont);
		jLabel2.setText("银行卡号:   "+model.getNumber());
		container.add(jLabel2);
		
		jLabel3 = new JLabel("",JLabel.CENTER);
		jLabel3.setBounds(0, 340, 800, 160);
		jLabel3.setFont(topicFont);
		jLabel3.setText("账户余额:   "+model.getMoney());
		container.add(jLabel3);
		
	}

	@Override
	public void dealAction() {	
	}

	@Override
	public void showView() {
		jFrame.setVisible(true);
	}

	@Override
	public void exitView() {
		
	}

}
