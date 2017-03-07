/*
 * 主界面类：
 * 功能：登录成功后，可通过该界面进入其他界面。
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//主界面类继承JFrame实现ActionListener接口
public class MainInterface extends JFrame implements ActionListener
{
	//类属性声明
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

	public MainInterface(String [] inform, int nowposition,FileOperate file) //窗体界面的设计
	{
		this.inform = inform;//用户信息
		this.nowposition = nowposition;//用户信息在文件中的位置
		this.file = file;
		str = file.getinform(inform[nowposition]);
		setResizable(false);//设置窗体大小不可变
		setTitle("主界面");//设置窗体左上角的名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作
		setBounds(500, 150, 489, 387);
		
		panel = new JPanel();//实例化面板对象
		panel.setBackground(new Color(153, 204, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		lblatm = new JLabel("欢迎使用ATM自动提款机");//实例化标签对象
		sl_panel.putConstraint(SpringLayout.NORTH, lblatm, 34, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblatm, -78, 
								SpringLayout.EAST, panel);
		lblatm.setFont(new Font("楷体", Font.PLAIN, 30));
		panel.add(lblatm);//添加标签组件到面板
		
		button = new JButton("余额查询");
		sl_panel.putConstraint(SpringLayout.EAST, button, 0, 
								SpringLayout.EAST, panel);
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(button);//添加按钮组件到面板
		button.addActionListener(this);//注册监听
		
		button_1 = new JButton("信息修改");
		sl_panel.putConstraint(SpringLayout.SOUTH, button, -24, 
								SpringLayout.NORTH, button_1);
		sl_panel.putConstraint(SpringLayout.EAST, button_1, 0, 
								SpringLayout.EAST, button);
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(button_1);
		button_1.addActionListener(this);
		
		button_2 = new JButton("账号维护");
		sl_panel.putConstraint(SpringLayout.SOUTH, button_2, 0, 
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_2, 0, 
								SpringLayout.EAST, panel);
		button_2.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(button_2);
		button_2.addActionListener(this);
		
		button_3 = new JButton("取款");
		sl_panel.putConstraint(SpringLayout.WEST, button_3, 0, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_3, -207, 
								SpringLayout.WEST, button);
		button_3.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(button_3);
		button_3.addActionListener(this);
		
		button_4 = new JButton("存款");
		sl_panel.putConstraint(SpringLayout.NORTH, button_1, 0, 
								SpringLayout.NORTH, button_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, button_3, -24, 
								SpringLayout.NORTH, button_4);
		sl_panel.putConstraint(SpringLayout.WEST, button_4, 0, 
								SpringLayout.WEST, button_3);
		button_4.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(button_4);
		button_4.addActionListener(this);
		
		button_5 = new JButton("退出");
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
		button_5.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(button_5);
		button_5.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if	(source == button)
		{
			buttonClick();//调用余额查询按钮事件
		}
		if	(source == button_1)
		{
			if	(str[wflag].equals("true"))
			{
				button_1Click();//调用修改信息按钮事件
			}
			else
			{
				JOptionPane.showMessageDialog(button_1, "已暂停服务，不能进行存取及修改操作！", "提示", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_2)
		{
			button_2Click();//调用账号维护按钮事件
		}
		if	(source == button_3)
		{
			if	(str[wflag].equals("true"))
			{
				button_3Click();//调用取款按钮事件
			}
			else
			{
				JOptionPane.showMessageDialog(button_3, "已暂停服务，不能进行存取及修改操作！", "提示", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_4)
		{
			if	(str[wflag].equals("true"))
			{
				button_4Click();//调用存款按钮事件
			}
			else
			{
				JOptionPane.showMessageDialog(button_4, "已暂停服务，不能进行存取及修改操作！", "提示", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if	(source == button_5)
		{
			button_5Click();//调用退出按钮事件
		}
	}
	private void buttonClick()//存款余额查询事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入余额查询界面
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
	private void button_1Click()//信息修改按钮事件处理
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
	private void button_2Click()//账号维护按钮事件处理
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
	private void button_3Click()//取款按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入退出界面
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
	private void button_4Click()//存款按钮事件处理
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
	private void button_5Click()//退出按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入取款界面
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
