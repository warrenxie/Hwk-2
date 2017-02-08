import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T> {
	private T[] stack;
	private int topIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 10000;
	public ArrayStack(){
		this(DEFAULT_CAPACITY);
	}
	public ArrayStack(int initialCapacity){
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[initialCapacity];
		stack = temp;
		topIndex = -1;
		initialized = true;
	}

	public void push(T newEntry) {
		// TODO Auto-generated method stub
		checkInitialization();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}
	private void ensureCapacity(){
		if(topIndex == stack.length - 1){
			int newLength = 2*stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		}
	}


	public T pop() {
		checkInitialization();
		if(isEmpty())
			throw new EmptyStackException();
		else{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}


	public T peek() {
		// TODO Auto-generated method stub
		checkInitialization();
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack[topIndex];
		
	}


	public boolean isEmpty() {
		return topIndex <0;
	}


	public void clear() {
		while(!isEmpty())
			pop();
	}
	
    private void checkInitialization()
    {
        if (!initialized)
             throw new SecurityException("ArrayStack object is not initialized " +
                                        "properly.");
   }
    private void checkCapacity(int initialCapacity){
    	if(initialCapacity > MAX_CAPACITY)
    		throw new IllegalStateException("Attempt to create a stack " +
                                            "whose capacity exceeds " +
                                            "allowed maximum.");
    }
    
}
