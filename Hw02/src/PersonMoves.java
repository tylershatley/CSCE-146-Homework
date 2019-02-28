/*
 * Tyler Shatley
 * csce 146
 */
public class PersonMoves {
	
	private int guess;
	private int total;
	
	
	//default constructor
	public PersonMoves()
	{
		this.guess = 1;
		this.total = 0;
	}
	
	//parametrized constructor
	public PersonMoves(int xguess , int xtotal)
	{
		this.setguess(xguess);
		this.setguess(xtotal);
	}
	
	//guess getter
	public int getguess()
	{
		return this.guess;
	}
	//guess accessor
	public void setguess(int xguess)
	{
		if(xguess >= 1 && xguess <= 10) //guess can only be between 1-10
		{
			this.guess = xguess;
		}
		else
		{
			System.out.println("Invalid input... we're gona assume you meant 10");
			this.guess = 10;
		}
	}
	//total getter
	public int gettotal()
	{
		return this.total;
	}
	
	//total accessor
	public void settotal(int xtotal)
	{
		this.total = xtotal;
	}
	
	//add guesses together method.
	public void addGuess(int xguess)
	{
		total += xguess;
	}
	
	//boolean number check
	public boolean checkTotal(Potato xPotato)
	{
		if(total < xPotato.getp())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
