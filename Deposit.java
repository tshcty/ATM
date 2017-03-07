/*
 * 存款类：
 * 实现功能：取款操作
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//存款类继承了JFrame，实现了ActionListener接口
public class Deposit extends JFrame implements ActionListener
{
	//类属性声明
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
	// 定义一个字符串数组，将计算器中按钮的文字都放在该数组中
	private String name1[] = { "7", "8", "9", "0", "4", "5", "6", "00", "1", "2",
				"3", "清除"};
	private FileOperate file;

//构造方法实现界面的设计
	public Deposit(String [] inform, int nowposition, FileOperate file)
	{
		this.inform = inform;
		this.nowposition = nowposition;
		this.file = file;
		str = file.getinform(inform[nowposition]);
		setResizable(false);//设置窗体大小不可改
		setTitle("存款");//设置窗体名称
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭窗体操作
		setBounds(500, 150, 552, 432);//设置窗体大小
		
		panel = new JPanel();//实例化面板对象
		panel.setBackground(new Color(153, 204, 255));//设置面板颜色
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		label = new JLabel("存入的金额为：");//实例化标签对象
		sl_panel.putConstraint(SpringLayout.WEST, label, 10, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label, -316, 
								SpringLayout.SOUTH, panel);
		label.setFont(new Font("楷体", Font.PLAIN, 24));//设置标签字体
		panel.add(label);//添加标签到面板
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 63, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 6, 
								SpringLayout.EAST, label);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, 0, 
								SpringLayout.SOUTH, label);
		panel.add(textField);
		textField.setColumns(10);//设置文本框输入文字多少
		
		label_1 = new JLabel("存入的金额必须为100");
		sl_panel.putConstraint(SpringLayout.EAST, textField, -16, 
								SpringLayout.WEST, label_1);
		sl_panel.putConstraint(SpringLayout.NORTH, label_1, 6, 
								SpringLayout.NORTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 350, 
								SpringLayout.WEST, panel);
		label_1.setForeground(new Color(255, 0, 0));//设置字体颜色
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		panel.add(label_1);
		
		lblNewLabel = new JLabel("的整数倍）");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, 
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, 
								SpringLayout.WEST, label);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		button_12 = new JButton("确定");
		sl_panel.putConstraint(SpringLayout.NORTH, button_12, 119, 
								SpringLayout.SOUTH, label_1);
		sl_panel.putConstraint(SpringLayout.EAST, label_1, 0, 
								SpringLayout.EAST, button_12);
		button_12.addActionListener(this);
		button_12.setFont(new Font("宋体", Font.PLAIN, 25));
		sl_panel.putConstraint(SpringLayout.EAST, button_12, 0, 
								SpringLayout.EAST, panel);
		panel.add(button_12);
		
		button_13 = new JButton("返回");
		button_13.addActionListener(this);
		button_13.setFont(new Font("宋体", Font.PLAIN, 25));
		sl_panel.putConstraint(SpringLayout.NORTH, button_13, 31, 
								SpringLayout.SOUTH, button_12);
		sl_panel.putConstraint(SpringLayout.EAST, button_13, 0, 
								SpringLayout.EAST, button_12);
		panel.add(button_13);
		
		button_14 = new JButton("退出");
		button_14.addActionListener(this);
		button_14.setFont(new Font("宋体", Font.PLAIN, 25));
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
			// 注册监听
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
			button_12Click();//调用确定按钮事件
		}
		else if	(source == button_13)
		{
			button_13Click();//调用返回按钮事件
		}
		else if	(source == button_14)
		{
			button_14Click();
		}
		else if	(input.equals("清除"))
		{
			textField.setText("");
		}
		else
		{
			textField.setText(textField.getText() + input);
		}
	}
	private void button_12Click()//确定按钮事件处理
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
				JOptionPane.showMessageDialog(button_12, "存款成功！", "提示", 
						JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(button_12, "输入金额有误！", "提示", 
					JOptionPane.WARNING_MESSAGE);
		}
	}
	private void button_13Click()//返回按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入主界面
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
	
	private void button_14Click()//退出按钮事件处理
	{
		this.setVisible(false);//隐藏当前窗口
		//进入取款界面
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

