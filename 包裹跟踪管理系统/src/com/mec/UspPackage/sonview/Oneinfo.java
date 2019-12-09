package com.mec.UspPackage.sonview;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mec.UspPackage.fatherview.IBKmanageView;
import com.mec.UspPackage.model.AddModel;

public class Oneinfo implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private AddModel model;
	private JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5;
	
	public Oneinfo(AddModel pm) {
		this.model = pm;
		init();
		dealAction();
	}
	
	@Override
	public void init() {
		jFrame = new JFrame("查询包裹信息");
		jFrame.setSize(800, 500);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jLabel1 = new JLabel("",JLabel.CENTER);
		jLabel1.setBounds(0, 0, 800, 80);
		jLabel1.setFont(warningTopicfont);
		jLabel1.setText("包裹编号:   "+model.getId());
		container.add(jLabel1);
		
		jLabel2 = new JLabel("",JLabel.CENTER);
		jLabel2.setBounds(0, 100, 800, 80);
		jLabel2.setFont(warningTopicfont);
		jLabel2.setText("包裹首发站:   "+model.getStart());
		container.add(jLabel2);
		
		jLabel3 = new JLabel("",JLabel.CENTER);
		jLabel3.setBounds(0, 200, 800, 80);
		jLabel3.setFont(warningTopicfont);
		jLabel3.setText("包裹终止站:   "+model.getEnd());
		container.add(jLabel3);
		
		jLabel4 = new JLabel("",JLabel.CENTER);
		jLabel4.setBounds(0, 300, 800, 80);
		jLabel4.setFont(warningTopicfont);
		jLabel4.setText("包裹当前站:   "+model.getNow());
		container.add(jLabel4);
		
		jLabel5 = new JLabel("",JLabel.CENTER);
		jLabel5.setBounds(0, 400, 800, 80);
		jLabel5.setFont(textfield1font);
		jLabel5.setText("包裹途径站:   "+model.getTmp());
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
