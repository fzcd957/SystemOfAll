package com.mec.bookmanage.fatherview;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
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

import com.mec.bookmanage.core.Query;
import com.mec.bookmanage.model.PersonModel;
import com.mec.bookmanage.sonview.Allinfo;
import com.mec.bookmanage.sonview.Domoney;
import com.mec.bookmanage.sonview.Getinfo;
import com.mec.bookmanage.sonview.Getinfo2;
import com.mec.bookmanage.sonview.Interest;
import com.mec.bookmanage.sonview.NewOne;
import com.mec.bookmanage.sonview.Transfermoney;

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
		jFrame = new JFrame("超市管理系统");
		jFrame.setSize(800, 500);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jPanel1 = new JPanel() {
//			public void paintComponent(Graphics g) {
//                ImageIcon icon =new ImageIcon("D:\\测试用图\\6.png");
//                g.drawImage(icon.getImage(), 0, 0, 800,80,jFrame);
//            }
		};
		jPanel1.setBounds(0, 0, 800, 80);
//		jPanel1.setBackground(Color.red);
		jPanel1.setLayout(new BorderLayout());
		container.add(jPanel1);
		
		jLabel = new JLabel("超市管理系统",jLabel.CENTER);
		jLabel.setFont(topicFont);
		jLabel.setSize(800, 100);
		jPanel1.add(jLabel,BorderLayout.CENTER);
		
	//--------------------------------------------------------------------------	
		
		jPanel2  = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("D:\\测试用图\\8.png");
                g.drawImage(icon.getImage(), 0, 0, 800,300,jFrame);
            }
		};
		jPanel2.setBounds(0, 80, 800, 300);
		jPanel2.setLayout(new FlowLayout(1, 30, 30));
//		jPanel2.setBackground(Color.LIGHT_GRAY);
		container.add(jPanel2);
		
		
		jButton1 = new JButton("查询商品信息");
		jButton1.setFont(textfield1font);
		// 在流式布局下设置控件大小
		jButton1.setPreferredSize(new Dimension(180, 40));
//		jButton1.setBackground(Color.RED);
		jPanel2.add(jButton1);
		
		jButton2 = new JButton("商品替换");
		jButton2.setFont(textfield1font);
		jButton2.setPreferredSize(new Dimension(180, 40));
//		jButton2.setBackground(Color.RED);
		jPanel2.add(jButton2);

		jButton3 = new JButton("进货/出货");
		jButton3.setFont(textfield1font);
		jButton3.setPreferredSize(new Dimension(180, 40));
//		jButton3.setBackground(Color.RED);
		jPanel2.add(jButton3);
		
		jButton4 = new JButton("查看商品累计利润");
		jButton4.setFont(textfield1font);
		jButton4.setPreferredSize(new Dimension(180, 40));
//		jButton4.setBackground(Color.RED);
		jPanel2.add(jButton4);
		
		jButton5 = new JButton("新增商品");
		jButton5.setFont(textfield1font);
		jButton5.setPreferredSize(new Dimension(180, 40));
//		jButton5.setBackground(Color.RED);
		jPanel2.add(jButton5);
		
		jButton6 = new JButton("所有商品信息");
		jButton6.setFont(textfield1font);
		jButton6.setPreferredSize(new Dimension(180, 40));
//		jButton6.setBackground(Color.RED);
		jPanel2.add(jButton6);
		
		//--------------------------------------------------------------------------
		
		jPanel3 = new JPanel()
		{
//			public void paintComponent(Graphics g) {
//                ImageIcon icon =new ImageIcon("D:\\测试用图\\6.png");
//                g.drawImage(icon.getImage(), 0, 0, 800,100,jFrame);
//            }
		};
		jPanel3.setBounds(0, 380, 800, 100);
		jPanel3.setLayout(null);
		container.add(jPanel3);
		
		jLabel2 = new JLabel("51831122  邢松浩");
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
				Getinfo getview = new Getinfo();
				getview.showView();
			}
		});
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Transfermoney tm = new Transfermoney();
				tm.showView();
			}
		});
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Domoney d = new Domoney();
				d.showView();
			}
		});
		jButton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Getinfo2 gf = new Getinfo2();
				gf.showView();
			}
		});
		jButton5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NewOne no = new NewOne();
				no.showView();
			}
		});
		
		jButton6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Allinfo af = new Allinfo();
				af.showView();
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
