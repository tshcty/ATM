/*
 * 文件操作类：
 * 功能：其他类可调用该类实现文件的操作与密码加密等功能 
 */
package ATM;

import java.io.*;
import java.util.regex.Pattern;

//文件操作类
class FileOperate
{
	private String filepath;//文件路径
	private BufferedReader breader;
	private PrintWriter pwriter;
	
	public FileOperate(String filepath)
	{
		this.filepath = filepath;//给文件路径赋值
	}
	
	public void openread()//读对象实例化，为后面读做准备
	{
		try//打开读文件
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
	
	//对文件进行行读取操作，返回读取内容
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
	
	public void closeread()//关闭读操作
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
	
	public void openwrite()//为写创建写对象
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
	
	//写入文件，rewrite为要写内容
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
	
	public void closewrite()//关闭写操作
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
	
	public String [] getinform(String str)//用正则表达式把字符串转换为字符串数组
	{
		String [] str1;
		String regex = "\\,";
		Pattern p = Pattern.compile(regex,Pattern.UNICODE_CASE);
		str1 = p.split(str);		
		return str1;
	}
	
	public void deletefile()//删除文件，为重新写入作准备
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
	
	public String cpassword(String pwd)//密码加密
	{
		String rpwd = null;
		StringBuffer sb = new StringBuffer(pwd);
		rpwd = sb.reverse().toString();
	//	System.out.println(rpwd);
		return rpwd;
	}	
}