/*
 * 更新类：
 * 功能：该类实现用户信息写入文件功能。
 */
package ATM;

public class Update
{
	private String [] inform;
	private int nowposition;
	private FileOperate file;
	
	public Update(String [] inform, int nowposition, FileOperate file)
	{
		this.inform = inform;
		this.nowposition = nowposition;
		this.file = file;
	}
	
	public void update()
	{
		try
		{
			file.openwrite();
			int i = 0;
			while	(null != inform[i])
			{
				file.write(inform[i]);
				i++;
			}
			file.closewrite();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
