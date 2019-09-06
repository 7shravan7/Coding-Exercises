package codes.DS;

public class DoubleLinkedListNode<T> {
	
	public T data;	
	public DoubleLinkedListNode<T> previous;	
	public DoubleLinkedListNode<T> next;
	
	public DoubleLinkedListNode(T data){
		this.data = data;
		previous = next = null;
	}
}
