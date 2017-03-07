/*
 * 退出类：
 * 实现功能：退出程序，并调用更新类更新用户信息，写入文件
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//退出类继承JFrame 实现了ActionListener接口
public class Exit extends JFrame implements ActionListener
{

	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton button;
	private JButton button_1;
	private JFrame jf;
	private String [] inform;
	private int nowposition;
	private FileOperate file;

	public Exit(JFrame jf,String [] inform, int nowposition, FileOperate file) 
	{
		this.inform = inform;
		this.nowposition = nowposition;
		this.file = file;
		this.jf = jf;//为退出类的返回作准备
		setResizable(false);//设置窗体大小不可变
		setTitle("退出");//设置窗体左上角名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作
		setBounds(500, 150, 479, 267);
		
		panel = new JPanel();//实例化面板对象
		panel.setBackground(new Color(153, 204, 255));//设置面板颜色
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		lblNewLabel = new JLabel("提示 ：确定退出系统？");//标签实例化对象
		//标签位置设置
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 47,
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -55, 
								SpringLayout.EAST, panel);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		button = new JButton("确定");
		button.addActionListener(this);
		button.setFont(new Font("楷体", Font.PLAIN, 25));
		panel.add(button);
		
		button_1 = new JButton("返回");
		button_1.addActionListener(this);//按钮注册监听
		//按钮位置设置
		sl_panel.putConstraint(SpringLayout.NORTH, button_1, 47, 
								SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, button_1, 246, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, button, 0, 
								SpringLayout.NORTH, button_1);
		sl_panel.putConstraint(SpringLayout.EAST, button, -40, 
								SpringLayout.WEST, button_1);
		button_1.setFont(new Font("楷体", Font.PLAIN, 25));
		panel.add(button_1);//添加按钮组件到面板
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();//获取事件源名
		if	(source == button)
		{
			buttonClick();//调用存款按钮事件
		}
		if	(source == button_1)
		{
			button_1Click();//调用取款按钮事件
		}
	}
	private void buttonClick()//确定按钮事件
	{
		Update update = new Update(inform, nowposition, file);
		file.deletefile();
		update.update();
		this.setVisible(false);
	}
	private void button_1Click()//返回按钮事件
	{
		this.setVisible(false);
		jf.setVisible(true);
	}
}
