package com.mec.UspPackage.sonview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mec.UspPackage.core.DataSource;
import com.mec.UspPackage.core.Query;
import com.mec.UspPackage.fatherview.IBKmanageView;
import com.mec.UspPackage.model.AddModel;

public class AddPackage implements IBKmanageView {
	private JFrame jFrame;
	private JPanel jPanel1,jPanel2,jPanel3;
	private Container container;
	private JLabel jLabel,jLabel1,jLabel2,jLabel3,jLabel4;
	private JTextField jTextField1,jTextField2,jTextField3,jTextField4;
	private JButton jButton1,jButton2;
	
	public AddPackage() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("包裹录入");
		jFrame.setSize(500,600);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jPanel1 = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("D:\\测试用图\\4.jpg");
                g.drawImage(icon.getImage(), 0, 0,500,80,jFrame);
            }
		};
		jPanel1.setBounds(0,0,500,80);
		jPanel1.setBackground(Color.BLUE);
		container.add(jPanel1);
		
		jLabel = new JLabel("包裹录入",JLabel.CENTER);
		jLabel.setFont(topicFont);
		jLabel.setBounds(0, 40, 500, 80);
		jPanel1.add(jLabel);
		
		jPanel2 = new JPanel() {
			public void paintComponent(Graphics g) {
            ImageIcon icon =new ImageIcon("D:\\测试用图\\6.png");
            g.drawImage(icon.getImage(), 0, 0,500,400,jFrame);
	    }};
		jPanel2.setBounds(0,80,500,400);
		jPanel2.setLayout(null);
		container.add(jPanel2);
	
		jLabel1 = new JLabel("包裹编号");
		jLabel1.setFont(topicFont1);
		jLabel1.setBounds(0,0,200,80);
		jLabel1.setForeground(Color.red);
		jPanel2.add(jLabel1);
		
		jLabel2 = new JLabel("首发站:");
		jLabel2.setFont(topicFont1);
		jLabel2.setBounds(0,80,200,80);
		jPanel2.add(jLabel2);
		
		jLabel3 = new JLabel("终点站:");
		jLabel3.setFont(topicFont1);
		jLabel3.setBounds(0,160,200,80);
		jPanel2.add(jLabel3);
		
		jLabel4 = new JLabel("当前站点");
		jLabel4.setFont(topicFont1);
		jLabel4.setBounds(0,240,200,80);
		jPanel2.add(jLabel4); 
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(200, 20, 280, 50);
		jTextField1.setFont(new Font("微软雅黑", Font.BOLD, 27));
		jPanel2.add(jTextField1);
		
		
		jTextField2 = new JTextField();
		jTextField2.setBounds(200, 100, 280, 50);
		jTextField2.setFont(new Font("微软雅黑", Font.BOLD, 27));
		jPanel2.add(jTextField2);
		
		jTextField3 = new JTextField();
		jTextField3.setBounds(200, 175, 280, 50);
		jTextField3.setFont(new Font("微软雅黑", Font.BOLD, 27));
		jPanel2.add(jTextField3);
		
		jTextField4 = new JTextField();
		jTextField4.setBounds(200, 250, 280, 50);
		jTextField4.setFont(new Font("微软雅黑", Font.BOLD, 27));
		jPanel2.add(jTextField4);
		
		
		
		jPanel3 = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("D:\\测试用图\\4.jpg");
                g.drawImage(icon.getImage(), 0, 0,500,100,jFrame);
            }
		};
		jPanel3.setBounds(0,480,500,100);
		jPanel3.setBackground(Color.green);
		jPanel3.setLayout(null);
		container.add(jPanel3);
		
		jButton1 = new JButton("确  定");
		jButton1.setBounds(125, 30, 100, 30);
		jButton1.setBackground(Color.red);
		jPanel3.add(jButton1);
		
		jButton2 = new JButton("清  空");
		jButton2.setBounds(250, 30, 100, 30);
		jButton2.setBackground(Color.blue);
		jPanel3.add(jButton2);
		
	}


	@Override
	public void dealAction() {
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = jTextField1.getText().toString();
				String start = jTextField2.getText().toString();
				String end = jTextField3.getText().toString();
				String now = jTextField4.getText().toString();
				
				
				DataSource.initDatabase("com.mec.UspPackage.model");			
				Query query = new Query();
				
				AddModel check = query.get(AddModel.class, id);
					if(check == null) {
						AddModel addinfo = new AddModel();
						addinfo.setId(id);
						addinfo.setStart(start);
						addinfo.setEnd(end);
						addinfo.setNow(now);
						addinfo.setTmp(start);
						query.save(addinfo);
						Success1 sc = new Success1();
						sc.showView();
					}
					else {
						if(!check.getStart().equals(start)||!check.getEnd().equals(end)) {
							Error2 er = new Error2();
							er.showView();
						}
						else {
							query.update(AddModel.class, now, id);
							query.updateid(AddModel.class, check.getTmp()+"->"+now, id);
							
							Success1 sc = new Success1();
							sc.showView();
						}
					}
			}
		});
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jTextField1.setText("");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
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
