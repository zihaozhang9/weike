package weike;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Answer extends JFrame{
	private DefaultTableModel tableModel;							// 定义表格模型对象
	private JTable table;											// 定义表格对象
//	JTextField textField1;
//	JTextField textField2;
	String[][] data;
	 int i=0,j=0;
	 String answer;
	 public String ReEven="";
	public Answer(String Answer){
		super();
		answer=Answer;
		setTitle("问题栏");
		setBounds(500, 200, 500, 300);
//		setSize(500,300);
//		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-getWidth()/2,150);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				// 设置窗体的默认关闭模式
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = { "日期", "出题人","问题","答案","回答者" };	// 定义表格列名数组
		 try{
			 Connection con=DriverManager.getConnection("jdbc:odbc:Ask");//连接数据库
				java.sql.Statement sql=con.createStatement();//建立sql语句
				ResultSet rs=sql.executeQuery("SELECT * from Ask");//筛选用户名
				while(rs.next()){
					String r=rs.getString("问题");
					if(r!=null){j++;}}
				System.out.println("j"+j);
				data=new String[j][6];
				rs=sql.executeQuery("SELECT * from Ask");
				while(rs.next()){
//					String r=rs.getString("答案");
//					if(r==null){
						data[i][0]=rs.getDate("日期")+"";//.getString("日期");
						data[i][1]=rs.getString("提问者");
						data[i][2]=rs.getString("问题");
						data[i][3]=rs.getString("答案");
						data[i][4]=rs.getString("回答者");
						i++;
//					}
				}
				tableModel = new DefaultTableModel(data, columnNames);
		 }catch(SQLException e1){e1.printStackTrace();}
		table = new JTable(tableModel);								// 创建指定表格模型的表格
		table.setRowSorter(new TableRowSorter(tableModel));			// 设置表格的排序器
		// 选择模式设置为单选模式
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(Color.PINK);					// 被选择行的背景色为粉红的
		table.setSelectionForeground(Color.MAGENTA);				// 被选择行的前景色为洋红
		table.setRowHeight(25);										// 设置表格的行高为25像素
		scrollPane.setViewportView(table);
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);			// 把面板添加到窗体下面
		final JButton addButton = new JButton("提交");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object aa;
				String straa;
				i=0;
				int tep=j;
				String[] ReEvens=new String[j];
				try{
					i=0;
					Connection con=DriverManager.getConnection("jdbc:odbc:Ask");//连接数据库
					java.sql.Statement sql=con.createStatement();//建立sql语句
					while(tep!=0){
						aa=tableModel.getValueAt(i,3);
						straa=aa+"";
						if((!straa.equals(data[i][3]))&&(!"null".equals(data[i][3]+""))){
//							System.out.println(i+"修改");
							data[i][3]=aa+"";
							sql.executeUpdate("UPDATE Ask SET 答案 = '"+data[i][3]+"'WHERE 问题 = '"+data[i][2]+"'");
							sql.executeUpdate("UPDATE Ask SET 回答者 = '"+answer+"'WHERE 问题 = '"+data[i][2]+"'");
							ReEvens[i]=i+1+"行修改答案";
							System.out.println(ReEvens[i]);
						}
						else if(!straa.equals(data[i][3]+"")&&"null".equals(data[i][3]+"")){
//							System.out.println(i+"添加");
							data[i][3]=aa+"";
							sql.executeUpdate("UPDATE Ask SET 答案 = '"+data[i][3]+"'WHERE 问题 = '"+data[i][2]+"'");
							sql.executeUpdate("UPDATE Ask SET 回答者 = '"+answer+"'WHERE 问题 = '"+data[i][2]+"'");
							ReEvens[i]=i+1+"行添加答案";
							System.out.println(ReEvens[i]);
						}
//						else if(!straa.equals(data[i][3])&&"null".equals(straa)){
//							System.out.println(i+"删除");
//							ReEvens[i]=i+1+"行删除答案";
//						}
						data[i][3]=aa+"";
						i++;
						tep--;
					}
				}catch(SQLException e1){e1.printStackTrace();}
				i=0;
				while(j!=0){
					if(!"null".equals(ReEvens[i]+"")){
						System.out.println("ReEvens[i]"+ReEvens[i]);
						ReEven=ReEven+ReEvens[i];
					}
					i++;
					j--;
				}
				dispose();
				TiShi T=new TiShi();
				T.TiShi("提示", ReEven, "继续", "退出",answer);
			}
		});
		panel.add(addButton);
	}
	
//	public static void main(String[] args) {
////		Answer T=new Answer();
//		new Answer("li").setVisible(true);
//	}
}
