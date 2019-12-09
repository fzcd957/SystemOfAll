package com.mec.bookmanage.sonview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.mec.bookmanage.core.DataSource;
import com.mec.bookmanage.core.Query;
import com.mec.bookmanage.fatherview.IBKmanageView;
import com.mec.bookmanage.model.CarModel;

public class Allinfo implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private JLabel jLabel;
	private JPanel jPanel;
	private JTable jTable;
	private String cnum,pnum,sttime,sptime,money;
	
	public Allinfo() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("个人信息");
		jFrame.setSize(800, 600);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);		
		
		
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"班级编号","学生编号","入学时间","退学时间","总学费"});
		
		List<CarModel> CarModellList = showMessage();
		for (CarModel carinfo : CarModellList) {
			String carAllInfo = carinfo.toString();	
			String[] carAllInfoArray = carAllInfo.split(",");
			for(int i = 0; i < carAllInfoArray.length;i++) {
				 cnum = carAllInfoArray[0];
				 pnum = carAllInfoArray[1];
				 sttime = carAllInfoArray[2];	
				 sptime = carAllInfoArray[3];
				 money = carAllInfoArray[4];
				 
			}
			model.addRow(new Object[]{cnum,pnum,sttime,sptime,money});
		}
		
		jTable=new JTable(model);
		jTable.setEnabled(false);
		jTable.setRowHeight(50);
		jTable.setFont(new Font("楷体", Font.BOLD, 17));
		jTable.setSelectionForeground(Color.red);
		
		TableColumnModel tc = jTable.getColumnModel();
		TableColumn tm0 = tc.getColumn(0);
		TableColumn tm1 = tc.getColumn(1);
		TableColumn tm2 = tc.getColumn(2);
		TableColumn tm3 = tc.getColumn(3);
		TableColumn tm4 = tc.getColumn(4);
		tm0.setPreferredWidth(50);
		tm1.setPreferredWidth(30);
		tm2.setPreferredWidth(180);
		tm3.setPreferredWidth(180);
		
		
		
		
		JScrollPane jScrollPane = new JScrollPane(jTable);
		jScrollPane.setBounds(0, 80, 790, 520);
		jScrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		container.add(jScrollPane);
		
		jPanel = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("D:\\测试用图\\4.jpg");
                g.drawImage(icon.getImage(), 0, 0, 800,80,jFrame);
            }
		};
		jPanel.setBounds(0,0,800,80);
		container.add(jPanel);
		
		jLabel = new JLabel("所有学生信息",JLabel.CENTER);
		jLabel.setFont(topicFont);
		jLabel.setBounds(0,0,800,80);
		jPanel.add(jLabel);
		
		
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
	
	public List<CarModel> showMessage() {
		DataSource.initDatabase("com.mec.bookmanage.model");
		Query query = new Query();		
		List<CarModel> PersonModelList = query.get(CarModel.class);
		return PersonModelList;
	}
}
