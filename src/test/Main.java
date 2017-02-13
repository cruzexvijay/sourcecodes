package test;

import java.util.Comparator;

import DataStructures.LNode;
import DataStructures.VLinkedList;

class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		VLinkedList list = new VLinkedList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

		System.out.println(list.size());

		System.out.println("Printing");
		list.printList();

		System.out.println("\nremoving");
		list.remove(2, 1);
		list.remove(6, 5);

		list.printList();

		System.out.println("size of list :" + findSize(list.head));

		System.out.println("Search element : " + list.rSearch(5));

		list.swap(1, 5);

		list.printList();

		System.out.println("size : " + list.size());

		System.out.println("Nth element : " + list.getNthNode(list.size() - 1).data);
		list.add(6, 0);
		list.add(7);
		list.add(8);
		list.add(8);
		list.add(8, 2);

		list.printList();
		list.getMedian();

		list.getNthNodefromLast(2);

		System.out.println(list.getCount(8));

		list.printList();
		System.out.println("Reversed List");
		 list.reverse();
		 list.reverse(2);
		list.printList();

		// System.out.println(list.get());

		list.sortedInsert(9);
		list.add(12);
		list.sortedInsert(11);
		list.printList();

		list.clear();

		System.out.println();

		list.add(6);
		list.add(7);
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(4);
		list.add(9);
		list.add(2);
		list.add(5);

		list.printList();

		System.out.println("---ascending order-----");
		list.sort();
		list.printList();
		System.out.println("---descending order-----");
		list.sort(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		
		list.printList();
		
		System.out.println("Rotating list");
		list.rotateList(4);
		list.printList();
		
		list.clear();
		
		list.add(1);
		list.add(2);
		list.add(6);
		list.add(8);
		list.add(7);
		list.add(3);
		list.add(4);
	//	list.printList();
		list.reverse();
		list.printList();
		list.zigzag();
		list.printList();
	}

	private static int findSize(LNode node) {
		if (node == null)
			return 0;
		return 1 + findSize(node.next);
	}
}
