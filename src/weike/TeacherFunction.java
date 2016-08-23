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
	JButton button1= new  JButton("录入作业");
	JButton button2= new JButton("批改作业");
	JButton button3= new JButton("答疑");
	JButton button4= new JButton("在线问答");
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
//			x.setTitle("录入作业");
//			x.XieRuZY();
//			XRZY T=new XRZY(name);
//			T.setTitle("录入作业");
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
//	  details.setTitle("老师登录界面");
//	  details.TeacherFunction("li");
//	}
	
//	public void actionPerformed(ActionEvent e){}

}