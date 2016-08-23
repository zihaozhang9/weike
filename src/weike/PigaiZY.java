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

public class PigaiZY extends JFrame{
	private DefaultTableModel tableModel;							// 定义表格模型对象
	private JTable table;											// 定义表格对象
//	JTextField textField1;
//	JTextField textField2;
	String[][] data;
	 int i=0,j=0;
	 String name;
	 public String ReEven;
	public PigaiZY(String Answer){
		super();
		name=Answer;
		setTitle("作业栏");
		setBounds(500, 200, 500, 300);
//		setSize(500,300);
//		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-getWidth()/2,150);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				// 设置窗体的默认关闭模式
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = { "日期", "问题","回答","评语" ,"分数","得分" };	// 定义表格列名数组
		 try{
			 Connection con=DriverManager.getConnection("jdbc:odbc:Homework");//连接数据库
				java.sql.Statement sql=con.createStatement();//建立sql语句
				ResultSet rs=sql.executeQuery("SELECT * from Homework");//筛选用户名
				while(rs.next()){
					String r=rs.getString("问题");
					if(r!=null){j++;}}
				System.out.println("j"+j);
				data=new String[j][6];
				rs=sql.executeQuery("SELECT * from Homework");
				while(rs.next()){
//					String r=rs.getString("答案");
//					if(r==null){
					data[i][0]=rs.getDate("日期")+"";//.getString("日期");
					data[i][1]=rs.getString("问题");
					data[i][2]=rs.getString("答案");
					data[i][3]=rs.getString("评语");
					data[i][4]=rs.getString("分数");
					data[i][5]=rs.getString("得分");
					i++;
//					}
				}
				tableModel = new DefaultTableModel(data, columnNames);
		 }catch(SQLException e1){e1.printStackTrace();}
			// 创建表格模型
//		tableModel.addTableModelListener(new TableModelListener(){
//			public void tableChanged(TableModelEvent e) {
//				if (e.getType()==TableModelEvent.INSERT) {			// 是否在表格模型中添加了新行或新列
//					// 如果添加了新行或新列，则输出信息
//					System.out.println("向表格中添加了新的数据行。");
//					ReEven="向表格中添加了新的数据行。";
//				}
//				if (e.getType()==TableModelEvent.UPDATE) {			// 是否对表格模型中的行或列进行了编辑修改
//					int col=e.getColumn();							// 获得被修改列的列索引
//					if (col==1){									// 如果列索引是1，则输出信息
//						System.out.println("修改了表格中的数据行。");
//						ReEven="修改了表格中的数据行。";
//					}
//				}
//				if (e.getType()==TableModelEvent.DELETE) {			// 是否删除了表格模型中的行或列
//					// 如果删除了表格模型中的行或列，则输出信息
//					System.out.println("删除了表格中的数据行。");
//					ReEven="删除了表格中的数据行。";
//				}
//			}
//		});
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
				Object aa,bb;
				String straa;
				i=0;
				int tep=j;
//				if(null.equals("s")){System.out.println("straa");}//错
//				if("s".equals(null)){System.out.println("straa");}//对
				String[] ReEvens=new String[j];
//				while(j!=0){
//					aa=tableModel.getValueAt(i,3);
//					straa=aa+"";
////					System.out.println("straa"+straa);
////					System.out.println("data[i][3]"+data[i][3]);
//					if((!straa.equals(data[i][3]))&&(!"null".equals(data[i][3]))){
//						System.out.println(i+"修改");
//						ReEvens[i]=i+1+"行修改答案";
//					}
//					else if(!straa.equals(data[i][3])&&"null".equals(data[i][3])){
//						System.out.println(i+"添加");
//						ReEvens[i]=i+1+"行添加答案";
//					}
//					else if(!straa.equals(data[i][3])&&"null".equals(straa)){
//						System.out.println(i+"删除");
//						ReEvens[i]=i+1+"行删除答案";
//					}
////					else if(straa.equals(data[i][3])){
////						System.out.println(i+1+"未更改");
////						ReEvens[i]=i+1+"行未更改";
////					}
//					data[i][3]=aa+"";
////					System.out.println("data[i][3]"+data[i][3]);
//					i++;
//					j--;
//				}
				try{
					i=0;
					Connection con=DriverManager.getConnection("jdbc:odbc:Homework");//连接数据库
					java.sql.Statement sql=con.createStatement();//建立sql语句
//					while(tep!=0){
//						if(!"null".equals(data[i][3])){
//							sql.executeUpdate("UPDATE Homework1 SET 答案 = '"+data[i][3]+"'WHERE 回答 = '"+data[i][2]+"'");
//							sql.executeUpdate("UPDATE Homework1 SET  问题='"+answer+"'WHERE 回答 = '"+data[i][2]+"'");
//							}
//						tep--;
//						i++;
//					}
					while(tep!=0){
						aa=tableModel.getValueAt(i,3);
						bb=tableModel.getValueAt(i,5);
						straa=aa+"";
						if((!straa.equals(data[i][3]))&&(!"null".equals(data[i][3]+""))){
//							System.out.println(i+"修改");
							data[i][3]=aa+"";
							data[i][5]=bb+"";
							sql.executeUpdate("UPDATE Homework SET 评语 = '"+data[i][3]+"'WHERE 问题 = '"+data[i][1]+"'");
							sql.executeUpdate("UPDATE Homework SET 得分 = '"+data[i][5]+"'WHERE 问题 = '"+data[i][1]+"'");
							ReEvens[i]=i+1+"行修改答案";
							System.out.println(ReEvens[i]);
						}
						else if(!straa.equals(data[i][3]+"")&&"null".equals(data[i][3]+"")){
//							System.out.println(i+"添加");
							data[i][3]=aa+"";
							data[i][5]=bb+"";
							sql.executeUpdate("UPDATE Homework SET 评语 = '"+data[i][3]+"'WHERE 问题 = '"+data[i][1]+"'");
							sql.executeUpdate("UPDATE Homework SET 得分 = '"+data[i][5]+"'WHERE 问题 = '"+data[i][1]+"'");
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
					dispose();
					TiShi T=new TiShi();
					T.TiShi("提示", "提示:您已成功批改作业！", "继续", "退出",name);//筛选用户名
				}catch(SQLException e1){e1.printStackTrace();}
			}
		});
		panel.add(addButton);
	}
	
//	public static void main(String[] args) {
////		Answer T=new Answer();
//		new PigaiZY("li").setVisible(true);
//	}
}

