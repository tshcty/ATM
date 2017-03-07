/*
 * 账号维护类：
 * 功能：该类可实现暂停服务与恢复服务的功能。
 */
package ATM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//账号维护类继承JFrame实现ActionListener接口
public class Service extends JFrame implements ActionListener
{
	//类属性声明
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
	
	
	public Service(String [] inform, int nowposition,FileOperate file) //构造方法进行界面设计及属性初始化
	{
		this.inform = inform;//所有用户信息
		this.nowposition = nowposition;//用户信息在文件中的位置
		this.file = file;
		str = file.getinform(inform[nowposition]);
		setTitle("账号维护");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 450, 300);
		setResizable(false);//设置窗体大小不可变
		
		panel = new JPanel();//实例化面板对象
		panel.setBackground(new Color(153, 204, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		button = new JButton("暂停服务");
		sl_panel.putConstraint(SpringLayout.NORTH, button, 155, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, button, 44, 
								SpringLayout.WEST, panel);
		button.addActionListener(this);
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(button);
		
		button_1 = new JButton("恢复服务");
		button_1.addActionListener(this);
		sl_panel.putConstraint(SpringLayout.NORTH, button_1, 0, 
								SpringLayout.NORTH, button);
		sl_panel.putConstraint(SpringLayout.WEST, button_1, 6, 
								SpringLayout.EAST, button);
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(button_1);
		
		button_2 = new JButton("返回");
		sl_panel.putConstraint(SpringLayout.NORTH, button_2, 0,
								SpringLayout.NORTH, button);
		sl_panel.putConstraint(SpringLayout.WEST, button_2, 6, 
								SpringLayout.EAST, button_1);
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(button_2);
		button_2.addActionListener(this);

		
		button_3 = new JButton("退出");
		button_3.setFont(new Font("宋体", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.SOUTH, button_3, 0, 
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_3, 0, 
								SpringLayout.EAST, panel);
		panel.add(button_3);
		
		JLabel label = new JLabel("提示 ：   当用户认为该账户存在着安全隐患时，");
		label.setForeground(Color.BLUE);
		sl_panel.putConstraint(SpringLayout.NORTH, label, 20, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, label, 57, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label, -228, 
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, label, -61, 
								SpringLayout.EAST, button_3);
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("可暂停本账户的服务.暂停服务后，用户不能进");
		lblNewLabel.setForeground(Color.BLUE);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, 
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, 
								SpringLayout.WEST, label);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("行存款、取款操作，必须恢复服务后才能进行。");
		lblNewLabel_1.setForeground(Color.BLUE);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 9, 
								SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0,
								SpringLayout.WEST, label);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		button_3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		Object source = e.getSource();
		
		if	(source == button)
		{
			buttonClick();//调用暂停服务按钮事件
		}
		if	(source == button_1)
		{
			button_1Click();//调用恢复服务按钮事件
		}
		if	(source == button_2)
		{
			button_2Click();//调用返回按钮事件
		}
		if	(source == button_3)
		{
			button_3Click();//调用退出按钮事件
		}
	}
	private void buttonClick()//暂停服务按钮事件
	{
		str[wflag] = "false";
		inform[nowposition] = str[num] + "," + str[name] + "," +str[sex] + "," +
							str[id] + "," +str[phonenum] + "," +str[passwd] + "," +
							str[money] + "," +str[wflag];
		JOptionPane.showMessageDialog(button, "已暂停服务！", "提示", 
				JOptionPane.WARNING_MESSAGE);
		
	}
	private void button_1Click()//恢复服务按钮事件
	{
		str[wflag] = "true";
		inform[nowposition] = str[num] + "," + str[name] + "," +str[sex] + "," +
							str[id] + "," +str[phonenum] + "," +str[passwd] + "," +
							str[money] + "," +str[wflag];
		JOptionPane.showMessageDialog(button, "已恢复服务！", "提示", 
				JOptionPane.WARNING_MESSAGE);
	}
	
	private void button_2Click()//返回按钮事件
	{
		this.setVisible(false);//隐藏当前窗口
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					//转到退出界面
					MainInterface maininterface = new MainInterface(inform, nowposition,file);
					maininterface.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	private void button_3Click()//退出按钮事件
	{
		this.setVisible(false);//隐藏当前窗口
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Service service = new Service(inform, nowposition,file);
					Exit exit = new Exit(service,inform, nowposition,file);//转到退出界面
					exit.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
