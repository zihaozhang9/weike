package weike;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import test.TableGeneral;

public class StudentFunction extends JFrame implements ActionListener{
	JButton button1= new  JButton("做作业");
	JButton button2= new JButton("看批改");
	JButton button3= new JButton("问问题");
	JButton button4= new  JButton("互动问答");
	JButton button5=new JButton("在线问答");
	GridLayout grid;
	JPanel chessboard;
	public String name;
//	MousePolice police;
	public void StudentFunction(String ReName){
		name=ReName;
		chessboard = new JPanel();
//		grid = new GridLayout(4,1);
		grid = new GridLayout(5,1);
		chessboard.setLayout(grid);
		button1.addActionListener(this);
		button2.addActionListener(this); 
		button3.addActionListener(this); 
		button4.addActionListener(this);
		button5.addActionListener(this);
	//	button2.addMouseListener(police);
		chessboard.add(button1);
		chessboard.add(button2);
		chessboard.add(button3);
		chessboard.add(button4);
		chessboard.add(button5);
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
//			Geshi geshi=new Geshi();
//			geshi.setTitle("顾客注册/登录");
			dispose();
//			TableGeneral T=new TableGeneral();
//			T.TableGeneral("ReName").setVisible(true);
			new DoHomework(name).setVisible(true);
		}
		else if(buttontest==button2){
			dispose();
			new LookCorrect(name).setVisible(true);
		}
		else if(buttontest==button3){
			dispose();
			AskQuestion A=new AskQuestion();
			A.AskQuestion(name);
		}
		else if(buttontest==button4){
			dispose();
			new Answer(name).setVisible(true);
		}
		else if(buttontest==button5){
			dispose();
//			Denglu d=new Denglu();
//			d.DengLuJieMian();
			OnlineStudent os=new OnlineStudent();
//			os.OnlineStudent();
//			new StudentOnline().setVisible(true);
//			new StudentOnline().recive();
//			os.setVisible(true);
		}
	}
//	public static void main(String args[]){
//		StudentFunction details=new StudentFunction();
//	  details.setTitle("学生功能选择");
//	  details.StudentFunction("");
//	}
	
//	public void actionPerformed(ActionEvent e){}

}
