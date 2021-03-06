package DataStructures;

import java.util.Comparator;
/**
 * A Custom implementation of LinkedList datastructure
 */
@SuppressWarnings("ALL")
public class VLinkedList{

	public LNode head;
	private final Integer MAX_SIZE;
	private static final int NO_SIZE = -1395;
	
	private Comparator<Integer> listComparator = null;
	
	public VLinkedList() {
			
		this.head = null;
		this.MAX_SIZE = NO_SIZE;
		
		if(this.listComparator==null){
			listComparator = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1.compareTo(o2);
				}
			};
		}
	}
		
	public VLinkedList(Integer size) {
		super();
		this.MAX_SIZE = size;
	}
	
	
	/**
	 * Method to add element to the end of the list
	 * @param data new data to be inserted into the list
	 */
	@SuppressWarnings("UnusedReturnValue")
    public VLinkedList add(int data){
		
		if(MAX_SIZE!=NO_SIZE && size()>MAX_SIZE)
			throw new IndexOutOfBoundsException("Limit Exceeded");
		
		if(head==null){
			head = new LNode(data);
		}
		else{
			LNode newNode = new LNode(data);
			LNode node=head;
		
			while(node!=null && node.next!=null){
				node=node.next;
			}

            assert node != null;
            node.next = newNode;
			//head = node;
		}
		
		return this;
	}
	
	/**
	 * Method to add element to insert at a specified position 
	 * @param data new data to be inserted
	 * @param pos position to insert
	 */
	public VLinkedList add(int data,int pos){
		
		if(pos==0){
			LNode newNode = new LNode(data);
			newNode.next = head;
			head = newNode;
			return this;
		}
		
		LNode curr=head;
		LNode prev=null;
		int curPos=0;
		
		while(curr!=null && curPos!=pos){
			prev = curr;
			curr = curr.next;
			curPos++;
		}
		
		if(curr!=null){
			LNode newNode = new LNode(data);
			newNode.next = curr;
			prev.next = newNode;
		}else{
			System.out.println("Cannot insert element at the specified position");
		}
		
		return this;
	}
	
	/**
	 * method to find the size of the linked list
	 * @return size of the list
	 */
	public int size(){
		return size(head);
	}
	
	private int size(LNode node){
		if(node==null)
			return 0;
		
		return 1+size(node.next);
	}
	
	/**
	 * Method to remove an item from the list based on the data
	 * @param key "data" to be removed
	 */
	public void remove(int key){
		
		LNode currentNode = head;
		LNode prevNode = null;
		
		
		if(currentNode!=null && currentNode.data==key){
			head = currentNode.next;
		}
		
		while(currentNode!=null && currentNode.data!=key){
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		
		
		if(currentNode==null)
			return;

        assert prevNode != null;
        prevNode.next = currentNode.next;
				
	}
	
	/**
	 * Method to remove an item from the list based on the data and its position
	 * @param key "data" to be removed
	 * @param pos "position" of the element
	 */
	public void remove(int key,int pos){

		LNode curr=head;
		LNode prev = null;
		int count=0;
		
		/*
		 * if the position is the first element, with the 
		 * correct key, then delete the element.
		 * 
		 */
		if(pos==0 && curr!= null && curr.data==key){
			head = curr.next;
			return;
		}
		
		while(count!=pos && curr != null && curr.data != key){
			prev = curr;
			curr = curr.next;
			count++;
		}
		
		if(curr==null)
			return;

        assert prev != null;
        prev.next = curr.next;
			
	}
	
	public boolean contains(int key){
		return search(key)!=null;
	}
		
	/**
	 * prints the list
	 */
	public void printList(){
		printList(head);
	}

	private void printList(LNode node){
		
		if(node==null){
			System.out.println("No list found");
			return;
		}
					
		while(node!=null){
			System.out.print(node.data+" ");
			node = node.next;
		}
		
		System.out.println();
	}
	
	/**
	 * Iterative implementation of searching in LinkedList
	 * @param key search key
	 * @return true if found, false if not;
	 */
	private LNode search(int key){
		
		LNode node = head;
		
		//iterate through the list,exit when the node is found
		// with the matching key.
		while(node!=null && node.data!=key){
			node = node.next;
		}
	
		return node!=null?node:null;
	}
	
	public boolean rSearch(int key){
		return rSearch(head,key);
	}
	
	/**
	 * recursive implementation of searching in LinkedList
	 * @param node Current Node of the linked list
	 * @param key search key.
	 * @return true if found, false if not;
	 */
    private boolean rSearch(LNode node, int key) {
        return node != null && (node.data == key || rSearch(node.next, key));
    }
		
	/**
	 * Swapping of two nodes without swapping their value.
	 * @param x "X" value
	 * @param y "Y" value
	 */
	@SuppressWarnings("SameParameterValue")
    public void swap(int x, int y){
	
		if(x==y)
			return; //return when both elements are equal
		
		LNode curX,prevX,curY,prevY;
		curX = head;
		prevX = null;

		/*
		 * find the node for key "X"
		 */
		while(curX!=null&&curX.data!=x){
			prevX = curX;
			curX = curX.next;
		}
		
		
		curY=head;
		prevY = null;
		/*
		 * find the node for key "X"
		 */
		while(curY!=null && curY.data!=y){
			prevY = curY;
			curY = curY.next;
		}
		
		/*
		 * return when any one of the elements is not present 
		 */
		if(curX==null || curY ==null)
			return;
		
		// assign the previous node pointers for X node
		if(prevX != null){
			prevX.next = curY;
		}else{
			head = curY;
		}
		
		// assign the previous node pointers for Y node
		if(prevY != null){
			prevY.next = curX;
		}else{
			head = curX;
		}
			
		// swap the pointers
		LNode temp = curX.next;
		
		curX.next = curY.next;
		curY.next = temp;
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
	 * implementation to get the Nth element of a LinkedList
	 * @param pos position of the node
	 * @return node
	 */
	public LNode getNthNode(int pos){
		
		LNode node = head;
		int curPos=0;
		
		if(pos==0)
			return node;
		
		while(node!=null && pos!=curPos){
			node = node.next;
			curPos++;
		}
		
		return node;
	}


	/**
	 * implementation to find the median/middle of the linked list
	 * @return data of the list
	 */
	public LNode getMedian(){
		return this.getMedianNode(head);
	}
	
	/**
	 * implementation to find the middle node of the linked list
	 * @param start start node
	 * @return middle node of the linked list
	 */
	private LNode getMedianNode(LNode start) {

		LNode slow;
		LNode fast;

		if (start == null || start.next == null) {
			slow = start;
		} else {

			slow = start;
			fast = start.next;

			while (fast != null) {

				fast = fast.next;

				if (fast != null) {
					slow = slow.next;
					fast = fast.next;
				}
			}
		}

		return slow;
	}

	/**
	 * get Nth node from the end of the linked list
	 * @param pos position from the end.
	 */
	public LNode getNthNodefromLast(@SuppressWarnings("SameParameterValue") int pos){
		
		LNode temp = getNthNode(size()-1-pos);

		return temp!=null?temp:null;
	}

	/**
	 * Returns the count of occurences of a given number
	 * @param key key to find the occurence
	 * @return no of occurences of the given key
	 */
	public int getCount(int key){
		
		int count=0;
		LNode node=head;
		
		while(node!=null){
			
			if(node.data==key)
				count++;
			
			node = node.next;
		}
		
		return count;
	}

	/**
	 * reverses a linked list
	 */
	public void reverse(){
		
		LNode current = head;
		LNode prev = null;
		LNode temp;
		
		/*
		 * change next to prev,prev to current, current to next
		 */
		while(current!=null){
			temp = current.next; //3 
			current.next = prev; //1
			prev = current;
			current = temp;
		}
		
		head = prev;
	}
	
	/**
	 * reverses the list groups of given size
	 * @param k size of each group
	 */
	public void reverse(int k){
		head = reverse(head,k);
	}
	
	/**
	 * Implementation to reverse the linked list in terms of groups
	 * @param node start node of the list
	 * @param k size of the group
	 * @return head node of the reversed list
	 */
	public LNode reverse(LNode node,int k){
		
		LNode current = node;
		LNode prev = null;
		LNode temp = null;
		
		int count = 0;
		/*
		 * change next to prev,prev to current, current to next
		 */
		while(count< k && current!=null){
			temp = current.next; //3 
			current.next = prev; //1
			prev = current;
			current = temp;
			count++;
		}
		
		if(temp != null)
			node.next = reverse(temp, k);
	
		return prev;
	}
	

	/**
	 * method to get the element of the linked list at 0th position
	 * @return returns the element at the given position
	 */
	public int get(){
		return get(0);
	}
	
	/**
	 * method to get an element at the given position
	 * @param pos position of the element to be found
	 * @return element at the given position
	 */
	public int get(int pos){
		
		LNode node = head;
		int curPos=0;
		
		if(pos==0)
			return node.data;
		
		while(node!=null && curPos!=pos){
			//System.out.println(node.data);
			node = node.next;
			curPos++;
		}
		
		if(node!=null)
			return node.data;
		else
			return -1;
		
	}

	/**
	 * Method to insert data into a list in sorted order
	 * @param newData new data to be inserted into the list
	 */
	public void sortedInsert(int newData){
		
		LNode node = head;
		LNode newNode = new LNode(newData);
		
		/*
		 * check if the new element is less than the head node;
		 * if yes, then create a new node and set it as head.
		 */
		if(node==null || newData < node.data){
			newNode.next = node;
            return;
		}
		
		LNode prev=null;
		LNode curr = node;
		
		/*
		 * iterate through the list, until an element greater than
		 * the new data is found. then insert a new node between the 
		 * two nodes.
		 */
		while(curr!=null && newData > curr.data){
			prev = curr;
			curr = curr.next;
		}
				
		newNode.next = curr;
        assert prev != null;
        prev.next = newNode;
	}


	/**
	 * checks whether two linked lists are equal or not
	 * @param list2 list to be checked against
	 * @return true if equals, false if not;
	 */
	public boolean equals(VLinkedList list2){
		return equals(this.head, list2.head);
	}
	
	/**
	 * recursive implementation to check whether 
	 * two lists are equal or not
	 * @param node1 -> node of list1
	 * @param node2 -> node of list2
	 * @return true if equal, false if not;
	 */
	private boolean equals(LNode node1,LNode node2) {

        if (node1 == null && node2 == null)
            return true;

        return node1 != null && node2 != null && (node1.data == node2.data) && equals(node1.next, node2.next);

    }

	/**
	 * method to sort the current linked list
	 */

    public void sort(){
       head = sort(head);
    }
    
    /**
     * Sorting based on custom comparator interface
     * @param customComparator custom comparator interface
     */
    public void sort(Comparator<Integer> customComparator){
    	this.listComparator = customComparator;
    	head = sort(head);
    }
    
    /**
     * recursive implementation to sort the list based on ascending order
     * @param head start pointer
     * @return new node of the sorted sub list
     */
    
    private LNode sort(LNode head) {
    	
		if (head == null || head.next == null)
			return head;
		LNode fast;
		LNode slow;
		
		slow = getMedianNode(head);
		fast = slow.next;
		slow.next = null;
		
		return mergeNodes(sort(head), sort(fast));
	}

	/**
	 * Recursive implementation to merge two lists into a single list
	 * @param node1 Node 1 of the first linked list
	 * @param node2 Node 2 of the second linked list
	 * @return head pointer of the new single sub list 
	 */
    private LNode mergeNodes(LNode node1, LNode node2) {
      
        if(node1==null)
            return node2;

        if(node2==null)
            return node1;

        LNode temp;

        if(listComparator.compare(node1.data, node2.data)<0) {
            temp = node1;
            temp.next = mergeNodes(node1.next,node2);
        }else {
            temp = node2;
            temp.next = mergeNodes(node1, node2.next);
        }
              
        return temp;
    }
    
   public void rotateList(int k){
	   head = rotateList(head,k);
   }
    
    private LNode rotateList(LNode node,int k){
    	
    	LNode current = node;
    	LNode kthNode;
    	int count = 0;
    	
    	while(count < k-1 && current != null){
    		current = current.next;
    		count++;
    	}
    	
    	kthNode = current;
    	
    	while(current!=null && current.next != null){
    		current = current.next;
    	}

        assert current != null;
        current.next = node;
    	
    	node = kthNode != null ? kthNode.next : null;
    	
    	kthNode.next = null;
    	
    	return node!=null?node:null;
    }
    

    public void zigzag(){
        	
    	LNode curr = head;
    	
    	boolean flag = true;
    	
    	while(curr.next!=null){
    		
    		System.out.println(curr.data+"--"+curr.next.data);
    		if(flag){
    			
    			if(curr.data > curr.next.data)
    				swap(curr,curr.next); //3,4
    		}else{
    			
    			if(curr.data < curr.next.data)
    				swap(curr,curr.next);
    		}
    		
    		curr = curr.next;
    		flag = !flag;
    		
    	}
    
    }
    
	/**
	 * clears the linked list
	 */
	public void clear(){
		this.head = null;
	}

}


