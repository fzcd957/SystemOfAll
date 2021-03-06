package com.mec.Bank.sonview;

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

import com.mec.Bank.core.DataSource;
import com.mec.Bank.core.Query;
import com.mec.Bank.fatherview.IBKmanageView;
import com.mec.Bank.model.PersonModel;

public class Allinfo implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private JLabel jLabel;
	private JPanel jPanel;
	private JTable jTable;
	private String pid,pname,pmoney,ppid,password;
	
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
		model.setColumnIdentifiers(new Object[]{"客户姓名","客户卡号","卡内余额","身份证","账户密码"});
		
		List<PersonModel> PersonModelList = showMessage();
		for (PersonModel Person : PersonModelList) {
			String Personinfo = Person.toString();	
			String[] PersoninfoArray = Personinfo.split(",");
			for(int i = 0; i < PersoninfoArray.length;i++) {
				 pid = PersoninfoArray[0];
				 pname = PersoninfoArray[1];
				 pmoney = PersoninfoArray[2];	
				 ppid = PersoninfoArray[3];
				 password = PersoninfoArray[4];
				 
			}
			model.addRow(new Object[]{pid,pname,pmoney,ppid,password});
		}
		
		jTable=new JTable(model);
		jTable.setEnabled(false);
		jTable.setRowHeight(50);
		jTable.setFont(new Font("楷体", Font.BOLD, 17));
		jTable.setSelectionForeground(Color.red);
		
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
		
		jLabel = new JLabel("所有账户信息",JLabel.CENTER);
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
	
	public List<PersonModel> showMessage() {
		DataSource.initDatabase("com.mec.bookmanage.model");
		Query query = new Query();		
		List<PersonModel> PersonModelList = query.get(PersonModel.class);
		return PersonModelList;
	}
}
