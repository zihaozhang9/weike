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

public class TiShi extends JFrame implements ActionListener {//��ʾ����
	 JLabel     JTiShi =new JLabel("����ѡ��");
	 JButton    JB1 =new JButton("��¼");			//������ť����
	 JButton    JB2  =new JButton("ȥע��");
//	 JComboBox  JC   =new JComboBox();				//����һ����Ͽ����
	 String name;
	public void TiShi(String title,String shuoming,String JB1shuoming,String JB2shuoming,String ReName){
		name=ReName;
		this.setTitle(title);			//���ô��ڱ���
		this.setLayout(null);						//���ô��ڲ��ֹ�����
		JTiShi.setText(shuoming);
		JTiShi.setBounds(150,40,300,20);		//����������ǩ�ĳ�ʼλ��
		this.add(JTiShi);						//��������ǩ�����ӵ�����
//		JC.setBounds(200,150,80,20);				//������Ͽ�ĳ�ʼλ��
//		this.add(JC);								//����Ͽ������ӵ�����
		JB1.setText(JB1shuoming);
		JB1.setBounds(150,100,80,60);				//���õ�¼��ť�ĳ�ʼλ��
		this.add(JB1);								//����¼��ť�����ӵ�����
		JB1.addActionListener(this);				//����ť��Ӽ�����
		JB2.setText(JB2shuoming);
		JB2.setBounds(250,100,80,60);				//����ȡ����ť�ĳ�ʼλ��
		this.add(JB2);								//��ȡ����ť����������
		JB2.addActionListener(this);				//����ť��Ӽ�����
		this.setVisible(true);						//���ô��ڵĿɼ���
		this.setBounds(400,200,500,300);				//���ô��ڳߴ��С
		addWindowListener(new WindowAdapter()
                    { public void windowClosing(WindowEvent e)
                       {
                          System.exit(0);
                         }
                    });								//ͨ���ڲ�����д�رմ���
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JB1&&JB1.getText().equals("ȥע��")){
			dispose();
			ZhuCe Z=new ZhuCe();
			Z.ZhuCe();
		}
		else if(e.getSource()==JB1&&JB1.getText().equals("��¼")){
			dispose();
			Denglu D=new Denglu();
			D.DengLuJieMian();
		}
		else if(e.getSource()==JB1&&JB1.getText().equals("����")){
			try{
				Connection con=DriverManager.getConnection("jdbc:odbc:StudentDate");//�������ݿ�
				java.sql.Statement sql=con.createStatement();//����sql���
				ResultSet rs=sql.executeQuery("SELECT * from StudentDate");//ɸѡ�û���
				int test=0;
				while(rs.next()){
					if(name.equals(rs.getString("�û���"))){test++;}
				}
				if(test==0){
					dispose();
					TeacherFunction F=new TeacherFunction();
					F.setTitle("����ѡ��");
					F.TeacherFunction(name);
				}
				else{
					dispose();
					StudentFunction F=new StudentFunction();
					F.setTitle("����ѡ��");
					F.StudentFunction(name);					
				}
			}catch(SQLException e1){e1.printStackTrace();}
		}
		else if(e.getSource()==JB2&&JB2.getText().equals("�˳�")){
			System.exit(0);
		}
	}
	
//	public static void main(String arg[]){
//		TiShi T=new TiShi();
//		T.TiShi("ע����ʾ", "ע����ʾ", "��¼", "�˳�","");
//		
//	}
}
