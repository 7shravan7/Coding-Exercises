package codes.DS;

import java.util.List;

public class DoubleLinkedList<T> {
	
	DoubleLinkedListNode<T> head;
	
	public DoubleLinkedList(){
		head = null; 
	}
	
	public DoubleLinkedListNode<T> getHead() {
		return head;
	}
	
	public void insert(T data) {
		if(head == null) {
			head = new DoubleLinkedListNode<T>(data);
		} else {
			DoubleLinkedListNode<T> temp = head;
			DoubleLinkedListNode<T> prev = null;
			while(temp!=null) {
				prev = temp;
				temp = temp.next;
			}
			temp = new DoubleLinkedListNode<T>(data);
			temp.previous = prev;
			prev.next = temp;
		}
	}
	
	public void delete(T data) {
		DoubleLinkedListNode<T> temp = head;
		DoubleLinkedListNode<T> prev = head;
		DoubleLinkedListNode<T> nxt = head;
		while(temp!=null) {
			if(temp.data.equals(data)) {
				prev = temp.previous;
				nxt = temp.next;
				if(prev!=null) {
					prev.next = nxt;
				}
			}
		}
	}
	
	public void printDLL() {
		DoubleLinkedListNode<T> temp = head;
		System.out.println();
		System.out.println("----Printing Double Linked List---");
		while(temp!=null) {
			System.out.print(temp.data);
			if(temp.next!=null) {
				System.out.print("<=>");
			}
			temp = temp.next;
		}
		System.out.println();
	}
	
	public DoubleLinkedList<T> constructDLLfromList(List<T> list) {
		head = null;
		DoubleLinkedListNode<T> temp = head;
		DoubleLinkedListNode<T> prev = null;
		int listLength = list.size();
		for(int i=0;i<listLength;i++) {
			temp = new DoubleLinkedListNode<T>(list.get(i));
			if(head == null) {
				head = temp;
			} else {
				prev.next = temp;
				temp.previous = prev;
			}
			prev = temp;
			temp = temp.next;
		}
		return this;
	}
}
