package com.mec.UspPackage.fatherview;

import java.awt.Font;

public interface IBKmanageView {
		
	public final Font topicFont = new Font("楷体", Font.BOLD, 50);
	public final Font topicFont1 = new Font("楷体", Font.BOLD, 25);
	public final Font textfield1font = new Font("楷体", Font.ITALIC, 20);
	public final Font TextTopicfont = new Font("楷体", Font.BOLD, 20);
	public final Font warningTopicfont = new Font("微软雅黑", Font.BOLD, 40);
	
	public void init();
	public void dealAction();
	public void showView();
	public void exitView();	
}
