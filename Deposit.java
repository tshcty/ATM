/*
 * ����ࣺ
 * ʵ�ֹ��ܣ�ȡ�����
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//�����̳���JFrame��ʵ����ActionListener�ӿ�
public class Deposit extends JFrame implements ActionListener
{
	//����������
	private JPanel panel;
	private JTextField textField;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JPanel panel_1;
	private JButton button[];
	private String [] inform;
	private String [] str;
	private int nowposition;
	private final int num = 0,name=1, sex=2,id=3,phonenum=4,passwd=5,money=6,wflag=7; 
	// ����һ���ַ������飬���������а�ť�����ֶ����ڸ�������
	private String name1[] = { "7", "8", "9", "0", "4", "5", "6", "00", "1", "2",
				"3", "���"};
	private FileOperate file;

//���췽��ʵ�ֽ�������
	public Deposit(String [] inform, int nowposition, FileOperate file)
	{
		this.inform = inform;
		this.nowposition = nowposition;
		this.file = file;
		str = file.getinform(inform[nowposition]);
		setResizable(false);//���ô����С���ɸ�
		setTitle("���");//���ô�������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرմ������
		setBounds(500, 150, 552, 432);//���ô����С
		
		panel = new JPanel();//ʵ����������
		panel.setBackground(new Color(153, 204, 255));//���������ɫ
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		label = new JLabel("����Ľ��Ϊ��");//ʵ������ǩ����
		sl_panel.putConstraint(SpringLayout.WEST, label, 10, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label, -316, 
								SpringLayout.SOUTH, panel);
		label.setFont(new Font("����", Font.PLAIN, 24));//���ñ�ǩ����
		panel.add(label);//��ӱ�ǩ�����
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 63, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 6, 
								SpringLayout.EAST, label);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, 0, 
								SpringLayout.SOUTH, label);
		panel.add(textField);
		textField.setColumns(10);//�����ı����������ֶ���
		
		label_1 = new JLabel("����Ľ�����Ϊ100");
		sl_panel.putConstraint(SpringLayout.EAST, textField, -16, 
								SpringLayout.WEST, label_1);
		sl_panel.putConstraint(SpringLayout.NORTH, label_1, 6, 
								SpringLayout.NORTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 350, 
								SpringLayout.WEST, panel);
		label_1.setForeground(new Color(255, 0, 0));//����������ɫ
		label_1.setFont(new Font("����", Font.PLAIN, 18));
		panel.add(label_1);
		
		lblNewLabel = new JLabel("����������");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, 
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, 
								SpringLayout.WEST, label);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		button_12 = new JButton("ȷ��");
		sl_panel.putConstraint(SpringLayout.NORTH, button_12, 119, 
								SpringLayout.SOUTH, label_1);
		sl_panel.putConstraint(SpringLayout.EAST, label_1, 0, 
								SpringLayout.EAST, button_12);
		button_12.addActionListener(this);
		button_12.setFont(new Font("����", Font.PLAIN, 25));
		sl_panel.putConstraint(SpringLayout.EAST, button_12, 0, 
								SpringLayout.EAST, panel);
		panel.add(button_12);
		
		button_13 = new JButton("����");
		button_13.addActionListener(this);
		button_13.setFont(new Font("����", Font.PLAIN, 25));
		sl_panel.putConstraint(SpringLayout.NORTH, button_13, 31, 
								SpringLayout.SOUTH, button_12);
		sl_panel.putConstraint(SpringLayout.EAST, button_13, 0, 
								SpringLayout.EAST, button_12);
		panel.add(button_13);
		
		button_14 = new JButton("�˳�");
		button_14.addActionListener(this);
		button_14.setFont(new Font("����", Font.PLAIN, 25));
		sl_panel.putConstraint(SpringLayout.SOUTH, button_14, 0, 
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_14, 0, 
								SpringLayout.EAST, button_12);
		panel.add(button_14);
		
		panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 90, 
								SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -4, 
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 322, 
								SpringLayout.WEST, panel);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(3,4));
		
		button = new JButton[name1.length];
		for (int i = 0; i < button.length; i++) 
		{
			button[i] = new JButton(name1[i]);
			// ע�����
			button[i].addActionListener(this);
			panel_1.add(button[i]);
		}
	
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		String input = e.getActionCommand();
		
		if	(source == button_12)
		{
			button_12Click();//����ȷ����ť�¼�
		}
		else if	(source == button_13)
		{
			button_13Click();//���÷��ذ�ť�¼�
		}
		else if	(source == button_14)
		{
			button_14Click();
		}
		else if	(input.equals("���"))
		{
			textField.setText("");
		}
		else
		{
			textField.setText(textField.getText() + input);
		}
	}
	private void button_12Click()//ȷ����ť�¼�����
	{
		String smoney = textField.getText();
		Long nmoney = Long.valueOf(smoney);
		System.out.println(nmoney);
		Long pmoney = null;
		if	(nmoney % 100 ==0 && nmoney > 0)
		{
				pmoney = Long.valueOf(str[money]);
				str[money] = Long.toString((nmoney + pmoney));
				inform[nowposition] = str[num] + "," + str[name] + "," +str[sex] + 
						"," +str[id] + "," +str[phonenum] + "," +str[passwd] + "," +
						str[money] + "," +str[wflag];
				System.out.println(inform[nowposition]);
				JOptionPane.showMessageDialog(button_12, "���ɹ���", "��ʾ", 
						JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(button_12, "����������", "��ʾ", 
					JOptionPane.WARNING_MESSAGE);
		}
	}
	private void button_13Click()//���ذ�ť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//����������
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainInterface maininterface = 
									new MainInterface(inform, nowposition,file);
					maininterface.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	private void button_14Click()//�˳���ť�¼�����
	{
		this.setVisible(false);//���ص�ǰ����
		//����ȡ�����
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Deposit deposit = new Deposit(inform, nowposition, file);
					Exit exit = new Exit(deposit,inform, nowposition,file);
					exit.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}

