import java.util.NoSuchElementException;

public final class ArrayQueue<T> implements QueueInterface<T> {
	private T[] queue; 
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 10;
	public static final int MAX_CAPACITY = 1000;
	
	public ArrayQueue(){
		this(DEFAULT_CAPACITY);
	}

	public ArrayQueue(int initialCapacity) {
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[initialCapacity + 1];
		queue = temp;
		frontIndex = 0;
		backIndex = initialCapacity;
		initialized = true;
	}
	private void checkInitialization()
	    {
	        if (!initialized)
	             throw new SecurityException(" object is not initialized " +
	                                        "properly.");
	   }
	private void checkCapacity(int initialCapacity){
		if(initialCapacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a queue whose" +
											"capacity exceeds allowed maximum" + MAX_CAPACITY);
											
	}
	public void enqueue (T newEntry){
		checkInitialization();
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	}
	public T getFront(){
		checkInitialization();
		
		if(isEmpty())
			throw new NoSuchElementException();
		else
				return queue[frontIndex];
		
	}
	public T dequeue(){
		checkInitialization();
		if(isEmpty())
			throw new NoSuchElementException();
		else{
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
		}
	}
	private void ensureCapacity(){
		if(frontIndex == (backIndex + 2) % queue.length){
			T[] oldQ = queue;
			int oldSize = oldQ.length;
			int newSize = 2 * oldSize;
			checkCapacity(newSize - 1);
			@SuppressWarnings("unchecked")
			T[] tempQ = (T[]) new Object[newSize];
			queue = tempQ;
			for(int i = 0; i < oldSize- 1; i++ ){
				queue[i] = oldQ[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}
	public boolean isEmpty(){
		return frontIndex == ((backIndex + 1) % queue.length);
	}
	public void clear() {
		while(!isEmpty())
			dequeue();
	}	
}
