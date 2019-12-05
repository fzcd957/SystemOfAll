package com.mec.bookmanage.sonview;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mec.bookmanage.fatherview.IBKmanageView;

public class Help implements IBKmanageView{
	private JFrame jFrame;
	private JLabel jLabel;
	
	public Help() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("帮助");
		jFrame.setSize(500,300);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		jLabel = new JLabel("请咨询Q:54188",JLabel.CENTER);
		jLabel.setLocation(200, 80);
		jLabel.setFont(warningTopicfont);
		jLabel.setForeground(Color.RED);
		jFrame.add(jLabel);
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
