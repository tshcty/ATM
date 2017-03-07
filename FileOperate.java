/*
 * �ļ������ࣺ
 * ���ܣ�������ɵ��ø���ʵ���ļ��Ĳ�����������ܵȹ��� 
 */
package ATM;

import java.io.*;
import java.util.regex.Pattern;

//�ļ�������
class FileOperate
{
	private String filepath;//�ļ�·��
	private BufferedReader breader;
	private PrintWriter pwriter;
	
	public FileOperate(String filepath)
	{
		this.filepath = filepath;//���ļ�·����ֵ
	}
	
	public void openread()//������ʵ������Ϊ�������׼��
	{
		try//�򿪶��ļ�
		{
			File file = new File(filepath);
			if	(false == file.exists())
			{
				File dirName = new File("F:/javafile");
				dirName.mkdirs();
				if	(false == file.exists())
				{
					file.createNewFile();
				}
			}
			breader = new BufferedReader(new FileReader(file));
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	//���ļ������ж�ȡ���������ض�ȡ����
	public String read()
	{
		String  str = null;
		try
		{
			str = breader.readLine();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return str;
	}
	
	public void closeread()//�رն�����
	{
		try
		{
			breader.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void openwrite()//Ϊд����д����
	{
		try
		{
			File file = new File(filepath);
			if	(false == file.exists())
			{
				File dirName = new File("F:/javafile");
				dirName.mkdirs();
				if	(false == file.exists())
				{
					file.createNewFile();
				}
			}
			pwriter = new PrintWriter(new FileWriter(file,true));
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	//д���ļ���rewriteΪҪд����
	public void write(String rewrite)
	{
		
		try
		{
			pwriter.println(rewrite);
			pwriter.flush();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void closewrite()//�ر�д����
	{
		try
		{
			pwriter.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public String [] getinform(String str)//��������ʽ���ַ���ת��Ϊ�ַ�������
	{
		String [] str1;
		String regex = "\\,";
		Pattern p = Pattern.compile(regex,Pattern.UNICODE_CASE);
		str1 = p.split(str);		
		return str1;
	}
	
	public void deletefile()//ɾ���ļ���Ϊ����д����׼��
	{
		try
		{
			File file = new File(filepath);
			if	(true == file.exists())
			{
				file.delete();
			}
		}catch	(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public String cpassword(String pwd)//�������
	{
		String rpwd = null;
		StringBuffer sb = new StringBuffer(pwd);
		rpwd = sb.reverse().toString();
	//	System.out.println(rpwd);
		return rpwd;
	}	
}