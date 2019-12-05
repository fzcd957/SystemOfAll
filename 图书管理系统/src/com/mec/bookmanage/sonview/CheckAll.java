package com.mec.bookmanage.sonview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mec.bookmanage.core.DataSource;
import com.mec.bookmanage.core.Query;
import com.mec.bookmanage.fatherview.IBKmanageView;
import com.mec.bookmanage.model.BookModel;

public class CheckAll implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private JLabel jLabel;
	private JPanel jPanel;
	private JTable jTable;
	private String bid,bname,blocation,bisused,bprice;
	
	public CheckAll() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("查看所有书籍");
		jFrame.setSize(800, 600);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);		
		
		
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"书籍编号","书籍名称","书籍存放位置","是否被借出","书籍价格"});
		
		List<BookModel> BookModelList = showMessage();
		for (BookModel book : BookModelList) {
			String bookinfo = book.toString();	
			String[] bookinfoArray = bookinfo.split(",");
			for(int i = 0; i < bookinfoArray.length;i++) {
				 bid = bookinfoArray[0];
				 bname = bookinfoArray[1];
				 blocation = bookinfoArray[2];
				 bisused = bookinfoArray[3];
				 bprice = bookinfoArray[4];		
			}
			model.addRow(new Object[]{bid,bname,blocation,bisused,bprice});
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
		
		jLabel = new JLabel("图书馆藏书",JLabel.CENTER);
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
	
	public List<BookModel> showMessage() {
		DataSource.initDatabase("com.mec.bookmanage.model");
		Query query = new Query();		
		List<BookModel> BookModelList = query.get(BookModel.class);
		return BookModelList;
	}
}
