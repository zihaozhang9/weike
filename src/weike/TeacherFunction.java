package weike;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TeacherFunction extends JFrame implements ActionListener{
	JButton button1= new  JButton("¼����ҵ");
	JButton button2= new JButton("������ҵ");
	JButton button3= new JButton("����");
	JButton button4= new JButton("�����ʴ�");
String name;
	GridLayout grid;
	JPanel chessboard;
//	MousePolice police;
	public void TeacherFunction(String teacher){
		name=teacher;
		chessboard = new JPanel();
		grid = new GridLayout(3,1);
//		grid = new GridLayout(4,1);
		chessboard.setLayout(grid);
		 button1.addActionListener(this);
			button2.addActionListener(this); 
			button3.addActionListener(this); 
//			button4.addActionListener(this); 
	//	button2.addMouseListener(police);
		chessboard.add(button1);
		chessboard.add(button2);
		chessboard.add(button3);
//		chessboard.add(button4);

	    add(chessboard,BorderLayout.CENTER);
		setBounds(500,200,400,300);
	//	addMouseListener(police);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttontest = (JButton)e.getSource();
		if(buttontest==button1){
			dispose();
//			XieRuZY x=new XieRuZY();
//			x.setTitle("¼����ҵ");
//			x.XieRuZY();
//			XRZY T=new XRZY(name);
//			T.setTitle("¼����ҵ");
			new XRZY(name).setVisible(true);
		}
		else if(buttontest==button2){
			dispose();
			new PigaiZY(name).setVisible(true);
		}
		else if(buttontest==button3){
			dispose();
			new Answer(name).setVisible(true);
		}
		else if(buttontest==button4){
			dispose();
			OnlineTeacher ot=new OnlineTeacher();
			ot.OnlineTeacher();
//			ot.recive();
		}
//		dispose();
	}
//	public static void main(String args[]){
//		TeacherFunction details=new TeacherFunction();
//	  details.setTitle("��ʦ��¼����");
//	  details.TeacherFunction("li");
//	}
	
//	public void actionPerformed(ActionEvent e){}

}