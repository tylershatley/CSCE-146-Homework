import java.util.*;
import java.io.*;
public class TacoDB {
	
	private GenLL<Taco> tacos;
	public static final String DELIM = "\t";
	
	public TacoDB()
	{
		tacos = new GenLL<Taco>();
	}
	
	public void addTaco(Taco xTaco)
	{
		tacos.insert(xTaco);
	}

	public void removeTaco(Taco xTaco)
	{
		tacos.GoToItem(xTaco);
		tacos.deleteCurrent();
		//variation
		tacos.resetCurrent();
		while(tacos.hasMore())
		{
			if(tacos.getCurrent().equals(xTaco))
			{
				tacos.deleteCurrent();
				return;
			}
		}
	}
	
	public void readFromFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLine = fileLine.split(DELIM);
				if(splitLine.length != 4)
					continue;
				this.addTaco(new Taco(splitLine[0],
						splitLine[1],
						Double.parseDouble(splitLine[2]),
						Integer.parseInt(splitLine[3])));
			}
			fileScanner.close();
		}
		
	}
}
