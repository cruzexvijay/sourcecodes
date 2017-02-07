package test;

import DataStructures.VLinkedList;
import Exceptions.StackOverflowException;
import Exceptions.StackUnderflowException;
import Util.LLutil;

public class UtilTest {
	
	public static LLutil util = new LLutil();

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException{
		
		//mergeDemo();
		//palinDemo1();
		//equalsDemo();
		recReverse();
		
	}
	
	public static void mergeDemo(){
		VLinkedList list1 = new VLinkedList();
		VLinkedList list2 = new VLinkedList();
		VLinkedList newList;
		
//		list1.head = new LNode(1);
//		list1.head.next = new LNode(2);
//		list1.head.next.next = new LNode(3);
//		list1.head.next.next.next = new LNode(4);
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.printList();
		//list.head.next.next.next.next = list.head.next;
			
		list2.add(5);
		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(9);
		
		list2.printList();
		
		newList = LLutil.merge(list1, list2);
		
		newList.printList();
	}
	
	public static void palinDemo() throws StackOverflowException, StackUnderflowException{
		
		VLinkedList list = new VLinkedList();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(1);
		
		list.printList();
		
		System.out.println(LLutil.isPalindrome(list));
	}
	
	
	public static void equalsDemo(){
		VLinkedList list1 = new VLinkedList();
		VLinkedList list2 = new VLinkedList();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.printList();
		
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
				
		list2.printList();
		
		System.out.println(list1.equals(list2));
	}
	
	
	public static void palinDemo1(){
		
		VLinkedList list = new VLinkedList();
		
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(1);
		list.add(2);
		//list.add(5);
		list.add(1);
		
		
		System.out.println(LLutil.isPalindrome(list.head));
	}

	private static void recReverse(){
		
		VLinkedList list = new VLinkedList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		
		//LLutil.printRecursiveReverse(list.head);
		list.head = LLutil.recursiveReverse(list.head, null);
	//	System.out.println(list.head);
		list.printList();
	}
}
