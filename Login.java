/*
 * ��¼�ࣺ
 * ���ܣ��������ڣ���ͨ���������������������������������δ���󣬸��û���ͣ����
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener//��¼���������JFrame
{
	private JTextField textField; //�ı�������
	private JPasswordField passwordField;//���������
	private JPanel panel;//�������
	private JLabel label;//��ǩ����
	private JLabel label_1;
	private JButton button;//��ť����
	private JButton button_1;
	private JButton button_2;
	private String filepath;//�ļ�·��
	private FileOperate file;//����һ���Զ�����ļ������ࣻ	
	private final int num = 0,name=1, sex=2,id=3,phonenum=4,passwd=5,money=6,wflag=7; 
	private int nowposition = 0;//�ͻ���Ϣ���ļ��еĵ�ǰλ��
	private String [] inform = new String[10];//�洢�ͻ���Ϣ
	private String [] str;//ÿ���û���Ϣ
	private static  int	count = 3;//��¼����

	public Login() 
	{
		//����ļ�·��
		filepath = new String("F:/javafile/file.txt");
		//�ļ�������ʼ
		file = new FileOperate(filepath);
		String isempty;
		file.openread();
		isempty = file.read();
		file.closeread();
		if	(null == isempty)
		{
			String fstr = "123456" + "," + "123456" + "," +"��" + "," +"123456" + 
				"," +"123456" + "," +"654321" + "," +"10000" + "," +"true";
			
		file.openwrite();
		file.write(fstr);
		file.closewrite();
		}
		
		this.setResizable(false);//���ô����С���ɸı�
		this.setTitle("��¼");//���ô������Ͻǵ�����Ϊ��¼
		this.setBounds(500, 150, 444, 292);//���ô�������Ļ�е�λ�ü������С
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĭ�ϵĹرղ���
		
		panel = new JPanel();//ʵ�����������1
		panel.setBackground(new Color(153, 204, 255));//���������ɫ
		getContentPane().add(panel, BorderLayout.CENTER);//�����ӵ���ǰ����
		SpringLayout sl_panel = new SpringLayout();//ʵ��������SprinLayout����
		panel.setLayout(sl_panel);//���1���SpringLayout����
		
		label = new JLabel("���� ��");//ʵ������ǩ�����š�
		sl_panel.putConstraint(SpringLayout.NORTH, label, 39,
								SpringLayout.NORTH, panel);//����ǩ�����š��ı��������ı��߹̶�����39
		label.setFont(new Font("����", Font.PLAIN, 20));//���ñ�ǩ��������
		panel.add(label);//��ӱ�ǩ�����1
		
		label_1 = new JLabel("���� ��");
		sl_panel.putConstraint(SpringLayout.NORTH, label_1, 29,
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 0, 
								SpringLayout.WEST, label);
		label_1.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(label_1);
		
		textField = new JTextField();//ʵ�����ı���
		//�ı���λ������
		sl_panel.putConstraint(SpringLayout.EAST, label, -6, 
								SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, 8, 
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 39,
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 165,
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -93,
								SpringLayout.EAST, panel);
		panel.add(textField);//����ı������1
		textField.setColumns(10);//�����ı����С
		
		passwordField = new JPasswordField();//ʵ���������
		passwordField.setColumns(20);//����������С
		passwordField.setEchoChar('*');//����Ҫ���ڻ��Ե��ַ���
		sl_panel.putConstraint(SpringLayout.NORTH, passwordField, -1, 
								SpringLayout.NORTH, label_1);
		sl_panel.putConstraint(SpringLayout.WEST, passwordField, 6, 
								SpringLayout.EAST, label_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, passwordField, 31, 
								SpringLayout.NORTH, label_1);
		sl_panel.putConstraint(SpringLayout.EAST, passwordField, 0,
								SpringLayout.EAST, textField);
		panel.add(passwordField);//�����������1
		
		button = new JButton("��¼");//ʵ������ť"��¼"
		button.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(button);
		button.addActionListener(this);//��¼��ťע�����

		button_1 = new JButton("�˳�");
		sl_panel.putConstraint(SpringLayout.SOUTH, button_1, 0, 
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_1, 0, 
								SpringLayout.EAST, panel);
		button_1.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(button_1);
		button_1.addActionListener(this);//�˳���ťע�����
		
		button_2 = new JButton("ע��");
		sl_panel.putConstraint(SpringLayout.NORTH, button_2, 36, 
								SpringLayout.SOUTH, passwordField);
		sl_panel.putConstraint(SpringLayout.WEST, button_2, 232, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, button, 0, 
								SpringLayout.NORTH, button_2);
		sl_panel.putConstraint(SpringLayout.EAST, button, -6, 
								SpringLayout.WEST, button_2);
		button_2.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(button_2);
		button_2.addActionListener(this);//ע�ᰴťע�����
	}
	//��дActionListener��actionPerformed����
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if	(source == button)
		{
			buttonClick();
		}
		if	(source == button_1)
		{
			button_1Click();
		}
		if	(source == button_2)
		{
			button_2Click();
		}
	}
	
	private int buttonClick()//��¼��ť�¼�����
	{
		int nowposition = 0;
		String unum = textField.getText();//���ı����е����ݸ���unum
		String upassword = new String(passwordField.getPassword());
		int i = 0;
		file.openread();
		while	(null != (inform[i] = file.read()))//�������ļ��ڵ���Ϣ����
		{
			i++;
		}
		file.closeread();
		
		if	(unum.equals(""))//����Ϊ��
		{
			//��֪�û�ĳ���ѷ���
			JOptionPane.showMessageDialog(button, "���Ų���Ϊ��", "��ʾ", 
										JOptionPane.WARNING_MESSAGE);
		}
		else if	(upassword.equals(""))//����Ϊ��
		{
			JOptionPane.showMessageDialog(button, "���벻��Ϊ��", "��ʾ", 
										JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			
			String  str1 = null;//�洢һ����Ա����Ϣ
			i = 0;
			while	(null != inform[i])
			{
				str = file.getinform(inform[i]);
				if	(unum.equals(str[num]))
				{
					break;
				}
				i++;
				nowposition++;
			}
			if	(null == inform[i])
			{
				JOptionPane.showMessageDialog(button, "���û������ڣ�", "��ʾ",
										JOptionPane.INFORMATION_MESSAGE);
			}
			if	(unum.equals(str[num]))
			{
				str1 = file.cpassword(str[passwd]);
				
				if	(upassword.equals(str1))
				{
					inform[nowposition] = str[num] + "," + str[name] + "," +str[sex] + "," +str[id] + 
					"," +str[phonenum] + "," +str1 + "," +str[money] + "," +str[wflag];
					this.setVisible(false);
					MainInterface maininterface = new MainInterface(inform, nowposition,file);
					maininterface.setVisible(true);
					return 0;
				}
				else
				{
					count--;
					if	(count > 0)
					{
						JOptionPane.showMessageDialog(button, "����������󣬻���" + count + "�λ��ᣡ", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						str[wflag] = "false";
						inform[nowposition] = str[num] + "," + str[name] + "," +str[sex] + "," +
											str[id] + "," +str[phonenum] + "," +str[passwd] + "," +
											str[money] + "," +str[wflag];
						JOptionPane.showMessageDialog(button, "3��������������˻�����ͣ�������Զ��˳�", "��ʾ",
								JOptionPane.INFORMATION_MESSAGE);
						Update update = new Update(inform, nowposition, file);
						file.deletefile();
						update.update();
						this.setVisible(false);
					
					}
					
				}
			}
				
		}
			
		return 0;
	}
	private void button_1Click()//�˳���ť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//�����˳�����
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Login login = new Login();
					Exit frame = new Exit(login,inform,nowposition, file);
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	private void button_2Click()//ע�ᰴť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
//		����ע�������棻���� runnable �� run 
//		������ the system EventQueue ��ָ���߳��б����á�
//		�����й����¼��������ŷ��������ⷢ��֮ǰ���ñ�������
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Regist frame = new Regist(filepath,inform, nowposition,file);
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String [] args)
	{
		Login login = new Login();
		login.setVisible(true);
	}	
}
