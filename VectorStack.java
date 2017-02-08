import java.util.EmptyStackException;
import java.util.Vector;

public class VectorStack<T> implements StackInterface<T> {
	private Vector<T> stack;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 10000;
	
	public VectorStack(){
		this(DEFAULT_CAPACITY);
	}
	public VectorStack(int initialCapacity){
		checkCapacity(initialCapacity);
		stack = new Vector<>(initialCapacity);
		initialized = true;
	}
	   private void checkCapacity(int initialCapacity){
	    	if(initialCapacity > MAX_CAPACITY)
	    		throw new IllegalStateException("Attempt to create a stack " +
	                                            "whose capacity exceeds " +
	                                            "allowed maximum.");
	    }
	    private void checkInitialization()
	    {
	        if (!initialized)
	             throw new SecurityException("ArrayStack object is not initialized " +
	                                        "properly.");
	   }

		public void push(T newEntry) {
			// TODO Auto-generated method stub
			checkInitialization();
			stack.add(newEntry);
		}
		
		public T pop() {
			checkInitialization();
			if(isEmpty())
				throw new EmptyStackException();
			else
				return stack.remove(stack.size() - 1);
		}
		
		public T peek() {
			// TODO Auto-generated method stub
			checkInitialization();
			if(isEmpty())
				throw new EmptyStackException();
			else
				return stack.lastElement();
		}
	
		public boolean isEmpty() {
			return stack.isEmpty();
		}
	
		public void clear() {
			stack.clear();
		}
	    
}
