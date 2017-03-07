/*
 * �˺�ά���ࣺ
 * ���ܣ������ʵ����ͣ������ָ�����Ĺ��ܡ�
 */
package ATM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//�˺�ά����̳�JFrameʵ��ActionListener�ӿ�
public class Service extends JFrame implements ActionListener
{
	//����������
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private String [] inform;
	private String [] str;
	private int nowposition;
	private final int num = 0,name=1, sex=2,id=3,phonenum=4,passwd=5,money=6,wflag=7; 
	private FileOperate file;
	private JLabel lblNewLabel_1;
	
	
	public Service(String [] inform, int nowposition,FileOperate file) //���췽�����н�����Ƽ����Գ�ʼ��
	{
		this.inform = inform;//�����û���Ϣ
		this.nowposition = nowposition;//�û���Ϣ���ļ��е�λ��
		this.file = file;
		str = file.getinform(inform[nowposition]);
		setTitle("�˺�ά��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 450, 300);
		setResizable(false);//���ô����С���ɱ�
		
		panel = new JPanel();//ʵ����������
		panel.setBackground(new Color(153, 204, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		button = new JButton("��ͣ����");
		sl_panel.putConstraint(SpringLayout.NORTH, button, 155, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, button, 44, 
								SpringLayout.WEST, panel);
		button.addActionListener(this);
		button.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(button);
		
		button_1 = new JButton("�ָ�����");
		button_1.addActionListener(this);
		sl_panel.putConstraint(SpringLayout.NORTH, button_1, 0, 
								SpringLayout.NORTH, button);
		sl_panel.putConstraint(SpringLayout.WEST, button_1, 6, 
								SpringLayout.EAST, button);
		button_1.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(button_1);
		
		button_2 = new JButton("����");
		sl_panel.putConstraint(SpringLayout.NORTH, button_2, 0,
								SpringLayout.NORTH, button);
		sl_panel.putConstraint(SpringLayout.WEST, button_2, 6, 
								SpringLayout.EAST, button_1);
		button_2.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(button_2);
		button_2.addActionListener(this);

		
		button_3 = new JButton("�˳�");
		button_3.setFont(new Font("����", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.SOUTH, button_3, 0, 
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_3, 0, 
								SpringLayout.EAST, panel);
		panel.add(button_3);
		
		JLabel label = new JLabel("��ʾ ��   ���û���Ϊ���˻������Ű�ȫ����ʱ��");
		label.setForeground(Color.BLUE);
		sl_panel.putConstraint(SpringLayout.NORTH, label, 20, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, label, 57, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label, -228, 
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, label, -61, 
								SpringLayout.EAST, button_3);
		label.setFont(new Font("����", Font.PLAIN, 14));
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("����ͣ���˻��ķ���.��ͣ������û����ܽ�");
		lblNewLabel.setForeground(Color.BLUE);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, 
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, 
								SpringLayout.WEST, label);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("�д�ȡ�����������ָ��������ܽ��С�");
		lblNewLabel_1.setForeground(Color.BLUE);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 9, 
								SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0,
								SpringLayout.WEST, label);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		button_3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		Object source = e.getSource();
		
		if	(source == button)
		{
			buttonClick();//������ͣ����ť�¼�
		}
		if	(source == button_1)
		{
			button_1Click();//���ûָ�����ť�¼�
		}
		if	(source == button_2)
		{
			button_2Click();//���÷��ذ�ť�¼�
		}
		if	(source == button_3)
		{
			button_3Click();//�����˳���ť�¼�
		}
	}
	private void buttonClick()//��ͣ����ť�¼�
	{
		str[wflag] = "false";
		inform[nowposition] = str[num] + "," + str[name] + "," +str[sex] + "," +
							str[id] + "," +str[phonenum] + "," +str[passwd] + "," +
							str[money] + "," +str[wflag];
		JOptionPane.showMessageDialog(button, "����ͣ����", "��ʾ", 
				JOptionPane.WARNING_MESSAGE);
		
	}
	private void button_1Click()//�ָ�����ť�¼�
	{
		str[wflag] = "true";
		inform[nowposition] = str[num] + "," + str[name] + "," +str[sex] + "," +
							str[id] + "," +str[phonenum] + "," +str[passwd] + "," +
							str[money] + "," +str[wflag];
		JOptionPane.showMessageDialog(button, "�ѻָ�����", "��ʾ", 
				JOptionPane.WARNING_MESSAGE);
	}
	
	private void button_2Click()//���ذ�ť�¼�
	{
		this.setVisible(false);//���ص�ǰ����
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					//ת���˳�����
					MainInterface maininterface = new MainInterface(inform, nowposition,file);
					maininterface.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
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
					Service service = new Service(inform, nowposition,file);
					Exit exit = new Exit(service,inform, nowposition,file);//ת���˳�����
					exit.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
