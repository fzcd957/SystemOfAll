package com.mec.bookmanage.sonview;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mec.bookmanage.fatherview.IBKmanageView;
import com.mec.bookmanage.model.CostModel;

public class Cost implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private CostModel model;
	private JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6;
	
	public Cost(CostModel pm) {
		this.model = pm;
		init();
		dealAction();
	}
	
	@Override
	public void init() {
		jFrame = new JFrame("划   价");
		jFrame.setSize(800, 500);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jLabel1 = new JLabel("划   价",JLabel.CENTER);
		jLabel1.setBounds(0, 0, 800, 70);
		jLabel1.setFont(new Font("楷体", Font.BOLD, 30));
		jLabel1.setText("病历号:   "+model.getId());
		container.add(jLabel1);
		
		jLabel2 = new JLabel("",JLabel.CENTER);
		jLabel2.setBounds(0, 80, 800, 70);
		jLabel2.setFont(new Font("楷体", Font.BOLD, 30));
		jLabel2.setText("划价价格:   "+model.getMoney());
		container.add(jLabel2);
		
		jLabel3 = new JLabel("",JLabel.CENTER);
		jLabel3.setBounds(0, 160, 800, 70);
		jLabel3.setFont(new Font("楷体", Font.BOLD, 30));
		jLabel3.setText("提示: 请前往缴费处缴费");
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
