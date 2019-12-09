package com.mec.bookmanage.sonview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mec.bookmanage.core.DataSource;
import com.mec.bookmanage.core.Query;
import com.mec.bookmanage.fatherview.IBKmanageView;
import com.mec.bookmanage.model.CarModel;
import com.mec.bookmanage.model.PlaceModel;

public class InorOut implements IBKmanageView {
	private JFrame jFrame;
	private Container container;
	private JPanel jPanel;
	private JLabel jLabel,jLabel1,jLabel2;
	private JTextField jTextField,jTextField1;
	private JButton jButton1,jButton2;
	
	public InorOut() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("入库/出库");
		jFrame.setSize(800, 300);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jPanel = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("D:\\测试用图\\6.png");
                g.drawImage(icon.getImage(), 0, 0, 800,300,jFrame);
            }
		};
		jPanel.setBounds(0, 0, 800, 300);
		jPanel.setBackground(Color.red);
		jPanel.setLayout(null);
		container.add(jPanel);
		
		jLabel = new JLabel("车辆入库/车辆出库",JLabel.CENTER);
		jLabel.setBounds(0,0,800,80);
		jLabel.setFont(topicFont);
		jPanel.add(jLabel);
		
		jLabel1 = new JLabel("   车辆编号:  ");
		jLabel1.setBounds(50,75,400,80);
		jLabel1.setFont(topicFont1);
		jPanel.add(jLabel1);
		
		jTextField = new JTextField();
		jTextField.setBounds(240, 100, 300, 40);
		jTextField.setFont(new Font("楷体", Font.BOLD, 26));
		jPanel.add(jTextField);
		
		jLabel2 = new JLabel("   车位编号:  ");
		jLabel2.setBounds(50,125,400,80);
		jLabel2.setFont(topicFont1);
		jPanel.add(jLabel2);
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(240, 150, 300, 40);
		jTextField1.setFont(new Font("楷体", Font.BOLD, 26));
		jPanel.add(jTextField1);
		
		jButton1 = new JButton("入  库");
		jButton1.setBounds(230, 220, 100, 30);
		jButton1.setBackground(Color.PINK);
		jPanel.add(jButton1);
		
		jButton2 = new JButton("出  库");
		jButton2.setBounds(430, 220, 100, 30);
		jButton2.setBackground(Color.PINK);
		jPanel.add(jButton2);
		
	}

	@Override
	public void dealAction() {
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String carnumber = jTextField.getText().toString();
				String plnumber = jTextField1.getText().toString();
				Calendar cd =  Calendar.getInstance();
				Date data = cd.getTime();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String STtime = dateFormat.format(data);
				Timestamp T = Timestamp.valueOf(STtime);		
				
				DataSource.initDatabase("com.mec.bookmanage.model");			
				Query query = new Query();
				
				PlaceModel pm = query.get(PlaceModel.class,plnumber);
				
				if(pm.getStatus().equals("空闲")) {					
					CarModel cm = new CarModel();
					cm.setCnumber(carnumber);
					cm.setPnumber(plnumber);
					cm.setSTtime(T);
					query.save(cm);
					
					query.updateBynumber(pm.getClass(), "占用", plnumber);
					
					Success1 sc = new Success1();
					sc.showView();
				}
				else {
					Error2 e2 = new Error2();
					e2.showView();
				}
				
			}
		});
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String carnumber = jTextField.getText().toString();
				String plnumber = jTextField1.getText().toString();
				Calendar cd =  Calendar.getInstance();
				Date data = cd.getTime();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String STtime = dateFormat.format(data);
				Timestamp T = Timestamp.valueOf(STtime);
				
				DataSource.initDatabase("com.mec.bookmanage.model");			
				Query query = new Query();
				
				//计算停车费
				CarModel cm = query.getsomething(new CarModel().getClass(), carnumber, plnumber);
				double result = (T.getTime()-cm.getSTtime().getTime())/(1000 * 60.0 * 60);
				PlaceModel pm = query.get(PlaceModel.class,plnumber);
				double f = result*pm.getMoney();
				BigDecimal b = new BigDecimal(f);
				double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				
				query.updateBysome(new CarModel().getClass(), T, f1, carnumber,plnumber);
				query.updateBynumber(new PlaceModel().getClass(), "空闲", plnumber);
				
				Success2 sc = new Success2();
				sc.showView();
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
