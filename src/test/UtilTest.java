package test;

import DataStructures.LNode;
import DataStructures.VLinkedList;
import Exceptions.StackOverflowException;
import Exceptions.StackUnderflowException;
import Util.LLutil;

public class UtilTest {

	public static LLutil util = new LLutil();

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {

		// mergeDemo();
		// palinDemo1();
		// equalsDemo();
		// recReverse();
		//intersectDemo();
		//alternateDemo();
		//splitDemo();
		//altDemo();
		//delDemo();
		//oddDemo();
		cycleDemo();
	}
	
	private static void cycleDemo(){
		
		
		VLinkedList list = new VLinkedList();
		
		list.head = new LNode(1);
		list.head.next = new LNode(2);
		list.head.next.next = new LNode(3);
		list.head.next.next.next = new LNode(4);
		list.head.next.next.next.next = new LNode(5);
		list.head.next.next.next.next.next = list.head.next;
		
		//System.out.println("1->2->3->4->5->2");
		list.head = LLutil.removeLoop(list);
		//assert(list.head!=null);
		list.printList();
	}
	
	private static void oddDemo(){
		VLinkedList list1 = new VLinkedList();
		list1.add(1);//
		list1.add(2);
		list1.add(3); //
		list1.add(4);
		list1.add(6); //
		list1.add(7);
		list1.add(2); //
		list1.add(4);
		list1.add(6);//
		list1.add(8);
		list1.printList();
		
		list1.head = LLutil.splitOddEven(list1.head);
		
		list1.printList();
	}
	private static void delDemo(){
		VLinkedList list1 = new VLinkedList();
		
		list1.add(4);
		list1.add(3);//
		list1.add(2);
		list1.add(1); //
		
		
		list1.printList();
		//list1.reverse();
		//list1.printList();
		
		list1.head = LLutil.del(list1.head);
		list1.printList();
	}
	
	private static void altDemo(){
		VLinkedList list1 = new VLinkedList();
		list1.add(1);//
		list1.add(2);
		list1.add(3); //
		list1.add(4);
		list1.add(6); //
		list1.add(7);
		list1.add(2); //
		list1.add(4);
		list1.add(6);//
		list1.add(8);
		list1.printList();
		
		list1.head = LLutil.reverseAlternateNodes(list1.head, 3);
		list1.printList();
	}
	
	private static void splitDemo(){
		VLinkedList list1 = new VLinkedList();
		list1.add(1);//
		list1.add(2);
		list1.add(3); //
		list1.add(4);
		list1.add(6); //
		list1.add(7);
		list1.add(2); //
		list1.add(4);
		list1.add(6);//
		list1.add(8);
		list1.printList();
		
		VLinkedList l1 = new VLinkedList();
		VLinkedList l2 = new VLinkedList();
		
		LNode[] ls = LLutil.split(list1.head);
				
		l1.head = ls[0];
		l2.head = ls[1];
		
		l1.printList();
		l2.printList();
		
	}
	
	private static void alternateDemo(){
		VLinkedList list1 = new VLinkedList();
		list1.add(1);//
		list1.add(2);
		list1.add(3); //
		list1.add(4);
		list1.add(6); //
		list1.add(7);
		list1.add(2); //
		list1.add(4);
		list1.add(6);//
		list1.add(8);
		list1.printList();
		
		list1.head = LLutil.deleteAlternates(list1.head);
		
		list1.printList();
	}

	private static void intersectDemo() {
		VLinkedList list1 = new VLinkedList();
		VLinkedList list2 = new VLinkedList();

		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(6);
		list1.printList();

		list1.add(7);
		list2.add(2);
		list2.add(4);
		list2.add(6);
		list2.add(8);
		// list2.add(5);

		list2.printList();

		list1.head = LLutil.findIntersect(list1.head, list2.head);

		list1.printList();
	}

	public static void mergeDemo() {
		VLinkedList list1 = new VLinkedList();
		VLinkedList list2 = new VLinkedList();
		VLinkedList newList;

		// list1.head = new LNode(1);
		// list1.head.next = new LNode(2);
		// list1.head.next.next = new LNode(3);
		// list1.head.next.next.next = new LNode(4);

		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.printList();
		// list.head.next.next.next.next = list.head.next;

		list2.add(5);
		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(9);

		list2.printList();

		newList = LLutil.merge(list1, list2);

		newList.printList();
	}

	public static void palinDemo() throws StackOverflowException, StackUnderflowException {

		VLinkedList list = new VLinkedList();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(1);

		list.printList();

		System.out.println(LLutil.isPalindrome(list));
	}

	public static void equalsDemo() {
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

	public static void palinDemo1() {

		VLinkedList list = new VLinkedList();

		list.add(1);
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(1);
		list.add(2);
		// list.add(5);
		list.add(1);

		System.out.println(LLutil.isPalindrome(list.head));
	}

	private static void recReverse() {

		VLinkedList list = new VLinkedList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);

		// LLutil.printRecursiveReverse(list.head);
		list.head = LLutil.recursiveReverse(list.head, null);
		// System.out.println(list.head);
		list.printList();
	}

	private static void misc() {
		VLinkedList list = new VLinkedList();

		list.add(1);
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(1);
		list.add(2);
		// list.add(5);
		list.add(1);

		LLutil.removeSortedDuplicates(list.head).printList();

		System.out.println("////// unsorted dup");
		LLutil.removeUnsortedDuplicates(list.head).printList();

		System.out.println("Sorting");
		list.sort();
		list.printList();

		System.out.println("//////");
		list.reverse(1);
		list.printList();

		// list.printList();

		System.out.println("Dual Swap");

		LLutil.dualSwap(list.head).printList();

		// LLutil.recursiveSwap(new LNode(list.head)).printList();
	}
}
