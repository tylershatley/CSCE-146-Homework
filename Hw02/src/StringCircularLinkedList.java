/*
 * Tyler Shatley
 * csce 146
 * lab02
 */
public class StringCircularLinkedList <T>
{
	private class ListNode //Internal class
	{
		private T data;
		private ListNode link;
		public ListNode(T xData, ListNode xLink)
		{
			data = xData;
			link = xLink; //link points to new link. Points to something else
		}
	}
	private ListNode head; //point to the first item in the list
	private ListNode curr;// current nde of interest
	private ListNode prev;//one node behind current
	private ListNode tail;//end of the node
	
	public StringCircularLinkedList()
	{
		head = curr = prev = tail = null;
	}
	
	public void gotoNext()//go to next node method
	{
		if(curr == null)
			return;
		prev = curr;
		curr = curr.link;
	}
	
	public void gotoBack()// go back node method
	{
		if(prev != null)
			curr = prev;
			prev = prev.link; //wrong
	}
	
	public T getCurrent() //get data at current link
	{
		if(curr != null)
			return curr.data;
		return null;
	}
	
	public void setCurrent(T xData) //set data at current link
	{
		if(curr != null)
			curr.data = xData;
	}
	
	public void insert(T xData) // Inserts at the end of the list
	{
		ListNode newNode = new ListNode(xData,null);
		if(head == null)//The list is empty
		{
			head = newNode;
			curr = head;// curr = new node
			tail = head;
			head.link = head;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
		tail.link = head;
	}
	
	public void insertAfterCurrent(T xData)
	{
		if(curr == null)
			return;
		ListNode newNode = new ListNode(xData,curr.link);
		curr.link = newNode;
	}
	
	public void deleteCurrent()
	{
		if(curr != null && prev != null) // current is not at the head
		{
			prev.link = curr.link;
			curr = curr.link; //update current where it moves forward.
		}
		else if(curr != null && prev == null)//current is at the head
		{
			head = head.link; //curr = curr.link
		}
	}
	
	public void print()
	{
		for(ListNode temp = head; temp != null; temp = temp.link)
		{
			System.out.println(temp.data);
		}
		System.out.println();
	}
	
	public boolean isContained(T xData)//is the data i passed in here in a cotained structure?
	{
		return this.findNodeWith(xData) != null; //if its contained it wont be null
	}
	private ListNode findNodeWith(T xData)
	{
		ListNode temp = head;
		while(temp != null)
		{
			if(temp.data.equals(xData))
				return temp;
			temp = temp.link;
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		GenLL<Integer> stuff;
		stuff = new GenLL<Integer>();
		
		System.out.println("Circular Linked List Tester\n");
		System.out.println("Create, insert, and print test by adding values 1-4");
		
		for(int i = 1; i < 5; i++)
		{
			stuff.insert(i);
		}
		stuff.print();
		
		System.out.println("Moving current twice and deleting the current");
		stuff.gotoNext();
		stuff.gotoNext();
		stuff.deleteCurrent();
		stuff.print();
		
		System.out.println("Testing In list by searching for the value 4");
		//to do
		
		System.out.println("Testing In list by searching for the value 3");
		//todo
		
		System.out.println("Testing getting and setting current by adding the value 10 to the current data.");
		stuff.getCurrent();
		stuff.setCurrent(stuff.getCurrent()+10);
		stuff.print();
		
		System.out.println("Moving current forward and deleting that node");
		stuff.gotoNext();
		stuff.deleteCurrent();
		stuff.print();
		
		System.out.println("Moving current backwards and deleting that node");
		//to do
		
		System.out.println("Test done");
		
		
	}
	
	
}
