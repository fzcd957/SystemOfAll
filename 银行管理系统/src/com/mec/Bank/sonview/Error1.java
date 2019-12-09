package com.mec.Bank.sonview;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mec.Bank.fatherview.IBKmanageView;

public class Error1 implements IBKmanageView {
	private JFrame jFrame;
	private JLabel jLabel;
	
	public Error1() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("错误界面");
		jFrame.setSize(500,300);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		jLabel = new JLabel("账号或密码错误",JLabel.CENTER);
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
