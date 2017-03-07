/*
 * �˳��ࣺ
 * ʵ�ֹ��ܣ��˳����򣬲����ø���������û���Ϣ��д���ļ�
 */
package ATM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//�˳���̳�JFrame ʵ����ActionListener�ӿ�
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
		this.jf = jf;//Ϊ�˳���ķ�����׼��
		setResizable(false);//���ô����С���ɱ�
		setTitle("�˳�");//���ô������Ͻ�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرղ���
		setBounds(500, 150, 479, 267);
		
		panel = new JPanel();//ʵ����������
		panel.setBackground(new Color(153, 204, 255));//���������ɫ
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		lblNewLabel = new JLabel("��ʾ ��ȷ���˳�ϵͳ��");//��ǩʵ��������
		//��ǩλ������
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 47,
								SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -55, 
								SpringLayout.EAST, panel);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		button = new JButton("ȷ��");
		button.addActionListener(this);
		button.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(button);
		
		button_1 = new JButton("����");
		button_1.addActionListener(this);//��ťע�����
		//��ťλ������
		sl_panel.putConstraint(SpringLayout.NORTH, button_1, 47, 
								SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, button_1, 246, 
								SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, button, 0, 
								SpringLayout.NORTH, button_1);
		sl_panel.putConstraint(SpringLayout.EAST, button, -40, 
								SpringLayout.WEST, button_1);
		button_1.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(button_1);//��Ӱ�ť��������
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();//��ȡ�¼�Դ��
		if	(source == button)
		{
			buttonClick();//���ô�ť�¼�
		}
		if	(source == button_1)
		{
			button_1Click();//����ȡ�ť�¼�
		}
	}
	private void buttonClick()//ȷ����ť�¼�
	{
		Update update = new Update(inform, nowposition, file);
		file.deletefile();
		update.update();
		this.setVisible(false);
	}
	private void button_1Click()//���ذ�ť�¼�
	{
		this.setVisible(false);
		jf.setVisible(true);
	}
}
