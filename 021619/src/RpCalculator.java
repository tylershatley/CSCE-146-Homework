import java.util.*;
public class RpCalculator {
	
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		
		Scanner key = new Scanner(System.in);
		String input = key.nextLine();
		LLStack<Integer>iStack = new LLStack<Integer>();
		Scanner strScanner = new Scanner(input);
		
		while(strScanner.hasNext())
		{
			String symbol = strScanner.next();
			if(symbol.equals("+"))
			{
				if(iStack.size() < 2)
				{
					System.out.println("This is ill formatted");
					break;
				}
				int n2 = iStack.pop();
				int n1 = iStack.pop();
				iStack.push(n1 + n2);
			}
			//...the other stuff
			else
			{
				try
				{
					iStack.push(Integer.parseInt(symbol));
				}
				catch(Exception e)
				{
					System.out.println("Not recognized symbol");
				}
			}
		}
		if(iStack.size() == 1)
			System.out.println(iStack.pop());
		else
			System.out.println("Ill formatted experssion");
		
	}

}
