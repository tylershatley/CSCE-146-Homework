/*
 * Tyler Shatley
 * csce 146
 */
public class Person {
	
	private String name;
	
	
	//default constructor
	public Person()
	{
		this.name = "bob";
	}
	
	//paramterized constructor 
	public Person(String xname)
	{
		this.setname(xname);
	}

	//getter
	public String getname()
	{
		return this.name;
	}
	
	//accessor
	public void setname(String xname)
	{
		this.name = xname;
	}
	
	public String toString()
	{
		return this.name;
	}
	
}
