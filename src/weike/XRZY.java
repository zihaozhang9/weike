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
	JButton bt= new  JButton("�ύ");
	JLabel labelwenben = new JLabel("����");
	JTextArea wenti = new JTextArea();
	JLabel labelriqi = new JLabel("����");
	JLabel labeltime = new JLabel(" ");
	JLabel labelfenshu = new JLabel("����");
	JTextField fenshu=new JTextField();
	static String name;
	public String ReEven;
	
	public  XRZY(String teacher)//
	{
	
		super();
		name=teacher;
		this.setTitle("¼����ҵ");			//���ô��ڱ���
	this.setLayout(null);						//���ô��ڲ��ֹ�����
	setBounds(500, 200, 500, 300);
	labelriqi.setBounds(20,15,80,20);		//�������ڱ�ǩ�ĳ�ʼλ��
	labelriqi.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	this.add(labelriqi);						//�������ǩ�����ӵ�����  
	labelwenben.setBounds(160,70,80,20);			//�����ı���ĳ�ʼλ��XY   C H
	labelwenben.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	this.add(labelwenben);						//���ı��������ӵ�����
	labeltime.setBounds(20,40,80,20);		//����ʱ���ǩ�ĳ�ʼλ��
	labeltime.setFont(new Font("΢���ź�", Font.PLAIN, 12));
	Date date=new Date();
	 String XieRuZYStr=String.format("%tY/%tm/%td",date,date,date);
       labeltime.setText(XieRuZYStr);
	this.add(labeltime);						//���ı��������ӵ�����
	wenti.setBounds(50,100,250,150);					
	this.add(wenti);		
	labelfenshu.setBounds(340, 70, 80, 20);	//�����ı���
	labelfenshu.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	this.add(labelfenshu);                
	fenshu.setBounds(350, 100,50, 20);
	this.add(fenshu);
	bt.setBounds(320,150,100,20);				//���õ�¼��ť�ĳ�ʼλ��
	this.add(bt);								//����¼��ť�����ӵ�����
	bt.addActionListener(this);				//����ť��Ӽ�����
		//����ť��Ӽ�����
	this.setVisible(true);						//���ô��ڵĿɼ���

	this.setBounds(400,200,500,300);				//���ô��ڳߴ��С
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
			 String question=wenti.getText();//����
		try{
			
				Connection con=DriverManager.getConnection("jdbc:odbc:StudentDate");//�������ݿ�
				java.sql.Statement sql=con.createStatement();//����sql���
				ResultSet rs=sql.executeQuery("SELECT * from Homework");
				sql.executeUpdate("INSERT INTO Homework (����,����,������) VALUES ('"+question+"','"+score+"','"+name+"')");
				dispose();
				TiShi T=new TiShi();
				T.TiShi("��ʾ", "��ʾ:���ѳɹ������ҵ��", "����", "�˳�",name);//ɸѡ�û���
	}catch(SQLException e1){e1.printStackTrace();}
	 }

}
