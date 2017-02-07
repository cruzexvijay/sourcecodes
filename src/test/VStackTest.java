package test;

import DataStructures.VStack;
import Exceptions.StackOverflowException;
import Exceptions.StackUnderflowException;


public class VStackTest {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		// TODO Auto-generated method stub

		VStack<Integer> stack = new VStack<>();
		
		stack.push(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
				
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
