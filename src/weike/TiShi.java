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

public class TiShi extends JFrame implements ActionListener {//提示界面
	 JLabel     JTiShi =new JLabel("功能选择");
	 JButton    JB1 =new JButton("登录");			//创建按钮对象
	 JButton    JB2  =new JButton("去注册");
//	 JComboBox  JC   =new JComboBox();				//创建一个组合框对象
	 String name;
	public void TiShi(String title,String shuoming,String JB1shuoming,String JB2shuoming,String ReName){
		name=ReName;
		this.setTitle(title);			//设置窗口标题
		this.setLayout(null);						//设置窗口布局管理器
		JTiShi.setText(shuoming);
		JTiShi.setBounds(150,40,300,20);		//设置姓名标签的初始位置
		this.add(JTiShi);						//将姓名标签组件添加到容器
//		JC.setBounds(200,150,80,20);				//设置组合框的初始位置
//		this.add(JC);								//将组合框组件添加到容器
		JB1.setText(JB1shuoming);
		JB1.setBounds(150,100,80,60);				//设置登录按钮的初始位置
		this.add(JB1);								//将登录按钮组件添加到容器
		JB1.addActionListener(this);				//给按钮添加监听器
		JB2.setText(JB2shuoming);
		JB2.setBounds(250,100,80,60);				//设置取消按钮的初始位置
		this.add(JB2);								//将取消按钮组件添加容器
		JB2.addActionListener(this);				//给按钮添加监听器
		this.setVisible(true);						//设置窗口的可见性
		this.setBounds(400,200,500,300);				//设置窗口尺寸大小
		addWindowListener(new WindowAdapter()
                    { public void windowClosing(WindowEvent e)
                       {
                          System.exit(0);
                         }
                    });								//通过内部类重写关闭窗体
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JB1&&JB1.getText().equals("去注册")){
			dispose();
			ZhuCe Z=new ZhuCe();
			Z.ZhuCe();
		}
		else if(e.getSource()==JB1&&JB1.getText().equals("登录")){
			dispose();
			Denglu D=new Denglu();
			D.DengLuJieMian();
		}
		else if(e.getSource()==JB1&&JB1.getText().equals("继续")){
			try{
				Connection con=DriverManager.getConnection("jdbc:odbc:StudentDate");//连接数据库
				java.sql.Statement sql=con.createStatement();//建立sql语句
				ResultSet rs=sql.executeQuery("SELECT * from StudentDate");//筛选用户名
				int test=0;
				while(rs.next()){
					if(name.equals(rs.getString("用户名"))){test++;}
				}
				if(test==0){
					dispose();
					TeacherFunction F=new TeacherFunction();
					F.setTitle("功能选择");
					F.TeacherFunction(name);
				}
				else{
					dispose();
					StudentFunction F=new StudentFunction();
					F.setTitle("功能选择");
					F.StudentFunction(name);					
				}
			}catch(SQLException e1){e1.printStackTrace();}
		}
		else if(e.getSource()==JB2&&JB2.getText().equals("退出")){
			System.exit(0);
		}
	}
	
//	public static void main(String arg[]){
//		TiShi T=new TiShi();
//		T.TiShi("注册提示", "注册提示", "登录", "退出","");
//		
//	}
}
