package weike;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Date;
import java.util.*;

import javax.swing.event.*;

import java.sql.*;
import java.text.SimpleDateFormat;

public class AskQuestion extends JFrame implements ActionListener{
//	private DefaultTableModel tableModel;							// 定义表格模型对象
//	private JTable table;											// 定义表格对象
//	JTextField textField1;
//	JFrame J=new JFrame();
//	JPanel P=new JPanel();
	JScrollPane scrollpane=new JScrollPane();
	JLabel  JLDate=new JLabel("日期");
	JLabel  Date=new JLabel("日期");
	JLabel  JLQuestion=new JLabel("问题");
	JTextField JTQuestion=new JTextField();
	JButton JBHand=new JButton("提交");
//		String ReName=new String(" ");
		public String ReEven;
		public String name;
		public void AskQuestion(String ReName)//map
		{
			name=ReName;
			this.setTitle("学生问问题");			//设置窗口标题
			this.setLayout(null);						//设置窗口布局管理器
			JLDate.setBounds(100, 20, 80, 20);		//设置姓名标签的初始位置
			this.add(JLDate);						//将姓名标签组件添加到容器
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date.setText(df.format(new Date()));
			Date.setBounds(100, 80, 100, 40);			//设置文本框的初始位置
			this.add(Date);						//将文本框组件添加到容器
			JLQuestion.setBounds(200, 20, 80, 20);				//设置密码标签的初始位置
			this.add(JLQuestion);							//将密码标签组件添加到容器
			JTQuestion.setBounds(200, 80,200, 60);				//设置密码框的初始位置
			this.add(JTQuestion );							//将密码框组件添加到容器
			JBHand.setBounds(200, 200, 80, 20);				//设置密码框的初始位置
			this.add(JBHand );							//将密码框组件添加到容器
			JBHand.addActionListener(this);				//给按钮添加监听器
			this.setVisible(true);						//设置窗口的可见性
		
			this.setBounds(400,200,500,300);				//设置窗口尺寸大小
			addWindowListener(new WindowAdapter()
	                    { public void windowClosing(WindowEvent e)
	                       {
	                          System.exit(0);
	                         }
	                    });								//通过内部类重写关闭窗体的方法
		}
		
	public void actionPerformed(ActionEvent e){
		JButton getbut=(JButton)e.getSource();
		if(e.getSource()==JBHand){
			try{

				Connection con=DriverManager.getConnection("jdbc:odbc:Ask");//连接数据库
				java.sql.Statement sql=con.createStatement();//建立sql语句
				ResultSet rs=sql.executeQuery("SELECT * from Ask ");//筛选用户名
				String question=JTQuestion.getText()+"";
				int q=0;
				while(rs.next()){
					if(question==rs.getString("问题")){q++;}
				}
				if(q==0){
					sql.executeUpdate("INSERT INTO Ask(日期,问题,提问者) values ('"+Date.getText()+"','"+question+"','"+name+"')");
					ReEven="提问成功";
				}
				else{
					ReEven="问题存在，提问不成功";
				}
				dispose();
				TiShi T=new TiShi();
				T.TiShi("提示", ReEven, "继续", "退出",name);
			}catch(SQLException e1){e1.printStackTrace();}
		}
	}
//	public static void main(String[] args) {
////		new AskQuestion().setVisible(true);
//		AskQuestion A=new AskQuestion();
//		A.AskQuestion("li");
//	}

	                                                                         
}
