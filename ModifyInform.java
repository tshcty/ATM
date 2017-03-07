/*
 * 信息修改类：
 * 功能：该类可修改可修改信息
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//信息修改类继承JFramce实现ActionListener接口
public class ModifyInform extends JFrame implements ActionListener
{
	//类属性声明
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
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
	private JLabel lblNum;
	private JLabel lblName;
	private JLabel lblNewLabel;
	private JLabel lblId;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private String [] inform;
	private String [] str;
	private int nowposition;
	private final int num = 0,name=1, sex=2,id=3,phonenum=4,passwd=5,money=6,wflag=7; 
	private FileOperate file;
	
	
	public ModifyInform(String [] inform,int nowposition,FileOperate file) //构造方法界面设计
	{
		this.inform = inform;
		this.nowposition = nowposition;
		this.file = file;
		str = file.getinform(inform[nowposition]);
		setResizable(false);//设置窗体大小不可改
		setTitle("信息修改");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作
		setBounds(500, 150, 509, 569);
		
		panel = new JPanel();//面板实例化
		panel.setBackground(new Color(153, 204, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		label = new JLabel("不可修改信息");//标签实例化对象
		sl_panel.putConstraint(SpringLayout.NORTH, label, 25, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, label, 10, 
								SpringLayout.WEST, panel);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(label);//添加标签组件到面板
		
		label_1 = new JLabel("卡号 ：");
		sl_panel.putConstraint(SpringLayout.NORTH, label_1, 6, 
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 154, 
								SpringLayout.WEST, panel);
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(label_1);
		
		label_2 = new JLabel("用户名 ：");
		sl_panel.putConstraint(SpringLayout.NORTH, label_2, 6, 
								SpringLayout.SOUTH, label_1);
		sl_panel.putConstraint(SpringLayout.EAST, label_2, 0, 
								SpringLayout.EAST, label_1);
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(label_2);
		
		label_3 = new JLabel("性别 ：");
		sl_panel.putConstraint(SpringLayout.NORTH, label_3, 6,
								SpringLayout.SOUTH, label_2);
		sl_panel.putConstraint(SpringLayout.EAST, label_3, 0, 
								SpringLayout.EAST, label_1);
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(label_3);
		
		label_4 = new JLabel("身份证号码 ：");
		sl_panel.putConstraint(SpringLayout.NORTH, label_4, 6, SpringLayout.SOUTH, label_3);
		sl_panel.putConstraint(SpringLayout.EAST, label_4, 0, 
								SpringLayout.EAST, label_1);
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(label_4);
		
		label_5 = new JLabel("可修改信息 ");
		sl_panel.putConstraint(SpringLayout.NORTH, label_5, 19, 
								SpringLayout.SOUTH, label_4);
		sl_panel.putConstraint(SpringLayout.WEST, label_5, 29, 
								SpringLayout.WEST, panel);
		label_5.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(label_5);
		
		label_6 = new JLabel("手机号码 ：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, label_6, 70, 
								SpringLayout.SOUTH, label_4);
		sl_panel.putConstraint(SpringLayout.EAST, label_6, 0, 
								SpringLayout.EAST, label_1);
		panel.add(label_6);
		
		label_7 = new JLabel("旧密码 ：");
		sl_panel.putConstraint(SpringLayout.NORTH, label_7, 6, 
								SpringLayout.SOUTH, label_6);
		sl_panel.putConstraint(SpringLayout.WEST, label_7, 0, 
								SpringLayout.WEST, label_2);
		label_7.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(label_7);
		
		label_8 = new JLabel("新密码 ：");
		label_8.setFont(new Font("宋体", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, label_8, 6, 
								SpringLayout.SOUTH, label_7);
		sl_panel.putConstraint(SpringLayout.EAST, label_8, 0, 
								SpringLayout.EAST, label_1);
		panel.add(label_8);
		
		label_9 = new JLabel("确认新密码 ：");
		label_9.setFont(new Font("宋体", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, label_9, 6, 
								SpringLayout.SOUTH, label_8);
		sl_panel.putConstraint(SpringLayout.EAST, label_9, 0, 
								SpringLayout.EAST, label_1);
		panel.add(label_9);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 248, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 3, 
								SpringLayout.EAST, label_6);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 155, 
								SpringLayout.EAST, label_6);
		panel.add(textField);
		textField.setColumns(10);//设置文本大小
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);//设置密码框大小
		passwordField.setEchoChar('*');//设置密码回显符合
		sl_panel.putConstraint(SpringLayout.NORTH, passwordField, 9, 
								SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, passwordField, 0, 
								SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, passwordField, 0, 
								SpringLayout.EAST, textField);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(20);
		passwordField_1.setEchoChar('*');
		sl_panel.putConstraint(SpringLayout.NORTH, passwordField_1, 6, 
								SpringLayout.SOUTH, label_7);
		sl_panel.putConstraint(SpringLayout.WEST, passwordField_1, 3,
								SpringLayout.EAST, label_8);
		sl_panel.putConstraint(SpringLayout.EAST, passwordField_1, 0, 
								SpringLayout.EAST, textField);
		panel.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setColumns(20);
		passwordField_2.setEchoChar('*');
		sl_panel.putConstraint(SpringLayout.NORTH, passwordField_2, 13, 
								SpringLayout.SOUTH, passwordField_1);
		sl_panel.putConstraint(SpringLayout.WEST, passwordField_2, 0, 
								SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, passwordField_2, 0, 
								SpringLayout.EAST, textField);
		panel.add(passwordField_2);
		
		button = new JButton("确定");
		button.addActionListener(this);
		sl_panel.putConstraint(SpringLayout.NORTH, button, 44, 
								SpringLayout.SOUTH, passwordField_2);
		sl_panel.putConstraint(SpringLayout.WEST, button, 164, 
								SpringLayout.WEST, panel);
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(button);
		
		button_1 = new JButton("返回");
		button_1.addActionListener(this);
		sl_panel.putConstraint(SpringLayout.NORTH, button_1, 0, 
								SpringLayout.NORTH, button);
		sl_panel.putConstraint(SpringLayout.EAST, button_1, 0, 
								SpringLayout.EAST, textField);
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(button_1);
		
		button_2 = new JButton("退出");
		button_2.addActionListener(this);//按钮注册监听
		button_2.setFont(new Font("宋体", Font.PLAIN, 25));
		sl_panel.putConstraint(SpringLayout.SOUTH, button_2, 0,
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_2, 0, 
								SpringLayout.EAST, panel);
		panel.add(button_2);
		
		lblNum = new JLabel(str[num]);//显示当前用户名
		sl_panel.putConstraint(SpringLayout.WEST, lblNum, 6,
								SpringLayout.EAST, label_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNum, 0, 
								SpringLayout.SOUTH, label_1);
		panel.add(lblNum);
		
		lblName = new JLabel(str[name]);
		sl_panel.putConstraint(SpringLayout.NORTH, lblName, 7, 
								SpringLayout.NORTH, label_2);
		sl_panel.putConstraint(SpringLayout.WEST, lblName, 0, 
								SpringLayout.WEST, textField);
		panel.add(lblName);
		
		lblNewLabel = new JLabel(str[sex]);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 7, SpringLayout.NORTH, label_3);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 6, SpringLayout.EAST, label_3);
		panel.add(lblNewLabel);
		
		lblId = new JLabel(str[id]);
		sl_panel.putConstraint(SpringLayout.WEST, lblId, 5, 
								SpringLayout.EAST, label_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblId, 0, 
								SpringLayout.SOUTH, label_4);
		panel.add(lblId);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if	(source == button)
		{
			buttonClick();//调用确定按钮事件
		}
		if	(source == button_1)
		{
			button_1Click();//调用返回按钮事件
		}
		if	(source == button_2)
		{
			button_2Click();//调用退出按钮事件
		}
	}
	private void buttonClick()//确定按钮事件处理
	{
		String nphone = textField.getText();
		String ppsw = new String(passwordField.getPassword());
		String npsw = new String(passwordField_1.getPassword());
		String nrepsw = new String(passwordField_2.getPassword());
		str[phonenum] = nphone;
		if	(ppsw.equals(str[passwd]))
		{
			char carray [] = npsw.toCharArray();
			boolean flag = false;
			int len = carray.length;
			for	(int i=1; i<len; i++)
			{
				if	(carray[0] != carray[i])
				{
					flag = true;
					break;
				}
			}
			if	(npsw.length() > 6 && flag == true && npsw.equals(nrepsw))
			{
				
				str[passwd] = file.cpassword(npsw);
				inform[nowposition] = str[num] + "," + str[name] + "," +str[sex] + "," +str[id] + "," +
						str[phonenum] + "," +str[passwd] + "," +str[money] + "," +str[wflag];
				JOptionPane.showMessageDialog(button, "修改成功！", "提示", 
						JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(button, "新密码有误！", "提示", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(button, "旧密码错误！", "提示", 
					JOptionPane.WARNING_MESSAGE);
		}
		
	}
	private void button_1Click()//返回按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入退出界面
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainInterface maininterface = new MainInterface(inform, nowposition,file);
					maininterface.setVisible(true);
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
					ModifyInform modifyinform = new ModifyInform(inform, nowposition,file);
					Exit exit = new Exit(modifyinform,inform, nowposition,file);//转到退出界面
					exit.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
