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
	 JLabel     JLUserName =new JLabel("�û�����");	//ʹ���ı�����һ����ǩ����
		JLabel     JLPaw =new JLabel("��    �룺");		//ʹ���ı�����һ����ǩ����
		JLabel     JLGrade =new JLabel("�����꼶��");		//ʹ���ı�����һ����ǩ����
		JComboBox  JCGrade   =new JComboBox();
		JTextField JTUserName=new JTextField();			//����һ���ı������
		JPasswordField JPsw  =new JPasswordField();		//����һ����������
		JLabel     JL1  =new JLabel("��    ��:");		//ʹ���ı�����һ����ǩ����
		JComboBox  JCShenFen   =new JComboBox();				//����һ����Ͽ����
		JButton    JB1 =new JButton("���ע��");			//������ť����
//		String ReName=new String(" ");
		public String ReEven;
		
		public void ZhuCe()//
		{
			this.setTitle("�û�ע��");			//���ô��ڱ���
			this.setLayout(null);						//���ô��ڲ��ֹ�����
			JLUserName.setBounds(150,40,80,20);		//����������ǩ�ĳ�ʼλ��
			this.add(JLUserName);						//��������ǩ�����ӵ�����
			JTUserName.setBounds(250,40,80,20);			//�����ı���ĳ�ʼλ��
			this.add(JTUserName);						//���ı��������ӵ�����
			JLPaw.setBounds(150,80,80,20);				//���������ǩ�ĳ�ʼλ��
			this.add(JLPaw);							//�������ǩ�����ӵ�����
			JPsw.setBounds(250,80,80,20);				//���������ĳ�ʼλ��
			this.add(JPsw );							//������������ӵ�����
			JLGrade.setBounds(150,120,80,20);				//���������ĳ�ʼλ��
			this.add(JLGrade );							//������������ӵ�����
			JCGrade.setBounds(250,120,80,20);				//���������ĳ�ʼλ��
			JCGrade.addItem(new String("��һ"));				//����Ͽ��������
			JCGrade.addItem(new String("���"));
			JCGrade.addItem(new String("����"));
			JCGrade.addItem(new String("����"));
			this.add(JCGrade );							//������������ӵ�����
			JL1.setBounds(150,160,60,20);				//������ݱ�ǩ�ĳ�ʼλ��
			this.add(JL1);								//����ݱ�ǩ�����ӵ�����
			JCShenFen.setBounds(250,160,80,20);				//������Ͽ�ĳ�ʼλ��
			this.add(JCShenFen);								//����Ͽ������ӵ�����
			JCShenFen.addItem(new String("ѧ��"));				//����Ͽ��������
			JCShenFen.addItem(new String("��ʦ"));
			JB1.setBounds(180,200,100,20);				//���õ�¼��ť�ĳ�ʼλ��
			this.add(JB1);								//����¼��ť�����ӵ�����
			JB1.addActionListener(this);				//����ť��Ӽ�����
	    		//����ť��Ӽ�����
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
			if(e.getSource()==JB1){
				String rname=JTUserName.getText();		//���ı����а������ı������ַ���name
				String rpassword=new String(JPsw.getPassword());//��������а������ı������ַ���password
				String rgrade=(String)JCGrade.getSelectedItem();
				String rshen=(String)JCShenFen.getSelectedItem();
				int nametest=0;
				if(rshen.equals("ѧ��")){
					try{
						Connection con=DriverManager.getConnection("jdbc:odbc:StudentDate");//�������ݿ�
						java.sql.Statement sql=con.createStatement();//����sql���
						ResultSet rs=sql.executeQuery("SELECT * from StudentDate");
						while(rs.next()){
							if(rname.equals(rs.getString("�û���"))){
								nametest++;
							}
						}
						if(nametest==0){
							sql.executeUpdate("INSERT INTO StudentDate values ('"+rname+"','"+rpassword+"','"+rgrade+"')");//ɸѡ�û���
							ReEven="ע��ɹ�";
							dispose();
							TiShi T=new TiShi();
							T.TiShi("ע����ʾ", ReEven, "��¼", "�˳�","");
						}
						else{
							ReEven="ע��ʧ�ܣ��û����Ѵ��ڣ�";
							dispose();
							TiShi T=new TiShi();
							T.TiShi("ע����ʾ", ReEven, "ȥע��", "�˳�","");
						}
					}catch(SQLException e1){e1.printStackTrace();}
				}
				else if(rshen.equals("��ʦ")){
					try{
						Connection con=DriverManager.getConnection("jdbc:odbc:TeacherDate");//�������ݿ�
						java.sql.Statement sql=con.createStatement();//����sql���
						ResultSet rs=sql.executeQuery("SELECT * from TeacherDate");
						while(rs.next()){
							if(rname.equals(rs.getString("�û���"))){
								nametest++;
							}
						}
						if(nametest==0){
							sql.executeUpdate("INSERT INTO TeacherDate values ('"+rname+"','"+rpassword+"','"+rgrade+"')");//ɸѡ�û���
							ReEven="ע��ɹ�";
							dispose();
							TiShi T=new TiShi();
							T.TiShi("ע����ʾ", ReEven, "��¼", "�˳�","");
						}
						else{
							ReEven="ע��ʧ�ܣ��û����Ѵ��ڣ�";
							dispose();
							TiShi T=new TiShi();
							T.TiShi("ע����ʾ", ReEven, "ȥע��", "�˳�","");
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
