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
	 JLabel     JLUserName =new JLabel("�û�����");	//ʹ���ı�����һ����ǩ����
		JLabel     JLPaw =new JLabel("��    �룺");		//ʹ���ı�����һ����ǩ����
		JTextField JTUserName=new JTextField();			//����һ���ı������
		JPasswordField JPsw  =new JPasswordField();		//����һ����������
		JButton    JB1 =new JButton("��¼");			//������ť����
		JButton    JB2  =new JButton("ȥע��");
		JLabel     JL1  =new JLabel("��    ��:");		//ʹ���ı�����һ����ǩ����
		JComboBox  JC   =new JComboBox();				//����һ����Ͽ����
		JLabel imgLabel4;
		JLabel imgLabel;
		String ReName=new String(" ");
		public String ReEven;


		public void DengLuJieMian()//
		{
			this.setTitle("΢�λ���ϵͳ");			//���ô��ڱ���
			this.setLayout(null);						//���ô��ڲ��ֹ�����
			imgLabel4=new JLabel(new ImageIcon("image\\4.jpg")); 
			imgLabel4.setBounds(50,10,80,200);
			this.add(imgLabel4);
			imgLabel=new JLabel(new ImageIcon("image\\3.jpg")); 
			imgLabel.setBounds(330,50,150,100);
			this.add(imgLabel);
			JLUserName.setBounds(150,40,100,20);		//����������ǩ�ĳ�ʼλ��
			this.add(JLUserName);						//��������ǩ�����ӵ�����
			JTUserName.setBounds(250,40,80,20);			//�����ı���ĳ�ʼλ��
			this.add(JTUserName);						//���ı��������ӵ�����
			JLPaw.setBounds(150,100,60,20);				//���������ǩ�ĳ�ʼλ��
			this.add(JLPaw);							//�������ǩ�����ӵ�����
			JPsw.setBounds(250,100,80,20);				//���������ĳ�ʼλ��
			this.add(JPsw );							//������������ӵ�����
			JL1.setBounds(150,150,60,20);				//������ݱ�ǩ�ĳ�ʼλ��
			this.add(JL1);								//����ݱ�ǩ�����ӵ�����
			JC.setBounds(250,150,80,20);				//������Ͽ�ĳ�ʼλ��
			this.add(JC);								//����Ͽ������ӵ�����
			JC.addItem(new String("ѧ��"));				//����Ͽ��������
			JC.addItem(new String("��ʦ"));
			JB1.setBounds(150,200,60,20);				//���õ�¼��ť�ĳ�ʼλ��
			this.add(JB1);								//����¼��ť�����ӵ�����
			JB1.addActionListener(this);				//����ť��Ӽ�����
	        JB2.setBounds(250,200,80,20);				//����ȡ����ť�ĳ�ʼλ��
			this.add(JB2);								//��ȡ����ť����������
			JB2.addActionListener(this);				//����ť��Ӽ�����
			this.setVisible(true);						//���ô��ڵĿɼ���
		
			this.setBounds(400,200,500,300);				//���ô��ڳߴ��С
			addWindowListener(new WindowAdapter()
	                    { public void windowClosing(WindowEvent e)
	                       {
	                          System.exit(0);
	                         }
	                    });								//ͨ���ڲ�����д�رմ���ķ���
		}
		
		public String login(String name,String password,String shenfen){//��¼����
			//System.out.println("�������û���!");//��ʾ����
			//name=in.next();//������ĸ�ֵ��myInput
			//System.out.println("����������!");//��ʾ����
			//password=in.next();//�������븳ֵ
			
			try{//�쳣����
				Connection con=DriverManager.getConnection("jdbc:odbc:"+shenfen+"");//�������ݿ�
				java.sql.Statement sql=con.createStatement();//����sql���
				ResultSet rs=sql.executeQuery("SELECT ���� from "+shenfen+" where �û���='"+name+"'");//ɸѡ�û���
				if(rs.next()){//��������Ϊ��
					String mypassword=rs.getString("����");//�Ѹ÷���ֵ�����븳ֵ��myPassword
					if(mypassword.equals(password)){//�Աȿ���̨����ĺ����ݿ��������
//						System.out.println(name+"��½�ɹ�!");	//��ͬ �ɹ�
						ReEven=name+"��½�ɹ�!";
						return name;
					}
					else{//��ͬ
//						System.out.println("�������,��¼ʧ��!");//��¼ʧ��
						ReEven="�������,��¼ʧ��!";
					}
				}
				else{//Ϊ��
//					System.out.println("�û���û��!");//û�и��û�
					ReEven="�û���û��!";
				}
				sql.close();//�ѵ�ǰ�����ݿ�ر�
				con.close();//�رյ�ǰ����
			}catch(SQLException e1){e1.printStackTrace();}//����������� ׷�ٴ�ӡe1���ֵ�����
			return " ";
		}
	
	public void actionPerformed(ActionEvent e){
		JButton getbut=(JButton)e.getSource();
		if(e.getSource()==JB1){ 						//�����¼�¼�
			String rname=JTUserName.getText();		//���ı����а������ı������ַ���name
			String rpassword=new String(JPsw.getPassword());//��������а������ı������ַ���password
			String box= (String)JC.getSelectedItem();//����ǰ��ѡ����ַ���box
						//�ж����
				if(box.equals("ѧ��")){//ѡ��ѧ����ݵ�¼
					ReName=login(rname,rpassword,"StudentDate");
				}
				else if(box.equals("��ʦ")){//ѡ��ѧ����ݵ�¼
					ReName=login(rname,rpassword,"TeacherDate");
				}
				if(!ReName.equals(" ")){
					dispose();
					TiShi T=new TiShi();
					T.TiShi("��¼��ʾ", ReEven, "����", "�˳�",ReName);
				}
				else{
					dispose();
					TiShi T=new TiShi();
					T.TiShi("��¼��ʾ", ReEven, "��¼", "�˳�","");
				}
		}
		else if(e.getSource()==JB2){
			//���ע��ҳ��
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
