import java.io.*;
import java.util.*;
public class CircleDrawer {

	public static final String DELIM = "\t";
	public static void main(String[] args) {
		
		writeToFile(CircleDrawer.makePoints(5,10,20,40), "Circle.txt");

	}
	
	public static void writeToFile(Point[] points, String fileName)
	{
		
		try
		{
			PrintWriter fileWriter = new PrintWriter(
					new FileOutputStream(fileName));
			
			for(Point p : points)
			{
				fileWriter.println(p.getx() + DELIM + p.gety());
			}
			fileWriter.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static Point[] makePoints(double x, double y, double r, int numP)
	{
		if(numP <= 0)
			return null;
		Point[] retP = new Point[numP];
		for(int i = 0; i < numP; i++)
		{
			retP[i] = 
					new Point(x+Math.cos((double)i/(double)numP)*Math.PI*2,
							y+Math.sin((double)i/(double)numP)*Math.PI*2);
		}
		return retP;
	}
	public static Point [] readFromFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			int count = 0;
			
			while(fileScanner.hasNextLine())
			{
				count ++;
				fileScanner.nextLine();
			}
			fileScanner = new Scanner(new File(fileName));
			count = 0;
			
			while(fileScanner.hasNextLine())
			{
				String line = fileScanner.nextLine();
				String[] splitline = line.split(DELIM);
				if(splitline.length != 2)
					continue;
				Point[] retP = null;
				retP[count++] = new Point(Double.parseDouble(splitline[0]),
						Double.parseDouble(splitline[1]));
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

}
