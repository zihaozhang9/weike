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
	private DefaultTableModel tableModel;							// ������ģ�Ͷ���
	private JTable table;											// ���������
//	JTextField textField1;
//	JTextField textField2;
	String[][] data;
	 int i=0,j=0;
	 String answer;
	public LookCorrect(String Answer){
		super();
		answer=Answer;
		setTitle("������");
		setBounds(500, 200, 500, 300);
//		setSize(500,300);
//		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-getWidth()/2,150);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				// ���ô����Ĭ�Ϲر�ģʽ
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = { "����", "������","����","��" ,"����","�÷�"};						// ��������������

		 try{
			 Connection con=DriverManager.getConnection("jdbc:odbc:Homework");//�������ݿ�
				java.sql.Statement sql=con.createStatement();//����sql���
				ResultSet rs=sql.executeQuery("SELECT ���� from Homework where ������='"+answer+"'");//ɸѡ�û���
				while(rs.next()){j++;}
				data=new String[j][6];
				rs=sql.executeQuery("SELECT * from Homework where ������='"+answer+"'");
				while(rs.next()){
//					String r=rs.getString("����")+"";
//					if(r.equals("null")){
						data[i][0]=rs.getDate("����")+"";//.getString("����");
						data[i][1]=rs.getString("������");
						data[i][2]=rs.getString("����");
						data[i][3]=rs.getString("��");
						data[i][4]=rs.getString("����");
						data[i][5]=rs.getString("�÷�");
						i++;
//					}
				}
				tableModel = new DefaultTableModel(data, columnNames);
		 }catch(SQLException e1){e1.printStackTrace();}
			// �������ģ��
//		tableModel.addTableModelListener(new TableModelListener(){
//			public void tableChanged(TableModelEvent e) {
//				if (e.getType()==TableModelEvent.INSERT) {			// �Ƿ��ڱ��ģ������������л�����
//					// �����������л����У��������Ϣ
//					System.out.println("������������µ������С�");
//				}
//				if (e.getType()==TableModelEvent.UPDATE) {			// �Ƿ�Ա��ģ���е��л��н����˱༭�޸�
//					int col=e.getColumn();							// ��ñ��޸��е�������
//					if (col==1){									// �����������1���������Ϣ
//						System.out.println("�޸��˱���е������С�");
//					}
//				}
//				if (e.getType()==TableModelEvent.DELETE) {			// �Ƿ�ɾ���˱��ģ���е��л���
//					// ���ɾ���˱��ģ���е��л��У��������Ϣ
//					System.out.println("ɾ���˱���е������С�");
//				}
//			}
//		});
		table = new JTable(tableModel);								// ����ָ�����ģ�͵ı��
		table.setRowSorter(new TableRowSorter(tableModel));			// ���ñ���������
		// ѡ��ģʽ����Ϊ��ѡģʽ
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(Color.PINK);					// ��ѡ���еı���ɫΪ�ۺ��
		table.setSelectionForeground(Color.MAGENTA);				// ��ѡ���е�ǰ��ɫΪ���
		table.setRowHeight(25);										// ���ñ����и�Ϊ25����
		scrollPane.setViewportView(table);
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);			// �������ӵ���������
		final JButton addButton = new JButton("����");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentFunction SF=new StudentFunction();
				  SF.setTitle("ѧ������ѡ��");
				  SF.StudentFunction("");
			}
		});
		panel.add(addButton);
	}
//	final JButton addButton = new JButton("�ύ");
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
//				Connection con=DriverManager.getConnection("jdbc:odbc:Homework");//�������ݿ�
//				java.sql.Statement sql=con.createStatement();//����sql���
//				while(tep!=0){
//					if(!data[i][3].equals("null")){
//						sql.executeUpdate("UPDATE Homework SET �� = '"+data[i][3]+"'WHERE ���� = '"+data[i][2]+"'");
//						sql.executeUpdate("UPDATE Homework SET  ������='"+answer+"'WHERE ���� = '"+data[i][2]+"'");
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
