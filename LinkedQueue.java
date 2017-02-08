import java.util.NoSuchElementException;

public class LinkedQueue<T> implements QueueInterface<T> {
	private Node fNode;
	private Node lNode;

	public LinkedQueue(){
		fNode= null;
		lNode= null;
	}
	
	public void enqueue(T newEntry) {
		Node  newNode = new Node(newEntry, null);
		if(isEmpty()){
			fNode = newNode;
		}
		else{
			lNode.setNextNode(newNode);
		}
	}
	
	public T dequeue() {
		T front = getFront();
		assert fNode != null;
		fNode.setData(null);
		fNode = fNode.getNextNode();
		
		if(fNode ==null)
			lNode=null;
		return front;
	}


	
	public T getFront() {
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		else 
			return fNode.getData();
	}


	
	public boolean isEmpty() {
		return (fNode == null) && ( lNode == null);
	}


	
	public void clear() {
		fNode = null;
		lNode = null;
		
	}
	
	private class Node{
	private T data;
	private Node next;
	
	private Node(T dataPortion){
		this(dataPortion,null);
	}
	private Node(T dataPortion, Node nextNode){
		data = dataPortion;
		next = nextNode;
	}
	private T getData(){
		return data;
	}
	private void setData(T newData){
		data = newData;
	}
	private Node getNextNode(){
		return next;
	}
	private void setNextNode(Node nextNode){
		next = nextNode;
	}
  }
}



