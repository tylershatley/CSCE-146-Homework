
public interface QueueInterface <T>{
	public void enqueue(T xData);
	public T dequeue();
	public T peek();
	public void print();
	
}
