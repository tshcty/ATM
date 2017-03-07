/*
 * 登录类：
 * 功能：程序的入口，可通过该类进入其他界面操作。密码输入三次错误后，该用户暂停服务。
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener//登录界面类基础JFrame
{
	private JTextField textField; //文本域声明
	private JPasswordField passwordField;//密码框声明
	private JPanel panel;//面板声明
	private JLabel label;//标签声明
	private JLabel label_1;
	private JButton button;//按钮声明
	private JButton button_1;
	private JButton button_2;
	private String filepath;//文件路径
	private FileOperate file;//声明一个自定义的文件操作类；	
	private final int num = 0,name=1, sex=2,id=3,phonenum=4,passwd=5,money=6,wflag=7; 
	private int nowposition = 0;//客户信息在文件中的当前位置
	private String [] inform = new String[10];//存储客户信息
	private String [] str;//每个用户信息
	private static  int	count = 3;//登录次数

	public Login() 
	{
		//存放文件路径
		filepath = new String("F:/javafile/file.txt");
		//文件操作开始
		file = new FileOperate(filepath);
		String isempty;
		file.openread();
		isempty = file.read();
		file.closeread();
		if	(null == isempty)
		{
			String fstr = "123456" + "," + "123456" + "," +"男" + "," +"123456" + 
				"," +"123456" + "," +"654321" + "," +"10000" + "," +"true";
			
		file.openwrite();
		file.write(fstr);
		file.closewrite();
		}
		
		this.setResizable(false);//设置窗体大小不可改变
		this.setTitle("登录");//设置窗体左上角的名字为登录
		this.setBounds(500, 150, 444, 292);//设置窗体在屏幕中的位置及窗体大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体默认的关闭操作
		
		panel = new JPanel();//实例化对象面板1
		panel.setBackground(new Color(153, 204, 255));//设置面板颜色
		getContentPane().add(panel, BorderLayout.CENTER);//将面板加到当前窗体
		SpringLayout sl_panel = new SpringLayout();//实例化对象SprinLayout布局
		panel.setLayout(sl_panel);//面板1添加SpringLayout布局
		
		label = new JLabel("卡号 ：");//实例化标签“卡号”
		sl_panel.putConstraint(SpringLayout.NORTH, label, 39,
								SpringLayout.NORTH, panel);//将标签“卡号”的北边与面板的北边固定距离39
		label.setFont(new Font("宋体", Font.PLAIN, 20));//设置标签字体属性
		panel.add(label);//添加标签到面板1
		
		label_1 = new JLabel("密码 ：");
		sl_panel.putConstraint(SpringLayout.NORTH, label_1, 29,
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 0, 
								SpringLayout.WEST, label);
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(label_1);
		
		textField = new JTextField();//实例化文本框
		//文本框位置设置
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
		panel.add(textField);//添加文本框到面板1
		textField.setColumns(10);//设置文本框大小
		
		passwordField = new JPasswordField();//实例化密码框
		passwordField.setColumns(20);//设置密码框大小
		passwordField.setEchoChar('*');//设置要用于回显的字符。
		sl_panel.putConstraint(SpringLayout.NORTH, passwordField, -1, 
								SpringLayout.NORTH, label_1);
		sl_panel.putConstraint(SpringLayout.WEST, passwordField, 6, 
								SpringLayout.EAST, label_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, passwordField, 31, 
								SpringLayout.NORTH, label_1);
		sl_panel.putConstraint(SpringLayout.EAST, passwordField, 0,
								SpringLayout.EAST, textField);
		panel.add(passwordField);//添加密码框到面板1
		
		button = new JButton("登录");//实例化按钮"登录"
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(button);
		button.addActionListener(this);//登录按钮注册监听

		button_1 = new JButton("退出");
		sl_panel.putConstraint(SpringLayout.SOUTH, button_1, 0, 
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_1, 0, 
								SpringLayout.EAST, panel);
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(button_1);
		button_1.addActionListener(this);//退出按钮注册监听
		
		button_2 = new JButton("注册");
		sl_panel.putConstraint(SpringLayout.NORTH, button_2, 36, 
								SpringLayout.SOUTH, passwordField);
		sl_panel.putConstraint(SpringLayout.WEST, button_2, 232, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, button, 0, 
								SpringLayout.NORTH, button_2);
		sl_panel.putConstraint(SpringLayout.EAST, button, -6, 
								SpringLayout.WEST, button_2);
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(button_2);
		button_2.addActionListener(this);//注册按钮注册监听
	}
	//重写ActionListener的actionPerformed方法
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
	
	private int buttonClick()//登录按钮事件处理
	{
		int nowposition = 0;
		String unum = textField.getText();//将文本框中的内容赋给unum
		String upassword = new String(passwordField.getPassword());
		int i = 0;
		file.openread();
		while	(null != (inform[i] = file.read()))//将所有文件内的信息读入
		{
			i++;
		}
		file.closeread();
		
		if	(unum.equals(""))//卡号为空
		{
			//告知用户某事已发生
			JOptionPane.showMessageDialog(button, "卡号不能为空", "提示", 
										JOptionPane.WARNING_MESSAGE);
		}
		else if	(upassword.equals(""))//密码为空
		{
			JOptionPane.showMessageDialog(button, "密码不能为空", "提示", 
										JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			
			String  str1 = null;//存储一个成员的信息
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
				JOptionPane.showMessageDialog(button, "该用户不存在！", "提示",
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
						JOptionPane.showMessageDialog(button, "输入密码错误，还有" + count + "次机会！", "提示",
							JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						str[wflag] = "false";
						inform[nowposition] = str[num] + "," + str[name] + "," +str[sex] + "," +
											str[id] + "," +str[phonenum] + "," +str[passwd] + "," +
											str[money] + "," +str[wflag];
						JOptionPane.showMessageDialog(button, "3次输入密码错误，账户将暂停服务且自动退出", "提示",
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
	private void button_1Click()//退出按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入退出界面
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
	private void button_2Click()//注册按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
//		进入注册界面界面；导致 runnable 的 run 
//		方法在 the system EventQueue 的指派线程中被调用。
//		在所有挂起事件被处理后才发生。在这发生之前调用被阻塞。
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
