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
	JButton    JB1 =new JButton("����");			//������ť����
	JButton    JB2  =new JButton("��ʼ");
	JButton    JB3  =new JButton("����");
	JPanel JP=new JPanel();
	 int i=0,j=0,k=0;
	 String answer;
	 public String ReEven="";
	public StudentOnline(){
		super();
//		JTextArea JTA1=new JTextArea();
//		JTextArea JTA2=new JTextArea();
//		JButton    JB1 =new JButton("����");			//������ť����
//		JButton    JB2  =new JButton("��ʼ");
//		JButton    JB3  =new JButton("����");
//		JPanel JP=new JPanel();
//		answer=Answer;
		setTitle("������");
		setBounds(500, 200, 500, 300);
		
		this.setTitle("onlineStudent�����ʴ�ϵͳ");			//���ô��ڱ���
//		this.setLayout(null);						//���ô��ڲ��ֹ�����
		JP.setLayout(null);
		JP.setBounds(0, 0, 500, 300);
		JTA1.setBounds(110,10,300,100);		//����������ǩ�ĳ�ʼλ��
		this.add(JTA1);						//��������ǩ�����ӵ�����
		JP.add(JTA1);	
		JTA2.setBounds(110,150,300,100);			//�����ı���ĳ�ʼλ��
		this.add(JTA2);						//���ı��������ӵ�����
		JP.add(JTA2);
		JB1.setBounds(300,110,60,20);				//���������ǩ�ĳ�ʼλ��
		this.add(JB1);							//�������ǩ�����ӵ�����
		JP.add(JB1);
		JB2.setBounds(150,110,80,20);				//���������ĳ�ʼλ��
		JB2.setBackground(new Color(200,200,1));
//		this.add(JB2 );							//������������ӵ�����
		JB3.setBounds(50,110,80,20);				//���������ǩ�ĳ�ʼλ��
		JB3.setBackground(new Color(200,200,1));
		this.add(JB3);							//�������ǩ�����ӵ�����
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
		this.setBounds(400,200,500,300);				//���ô��ڳߴ��С
		this.setVisible(true);						//���ô��ڵĿɼ���
		addWindowListener(new WindowAdapter()
                    { public void windowClosing(WindowEvent e)
                       {
                          System.exit(0);
                         }
                    });								//ͨ���ڲ�����д�رմ���ķ���
//		setSize(500,300);
//		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-getWidth()/2,150);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				// ���ô����Ĭ�Ϲر�ģʽ
//		final JScrollPane scrollPane = new JScrollPane();
//		getContentPane().add(scrollPane, BorderLayout.CENTER);
//		String[] columnNames = { "����", "������","����","��","�ش���" };	// ��������������
//		 try{
//			 Connection con=DriverManager.getConnection("jdbc:odbc:Ask");//�������ݿ�
//				java.sql.Statement sql=con.createStatement();//����sql���
//				ResultSet rs=sql.executeQuery("SELECT * from Ask");//ɸѡ�û���
//				while(rs.next()){
//					String r=rs.getString("����");
//					if(r!=null){j++;}}
//				System.out.println("j"+j);
//				data=new String[j][6];
//				rs=sql.executeQuery("SELECT * from Ask");
//				while(rs.next()){
////					String r=rs.getString("��");
////					if(r==null){
//						data[i][0]=rs.getDate("����")+"";//.getString("����");
//						data[i][1]=rs.getString("������");
//						data[i][2]=rs.getString("����");
//						data[i][3]=rs.getString("��");
//						data[i][4]=rs.getString("�ش���");
//						i++;
////					}
//				}
//				tableModel = new DefaultTableModel(data, columnNames);
//		 }catch(SQLException e1){e1.printStackTrace();}
//		table = new JTable(tableModel);								// ����ָ�����ģ�͵ı��
//		table.setRowSorter(new TableRowSorter(tableModel));			// ���ñ���������
//		// ѡ��ģʽ����Ϊ��ѡģʽ
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table.setSelectionBackground(Color.PINK);					// ��ѡ���еı���ɫΪ�ۺ��
//		table.setSelectionForeground(Color.MAGENTA);				// ��ѡ���е�ǰ��ɫΪ���
//		table.setRowHeight(25);										// ���ñ����и�Ϊ25����
//		scrollPane.setViewportView(table);
//		final JPanel panel = new JPanel();
//		getContentPane().add(panel, BorderLayout.SOUTH);			// �������ӵ���������
//		final JButton addButton = new JButton("�ύ");
//		addButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Object aa;
//				String straa;
//				i=0;
//				int tep=j;
//				String[] ReEvens=new String[j];
//				try{
//					i=0;
//					Connection con=DriverManager.getConnection("jdbc:odbc:Ask");//�������ݿ�
//					java.sql.Statement sql=con.createStatement();//����sql���
//					while(tep!=0){
//						aa=tableModel.getValueAt(i,3);
//						straa=aa+"";
//						if((!straa.equals(data[i][3]))&&(!"null".equals(data[i][3]+""))){
////							System.out.println(i+"�޸�");
//							data[i][3]=aa+"";
//							sql.executeUpdate("UPDATE Ask SET �� = '"+data[i][3]+"'WHERE ���� = '"+data[i][2]+"'");
//							sql.executeUpdate("UPDATE Ask SET �ش��� = '"+answer+"'WHERE ���� = '"+data[i][2]+"'");
//							ReEvens[i]=i+1+"���޸Ĵ�";
//							System.out.println(ReEvens[i]);
//						}
//						else if(!straa.equals(data[i][3]+"")&&"null".equals(data[i][3]+"")){
////							System.out.println(i+"���");
//							data[i][3]=aa+"";
//							sql.executeUpdate("UPDATE Ask SET �� = '"+data[i][3]+"'WHERE ���� = '"+data[i][2]+"'");
//							sql.executeUpdate("UPDATE Ask SET �ش��� = '"+answer+"'WHERE ���� = '"+data[i][2]+"'");
//							ReEvens[i]=i+1+"����Ӵ�";
//							System.out.println(ReEvens[i]);
//						}
////						else if(!straa.equals(data[i][3])&&"null".equals(straa)){
////							System.out.println(i+"ɾ��");
////							ReEvens[i]=i+1+"��ɾ����";
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
//				T.TiShi("��ʾ", ReEven, "����", "�˳�",answer);
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
