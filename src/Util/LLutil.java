package Util;

import DataStructures.LNode;
import DataStructures.VLinkedList;
import DataStructures.VStack;
import Exceptions.StackOverflowException;
import Exceptions.StackUnderflowException;

public class LLutil {

	/**
	 * Check whether a list contains cycle or not
	 * @param list input Linked List
	 * @return true if yes, false if not.
	 */
	public static boolean isCycle(VLinkedList list){
		
		LNode slow = list.head;
		LNode fast = list.head;
		
		while(slow!=null && fast !=null && fast.next!=null){
			
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow==fast)
				return true;
				
		}
		
		return false;
		
	}
	
	/**
	 * Method to merge two linked lists into a single linked list
	 * @param list1 1st Linked List
	 * @param list2 2nd Linked List
	 * @return new merged LinkedList
	 */
	public static VLinkedList merge(VLinkedList list1,VLinkedList list2){
		
		VLinkedList newList = new VLinkedList();
		
		int list1_len = list1.size();
		int list2_len = list2.size();
		
		System.out.println("LEN1 : "+list1_len+"\n LEN2 :"+list2_len);
		int i=0,j=0;
			
		while(i<list1_len && j<list2_len){
			
			if(list1.get(i) <= list2.get(j)){
				newList.add(list1.get(i++));
			}else{
				newList.add(list2.get(j++));
			}
						
		}
	
		while(i<list1_len){
			newList.add(list1.get(i++));
		}
		
		while(j<list2_len){
			newList.add(list2.get(j++));
		}
		
		return newList;
	}

	public static boolean isPalindrome(VLinkedList list) throws StackOverflowException, StackUnderflowException{
		
		VStack<Integer> callStack = new VStack<>();
		
		LNode node = list.head;
		boolean isPalin = true;
		int i=0;
		
		while(node!=null && i<list.size()){
			callStack.push(list.get(i++));
			node = node.next;
		}
		
		
		node = list.head;
				
		while(node!=null){
			
			if(node.data!=callStack.pop()){
				isPalin = false;
				break;
			}
				
			node = node.next;
		}
		
		
		return isPalin;
	}

	public static boolean isPalindrome(LNode head){
		
		LNode slow = head;
		LNode fast = head;
		LNode slow_prev = null;
		LNode midPoint = null;
		
		
		while(slow!=null && fast!=null && fast.next!=null){
			slow_prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null){
			assert slow != null;
			midPoint = slow;
			slow = slow.next;
		}

		assert slow_prev != null;
		slow_prev.next= null;
		
		VLinkedList halfList = new VLinkedList();
		
		halfList.head = new VLinkedList().reverse(slow,1);
		
		VLinkedList originalList = new VLinkedList();
		originalList.head = head;
		
		boolean res = originalList.equals(halfList);
		
		halfList.reverse();
				
		if(midPoint != null){
			slow_prev.next = midPoint;
			midPoint.next = halfList.head;
		}else{
			slow_prev.next = halfList.head; 
		}
	
		originalList.printList();
		
		return res;
	}

	private static void printRecursiveReverse(LNode node){
		
		if(node==null)
			return;
				
		printRecursiveReverse(node.next);
		
		System.out.println(node.data+" ");
		
	}
	
	public static LNode recursiveReverse(LNode current,LNode prev){
		// 1->2->3->4
		
		LNode head;
		
		if(current.next == null){
			head = current;
			current.next = prev;
			return head;
		}
			
		
		LNode next = current.next; //2
		
		current.next = prev; //null
		
		// 3->2->1
		return  recursiveReverse(next, current);
	
	}
	
}
