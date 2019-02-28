
public class GenLL <T>
{
	private class ListNode
	{
		private T Data;
		private ListNode Link;
		
		public ListNode(T xData, ListNode xLink)
		{
			Data = xData;
			Link = xLink;
		}
	}
	private ListNode head; //points to the first item
	private ListNode curr; //points at item of interest
	private ListNode prev; //one behind the current
	
	public GenLL()
	{
		head = curr = prev = null;
	}
	
	public T getCurrent()
	{	
		if(curr != null)
			return curr.Data;
	return null;
	}
	
	public void setCurrent(T xData)
	{
		if(curr != null)
			curr.Data = xData;
	}
	
	public void GoToNext()
	{
		if(curr == null)
			return;
		prev = curr;
		curr = curr.Link; //point to the next point
	}
	
	public void resetCurrent() //takes current and points it back to the head
	{
		curr = head;
	}
	
	public boolean hasMore()
	{
		return curr != null; 
	}
	
	public void insert(T xData)
	{
		ListNode newNode = new ListNode(xData,null);
		
		if(head == null)
		{
			head = newNode;
			curr = head;
			return;
		}
		ListNode temp = head;
		while(temp.Link != null)
			temp = temp.Link;
		temp.Link = newNode;
	}
	
	public void insertAfterCurrent(T xData)
	{
		if(curr == null)
			return;
		ListNode newNode = new ListNode(xData,curr.Link);
		curr.Link = newNode;
	}
	
	public void deleteCurrent()
	{
		if(curr != null && prev != null)//means its pointing to anything but the head
		{
			prev.Link = curr.Link;
			curr = curr.Link;
		}
		else if(curr != null)//means prev is = to null. cut off the head
		{
			head = head.Link;
		}
	}
	
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.Data);
			temp = temp.Link;
		}
	}
	
	public boolean isContained(T xData)//is the data i passed in here in a cotained structure?
	{
		return this.findNodeWith(xData) != null; //if its contained it wont be null
	}
	
	public void GoToItem(T xData)
	{
		ListNode temp = this.findNodeWith(xData);
		if(temp == null)
			return;
		this.resetCurrent();
		while(this.hasMore() && curr != temp)
			this.GoToNext();
	}
	
	public ListNode findNodeWith(T xData)
	{
		ListNode temp = head;
		while(temp != null)
		{
			if(temp.Data.equals(xData))
				return temp;
			temp = temp.Link;
		}
		return null;
	}
	
}
