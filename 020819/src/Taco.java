
public class Taco {

	private String Name, Loc;
	private double Price;
	private int Rating; // 1-5

	public Taco() 
	{
		this.Name = this.Loc = "none";
		this.Price = 0.0;
		this.Rating = 1;
	}
	
	public Taco(String xName, String xLoc, double xPrice, int xRating)
	{
		this.setName(xName);
		this.setLoc(xLoc);
		this.setPrice(xPrice);
		this.setRating(xRating);
	}

	public String getName() 
	{
		return Name;
	}

	public void setName(String xName) 
	{
		this.Name = xName;
	}

	public String getLoc() 
	{
		return Loc;
	}

	public void setLoc(String xLoc) 
	{
		this.Loc = xLoc;
	}

	public double getPrice() 
	{
		return Price;
	}

	public void setPrice(double xPrice) 
	{
		if(xPrice >= 0.0)
		{
			this.Price = xPrice;
		}
	}

	public int getRating() 
	{
		return Rating;
	}

	public void setRating(int xRating) 
	{
		if(xRating >= 1 && xRating <= 5)
		{
			this.Rating = xRating;
		}
		else
		{
			this.Rating = 1;
		}
	}
	
	public String tostring()
	{
		return this.Name + " " + this.Loc + " " + this.Price + "  " + this.Rating;
	}
	
	public boolean equals(Taco xTaco)
	{
		return xTaco != null &&
				this.Name.equals(xTaco.getName()) &&
				this.Loc.equals(xTaco.getLoc()) &&
				this.Price == xTaco.getPrice() &&
				this.Rating == xTaco.getRating() ;
	}
	
	public boolean equals(Object o)
	{
		return this.equals((Taco)o);
	}
	
	public static void main(String[] args)
	{
		Taco t = new Taco();
		System.out.println(t);
		Taco u = new Taco();
		System.out.println(t.equals(u));
		Object o = u;
		System.out.println(o.equals(t));
	}
	

}
