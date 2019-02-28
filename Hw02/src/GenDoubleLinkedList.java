/*
 * Tyler Shatley
 * csce146
 * lab04
 */
public class GenDoubleLinkedList <T> {
	
	private class ListNode //Internal class
	{
		private T data;
		private ListNode link;
		private ListNode prevlink;
		public ListNode(T xData, ListNode xLink, ListNode plink)
		{
			data = xData;
			link = xLink; //link points to new link. Points to something else
			prevlink = plink;
		}
	}
	private ListNode head; //point to the first item in the list
	private ListNode curr;// current nde of interest
	private ListNode prev;//one node behind current
	
	public GenDoubleLinkedList()
	{
		head = curr = null;
	}
	
	public void goToNext()//go to next node method
	{
		if(curr == null)
			return;
		curr = curr.link;
	}
	
	public void goToPrev()// go back node method
	{
		if(curr == null)
			return;
		curr = curr.prevlink;
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
		ListNode newNode = new ListNode(xData,null,null);
		if(head == null)//The list is empty
		{
			head = newNode;
			curr = head;// curr = new node
			return;
		}
		ListNode temp = head;
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode;
		newNode.prevlink = temp	;
	}
	
	public void insertNodeAfterCurrent(T xData)
	{
		if(curr == null)
			return;
		ListNode newNode = new ListNode(xData,curr.link,null);
		newNode.link = curr.link;
		newNode.prevlink = curr;
		curr.link = newNode;
	}
	
	public void deleteCurrentNode()
	{
		if(curr != null && curr.prevlink != null) // current is not at the head
		{
			curr.prevlink.link = curr.link;
			curr = curr.link; //update current where it moves forward.
		}
		else if(curr != null && curr.prevlink == null)//current is at the head
		{
			head = head.link; //curr = curr.link
		}
	}
	
	public boolean hasMore()
	{
		return curr != null;
	}
	
	public void showList()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	public boolean inList(T xData)//is the data i passed in here in a cotained structure?
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
}

public static void main(String[] args)
{
	
}
