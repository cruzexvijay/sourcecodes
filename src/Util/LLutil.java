package Util;

import java.util.HashMap;
import java.util.Map;
import DataStructures.LNode;
import DataStructures.VLinkedList;
import DataStructures.VStack;
import Exceptions.StackOverflowException;
import Exceptions.StackUnderflowException;

public class LLutil {

	private static final VLinkedList list = new VLinkedList();

	/**
	 * Check whether a list contains cycle or not
	 * 
	 * @param list
	 *            input Linked List
	 * @return true if yes, false if not.
	 */
	public static boolean isCycle(VLinkedList list) {

		LNode slow = list.head;
		LNode fast = list.head;

		while (slow != null && fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;

		}

		return false;

	}

	/**
	 * Method to merge two linked lists into a single linked list
	 * 
	 * @param list1
	 *            1st Linked List
	 * @param list2
	 *            2nd Linked List
	 * @return new merged LinkedList
	 */
	public static VLinkedList merge(VLinkedList list1, VLinkedList list2) {

		VLinkedList newList = new VLinkedList();

		int list1_len = list1.size();
		int list2_len = list2.size();

		// System.out.println("LEN1 : "+list1_len+"\n LEN2 :"+list2_len);
		int i = 0, j = 0;

		while (i < list1_len && j < list2_len) {

			if (list1.get(i) <= list2.get(j)) {
				newList.add(list1.get(i++));
			} else {
				newList.add(list2.get(j++));
			}
		}

		while (i < list1_len) {
			newList.add(list1.get(i++));
		}

		while (j < list2_len) {
			newList.add(list2.get(j++));
		}

		return newList;
	}

	public static boolean isPalindrome(VLinkedList list) throws StackOverflowException, StackUnderflowException {

		VStack<Integer> callStack = new VStack<>();

		LNode node = list.head;
		boolean isPalin = true;
		int i = 0;

		while (node != null && i < list.size()) {
			callStack.push(list.get(i++));
			node = node.next;
		}

		node = list.head;

		while (node != null) {

			if (node.data != callStack.pop()) {
				isPalin = false;
				break;
			}

			node = node.next;
		}

		return isPalin;
	}

	public static boolean isPalindrome(LNode head) {

		LNode slow = head;
		LNode fast = head;
		LNode slow_prev = null;
		LNode midPoint = null;

		while (slow != null && fast != null && fast.next != null) {
			slow_prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) {
			assert slow != null;
			midPoint = slow;
			slow = slow.next;
		}

		assert slow_prev != null;
		slow_prev.next = null;

		VLinkedList halfList = new VLinkedList();

		halfList.head = new VLinkedList().reverse(slow, 1);

		VLinkedList originalList = new VLinkedList();
		originalList.head = head;

		boolean res = originalList.equals(halfList);

		halfList.reverse();

		if (midPoint != null) {
			slow_prev.next = midPoint;
			midPoint.next = halfList.head;
		} else {
			slow_prev.next = halfList.head;
		}

		originalList.printList();

		return res;
	}

	public static LNode recursiveReverse(LNode current, LNode prev) {
		// 1->2->3->4

		LNode head;

		if (current.next == null) {
			head = current;
			current.next = prev;
			return head;
		}

		LNode next = current.next; // 2

		current.next = prev; // null

		// 3->2->1
		return recursiveReverse(next, current);

	}

	/**
	 * Method to swap the elements of the list
	 * 
	 * @param head
	 *            start pointer of the list
	 * @return an instance of VLinkedList
	 */
	public static VLinkedList dualSwap(LNode head) {
		// return IdualSwap(head);
		return recursiveSwap(head);
	}

	/**
	 * recursive implementation of swapping the data
	 * 
	 * @param node
	 *            head node of the list
	 * @return an instance of Vlinked list
	 */
	private static VLinkedList recursiveSwap(LNode node) {

		if (node != null && node.next != null) {
			swap(node, node.next);
			recursiveSwap(node.next.next);
		}

		list.head = node;

		return list;
	}

	/**
	 * method to swap data between two nodes
	 * 
	 * @param node1
	 *            node1
	 * @param node2
	 *            node2
	 */
	private static void swap(LNode node1, LNode node2) {
		node1.data = node1.data + node2.data;
		node2.data = node1.data - node2.data;
		node1.data = node1.data - node2.data;
	}

	/**
	 * Implementation to remove duplicates in sorted list
	 */
	public static VLinkedList removeSortedDuplicates(LNode head) {

		LNode prev = null;
		LNode next;
		LNode node = head;

		if (head == null || head.next == null)
			return null;

		while (node != null) {

			if (prev != null && prev.data == node.data) {
				next = node.next;
				prev.next = next;
			} else {
				prev = node;
			}
			node = node.next;
		}

		list.head = head;
		return list;
	}

	/**
	 * Implementation to remove duplicate elements from an unsorted list
	 * @param head 
	 * 			start pointer of the list
	 * 
	 * @return new instance of VLinkedList
	 */
	public static VLinkedList removeUnsortedDuplicates(LNode head) {

		Map<Integer, Integer> map = new HashMap<>();

		LNode prev = null;
		LNode next;
		LNode node = head;

		if (head == null || head.next == null)
			return null;

		while (node != null) {

			if (prev != null && map.containsKey(node.data)) {
				next = node.next;
				prev.next = next;
			} else {
				map.put(node.data, 0);
				prev = node;
			}
			node = node.next;
		}

		list.head = head;

		return list;
	}

	/**
	 * Method to find the common nodes of two linked list
	 * @param node1 -> head pointer of 1st list
	 * @param node2 -> head pointer of 2nd list
	 * @return head reference of the new list
	 */
	public static LNode findIntersect(LNode node1, LNode node2) {

		VLinkedList list = new VLinkedList();

		while (node1 != null && node2 != null) {
			if (node1.data == node2.data) {

				list.add(node1.data);

				node1 = node1.next;
				node2 = node2.next;

			} else if (node1.data < node2.data)
				node1 = node1.next;
			else
				node2 = node2.next;
		}
		return list.head;
	}
	
	/**
	 * Deletes the alternating nodes of the linked list
	 * @param head -> start reference to the linked list
	 * @return node reference to the list
	 */
	public static LNode deleteAlternates(LNode head){
		
		if(head == null)
			return head;
		
		LNode prev = head;
		LNode curr = head.next;
		
		while(prev!=null && curr != null){
			
			prev.next = curr.next;
			
			curr = null;
			
			prev = prev.next;
			
			if(prev != null)
				curr = prev.next;
		}
		
		return head;
	}
	
	
	public static LNode[] split(LNode head){
	
		int pos = 0;
		LNode node = head;
		
		LNode ref1 = null;
		LNode ref2 = null;
		
		while(node!=null){
			
			if((pos&1)==0)
				ref1 = push(ref1,node);
			else
				ref2 = push(ref2,node);
		
			node = node.next;
			pos++;
		}
		
		return new LNode[]{ref1,ref2};
	}
	
	private static LNode push(LNode ref,LNode node){
				
		if(ref==null){
			ref = new LNode(node.data);
		}else{
			LNode newNode = new LNode(node.data);
			
			LNode temp = ref;
			
			while(temp!=null && temp.next!=null){
				temp = temp.next;
			}
			
			temp.next = newNode;		
		}
		
		return ref;
		
	}
	
	/**
	 * Reverses the alternate K nodes of the list
	 * @param head -> node in the list
	 * @param k -> no of nodes in alternate group
	 * @return reference to the new list
	 */
	public static LNode reverseAlternateNodes(LNode head,int k){
		
		LNode node = head;
		LNode prev = null;
		LNode curr = head;
		LNode next = null;
		
		int count = 0;
		
		
		while(curr!= null && count < k){
			
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
				
		if(node!=null)
			node.next = curr;
		
		//count=0;
		
		while(curr!=null && count > 1){
			curr = curr.next;
			count--;
		}
		
		if(curr!=null){
			//System.out.println(curr.next.data);
			curr.next = reverseAlternateNodes(curr.next, k);
		}
		
		return prev;
	}

	public static LNode del(LNode head){
		
		//System.out.println(head.data);
		
		list.head = head;
		list.reverse();
		
		head = list.head;
		
		LNode node = head;
	
		int max = head.data	;
		LNode temp = null;
		
		while(node!= null && node.next!=null){
			
			if(node.next.data < max){
				temp = node.next;
				node.next = temp.next;
				temp = null;
			}else{
				node = node.next;
				max = node.data;
			}			
		}
		list.head = head;
		list.reverse();
		
		return list.head;
	}
	
	
	public static LNode splitOddEven(LNode node){
		
		LNode oddRef = null;
		LNode evenRef = null;
		
		LNode curr = node;
		
		while(curr!=null && curr.next!=null){
			
			if((curr.data&1)!=0){
				oddRef = push(oddRef,curr);	
			}else{
				evenRef = push(evenRef,curr);
			}
			
			curr = curr.next;
			
		}
		
		System.out.println((oddRef.data&1)!=0);
		
		if(oddRef!=null && evenRef!=null){
			
			LNode temp = evenRef;
			
			while(temp!=null && temp.next!=null)
				temp = temp.next;
			
			temp.next = oddRef;
			
		}
		return evenRef;	
	}
	
	
	public static LNode removeLoop(VLinkedList list1){
		
		if(isCycle(list1)){
			return removeLoop(list1.head);
		}else{
			return null;
		}
		
		
	}
	
	private static LNode removeLoop(LNode node){
		
		LNode slow = node;
		LNode fast = node.next;
		
		while(fast != null && fast.next!=null){
			
			if(slow==fast)
				break;
			
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(slow == fast){
			slow = node;
			
			while(slow!=fast.next){
				slow = slow.next;
				fast = fast.next;
			}
			
			fast.next = null;
		}
		return node;
	}
	
	public static LNode findTriplets(LNode node1,LNode node2,LNode node3,int val){
		
		LNode a = node1;
		LNode b = node2;
		LNode c = node3;
		
		LNode newRef = null;
		
		while(a!=null){
		
			while(b!=null && c!=null){
				
				int sum = a.data + b.data + c.data;

				if(sum==val){
					newRef = push(push(push(newRef, a), b),c);
					break;
				}else if (sum < val){
					b = b.next;
				}else
					c = c.next;
			}
			
			a = a.next;
		}
		
		return newRef!=null?newRef:null;
	}

	public static void skipMdeleteN(LNode head,int m,int n){

	    LNode current = head;
	    LNode t;
	    int count = 1;

	    while (current!=null){

            while (count<m && current!=null) {
                current = current.next;
                count++;
            }

            if(current==null)
                return;

            t = current.next;
            count = 0;

            while (count < n && t!=null && t.next!=null){
                t = t.next;
                count++;
            }

            current.next = t;
            current = t;
        }
	}
	
	public static void mergeTwoLists(VLinkedList list1,VLinkedList list2){
	
		LNode[] rets = mergeTwoLists(list1.head, list2.head);
		list1.head = rets[0];
		list2.head = rets[1];
	}


	private static LNode[] mergeTwoLists(LNode fNode,LNode sNode){

	    LNode pNext = null;
	    LNode qNext = null;
	    LNode pCurrent = fNode;
	    LNode qCurrent = sNode;

	    // 1->3->5 ----- 2->4->6
        //1->2->3->4->5->6
 	    while (pCurrent!=null && qCurrent!=null){
            pNext = pCurrent.next;
	        qNext = qCurrent.next;

            qCurrent.next = pNext;
            pCurrent.next = qCurrent;

            pCurrent = pNext;
            qCurrent = qNext;
        }
 	   return new LNode[]{fNode,qCurrent};
    }
	
	public static LNode pairwiseSwap(LNode headRef){
		
		LNode curr = headRef;
		LNode prev = null;
		LNode next = null;
		
		while(curr!=null && curr.next!=null){
			
			next = curr.next;
			curr.next = next.next;
			next.next = curr;
			
			if(prev==null){
				headRef = next;
			}else{
				prev.next = next;
			}
			
			prev = curr;
			curr = curr.next;
		}
				
		return headRef;
	}
	
	
	public static LNode add1(LNode headRef){
		
		LNode curr = headRef;
		
		int sum = 0;
		int carry = 1;
		
		while(curr!=null){
			
			sum = curr.data + carry;
			
			carry = sum >= 10 ? 1 : 0;
		
			if(carry==1)
				curr.data = 0;
			else{
				curr.data = sum;
				break;
			}
		
			curr = curr.next;
		}
		
		list.head = headRef;
		list.reverse();
		headRef = list.head;
		list.clear();
		
		return headRef;
	}
	
	public static LNode removeLastOccurence(LNode headRef,int key){
		
		LNode prevKeyNode = null;
		LNode node = headRef;
		
		while(node!=null){
			
			if(node.next !=null && node.next.data==key)
				prevKeyNode = node;
			
			node =  node.next;
		}
		
		if(prevKeyNode!=null){
			
			node  = prevKeyNode.next;
			prevKeyNode.next = node.next;
			
			node = null;
		}else{
			
			if(headRef!=null && headRef.next!=null){
				headRef = headRef.next;
			}
		}
		
		return headRef;
	}
}
