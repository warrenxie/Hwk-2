

public class CircularLinkedQueue<T> implements QueueInterface<T> {
	private Node qNode;
	private Node freeNode;
	
	public CircularLinkedQueue(){
		freeNode= new Node( null, null);
		freeNode.setNextNode(freeNode);
		qNode = freeNode;
	}
	
	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
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
