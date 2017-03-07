/*
 * �������ࣺ
 * ���ܣ���¼�ɹ��󣬿�ͨ���ý�������������档
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//��������̳�JFrameʵ��ActionListener�ӿ�
public class MainInterface extends JFrame implements ActionListener
{
	//����������
	private JPanel panel;
	private JLabel lblatm;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private final int num = 0,name=1, sex=2,id=3,phonenum=4,passwd=5,money=6,wflag=7; 
	private String [] inform;
	private String [] str;
	private int nowposition;
	private FileOperate file;

	public MainInterface(String [] inform, int nowposition,FileOperate file) //�����������
	{
		this.inform = inform;//�û���Ϣ
		this.nowposition = nowposition;//�û���Ϣ���ļ��е�λ��
		this.file = file;
		str = file.getinform(inform[nowposition]);
		setResizable(false);//���ô����С���ɱ�
		setTitle("������");//���ô������Ͻǵ�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرղ���
		setBounds(500, 150, 489, 387);
		
		panel = new JPanel();//ʵ����������
		panel.setBackground(new Color(153, 204, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		lblatm = new JLabel("��ӭʹ��ATM�Զ�����");//ʵ������ǩ����
		sl_panel.putConstraint(SpringLayout.NORTH, lblatm, 34, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblatm, -78, 
								SpringLayout.EAST, panel);
		lblatm.setFont(new Font("����", Font.PLAIN, 30));
		panel.add(lblatm);//��ӱ�ǩ��������
		
		button = new JButton("����ѯ");
		sl_panel.putConstraint(SpringLayout.EAST, button, 0, 
								SpringLayout.EAST, panel);
		button.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(button);//��Ӱ�ť��������
		button.addActionListener(this);//ע�����
		
		button_1 = new JButton("��Ϣ�޸�");
		sl_panel.putConstraint(SpringLayout.SOUTH, button, -24, 
								SpringLayout.NORTH, button_1);
		sl_panel.putConstraint(SpringLayout.EAST, button_1, 0, 
								SpringLayout.EAST, button);
		button_1.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(button_1);
		button_1.addActionListener(this);
		
		button_2 = new JButton("�˺�ά��");
		sl_panel.putConstraint(SpringLayout.SOUTH, button_2, 0, 
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_2, 0, 
								SpringLayout.EAST, panel);
		button_2.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(button_2);
		button_2.addActionListener(this);
		
		button_3 = new JButton("ȡ��");
		sl_panel.putConstraint(SpringLayout.WEST, button_3, 0, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_3, -207, 
								SpringLayout.WEST, button);
		button_3.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(button_3);
		button_3.addActionListener(this);
		
		button_4 = new JButton("���");
		sl_panel.putConstraint(SpringLayout.NORTH, button_1, 0, 
								SpringLayout.NORTH, button_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, button_3, -24, 
								SpringLayout.NORTH, button_4);
		sl_panel.putConstraint(SpringLayout.WEST, button_4, 0, 
								SpringLayout.WEST, button_3);
		button_4.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(button_4);
		button_4.addActionListener(this);
		
		button_5 = new JButton("�˳�");
		sl_panel.putConstraint(SpringLayout.SOUTH, button_4, -17,
								SpringLayout.NORTH, button_5);
		sl_panel.putConstraint(SpringLayout.EAST, button_4, 0, 
								SpringLayout.EAST, button_5);
		sl_panel.putConstraint(SpringLayout.WEST, button_5, 0, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, button_5, 0, 
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_5, 133, 
								SpringLayout.WEST, panel);
		button_5.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(button_5);
		button_5.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if	(source == button)
		{
			buttonClick();//��������ѯ��ť�¼�
		}
		if	(source == button_1)
		{
			if	(str[wflag].equals("true"))
			{
				button_1Click();//�����޸���Ϣ��ť�¼�
			}
			else
			{
				JOptionPane.showMessageDialog(button_1, "����ͣ���񣬲��ܽ��д�ȡ���޸Ĳ�����", "��ʾ", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_2)
		{
			button_2Click();//�����˺�ά����ť�¼�
		}
		if	(source == button_3)
		{
			if	(str[wflag].equals("true"))
			{
				button_3Click();//����ȡ�ť�¼�
			}
			else
			{
				JOptionPane.showMessageDialog(button_3, "����ͣ���񣬲��ܽ��д�ȡ���޸Ĳ�����", "��ʾ", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_4)
		{
			if	(str[wflag].equals("true"))
			{
				button_4Click();//���ô�ť�¼�
			}
			else
			{
				JOptionPane.showMessageDialog(button_4, "����ͣ���񣬲��ܽ��д�ȡ���޸Ĳ�����", "��ʾ", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_5)
		{
			button_5Click();//�����˳���ť�¼�
		}
	}
	private void buttonClick()//�������ѯ�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//��������ѯ����
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Balance balance = new Balance(inform, nowposition,file);
					balance.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	private void button_1Click()//��Ϣ�޸İ�ť�¼�����
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
	private void button_2Click()//�˺�ά����ť�¼�����
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
	private void button_3Click()//ȡ�ť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//�����˳�����
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					RemoveMoney remoney= new RemoveMoney(inform, nowposition,file);
					remoney.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
	}
	private void button_4Click()//��ť�¼�����
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
	private void button_5Click()//�˳���ť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//����ȡ�����
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainInterface maininterface = new MainInterface(inform, nowposition,file);
					Exit exit = new Exit(maininterface,inform, nowposition,file);
					exit.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
