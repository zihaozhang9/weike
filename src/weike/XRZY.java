package weike;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.SystemColor;


public class XRZY extends JFrame implements ActionListener{
	JButton bt= new  JButton("提交");
	JLabel labelwenben = new JLabel("问题");
	JTextArea wenti = new JTextArea();
	JLabel labelriqi = new JLabel("日期");
	JLabel labeltime = new JLabel(" ");
	JLabel labelfenshu = new JLabel("分数");
	JTextField fenshu=new JTextField();
	static String name;
	public String ReEven;
	
	public  XRZY(String teacher)//
	{
	
		super();
		name=teacher;
		this.setTitle("录入作业");			//设置窗口标题
	this.setLayout(null);						//设置窗口布局管理器
	setBounds(500, 200, 500, 300);
	labelriqi.setBounds(20,15,80,20);		//设置日期标签的初始位置
	labelriqi.setFont(new Font("微软雅黑", Font.PLAIN, 16));
	this.add(labelriqi);						//将问题标签组件添加到容器  
	labelwenben.setBounds(160,70,80,20);			//设置文本框的初始位置XY   C H
	labelwenben.setFont(new Font("微软雅黑", Font.PLAIN, 16));
	this.add(labelwenben);						//将文本框组件添加到容器
	labeltime.setBounds(20,40,80,20);		//设置时间标签的初始位置
	labeltime.setFont(new Font("微软雅黑", Font.PLAIN, 12));
	Date date=new Date();
	 String XieRuZYStr=String.format("%tY/%tm/%td",date,date,date);
       labeltime.setText(XieRuZYStr);
	this.add(labeltime);						//将文本框组件添加到容器
	wenti.setBounds(50,100,250,150);					
	this.add(wenti);		
	labelfenshu.setBounds(340, 70, 80, 20);	//分数文本框
	labelfenshu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
	this.add(labelfenshu);                
	fenshu.setBounds(350, 100,50, 20);
	this.add(fenshu);
	bt.setBounds(320,150,100,20);				//设置登录按钮的初始位置
	this.add(bt);								//将登录按钮组件添加到容器
	bt.addActionListener(this);				//给按钮添加监听器
		//给按钮添加监听器
	this.setVisible(true);						//设置窗口的可见性

	this.setBounds(400,200,500,300);				//设置窗口尺寸大小
	addWindowListener(new WindowAdapter()
                { public void windowClosing(WindowEvent e)
                   {
                      System.exit(0);
                     }
                });							
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new XRZY("li").setVisible(true);
//	
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String score=fenshu.getText();
			 String question=wenti.getText();//问题
		try{
			
				Connection con=DriverManager.getConnection("jdbc:odbc:StudentDate");//连接数据库
				java.sql.Statement sql=con.createStatement();//建立sql语句
				ResultSet rs=sql.executeQuery("SELECT * from Homework");
				sql.executeUpdate("INSERT INTO Homework (问题,分数,出题人) VALUES ('"+question+"','"+score+"','"+name+"')");
				dispose();
				TiShi T=new TiShi();
				T.TiShi("提示", "提示:您已成功提出作业！", "继续", "退出",name);//筛选用户名
	}catch(SQLException e1){e1.printStackTrace();}
	 }

}
