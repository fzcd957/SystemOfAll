package com.mec.bookmanage.fatherview;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mec.bookmanage.sonview.Allinfo;
import com.mec.bookmanage.sonview.GetOneinfo;
import com.mec.bookmanage.sonview.InorOut;

public class BKmanageView extends Thread implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private JPanel jPanel1,jPanel2,jPanel3;
	private JLabel jLabel,jLabel2,jLabel3;
	private JButton jButton1,jButton2,jButton3,jButton4,jButton5,jButton6;
	public volatile boolean goon;
	
	
	public BKmanageView() {
		init();		
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("学生管理系统");
		jFrame.setSize(800, 400);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jPanel1 = new JPanel() {
		};
		jPanel1.setBounds(0, 0, 800, 80);
//		jPanel1.setBackground(Color.red);
		jPanel1.setLayout(new BorderLayout());
		container.add(jPanel1);
		
		jLabel = new JLabel("学生管理系统",jLabel.CENTER);
		jLabel.setFont(topicFont);
		jLabel.setSize(800, 100);
		jPanel1.add(jLabel,BorderLayout.CENTER);
		
	//--------------------------------------------------------------------------	
		
		jPanel2  = new JPanel() {

		};
		jPanel2.setBounds(0, 80, 800, 200);
		jPanel2.setLayout(new GridLayout(3, 3));
//		jPanel2.setBackground(Color.LIGHT_GRAY);
		container.add(jPanel2);
		
		
		jButton1 = new JButton("查询学生信息");
		jButton1.setFont(textfield1font);
		// 在流式布局下设置控件大小
		jButton1.setPreferredSize(new Dimension(180, 40));
//		jButton1.setBackground(Color.RED);
		jPanel2.add(jButton1);
		
		jButton2 = new JButton("增加/删除");
		jButton2.setFont(textfield1font);
		jButton2.setPreferredSize(new Dimension(180, 40));
//		jButton2.setBackground(Color.RED);
		jPanel2.add(jButton2);

		jButton3 = new JButton("查看所有学生信息");
		jButton3.setFont(textfield1font);
		jButton3.setPreferredSize(new Dimension(250, 40));
//		jButton3.setBackground(Color.RED);
		jPanel2.add(jButton3);
		
		
		//--------------------------------------------------------------------------
		
		jPanel3 = new JPanel()
		{
	
		};
		jPanel3.setBounds(0, 280, 800, 100);
		jPanel3.setLayout(null);
		container.add(jPanel3);
		
		jLabel2 = new JLabel("51831124  张家华");
		jLabel2.setBounds(400,0,400,100);
		jLabel2.setFont(topicFont1);
//		jLabel2.setBackground(Color.RED);
		jPanel3.add(jLabel2);
		
		jLabel3 = new JLabel();
		jLabel3.setBounds(0,0,400,100);
		jLabel3.setFont(topicFont1);
		jPanel3.add(jLabel3);
		
		
		
	}

	@Override
	public void dealAction() {
		jFrame.addWindowListener(new Windowsadapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				stopRun();
			}
		});
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GetOneinfo().showView();
			}
		});
		
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new InorOut().showView();
			}
		});
		
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Allinfo().showView();
			}
		});
	}
	
	@Override
	public void exitView() {
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void showView() {	
		jFrame.setVisible(true);
		startRun();
	}

	public void startRun() {
		goon = true;
		new Thread(this).start();
	}
	
	public void stopRun() {
		goon = false;
	}
	
	@Override
 public void run() {
	
		
	}



}
