/*
 * Tyler Shatley
 * csce146
 */
import java.util.Scanner;
import java.util.Random;
public class HotPotato {
	public static final int FINAL = 180; //(3 minutes) 
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		
		Random r = new Random();
		
		int ran = r.nextInt(FINAL)+1;
		
		Person pep = new Person();
		Potato pot = new Potato();
		PersonMoves pm = new PersonMoves();
		People p = new People();
		
		System.out.println("Welcome to the Hot Potato Game!");
		String ans = "yes";
		
		while(ans == "yes")
		{
			System.out.println("Enter how many people will be playing the game.");
			
			int num = key.nextInt();
			
			for(int i = 0; i < num; i++)
			{
				pep = new Person();
				System.out.println("Enter the name of player " + (i+1));
				String n = key.next();
				pep.setname(n);
				pep = new Person(n);
				p.addPerson(pep);
			}
			
			for(int i = 1; i < num; i++)
			{
				p.game();
			}
			System.out.println("Would you like to play another game? (yes or no)");
			String an1 = key.next();
			
			if(an1.equalsIgnoreCase("yes"))
			{
				ans = "yes";
			}
			else
			{
				ans = "no";
			}
			
		}
		System.out.println("Thanks for playing");
	}
}
