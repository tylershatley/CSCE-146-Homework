/*
 * Tyler Shatley
 * csce146
 */
import java.util.Scanner;
import java.util.Random;
public class People {
	public static final int FINAL = 180; //(3 minutes)
	
	private GenLL<Person>people;
	Scanner key = new Scanner(System.in);
	
	//add person to the linked list
	
	
	public People()
	{
		people = new GenLL<Person>();
	}
		public void addPerson(Person xPerson)
		{
			people.insert(xPerson);		
		}
		
		//remove a person from the linked list
		public void removePerson(Person xPerson)
		{			
			people.deleteCurrent();
		}
			
		//bring the list back to the begining 
		public void Reset(Person xPerson)
		{			
			people.MoveToHead();
		}
			
		//print the list of people
		public void printPeople()
		{
			people.print();
		}
		
		public void game()
		{
			people.MoveToHead();
			PersonMoves pm = new PersonMoves();
			Person pp = new Person();
			
			pm.settotal(0);
			Potato pot = new Potato();
			
			Random r = new Random();
			int ran = r.nextInt(FINAL)+1;
			pot = new Potato(ran);
			//String yes = "true";
			
				while(pm.checkTotal(pot) == true)
				{
					people.MoveToHead();
						while(people.hasMore())
						{
						System.out.println(people.getCurrent().getname() + ", enter a number from 1-10 corresponding to the number of seconds to hold the potato");
						pm.setguess(key.nextInt());
						pm.addGuess(pm.getguess());
						
						if(pm.checkTotal(pot) == true)
						{
							System.out.println(people.getCurrent().getname() + ", is safe for now.");
						}
						else
						{
							System.out.println("HOT POTATO!!! " + people.getCurrent() + " has been eliminated!");
							people.deleteCurrent();
							break;
						}
						people.gotoNext();
						}
				}
			}
		}

		

