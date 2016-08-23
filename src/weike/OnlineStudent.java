package weike;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OnlineStudent extends JFrame implements ActionListener {
	
	JTextArea JTA1=new JTextArea();
	JTextArea JTA2=new JTextArea();
	JTextArea JTA3=new JTextArea();
	JButton    JB1 =new JButton("����");			//������ť����
	JButton    JB2  =new JButton("���ļ�");
	JButton    JB3  =new JButton("����");
	String ReName=new String(" ");
	public String ReEven;
	JPanel JP=new JPanel();
//	try{Socket s = new Socket("127.0.0.1", 5567);}catch(IOException d){d.printStackTrace();}
	
		public OnlineStudent()//
		{
			
			this.setTitle("onlineStudent�����ʴ�ϵͳ");			//���ô��ڱ���
//			this.setLayout(null);						//���ô��ڲ��ֹ�����
			JP.setLayout(null);
			JP.setBounds(0, 0, 500, 300);
			JTA1.setBounds(110,5,300,100);		//����������ǩ�ĳ�ʼλ��
			this.add(JTA1);						//��������ǩ�����ӵ�����
			JP.add(JTA1);	
			JTA2.setBounds(110,150,300,100);			//�����ı���ĳ�ʼλ��
			this.add(JTA2);						//���ı��������ӵ�����
			JP.add(JTA2);
			JTA3.setBounds(5,110,130,20);			//�����ı���ĳ�ʼλ��
			this.add(JTA3);						//���ı��������ӵ�����
			JP.add(JTA3);
			JB1.setBounds(300,110,60,20);				//���������ǩ�ĳ�ʼλ��
			this.add(JB1);							//�������ǩ�����ӵ�����
			JP.add(JB1);
			JB2.setBounds(150,110,80,20);				//���������ĳ�ʼλ��
			JB2.setBackground(new Color(200,200,1));
			this.add(JB2 );							//������������ӵ�����
			JB3.setBounds(400,110,80,20);				//���������ǩ�ĳ�ʼλ��
			JB3.setBackground(new Color(200,200,1));
			this.add(JB3);							//�������ǩ�����ӵ�����
			JP.add(JB3);
			JB1.addActionListener(this);				//����ť��Ӽ�����
			JB2.addActionListener(this);				//����ť��Ӽ�����
			JB3.addActionListener(this);	
			this.add(JP);
//			this.setBackground(Color.black);
//		    this.setBackground(new Color(200,200,2));
//		    this.getgraphics(setColor(255,200,200));
			this.setBounds(400,200,500,300);				//���ô��ڳߴ��С
			this.setVisible(true);						//���ô��ڵĿɼ���
			addWindowListener(new WindowAdapter()
	                    { public void windowClosing(WindowEvent e)
	                       {
	                          System.exit(0);
	                         }
	                    });								//ͨ���ڲ�����д�رմ���ķ���
			recive();

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
			while(true){
				if(i!=0){client =  ss.accept();}
				inFromClient = new DataInputStream(client.getInputStream());
				if(i==0){
					cache[i]=inFromClient.readUTF();
					str =cache[i];}
				else if(i>0&&i<5) {
					cache[i]=inFromClient.readUTF();
					str = str+"\n"+cache[i];
					}
				else if(i>=5){
			  		str="";
					cache[5]=inFromClient.readUTF();
					for(j=0;j<5;j++)
					{
						cache[j]=cache[j+1];
						str=str+cache[j]+"\n";
					}
				}
				System.out.println(str);
				JTA1.setText(str);
				i++;
			}
		}catch(IOException d){d.printStackTrace();}
	}
	public void actionPerformed(ActionEvent e){
//		while(true){
			JButton getbut=(JButton)e.getSource();
			if(e.getSource()==JB1){
				try{
					Socket s = new Socket("127.0.0.2", 5567);
//					if(i==0){}
					
					
					DataInputStream inFromServer = new DataInputStream(s.getInputStream());
					DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());

					
					
//				  if(e.getSource()==JB1){
					  String str =JTA2.getText();
					  outToServer.writeUTF(str);
					  outToServer.flush();
					  System.out.println("ow2");
//					  break;
						
//					}

				}catch(IOException d){d.printStackTrace();}
			}
			 if(e.getSource()==JB2){
//				 recive();
				 try{
					 String stri =JTA3.getText();
				 BufferedReader br = new BufferedReader(new FileReader(stri));;
				  
				  String outcache="";
				  String out="";
//				  br 
				  while((outcache=br.readLine())!=null){  
//			            System.out.println(line);  
//			            out.println(line);  
					  out=out+outcache;
			        }  
				  JTA2.setText(out+"");
				  
				 }catch(IOException d){d.printStackTrace();}
				}

			  if(e.getSource()==JB3){
					dispose();
					StudentFunction SF=new StudentFunction();
					  SF.setTitle("ѧ������ѡ��");
					  SF.StudentFunction("");
//				  break;
					
				}
//		}

		
	}
//	public static void main(String arg[]){
//		OnlineStudent os=new OnlineStudent();
////		os.OnlineStudent();
////		os.recive();
////		while(true){o2.Onlinewhile2();}
//		
//
//	}

}
