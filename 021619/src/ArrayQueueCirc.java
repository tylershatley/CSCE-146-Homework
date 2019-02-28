
public class ArrayQueueCirc<T> implements QueueInterface<T> {
	private T[]queue;
	private int tailIndex;
	private int headIndex;
	public static final int DEF_SIZE = 50;
	
	public ArrayQueueCirc()
	{
		
	}
	
	public ArrayQueueCirc(int size)
	{
		
	}
	
	public void init(int size)
	{
		if(size <= 0)
			return;
		tailIndex = headIndex = 0;
		queue = (T[]) (new Object[size]);
	}
	
	public void enqueue(T xData)
	{
		if(queue[headIndex] != null && headIndex == tailIndex) 
			return;
		queue[tailIndex] = xData;
		tailIndex = (tailIndex+1)%queue.length;
	}
	
	public T deqeue()
	{
		T ret = queue[headIndex];
		headIndex = (headIndex+1)%queue.length;
		return ret;
	}
	
	public T peek()
	{
		return queue[headIndex];
	}
	
	public void print()
	{
		System.out.println(queue[headIndex]);
		for(int i = (headIndex+1)%queue.length; i != tailIndex; i= (i+1)%queue.length)
			{
			
			
			}
	}

}
