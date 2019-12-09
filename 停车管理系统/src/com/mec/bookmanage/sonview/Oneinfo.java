package com.mec.bookmanage.sonview;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mec.bookmanage.fatherview.IBKmanageView;
import com.mec.bookmanage.model.PlaceModel;

public class Oneinfo implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private PlaceModel model;
	private JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6;
	
	public Oneinfo(PlaceModel pm) {
		this.model = pm;
		init();
		dealAction();
	}
	
	@Override
	public void init() {
		jFrame = new JFrame("z");
		jFrame.setSize(800, 500);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jLabel1 = new JLabel("",JLabel.CENTER);
		jLabel1.setBounds(0, 0, 800, 70);
		jLabel1.setFont(new Font("楷体", Font.BOLD, 30));
		jLabel1.setText("车位编号:   "+model.getNumber());
		container.add(jLabel1);
		
		jLabel2 = new JLabel("",JLabel.CENTER);
		jLabel2.setBounds(0, 80, 800, 70);
		jLabel2.setFont(new Font("楷体", Font.BOLD, 30));
		jLabel2.setText("是否空闲:   "+model.getStatus());
		container.add(jLabel2);
		
		jLabel3 = new JLabel("",JLabel.CENTER);
		jLabel3.setBounds(0, 160, 800, 70);
		jLabel3.setFont(new Font("楷体", Font.BOLD, 30));
		jLabel3.setText("收费/小时:   "+model.getMoney());
		container.add(jLabel3);
		
		jLabel4 = new JLabel("",JLabel.CENTER);
		jLabel4.setBounds(0, 240, 800, 70);
		jLabel4.setFont(new Font("楷体", Font.BOLD, 30));
		jLabel4.setText("车位位置:   "+model.getLocation());
		container.add(jLabel4);
		
		jLabel5 = new JLabel("",JLabel.CENTER);
		jLabel5.setBounds(0, 320, 800, 70);
		jLabel5.setFont(new Font("楷体", Font.BOLD, 30));
		jLabel5.setText("车位大小:   "+model.getSize());
		container.add(jLabel5);
		
		jLabel6 = new JLabel("",JLabel.CENTER);
		jLabel6.setBounds(0, 400, 800, 70);
		jLabel6.setFont(new Font("楷体", Font.BOLD, 30));
		jLabel6.setText("车位等级:   "+model.getKind());
		container.add(jLabel6);
		
	
		
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
