/*
 * ����ѯ�ࣺ
 * ���ܣ�ʵ�����Ĳ�ѯ����ת�������ࡣ
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//����ѯ��̳д���ʵ��ActionListener�ӿ�
public class Balance extends JFrame implements ActionListener
{
	//����������
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblName;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private String [] inform;
	private String [] str;
	private int nowposition;
	private final int num = 0,name=1, sex=2,id=3,phonenum=4,passwd=5,money=6,wflag=7; 
	private FileOperate file;
	
	
	public Balance(String [] inform, int nowposition,FileOperate file) //�ڹ��췽����ʵ�ֽ������
	{
		this.inform = inform;
		this.nowposition = nowposition;
		this.file = file;
		str = file.getinform(inform[nowposition]);
		setTitle("����ѯ");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرղ���
		setBounds(500, 150, 366, 461);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setResizable(false);//���ô����С���ɱ�
		
		panel = new JPanel();//���������
		panel.setBackground(new Color(153, 204, 255));//��屳����ɫ
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();//���λ������
		panel.setLayout(sl_panel);
		
		label = new JLabel("�û��� :");//ʵ������ǩ����
		//��ǩλ�����ã������÷�������SpringLayout���֣��˲����������������
		//��������λ��
		sl_panel.putConstraint(SpringLayout.NORTH, label, 47, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, label, 63,
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, label, -189, 
								SpringLayout.EAST, panel);
		label.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(label);//������"�û���"��ǩ
		
		label_1 = new JLabel("��ǰ���Ϊ :");//ʵ������ǩ����
		//��ǩλ������
		sl_panel.putConstraint(SpringLayout.NORTH, label_1, 24, 
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 18, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, label_1, 0, 
								SpringLayout.EAST, label);
		label_1.setFont(new Font("����", Font.PLAIN, 24));
		panel.add(label_1);//��������ǩ�����
		
		button = new JButton("���");//ʵ������ť����
		//��ťλ������
		sl_panel.putConstraint(SpringLayout.WEST, button, 0, 
							SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button, -241,
							SpringLayout.EAST, panel);
		button.setFont(new Font("����", Font.PLAIN, 24));
		panel.add(button);//��������ť�����
		button.addActionListener(this);//ע�����
		
		button_1 = new JButton("ȡ��");//ʵ������ť����
		//��ťλ������ 
		sl_panel.putConstraint(SpringLayout.SOUTH, button, -47, 
							SpringLayout.NORTH, button_1);
		sl_panel.putConstraint(SpringLayout.WEST, button_1, 0, 
							SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_1, 0, 
							SpringLayout.EAST, button);
		button_1.setFont(new Font("����", Font.PLAIN, 24));
		panel.add(button_1);//��������ť�����
		button_1.addActionListener(this);//ע�����
		
		button_2 = new JButton("�˳�");//ʵ������ť����
		//��ťλ������ 
		sl_panel.putConstraint(SpringLayout.SOUTH, button_1, -49, 
							SpringLayout.NORTH, button_2);
		sl_panel.putConstraint(SpringLayout.WEST, button_2, 0, 
							SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_2, 0, 
							SpringLayout.EAST, button);
		button_2.setFont(new Font("����", Font.PLAIN, 24));
		panel.add(button_2);//��������ť�����
		button_2.addActionListener(this);//ע�����
		
		button_3 = new JButton("�޸���Ϣ");
		button_3.setFont(new Font("����", Font.PLAIN, 24));
		sl_panel.putConstraint(SpringLayout.EAST, button_3, 0, 
								SpringLayout.EAST, panel);
		panel.add(button_3);
		button_3.addActionListener(this);
		
		button_4 = new JButton("�˺�ά��");//ʵ������ť����
		sl_panel.putConstraint(SpringLayout.NORTH, button_4, 300, 
				SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, button_3, -47, 
				SpringLayout.NORTH, button_4);
		button_4.setFont(new Font("����", Font.PLAIN, 24));
		sl_panel.putConstraint(SpringLayout.EAST, button_4, 0, 
				SpringLayout.EAST, button_3);
		panel.add(button_4);//��������ť�����
		button_4.addActionListener(this);//ע�����
		
		button_5 = new JButton("��������");
		sl_panel.putConstraint(SpringLayout.NORTH, button_2, 0, 
				SpringLayout.NORTH, button_5);
		button_5.setFont(new Font("����", Font.PLAIN, 24));
		sl_panel.putConstraint(SpringLayout.SOUTH, button_5, 0, 
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_5, 0, 
				SpringLayout.EAST, panel);
		panel.add(button_5);
		button_5.addActionListener(this);
		
		lblName = new JLabel(str[name]);//ʵ������ǩ����
		sl_panel.putConstraint(SpringLayout.NORTH, lblName, 11, 
				SpringLayout.NORTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, lblName, 6, 
				SpringLayout.EAST, label);
		panel.add(lblName);
		
		label_2 = new JLabel(str[money]);
		//��ǩ����λ������
		sl_panel.putConstraint(SpringLayout.WEST, label_2, 6, 
				SpringLayout.EAST, label_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, label_2, 0, 
				SpringLayout.SOUTH, label_1);
		panel.add(label_2);//��ӱ�ǩ�������
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if	(source == button)
		{
			if	(str[wflag].equals("true"))
			{
				buttonClick();//���ô�ť�¼�
			}
			else
			{
				JOptionPane.showMessageDialog(button, "����ͣ���񣬲��ܽ��д�ȡ���޸Ĳ�����", "��ʾ", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_1)
		{
			if	(str[wflag].equals("true"))
			{
				button_1Click();//����ȡ�ť�¼�
			}
			else
			{
				JOptionPane.showMessageDialog(button_1, "����ͣ���񣬲��ܽ��д�ȡ���޸Ĳ�����", "��ʾ", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_2)
		{
			button_2Click();//�����˳���ť�¼�
		}
		if	(source == button_3)
		{
			if	(str[wflag].equals("true"))
			{
				button_3Click();//�����޸���Ϣ��ť�¼�
			}
			else
			{
				JOptionPane.showMessageDialog(button_3, "����ͣ���񣬲��ܽ��д�ȡ���޸Ĳ�����", "��ʾ", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_4)
		{
			button_4Click();//�����˺�ά����ť�¼�
		}
		if	(source == button_5)
		{
			button_5Click();//���û������水ť�¼�
		}
	}
	
	private void buttonClick()//��ť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//���������
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Deposit deposit = new Deposit(inform, nowposition,file);
					deposit.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	private void button_1Click()//ȡ�ť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//����ȡ�����
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					RemoveMoney removemoney = new RemoveMoney(inform, nowposition,file);
					removemoney.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	private void button_2Click()//�˳���ť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//�����˳�����
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Balance balance = new Balance(inform, nowposition,file);
					Exit exit = new Exit(balance,inform, nowposition,file);
					exit.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	private void button_3Click()//�޸���Ϣ��ť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//�����޸���Ϣ����
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ModifyInform modifyif = new ModifyInform(inform, nowposition,file);
					modifyif.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	private void button_4Click()//�˺�ά����ť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//�����˺�ά������
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Service service = new Service(inform, nowposition,file);
					service.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	private void button_5Click()//�������水ť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//����������
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainInterface maininface = new MainInterface(inform, nowposition,file);
					maininface.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
