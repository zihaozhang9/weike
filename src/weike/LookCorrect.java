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

public class LookCorrect extends JFrame{
	private DefaultTableModel tableModel;							// 定义表格模型对象
	private JTable table;											// 定义表格对象
//	JTextField textField1;
//	JTextField textField2;
	String[][] data;
	 int i=0,j=0;
	 String answer;
	public LookCorrect(String Answer){
		super();
		answer=Answer;
		setTitle("问题栏");
		setBounds(500, 200, 500, 300);
//		setSize(500,300);
//		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-getWidth()/2,150);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				// 设置窗体的默认关闭模式
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = { "日期", "出题人","问题","答案" ,"评语","得分"};						// 定义表格列名数组

		 try{
			 Connection con=DriverManager.getConnection("jdbc:odbc:Homework");//连接数据库
				java.sql.Statement sql=con.createStatement();//建立sql语句
				ResultSet rs=sql.executeQuery("SELECT 评语 from Homework where 答题人='"+answer+"'");//筛选用户名
				while(rs.next()){j++;}
				data=new String[j][6];
				rs=sql.executeQuery("SELECT * from Homework where 答题人='"+answer+"'");
				while(rs.next()){
//					String r=rs.getString("评语")+"";
//					if(r.equals("null")){
						data[i][0]=rs.getDate("日期")+"";//.getString("日期");
						data[i][1]=rs.getString("出题人");
						data[i][2]=rs.getString("问题");
						data[i][3]=rs.getString("答案");
						data[i][4]=rs.getString("评语");
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
//				}
//				if (e.getType()==TableModelEvent.UPDATE) {			// 是否对表格模型中的行或列进行了编辑修改
//					int col=e.getColumn();							// 获得被修改列的列索引
//					if (col==1){									// 如果列索引是1，则输出信息
//						System.out.println("修改了表格中的数据行。");
//					}
//				}
//				if (e.getType()==TableModelEvent.DELETE) {			// 是否删除了表格模型中的行或列
//					// 如果删除了表格模型中的行或列，则输出信息
//					System.out.println("删除了表格中的数据行。");
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
		final JButton addButton = new JButton("返回");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentFunction SF=new StudentFunction();
				  SF.setTitle("学生功能选择");
				  SF.StudentFunction("");
			}
		});
		panel.add(addButton);
	}
//	final JButton addButton = new JButton("提交");
//	addButton.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			Object aa;
//			i=0;
//			int tep=j;
//			while(j!=0){
//				aa=tableModel.getValueAt(i,3);
//				data[i][3]=aa+"";
//				System.out.println(data[i][3]);
//				i++;
//				j--;
//			}
//			try{
//				i=0;
//				Connection con=DriverManager.getConnection("jdbc:odbc:Homework");//连接数据库
//				java.sql.Statement sql=con.createStatement();//建立sql语句
//				while(tep!=0){
//					if(!data[i][3].equals("null")){
//						sql.executeUpdate("UPDATE Homework SET 答案 = '"+data[i][3]+"'WHERE 问题 = '"+data[i][2]+"'");
//						sql.executeUpdate("UPDATE Homework SET  答题人='"+answer+"'WHERE 问题 = '"+data[i][2]+"'");
//						}
//					tep--;
//					i++;
//				}
//			}catch(SQLException e1){e1.printStackTrace();}
//		}
//	});
//	panel.add(addButton);
//}
	
//	public static void main(String[] args) {
////		TableGeneral T=new TableGeneral();
//		new LookCorrect("li").setVisible(true);
//	}
}
