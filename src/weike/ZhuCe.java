package weike;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ZhuCe extends JFrame implements ActionListener{
	 JLabel     JLUserName =new JLabel("用户名：");	//使用文本创建一个标签对象
		JLabel     JLPaw =new JLabel("密    码：");		//使用文本创建一个标签对象
		JLabel     JLGrade =new JLabel("所在年级：");		//使用文本创建一个标签对象
		JComboBox  JCGrade   =new JComboBox();
		JTextField JTUserName=new JTextField();			//创建一个文本框对象
		JPasswordField JPsw  =new JPasswordField();		//创建一个密码框对象
		JLabel     JL1  =new JLabel("身    份:");		//使用文本创建一个标签对象
		JComboBox  JCShenFen   =new JComboBox();				//创建一个组合框对象
		JButton    JB1 =new JButton("完成注册");			//创建按钮对象
//		String ReName=new String(" ");
		public String ReEven;
		
		public void ZhuCe()//
		{
			this.setTitle("用户注册");			//设置窗口标题
			this.setLayout(null);						//设置窗口布局管理器
			JLUserName.setBounds(150,40,80,20);		//设置姓名标签的初始位置
			this.add(JLUserName);						//将姓名标签组件添加到容器
			JTUserName.setBounds(250,40,80,20);			//设置文本框的初始位置
			this.add(JTUserName);						//将文本框组件添加到容器
			JLPaw.setBounds(150,80,80,20);				//设置密码标签的初始位置
			this.add(JLPaw);							//将密码标签组件添加到容器
			JPsw.setBounds(250,80,80,20);				//设置密码框的初始位置
			this.add(JPsw );							//将密码框组件添加到容器
			JLGrade.setBounds(150,120,80,20);				//设置密码框的初始位置
			this.add(JLGrade );							//将密码框组件添加到容器
			JCGrade.setBounds(250,120,80,20);				//设置密码框的初始位置
			JCGrade.addItem(new String("大一"));				//给组合框添加内容
			JCGrade.addItem(new String("大二"));
			JCGrade.addItem(new String("大三"));
			JCGrade.addItem(new String("大四"));
			this.add(JCGrade );							//将密码框组件添加到容器
			JL1.setBounds(150,160,60,20);				//设置身份标签的初始位置
			this.add(JL1);								//将身份标签组件添加到容器
			JCShenFen.setBounds(250,160,80,20);				//设置组合框的初始位置
			this.add(JCShenFen);								//将组合框组件添加到容器
			JCShenFen.addItem(new String("学生"));				//给组合框添加内容
			JCShenFen.addItem(new String("老师"));
			JB1.setBounds(180,200,100,20);				//设置登录按钮的初始位置
			this.add(JB1);								//将登录按钮组件添加到容器
			JB1.addActionListener(this);				//给按钮添加监听器
	    		//给按钮添加监听器
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
			if(e.getSource()==JB1){
				String rname=JTUserName.getText();		//将文本框中包含的文本传给字符串name
				String rpassword=new String(JPsw.getPassword());//将密码框中包含的文本传给字符串password
				String rgrade=(String)JCGrade.getSelectedItem();
				String rshen=(String)JCShenFen.getSelectedItem();
				int nametest=0;
				if(rshen.equals("学生")){
					try{
						Connection con=DriverManager.getConnection("jdbc:odbc:StudentDate");//连接数据库
						java.sql.Statement sql=con.createStatement();//建立sql语句
						ResultSet rs=sql.executeQuery("SELECT * from StudentDate");
						while(rs.next()){
							if(rname.equals(rs.getString("用户名"))){
								nametest++;
							}
						}
						if(nametest==0){
							sql.executeUpdate("INSERT INTO StudentDate values ('"+rname+"','"+rpassword+"','"+rgrade+"')");//筛选用户名
							ReEven="注册成功";
							dispose();
							TiShi T=new TiShi();
							T.TiShi("注册提示", ReEven, "登录", "退出","");
						}
						else{
							ReEven="注册失败！用户名已存在！";
							dispose();
							TiShi T=new TiShi();
							T.TiShi("注册提示", ReEven, "去注册", "退出","");
						}
					}catch(SQLException e1){e1.printStackTrace();}
				}
				else if(rshen.equals("老师")){
					try{
						Connection con=DriverManager.getConnection("jdbc:odbc:TeacherDate");//连接数据库
						java.sql.Statement sql=con.createStatement();//建立sql语句
						ResultSet rs=sql.executeQuery("SELECT * from TeacherDate");
						while(rs.next()){
							if(rname.equals(rs.getString("用户名"))){
								nametest++;
							}
						}
						if(nametest==0){
							sql.executeUpdate("INSERT INTO TeacherDate values ('"+rname+"','"+rpassword+"','"+rgrade+"')");//筛选用户名
							ReEven="注册成功";
							dispose();
							TiShi T=new TiShi();
							T.TiShi("注册提示", ReEven, "登录", "退出","");
						}
						else{
							ReEven="注册失败！用户名已存在！";
							dispose();
							TiShi T=new TiShi();
							T.TiShi("注册提示", ReEven, "去注册", "退出","");
						}
					}catch(SQLException e1){e1.printStackTrace();}
				}
			}
		}
		
		public static void main(String arg[]){
			ZhuCe Z=new ZhuCe();
			Z.ZhuCe();
		} 

}
