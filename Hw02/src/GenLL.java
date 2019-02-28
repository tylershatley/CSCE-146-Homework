/*
 * Tyler Shatley
 * Csce 146
 */
public class GenLL <T>
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
		
		public GenLL()
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
		
		public T deleteCurrent()
		{
			if(curr != null && prev != null) // current is not at the head
			{
				prev.link = curr.link;
				curr = curr.link; //update current where it moves forward.
			}
			else if(curr != null && prev == null)//current is at the head
			{
				head = head.link; //curr = curr.link
				T ret = head.data;
				return ret;
			}
			else if(head == null)
				return null;
			T ret = head.data;
			head = head.link;
			return ret;
		}
		
		public void MoveToHead() 
		{
			curr = head;
		}
		
		public boolean hasMore()
		{
			return curr != null; 
		}
		
		public void print()
		{
			for(ListNode temp = head; temp != null; temp = temp.link)
			{
				System.out.println(temp.data);
			}
			System.out.println();
		}
	}