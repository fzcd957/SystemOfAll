package com.mec.Bank.sonview;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mec.Bank.fatherview.IBKmanageView;
import com.mec.Bank.model.PersonModel;

public class Interest implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private PersonModel model;
	private JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5;
	
	public Interest(PersonModel pm) {
		this.model = pm;
		init();
		dealAction();
	}
	
	@Override
	public void init() {
		jFrame = new JFrame("利息详情");
		jFrame.setSize(800, 500);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jLabel1 = new JLabel("",JLabel.CENTER);
		jLabel1.setBounds(0, 0, 800, 70);
		jLabel1.setFont(topicFont);
		jLabel1.setText("客户名称:   "+model.getName());
		container.add(jLabel1);
		
		jLabel2 = new JLabel("",JLabel.CENTER);
		jLabel2.setBounds(0, 80, 800, 70);
		jLabel2.setFont(topicFont);
		jLabel2.setText("银行卡号:   "+model.getNumber());
		container.add(jLabel2);
		
		jLabel3 = new JLabel("",JLabel.CENTER);
		jLabel3.setBounds(0, 160, 800, 70);
		jLabel3.setFont(topicFont);
		jLabel3.setText("账户余额:   "+model.getMoney());
		container.add(jLabel3);
		
		jLabel4 = new JLabel("",JLabel.CENTER);
		jLabel4.setBounds(0, 240, 800, 70);
		jLabel4.setFont(topicFont);
		jLabel4.setText("预计一年利息:   "+ Integer.valueOf(model.getMoney())*0.035);
		container.add(jLabel4);
		
		jLabel5 = new JLabel("",JLabel.CENTER);
		jLabel5.setBounds(0, 320, 800, 70);
		jLabel5.setFont(topicFont);
		jLabel5.setText("预计三年利息:   "+Integer.valueOf(model.getMoney())*0.046*3);
		container.add(jLabel5);
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
