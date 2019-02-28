
public class GenLL <T> implements Iterable<T> //Generic type T
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
	}				//type identifier that hold an address
	private ListNode head; //point to the first item in the list
	private ListNode curr;// current nde of interest
	private ListNode prev;//one node behind current
	
	private class ListIterator implements Iterator<T>
	{
		private ListNode iCurr;
		
		public ListIterator(ListNode head)
		{
			iCurr = head;
		}
		public boolean hasNext()
		{
			return iCurr != null;
		}
		
		public T next()
		{
			T ret = iCurr.data;
			iCurr = iCurr.link;
			return ret;
		}
	}
	public Iterator<T> iterator()
	{
		return new ListIterator(head);
	}
	
	
	public GenLL()
	{
		head = curr = prev = null;
	}
	
	public void insert(T xData) // Inserts at the end of the list
	{
		ListNode newNode = new ListNode(xData,null);
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
	}
	
	public void print()
	{
		for(ListNode temp = head; temp != null; temp = temp.link)
		{
			System.out.println(temp.data);
		}
		System.out.println();
	}
	
	public T getCurrent()
	{
		if(curr != null)
			return curr.data;
		return null;
	}
	public void setCurrent(T xData)
	{
		if(curr != null)
			curr.data = xData;
	}
	
	public void gotoNext()
	{
		if(curr == null)
			return;
		prev = curr;
		curr = curr.link;
	}
	
	public void reset()
	{
		prev = null;
		curr = head;
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
	
	public boolean isContained(T xData)//search action?
	{
		return search(xData) != null;
	}
	private ListNode search(T xData)
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
