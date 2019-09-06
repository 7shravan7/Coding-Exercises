package codes.DailyCodingProblems.Easy;

import java.util.Arrays;

import codes.DS.DoubleLinkedList;
import codes.DS.DoubleLinkedListNode;

public class DLLPalindrome {
	
	public static boolean isPalindrome(DoubleLinkedList<Integer> dll) {
		DoubleLinkedListNode<Integer> fwd = dll.getHead();
		DoubleLinkedListNode<Integer> rev = dll.getHead();
		while(rev.next!=null) {
			rev = rev.next;
		}
		while(fwd!=rev) {
			if(!fwd.data.equals(rev.data)) {
				return false;
			}
			fwd = fwd.next;
			rev = rev.previous;
		}
		return true;
	}

	public static void main(String[] args) {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
		dll = dll.constructDLLfromList(Arrays.asList(1,2,2,1));
		dll.printDLL();
		System.out.println(isPalindrome(dll));
	}

}
