import java.util.EmptyStackException;

public final  class LinkedStack <T> implements StackInterface<T> {
	private Node topNode;
	
	public LinkedStack(){
		topNode = null;
	}
	private class Node{
		private T data;
		private Node next;
		Node(T data, Node next){
			this.data = data;
			this.next = next;
		
		}
	public T getData(){
			return data;
		}
	public Node getNextNode(){
			return next;
		}
	public void setData(T data){
			this.data = data;
		}
	}
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		topNode = new Node(newEntry,topNode);
	}

	public T pop() {
		// TODO Auto-generated method stub
		T top = peek();
		assert topNode !=null;
		topNode = topNode.getNextNode();
		return top;
	}

	public T peek() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return topNode == null;
	}

	public void clear() {
		// TODO Auto-generated method stub
		topNode = null;
	}

}

