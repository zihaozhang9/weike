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
//	private DefaultTableModel tableModel;							// ������ģ�Ͷ���
//	private JTable table;											// ���������
//	JTextField textField1;
//	JFrame J=new JFrame();
//	JPanel P=new JPanel();
	JScrollPane scrollpane=new JScrollPane();
	JLabel  JLDate=new JLabel("����");
	JLabel  Date=new JLabel("����");
	JLabel  JLQuestion=new JLabel("����");
	JTextField JTQuestion=new JTextField();
	JButton JBHand=new JButton("�ύ");
//		String ReName=new String(" ");
		public String ReEven;
		public String name;
		public void AskQuestion(String ReName)//map
		{
			name=ReName;
			this.setTitle("ѧ��������");			//���ô��ڱ���
			this.setLayout(null);						//���ô��ڲ��ֹ�����
			JLDate.setBounds(100, 20, 80, 20);		//����������ǩ�ĳ�ʼλ��
			this.add(JLDate);						//��������ǩ�����ӵ�����
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date.setText(df.format(new Date()));
			Date.setBounds(100, 80, 100, 40);			//�����ı���ĳ�ʼλ��
			this.add(Date);						//���ı��������ӵ�����
			JLQuestion.setBounds(200, 20, 80, 20);				//���������ǩ�ĳ�ʼλ��
			this.add(JLQuestion);							//�������ǩ�����ӵ�����
			JTQuestion.setBounds(200, 80,200, 60);				//���������ĳ�ʼλ��
			this.add(JTQuestion );							//������������ӵ�����
			JBHand.setBounds(200, 200, 80, 20);				//���������ĳ�ʼλ��
			this.add(JBHand );							//������������ӵ�����
			JBHand.addActionListener(this);				//����ť��Ӽ�����
			this.setVisible(true);						//���ô��ڵĿɼ���
		
			this.setBounds(400,200,500,300);				//���ô��ڳߴ��С
			addWindowListener(new WindowAdapter()
	                    { public void windowClosing(WindowEvent e)
	                       {
	                          System.exit(0);
	                         }
	                    });								//ͨ���ڲ�����д�رմ���ķ���
		}
		
	public void actionPerformed(ActionEvent e){
		JButton getbut=(JButton)e.getSource();
		if(e.getSource()==JBHand){
			try{

				Connection con=DriverManager.getConnection("jdbc:odbc:Ask");//�������ݿ�
				java.sql.Statement sql=con.createStatement();//����sql���
				ResultSet rs=sql.executeQuery("SELECT * from Ask ");//ɸѡ�û���
				String question=JTQuestion.getText()+"";
				int q=0;
				while(rs.next()){
					if(question==rs.getString("����")){q++;}
				}
				if(q==0){
					sql.executeUpdate("INSERT INTO Ask(����,����,������) values ('"+Date.getText()+"','"+question+"','"+name+"')");
					ReEven="���ʳɹ�";
				}
				else{
					ReEven="������ڣ����ʲ��ɹ�";
				}
				dispose();
				TiShi T=new TiShi();
				T.TiShi("��ʾ", ReEven, "����", "�˳�",name);
			}catch(SQLException e1){e1.printStackTrace();}
		}
	}
//	public static void main(String[] args) {
////		new AskQuestion().setVisible(true);
//		AskQuestion A=new AskQuestion();
//		A.AskQuestion("li");
//	}

	                                                                         
}
