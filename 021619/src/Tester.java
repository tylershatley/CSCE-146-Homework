
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueInterface<Integer>iQ;
		iQ = new ArrayQueueCirc<Integer>();
		
		iQ = new ArrayQueue<Integer>();
		for(int i = 0; i < 10; i++)
			iQ.enqueue(i);
		iQ.print();
		iQ.dequeue();
		iQ.print();
		//iQ.peek();
	}
}
