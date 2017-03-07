/*
 * ע���ࣺ
 * ���ܣ������ע�����û�
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//ע����̳�JFrameʵ��ActionListener�ӿ�
public class Regist extends JFrame implements ActionListener
{
	//����������
	private JPanel panel;//���
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JTextField textField;//
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private String filepath;
	private FileOperate file;//����һ���Զ�����ļ������ࣻ
	private final int num = 0,name=1, sex=2,id=3,phonenum=4,passwd=5,money=6,wflag=7; 
	private String [] inform;
	private String [] str;
	private int nowposition;

	public Regist(String filepath,String [] inform, int nowposition,FileOperate file) //���췽�����н�����Ƽ���ʼ������
	{
		this.inform = inform;
		this.nowposition = nowposition;
		this.file = file;
		this.filepath = filepath;//��ʼ������
		setTitle("���û�ע��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرղ���
		setBounds(500, 150, 519, 523);
		setResizable(false);//���ô����С���ɱ�
		panel = new JPanel();//ʵ����������
		panel.setBackground(new Color(153, 204, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		label = new JLabel("ע�� ����*��һ����д��Ϣ�󲻿��޸ģ��������д��");
		sl_panel.putConstraint(SpringLayout.NORTH, label, 10, 
				SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, label, -3, 
				SpringLayout.EAST, panel);
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(label);
		
		label_1 = new JLabel("���� ��");
		sl_panel.putConstraint(SpringLayout.NORTH, label_1, 28, 
				SpringLayout.SOUTH, label);
		label_1.setFont(new Font("����", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 87, 
				SpringLayout.WEST, panel);
		panel.add(label_1);
		
		label_2 = new JLabel("�û��� ��");
		sl_panel.putConstraint(SpringLayout.EAST, label_2, 0, 
				SpringLayout.EAST, label_1);
		label_2.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(label_2);
		
		label_3 = new JLabel("�Ա� ��");
		sl_panel.putConstraint(SpringLayout.NORTH, label_3, 121, 
				SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label_2, -6, 
				SpringLayout.NORTH, label_3);
		label_3.setFont(new Font("����", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.EAST, label_3, 0, 
				SpringLayout.EAST, label_1);
		panel.add(label_3);
		
		label_4 = new JLabel("���֤���� ��");
		label_4.setFont(new Font("����", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, label_4, 6, 
				SpringLayout.SOUTH, label_3);
		sl_panel.putConstraint(SpringLayout.EAST, label_4, 0, 
				SpringLayout.EAST, label_1);
		panel.add(label_4);
		
		label_5 = new JLabel("�ֻ����� ��");
		sl_panel.putConstraint(SpringLayout.NORTH, label_5, 25, 
				SpringLayout.SOUTH, label_4);
		sl_panel.putConstraint(SpringLayout.EAST, label_5, 0, 
				SpringLayout.EAST, label_1);
		label_5.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(label_5);
		
		label_6 = new JLabel("���� ��");
		sl_panel.putConstraint(SpringLayout.EAST, label_6, 0, 
				SpringLayout.EAST, label_1);
		label_6.setFont(new Font("����", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, label_6, 6, 
				SpringLayout.SOUTH, label_5);
		panel.add(label_6);
		
		label_7 = new JLabel("ȷ������ ��");
		sl_panel.putConstraint(SpringLayout.EAST, label_7, 0, 
				SpringLayout.EAST, label_1);
		label_7.setFont(new Font("����", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, label_7, 6, 
				SpringLayout.SOUTH, label_6);
		panel.add(label_7);
		
		label_8 = new JLabel("���δ����� ��");
		sl_panel.putConstraint(SpringLayout.EAST, label_8, 0, 
				SpringLayout.EAST, label_1);
		label_8.setFont(new Font("����", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, label_8, 7, 
				SpringLayout.SOUTH, label_7);
		panel.add(label_8);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 4, 
				SpringLayout.NORTH, label_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 6, 
				SpringLayout.EAST, label_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 141, 
				SpringLayout.EAST, label_1);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 4, 
				SpringLayout.NORTH, label_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 6, 
				SpringLayout.EAST, label_2);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		radioButton = new JRadioButton("��");
		radioButton.setSelected(true);
		sl_panel.putConstraint(SpringLayout.WEST, radioButton, 6, 
				SpringLayout.EAST, label_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, radioButton, 0, 
				SpringLayout.SOUTH, label_3);
		panel.add(radioButton);
		
		radioButton_1 = new JRadioButton("Ů");
		sl_panel.putConstraint(SpringLayout.WEST, radioButton_1, 6, 
				SpringLayout.EAST, radioButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, radioButton_1, 0, 
				SpringLayout.SOUTH, label_3);
		panel.add(radioButton_1);
		
		//��������Ϊһ�鰴ť����һ����⣨multiple-exclusion��������
		ButtonGroup bgsex = new ButtonGroup();
		bgsex.add(radioButton);
		bgsex.add(radioButton_1);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 9, 
				SpringLayout.SOUTH, radioButton);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 6, 
				SpringLayout.EAST, label_4);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, 4, 
				SpringLayout.NORTH, label_5);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 6, 
				SpringLayout.EAST, label_5);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, 0, 
				SpringLayout.EAST, textField);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField(20);
		sl_panel.putConstraint(SpringLayout.NORTH, passwordField, 4,
				SpringLayout.NORTH, label_6);
		sl_panel.putConstraint(SpringLayout.WEST, passwordField, 6, 
				SpringLayout.EAST, label_6);
		passwordField.setEchoChar('*');
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		sl_panel.putConstraint(SpringLayout.NORTH, passwordField_1, 4, 
				SpringLayout.NORTH, label_7);
		sl_panel.putConstraint(SpringLayout.WEST, passwordField_1, 6, 
				SpringLayout.EAST, label_7);
		sl_panel.putConstraint(SpringLayout.EAST, passwordField_1, 0, 
				SpringLayout.EAST, textField);
		passwordField_1.setColumns(20);
		passwordField_1.setEchoChar('*');
		panel.add(passwordField_1);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, 4, 
				SpringLayout.NORTH, label_8);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 6, 
				SpringLayout.EAST, label_8);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, -205, 
				SpringLayout.EAST, panel);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		label_9 = new JLabel("*");
		sl_panel.putConstraint(SpringLayout.WEST, label_9, 15, 
				SpringLayout.EAST, textField);
		label_9.setFont(new Font("����", Font.PLAIN, 15));
		label_9.setForeground(new Color(255, 0, 0));
		sl_panel.putConstraint(SpringLayout.SOUTH, label_9, 0, 
				SpringLayout.SOUTH, label_1);
		panel.add(label_9);
		
		label_10 = new JLabel("*");
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -15, 
				SpringLayout.WEST, label_10);
		sl_panel.putConstraint(SpringLayout.NORTH, label_10, 5, 
				SpringLayout.NORTH, label_2);
		sl_panel.putConstraint(SpringLayout.EAST, label_10, 0, 
				SpringLayout.EAST, label_9);
		label_10.setForeground(new Color(255, 0, 0));
		label_10.setFont(new Font("����", Font.PLAIN, 15));
		panel.add(label_10);
		
		label_11 = new JLabel("*");
		label_11.setFont(new Font("����", Font.PLAIN, 15));
		label_11.setForeground(new Color(255, 0, 0));
		sl_panel.putConstraint(SpringLayout.NORTH, label_11, 7, 
				SpringLayout.NORTH, label_3);
		sl_panel.putConstraint(SpringLayout.EAST, label_11, 0, 
				SpringLayout.EAST, label_9);
		panel.add(label_11);
		
		label_12 = new JLabel("*");
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, -15, 
				SpringLayout.WEST, label_12);
		label_12.setFont(new Font("����", Font.PLAIN, 15));
		label_12.setForeground(new Color(255, 0, 0));
		sl_panel.putConstraint(SpringLayout.NORTH, label_12, 7, 
				SpringLayout.NORTH, label_4);
		sl_panel.putConstraint(SpringLayout.EAST, label_12, 0, 
				SpringLayout.EAST, label_9);
		panel.add(label_12);
		
		button = new JButton("ע��");
		sl_panel.putConstraint(SpringLayout.NORTH, button, 47, 
				SpringLayout.SOUTH, label_8);
		sl_panel.putConstraint(SpringLayout.EAST, button, -310,
				SpringLayout.EAST, panel);
		button.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(button);
		button.addActionListener(this);//ע�ᰴť�����¼�
		
		button_1 = new JButton("����");
		sl_panel.putConstraint(SpringLayout.NORTH, button_1, 0, 
				SpringLayout.NORTH, button);
		button_1.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(button_1);
		button_1.addActionListener(this);//���ذ�ťע�����
		
		button_2 = new JButton("����");
		sl_panel.putConstraint(SpringLayout.WEST, button_1, 17,
				SpringLayout.EAST, button_2);
		sl_panel.putConstraint(SpringLayout.NORTH, button_2, 0, 
				SpringLayout.NORTH, button);
		sl_panel.putConstraint(SpringLayout.WEST, button_2, 14, 
				SpringLayout.EAST, button);
		button_2.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(button_2);
		button_2.addActionListener(this);//���ð�ťע�����
		
		label_13 = new JLabel("������6λ��������ȫһ����");
		sl_panel.putConstraint(SpringLayout.EAST, passwordField, -6,
				SpringLayout.WEST, label_13);
		sl_panel.putConstraint(SpringLayout.WEST, label_13, 304, 
				SpringLayout.WEST, panel);
		label_13.setFont(new Font("����", Font.PLAIN, 15));
		label_13.setForeground(new Color(255, 0, 0));
		sl_panel.putConstraint(SpringLayout.NORTH, label_13, 7, 
				SpringLayout.NORTH, label_6);
		panel.add(label_13);
		
		button_3 = new JButton("�˳�");
		button_3.setFont(new Font("����", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.SOUTH, button_3, 0, 
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_3, 0, 
				SpringLayout.EAST, label);
		panel.add(button_3);
		button_3.addActionListener(this);//�˳���ťע�����
	}
	
	//��дActionListener��actionPerformed����
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		if	(source == button)
		{
			buttonClick();//����ע�ᰴť�¼�
		}
		if	(source == button_1)
		{
			button_1Click();//���÷��ذ�ť�¼�
		}
		if	(source == button_2)
		{
			button_2Click();//�������ð�ť�¼�
		}
		if	(source == button_3)
		{
			button_3Click();//�����˳���ť�¼�
		}
	}
	
	private void buttonClick()//ע�ᰴť�¼�
	{
	//	file = new FileOperate(filepath);//ʵ����һ���Զ����ļ�������
		String unum = textField.getText();//��ÿ���
		String uname = textField_1.getText();//����û���
		String usex = "��";//����Ա�
		if	(radioButton.isSelected())
		{
			usex = "��";
		}
		if	(radioButton_1.isSelected())
		{
			usex = "Ů";
		}
		String uid = textField_2.getText();
		String uphone = textField_3.getText();
		String psw = new String(passwordField.getPassword());
		String upsw =file.cpassword(psw);//���뷴ת
		String urepsw = new String(passwordField_1.getPassword());
		String umoney = textField_4.getText();
		String strinform = new String(unum + "," + uname + "," + usex + "," + uid + "," 
								+ uphone + "," + upsw + "," + umoney + "," + "true");
		
		if	(unum.equals("") || uname.equals("") || usex.equals("") || uid.equals("") ||
			uphone.equals("") ||psw.equals("") ||urepsw.equals("") || umoney.equals(""))
		{
			//��֪�û�ĳ���ѷ���
			JOptionPane.showMessageDialog(button, "ע�����ݱ���ȫ����д������д������", "��ʾ", 
									JOptionPane.WARNING_MESSAGE);
		}
		else if (psw.length() < 6)
		{
			JOptionPane.showMessageDialog(button, "������������6λ����", "��ʾ", 
					JOptionPane.WARNING_MESSAGE);
		}
		else if	(psw.equals(urepsw) != true)
		{
			JOptionPane.showMessageDialog(button, "����ȷ��ʧ�ܣ�", "��ʾ", 
					JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			try
			{
				String str1 = null;//����ļ��ж�ȡ���ַ���
				file.openread();//Ϊ�����ļ�
				while	(null != (str1 =file.read()))
				{
					str = file.getinform(str1);
					if	(unum.equals(str[num]))
					{
						JOptionPane.showMessageDialog(button, "�û��Ѵ��ڣ�ע��ʧ�ܣ�", "��ʾ", 
													JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				file.closeread();//�ر��ļ�
				if	(str1 == null)
				{		
					file.openwrite();//Ϊд���ļ�
					file.write(strinform);
					file.closewrite();//�ر��ļ�
					JOptionPane.showMessageDialog(button, "ע��ɹ�!", "��ʾ", 
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			catch (Exception e1)
			{
				System.out.println(e1);
			}
		}
		
	}
	
	private void button_1Click()//���ذ�ť�¼�
	{
		this.setVisible(false);//���ص�ǰ����
		EventQueue.invokeLater(new Runnable() //ʵ������������
		{
			public void run() //��дRunnable��run����
			{
				try //��׽�쳣
				{
					Login frame = new Login();//ʵ����Login�����
					frame.setVisible(true);//�ö���ɿ���
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	private void button_2Click()//���ð�ť�¼�
	{
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
		radioButton.setSelected(true);
	}
	private void button_3Click()//�˳���ť�¼�
	{
		this.setVisible(false);//���ص�ǰ����
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Regist regist = new Regist(filepath,inform, nowposition,file);
					Exit exit = new Exit(regist,inform, nowposition,file);//ת���˳�����
					exit.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
