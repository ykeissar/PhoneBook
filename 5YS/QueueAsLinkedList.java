import java.util.NoSuchElementException;

public class QueueAsLinkedList<T> implements Queue<T>{
	
	private final LinkedList<T> list;
	
	public QueueAsLinkedList() {
		this.list = new LinkedList();
	}
	
        @Override
	public void enqueue(T element) {
		list.add(element);
	}
	
        @Override
	public T dequeue() {
		if(isEmpty())
			throw new NoSuchElementException();
		T output = list.removeFirst();
		return output;
	}

        @Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
