package weike;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

import javax.swing.event.*;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Denglu extends JFrame implements ActionListener{
//	Scanner in=new Scanner(System.in);
	 JLabel     JLUserName =new JLabel("用户名：");	//使用文本创建一个标签对象
		JLabel     JLPaw =new JLabel("密    码：");		//使用文本创建一个标签对象
		JTextField JTUserName=new JTextField();			//创建一个文本框对象
		JPasswordField JPsw  =new JPasswordField();		//创建一个密码框对象
		JButton    JB1 =new JButton("登录");			//创建按钮对象
		JButton    JB2  =new JButton("去注册");
		JLabel     JL1  =new JLabel("身    份:");		//使用文本创建一个标签对象
		JComboBox  JC   =new JComboBox();				//创建一个组合框对象
		JLabel imgLabel4;
		JLabel imgLabel;
		String ReName=new String(" ");
		public String ReEven;


		public void DengLuJieMian()//
		{
			this.setTitle("微课互动系统");			//设置窗口标题
			this.setLayout(null);						//设置窗口布局管理器
			imgLabel4=new JLabel(new ImageIcon("image\\4.jpg")); 
			imgLabel4.setBounds(50,10,80,200);
			this.add(imgLabel4);
			imgLabel=new JLabel(new ImageIcon("image\\3.jpg")); 
			imgLabel.setBounds(330,50,150,100);
			this.add(imgLabel);
			JLUserName.setBounds(150,40,100,20);		//设置姓名标签的初始位置
			this.add(JLUserName);						//将姓名标签组件添加到容器
			JTUserName.setBounds(250,40,80,20);			//设置文本框的初始位置
			this.add(JTUserName);						//将文本框组件添加到容器
			JLPaw.setBounds(150,100,60,20);				//设置密码标签的初始位置
			this.add(JLPaw);							//将密码标签组件添加到容器
			JPsw.setBounds(250,100,80,20);				//设置密码框的初始位置
			this.add(JPsw );							//将密码框组件添加到容器
			JL1.setBounds(150,150,60,20);				//设置身份标签的初始位置
			this.add(JL1);								//将身份标签组件添加到容器
			JC.setBounds(250,150,80,20);				//设置组合框的初始位置
			this.add(JC);								//将组合框组件添加到容器
			JC.addItem(new String("学生"));				//给组合框添加内容
			JC.addItem(new String("老师"));
			JB1.setBounds(150,200,60,20);				//设置登录按钮的初始位置
			this.add(JB1);								//将登录按钮组件添加到容器
			JB1.addActionListener(this);				//给按钮添加监听器
	        JB2.setBounds(250,200,80,20);				//设置取消按钮的初始位置
			this.add(JB2);								//将取消按钮组件添加容器
			JB2.addActionListener(this);				//给按钮添加监听器
			this.setVisible(true);						//设置窗口的可见性
		
			this.setBounds(400,200,500,300);				//设置窗口尺寸大小
			addWindowListener(new WindowAdapter()
	                    { public void windowClosing(WindowEvent e)
	                       {
	                          System.exit(0);
	                         }
	                    });								//通过内部类重写关闭窗体的方法
		}
		
		public String login(String name,String password,String shenfen){//登录功能
			//System.out.println("请输入用户名!");//提示输入
			//name=in.next();//把输入的赋值给myInput
			//System.out.println("请输入密码!");//提示输入
			//password=in.next();//密码输入赋值
			
			try{//异常处理
				Connection con=DriverManager.getConnection("jdbc:odbc:"+shenfen+"");//连接数据库
				java.sql.Statement sql=con.createStatement();//建立sql语句
				ResultSet rs=sql.executeQuery("SELECT 密码 from "+shenfen+" where 用户名='"+name+"'");//筛选用户名
				if(rs.next()){//如果结果不为空
					String mypassword=rs.getString("密码");//把该返回值的密码赋值给myPassword
					if(mypassword.equals(password)){//对比控制台输入的和数据库里的密码
//						System.out.println(name+"登陆成功!");	//相同 成功
						ReEven=name+"登陆成功!";
						return name;
					}
					else{//不同
//						System.out.println("密码错误,登录失败!");//登录失败
						ReEven="密码错误,登录失败!";
					}
				}
				else{//为空
//					System.out.println("用户名没找!");//没有该用户
					ReEven="用户名没找!";
				}
				sql.close();//把当前的数据库关闭
				con.close();//关闭当前连接
			}catch(SQLException e1){e1.printStackTrace();}//如果出现问题 追踪打印e1出现的问题
			return " ";
		}
	
	public void actionPerformed(ActionEvent e){
		JButton getbut=(JButton)e.getSource();
		if(e.getSource()==JB1){ 						//处理登录事件
			String rname=JTUserName.getText();		//将文本框中包含的文本传给字符串name
			String rpassword=new String(JPsw.getPassword());//将密码框中包含的文本传给字符串password
			String box= (String)JC.getSelectedItem();//将当前所选项传给字符串box
						//判断语句
				if(box.equals("学生")){//选择学生身份登录
					ReName=login(rname,rpassword,"StudentDate");
				}
				else if(box.equals("老师")){//选择学生身份登录
					ReName=login(rname,rpassword,"TeacherDate");
				}
				if(!ReName.equals(" ")){
					dispose();
					TiShi T=new TiShi();
					T.TiShi("登录提示", ReEven, "继续", "退出",ReName);
				}
				else{
					dispose();
					TiShi T=new TiShi();
					T.TiShi("登录提示", ReEven, "登录", "退出","");
				}
		}
		else if(e.getSource()==JB2){
			//添加注册页面
			dispose();
			ZhuCe Z=new ZhuCe();
			Z.ZhuCe();
		}                         
	}
//	public static void main(String arg[]){
//		Denglu D=new Denglu();
//		D.DengLuJieMian();
//	}
	                                                                         
}
