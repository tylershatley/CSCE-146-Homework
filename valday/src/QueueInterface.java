/*
 * Tyler Shatley
 * csce146
 */
public interface QueueInterface <T> extends Iterable<T>{
	public void enqueue(T xData);
	public T dequeue();
	public T peek();
	public void print();
	public int size();
	
}
