import java.util.*;
public class TacoFrontEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		TacoDB tacoDB = new TacoDB();
		Scanner key = new Scanner(System.in);
		
		while(true)
		{
			printOps();
			int choice = key.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter name, loc, price, rating");
				taco.DB.addTaco(new Taco(key.nextLine()),
						key.nextLine(),
						key.nextDouble(),
						key.nextInt());
			}
		}
		
		public static void printOps()
		{
			System.out.println("enter 1: to something\nEnter 2: to do something else");
		}
	}

}
