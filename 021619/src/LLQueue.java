
public class LLQueue <T> implements QueueInterface<T>{
	
	private class ListNode
	{
		private T data;
		private ListNode link;
		public ListNode(T xData, ListNode xLink)
		{
			data = xData;
			link = xLink;
		}
	}
	ListNode head;
	ListNode tail;
	
	public LLQueue()
	{
		head = tail = null;
	}
	
	public void enqueue(T xData)
	{
		ListNode newNode = new ListNode(xData,null);
		if(head == null)
		{
			head = tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = newNode;// tail = tail.link
	}
	
	public T dequeue()
	{
		if(head == null)
			return null;
		T ret = head.data;
		head = head.link;
		return ret;
	}
	
	public void print()
	{
		ListNode temp = head;
		while(temp!= null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

}
