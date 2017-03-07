/*
 * 余额查询类：
 * 功能：实现余额的查询，可转到其他类。
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//余额查询类继承窗体实现ActionListener接口
public class Balance extends JFrame implements ActionListener
{
	//声明类属性
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
	
	
	public Balance(String [] inform, int nowposition,FileOperate file) //在构造方法中实现界面设计
	{
		this.inform = inform;
		this.nowposition = nowposition;
		this.file = file;
		str = file.getinform(inform[nowposition]);
		setTitle("余额查询");//窗体名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗体默认关闭操作
		setBounds(500, 150, 366, 461);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setResizable(false);//设置窗体大小不可变
		
		panel = new JPanel();//添加面板组件
		panel.setBackground(new Color(153, 204, 255));//面板背景颜色
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();//面板位置设置
		panel.setLayout(sl_panel);
		
		label = new JLabel("用户名 :");//实例化标签对象
		//标签位置设置，此设置方法采用SpringLayout布局，此布局是与其他组件相
		//关联设置位置
		sl_panel.putConstraint(SpringLayout.NORTH, label, 47, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, label, 63,
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, label, -189, 
								SpringLayout.EAST, panel);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		panel.add(label);//添加组件"用户名"标签
		
		label_1 = new JLabel("当前余额为 :");//实例化标签对象
		//标签位置设置
		sl_panel.putConstraint(SpringLayout.NORTH, label_1, 24, 
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 18, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, label_1, 0, 
								SpringLayout.EAST, label);
		label_1.setFont(new Font("楷体", Font.PLAIN, 24));
		panel.add(label_1);//添加组件标签到面板
		
		button = new JButton("存款");//实例化按钮对象
		//按钮位置设置
		sl_panel.putConstraint(SpringLayout.WEST, button, 0, 
							SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button, -241,
							SpringLayout.EAST, panel);
		button.setFont(new Font("楷体", Font.PLAIN, 24));
		panel.add(button);//添加组件按钮到面板
		button.addActionListener(this);//注册监听
		
		button_1 = new JButton("取款");//实例化按钮对象
		//按钮位置设置 
		sl_panel.putConstraint(SpringLayout.SOUTH, button, -47, 
							SpringLayout.NORTH, button_1);
		sl_panel.putConstraint(SpringLayout.WEST, button_1, 0, 
							SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_1, 0, 
							SpringLayout.EAST, button);
		button_1.setFont(new Font("楷体", Font.PLAIN, 24));
		panel.add(button_1);//添加组件按钮到面板
		button_1.addActionListener(this);//注册监听
		
		button_2 = new JButton("退出");//实例化按钮对象
		//按钮位置设置 
		sl_panel.putConstraint(SpringLayout.SOUTH, button_1, -49, 
							SpringLayout.NORTH, button_2);
		sl_panel.putConstraint(SpringLayout.WEST, button_2, 0, 
							SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_2, 0, 
							SpringLayout.EAST, button);
		button_2.setFont(new Font("楷体", Font.PLAIN, 24));
		panel.add(button_2);//添加组件按钮到面板
		button_2.addActionListener(this);//注册监听
		
		button_3 = new JButton("修改信息");
		button_3.setFont(new Font("楷体", Font.PLAIN, 24));
		sl_panel.putConstraint(SpringLayout.EAST, button_3, 0, 
								SpringLayout.EAST, panel);
		panel.add(button_3);
		button_3.addActionListener(this);
		
		button_4 = new JButton("账号维护");//实例化按钮对象
		sl_panel.putConstraint(SpringLayout.NORTH, button_4, 300, 
				SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, button_3, -47, 
				SpringLayout.NORTH, button_4);
		button_4.setFont(new Font("楷体", Font.PLAIN, 24));
		sl_panel.putConstraint(SpringLayout.EAST, button_4, 0, 
				SpringLayout.EAST, button_3);
		panel.add(button_4);//添加组件按钮到面板
		button_4.addActionListener(this);//注册监听
		
		button_5 = new JButton("回主界面");
		sl_panel.putConstraint(SpringLayout.NORTH, button_2, 0, 
				SpringLayout.NORTH, button_5);
		button_5.setFont(new Font("楷体", Font.PLAIN, 24));
		sl_panel.putConstraint(SpringLayout.SOUTH, button_5, 0, 
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_5, 0, 
				SpringLayout.EAST, panel);
		panel.add(button_5);
		button_5.addActionListener(this);
		
		lblName = new JLabel(str[name]);//实例化标签对象
		sl_panel.putConstraint(SpringLayout.NORTH, lblName, 11, 
				SpringLayout.NORTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, lblName, 6, 
				SpringLayout.EAST, label);
		panel.add(lblName);
		
		label_2 = new JLabel(str[money]);
		//标签对象位置设置
		sl_panel.putConstraint(SpringLayout.WEST, label_2, 6, 
				SpringLayout.EAST, label_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, label_2, 0, 
				SpringLayout.SOUTH, label_1);
		panel.add(label_2);//添加标签对象到面板
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if	(source == button)
		{
			if	(str[wflag].equals("true"))
			{
				buttonClick();//调用存款按钮事件
			}
			else
			{
				JOptionPane.showMessageDialog(button, "已暂停服务，不能进行存取及修改操作！", "提示", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_1)
		{
			if	(str[wflag].equals("true"))
			{
				button_1Click();//调用取款按钮事件
			}
			else
			{
				JOptionPane.showMessageDialog(button_1, "已暂停服务，不能进行存取及修改操作！", "提示", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_2)
		{
			button_2Click();//调用退出按钮事件
		}
		if	(source == button_3)
		{
			if	(str[wflag].equals("true"))
			{
				button_3Click();//调用修改信息按钮事件
			}
			else
			{
				JOptionPane.showMessageDialog(button_3, "已暂停服务，不能进行存取及修改操作！", "提示", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_4)
		{
			button_4Click();//调用账号维护按钮事件
		}
		if	(source == button_5)
		{
			button_5Click();//调用回主界面按钮事件
		}
	}
	
	private void buttonClick()//存款按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入存款界面
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
	private void button_1Click()//取款按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入取款界面
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
	private void button_2Click()//退出按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入退出界面
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
	private void button_3Click()//修改信息按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入修改信息界面
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
	private void button_4Click()//账号维护按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入账号维护界面
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
	private void button_5Click()//回主界面按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入主界面
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
