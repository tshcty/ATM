/*
 * 取款类：
 * 功能：执行取款操作。
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//取款类继承JFrame实现ActionLisener接口
public class RemoveMoney extends JFrame implements ActionListener
{
	//类属性声明
	private JPanel panel;
	private JTextField textField;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
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
	
	
//构造方法进行界面设计并初始化属性
	public RemoveMoney(String [] inform, int nowposition, FileOperate file) 
	{
		this.file = file;
		this.inform = inform;
		this.nowposition = nowposition;
		str = file.getinform(inform[nowposition]);
		setResizable(false);//设置窗体大小不可改
		setTitle("取款");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 537, 433);
		
		panel = new JPanel();//实例化面板对象
		panel.setBackground(new Color(153, 204, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		label = new JLabel("取出的金额为：");
//		标签位置设置
		sl_panel.putConstraint(SpringLayout.WEST, label, 10, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label, -317, 
								SpringLayout.SOUTH, panel);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(label);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 0, 
								SpringLayout.NORTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 6, 
								SpringLayout.EAST, label);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, 0, 
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -172, 
								SpringLayout.EAST, panel);
		panel.add(textField);
		textField.setColumns(10);
		
		label_1 = new JLabel("（取出的金额必须为");
		sl_panel.putConstraint(SpringLayout.NORTH, label_1, 10, 
								SpringLayout.NORTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 6, 
								SpringLayout.EAST, textField);
		label_1.setForeground(new Color(255, 0, 0));
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		panel.add(label_1);
		
		label_2 = new JLabel("100的整数倍，不能超过5000且小于当前余额）");
		sl_panel.putConstraint(SpringLayout.NORTH, label_2, 14, 
								SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, label_2, 0, 
								SpringLayout.WEST, label);
		label_2.setForeground(new Color(255, 0, 0));
		label_2.setFont(new Font("宋体", Font.PLAIN, 17));
		panel.add(label_2);
		
		button_12 = new JButton("确定");
		button_12.addActionListener(this);
		button_12.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(button_12);
		
		button_13 = new JButton("返回");
		sl_panel.putConstraint(SpringLayout.NORTH, button_13, 269, 
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, button_12, -4, 
								SpringLayout.NORTH, button_13);
		button_13.addActionListener(this);
		button_13.setFont(new Font("宋体", Font.PLAIN, 25));
		sl_panel.putConstraint(SpringLayout.EAST, button_12, 0,
								SpringLayout.EAST, button_13);
		sl_panel.putConstraint(SpringLayout.EAST, button_13, 0, 
								SpringLayout.EAST, panel);
		panel.add(button_13);
		
		button_14 = new JButton("退出");
		button_14.addActionListener(this);
		button_14.setFont(new Font("宋体", Font.PLAIN, 25));
		sl_panel.putConstraint(SpringLayout.SOUTH, button_14, 0, 
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, button_14, 0, 
								SpringLayout.EAST, panel);
		panel.add(button_14);
		
		panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 0, 
								SpringLayout.NORTH, button_12);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, 
								SpringLayout.WEST, label);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -1,
								SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 0, 
								SpringLayout.EAST, label_2);
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
			button_12Click();
		}
		else if	(source == button_13)
		{
			button_13Click();
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
		Long pmoney = Long.valueOf(str[money]);
		if	(nmoney % 100 ==0 && nmoney < 5000 && nmoney <= pmoney)
		{
				str[money] = Long.toString((pmoney - nmoney));
				inform[nowposition] = str[num] + "," + str[name] + "," +str[sex] +
						"," +str[id] + "," +str[phonenum] + "," +str[passwd] + "," +
						str[money] + "," +str[wflag];
				JOptionPane.showMessageDialog(button_12, "取款成功！", "提示", 
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
					MainInterface maininterface = new MainInterface(inform, nowposition, file);
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
					RemoveMoney removemoney = new RemoveMoney(inform, nowposition, file);
					Exit exit = new Exit(removemoney,inform, nowposition,file);
					exit.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
