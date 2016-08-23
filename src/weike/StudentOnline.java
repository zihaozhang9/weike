package weike;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class StudentOnline extends JFrame{
	JTextArea JTA1=new JTextArea();
	JTextArea JTA2=new JTextArea();
	JButton    JB1 =new JButton("发送");			//创建按钮对象
	JButton    JB2  =new JButton("开始");
	JButton    JB3  =new JButton("返回");
	JPanel JP=new JPanel();
	 int i=0,j=0,k=0;
	 String answer;
	 public String ReEven="";
	public StudentOnline(){
		super();
//		JTextArea JTA1=new JTextArea();
//		JTextArea JTA2=new JTextArea();
//		JButton    JB1 =new JButton("发送");			//创建按钮对象
//		JButton    JB2  =new JButton("开始");
//		JButton    JB3  =new JButton("返回");
//		JPanel JP=new JPanel();
//		answer=Answer;
		setTitle("问题栏");
		setBounds(500, 200, 500, 300);
		
		this.setTitle("onlineStudent在线问答系统");			//设置窗口标题
//		this.setLayout(null);						//设置窗口布局管理器
		JP.setLayout(null);
		JP.setBounds(0, 0, 500, 300);
		JTA1.setBounds(110,10,300,100);		//设置姓名标签的初始位置
		this.add(JTA1);						//将姓名标签组件添加到容器
		JP.add(JTA1);	
		JTA2.setBounds(110,150,300,100);			//设置文本框的初始位置
		this.add(JTA2);						//将文本框组件添加到容器
		JP.add(JTA2);
		JB1.setBounds(300,110,60,20);				//设置密码标签的初始位置
		this.add(JB1);							//将密码标签组件添加到容器
		JP.add(JB1);
		JB2.setBounds(150,110,80,20);				//设置密码框的初始位置
		JB2.setBackground(new Color(200,200,1));
//		this.add(JB2 );							//将密码框组件添加到容器
		JB3.setBounds(50,110,80,20);				//设置密码标签的初始位置
		JB3.setBackground(new Color(200,200,1));
		this.add(JB3);							//将密码标签组件添加到容器
		JP.add(JB3);
		JB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});	
		JB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});	
		JB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});	
		this.add(JP);
//		this.setBackground(Color.black);
//	    this.setBackground(new Color(200,200,2));
//	    this.getgraphics(setColor(255,200,200));
		this.setBounds(400,200,500,300);				//设置窗口尺寸大小
		this.setVisible(true);						//设置窗口的可见性
		addWindowListener(new WindowAdapter()
                    { public void windowClosing(WindowEvent e)
                       {
                          System.exit(0);
                         }
                    });								//通过内部类重写关闭窗体的方法
//		setSize(500,300);
//		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-getWidth()/2,150);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				// 设置窗体的默认关闭模式
//		final JScrollPane scrollPane = new JScrollPane();
//		getContentPane().add(scrollPane, BorderLayout.CENTER);
//		String[] columnNames = { "日期", "出题人","问题","答案","回答者" };	// 定义表格列名数组
//		 try{
//			 Connection con=DriverManager.getConnection("jdbc:odbc:Ask");//连接数据库
//				java.sql.Statement sql=con.createStatement();//建立sql语句
//				ResultSet rs=sql.executeQuery("SELECT * from Ask");//筛选用户名
//				while(rs.next()){
//					String r=rs.getString("问题");
//					if(r!=null){j++;}}
//				System.out.println("j"+j);
//				data=new String[j][6];
//				rs=sql.executeQuery("SELECT * from Ask");
//				while(rs.next()){
////					String r=rs.getString("答案");
////					if(r==null){
//						data[i][0]=rs.getDate("日期")+"";//.getString("日期");
//						data[i][1]=rs.getString("提问者");
//						data[i][2]=rs.getString("问题");
//						data[i][3]=rs.getString("答案");
//						data[i][4]=rs.getString("回答者");
//						i++;
////					}
//				}
//				tableModel = new DefaultTableModel(data, columnNames);
//		 }catch(SQLException e1){e1.printStackTrace();}
//		table = new JTable(tableModel);								// 创建指定表格模型的表格
//		table.setRowSorter(new TableRowSorter(tableModel));			// 设置表格的排序器
//		// 选择模式设置为单选模式
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table.setSelectionBackground(Color.PINK);					// 被选择行的背景色为粉红的
//		table.setSelectionForeground(Color.MAGENTA);				// 被选择行的前景色为洋红
//		table.setRowHeight(25);										// 设置表格的行高为25像素
//		scrollPane.setViewportView(table);
//		final JPanel panel = new JPanel();
//		getContentPane().add(panel, BorderLayout.SOUTH);			// 把面板添加到窗体下面
//		final JButton addButton = new JButton("提交");
//		addButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Object aa;
//				String straa;
//				i=0;
//				int tep=j;
//				String[] ReEvens=new String[j];
//				try{
//					i=0;
//					Connection con=DriverManager.getConnection("jdbc:odbc:Ask");//连接数据库
//					java.sql.Statement sql=con.createStatement();//建立sql语句
//					while(tep!=0){
//						aa=tableModel.getValueAt(i,3);
//						straa=aa+"";
//						if((!straa.equals(data[i][3]))&&(!"null".equals(data[i][3]+""))){
////							System.out.println(i+"修改");
//							data[i][3]=aa+"";
//							sql.executeUpdate("UPDATE Ask SET 答案 = '"+data[i][3]+"'WHERE 问题 = '"+data[i][2]+"'");
//							sql.executeUpdate("UPDATE Ask SET 回答者 = '"+answer+"'WHERE 问题 = '"+data[i][2]+"'");
//							ReEvens[i]=i+1+"行修改答案";
//							System.out.println(ReEvens[i]);
//						}
//						else if(!straa.equals(data[i][3]+"")&&"null".equals(data[i][3]+"")){
////							System.out.println(i+"添加");
//							data[i][3]=aa+"";
//							sql.executeUpdate("UPDATE Ask SET 答案 = '"+data[i][3]+"'WHERE 问题 = '"+data[i][2]+"'");
//							sql.executeUpdate("UPDATE Ask SET 回答者 = '"+answer+"'WHERE 问题 = '"+data[i][2]+"'");
//							ReEvens[i]=i+1+"行添加答案";
//							System.out.println(ReEvens[i]);
//						}
////						else if(!straa.equals(data[i][3])&&"null".equals(straa)){
////							System.out.println(i+"删除");
////							ReEvens[i]=i+1+"行删除答案";
////						}
//						data[i][3]=aa+"";
//						i++;
//						tep--;
//					}
//				}catch(SQLException e1){e1.printStackTrace();}
//				i=0;
//				while(j!=0){
//					if(!"null".equals(ReEvens[i]+"")){
//						System.out.println("ReEvens[i]"+ReEvens[i]);
//						ReEven=ReEven+ReEvens[i];
//					}
//					i++;
//					j--;
//				}
//				dispose();
//				TiShi T=new TiShi();
//				T.TiShi("提示", ReEven, "继续", "退出",answer);
//			}
//		});
//		panel.add(addButton);
//		k++;
//		if(k==1){
//			try{
//				  ServerSocket ss = new ServerSocket(5566);
//				  Socket client =  ss.accept();
//				 DataInputStream inFromClient = new DataInputStream(client.getInputStream());
//				  DataOutputStream outTOClient = new DataOutputStream(client.getOutputStream());
//				  String str="";
//				  String[] cache=new String[6]; 
//					int i=0,j=0;
//				while(true){
//					if(i!=0){client =  ss.accept();}
//					inFromClient = new DataInputStream(client.getInputStream());
//					if(i==0){
//						cache[i]=inFromClient.readUTF();
//						str =cache[i];}
//					else if(i>0&&i<5) {
//						cache[i]=inFromClient.readUTF();
//						str = str+"\n"+cache[i];
//						}
//					else if(i>=5){
//				  		str="";
//						cache[5]=inFromClient.readUTF();
//						for(j=0;j<5;j++)
//						{
//							cache[j]=cache[j+1];
//							str=str+cache[j]+"\n";
//						}
//					}
//					System.out.println(str);
//					JTA1.setText(str);
//					i++;
//				}
//			}catch(IOException d){d.printStackTrace();}
//		}
	}
	
	public void recive(){
		try{
			  ServerSocket ss = new ServerSocket(5566);
			  Socket client =  ss.accept();
			 DataInputStream inFromClient = new DataInputStream(client.getInputStream());
			  DataOutputStream outTOClient = new DataOutputStream(client.getOutputStream());
			  String str="";
			  String[] cache=new String[6]; 
				int i=0,j=0;
//			while(true){
//				System.out.println(1);
//				if(i!=0){client =  ss.accept();}
//				inFromClient = new DataInputStream(client.getInputStream());
//				if(i==0){
//					cache[i]=inFromClient.readUTF();
//					str =cache[i];}
//				else if(i>0&&i<5) {
//					cache[i]=inFromClient.readUTF();
//					str = str+"\n"+cache[i];
//					}
//				else if(i>=5){
//			  		str="";
//					cache[5]=inFromClient.readUTF();
//					for(j=0;j<5;j++)
//					{
//						cache[j]=cache[j+1];
//						str=str+cache[j]+"\n";
//					}
//				}
//				System.out.println(str);
//				JTA1.setText(str);
//				i++;
//			}
		}catch(IOException d){d.printStackTrace();}
	}
	
//	public static void main(String[] args) {
////		Answer T=new Answer();
//		new StudentOnline().setVisible(true);
//	}
}
