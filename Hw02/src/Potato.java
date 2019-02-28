/*
 * Tyler Shatley
 * csce146
 */
public class Potato {
	
	private int p;
	//defualt constructor
	
	
	public Potato()
	{
		this.p = 1;
	}
	
	//parametirzed construcotr
	public Potato(int xp)
	{
		this.setp(xp);
	}
	
	public int getp()
	{
		return this.p;
	}
	
	public void setp(int xp)
	{
		if(xp >= 1 && xp <= 180)//can only be from 1-180. (3 minutes)
		{
			this.p = xp;
		}
		else
		{
			System.out.println("Invalid time. So we assigned one to you.");
			this.p = 50; 
		}
	}
}
