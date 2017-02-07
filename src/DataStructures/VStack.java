package DataStructures;

import java.util.ArrayList;
import java.util.List;

import Exceptions.StackOverflowException;
import Exceptions.StackUnderflowException;

/**
 * A Custom implementation of Stack
 * @param <T> Type of the data to be inserted into the stack
 */
public class VStack<T>{

	private List<T> stackData = new ArrayList<>();
	private int top=0;
	private static final int MAX_SIZE = 1395; // maximum size of the stack
	
	/**
	 * pushes the new item into the stack
	 * @param newData new data to be pushed to the stack
	 * @throws StackOverflowException if,stack is full.
	 */
	public void push(T newData) throws StackOverflowException{
		
		// check if stack is full
		if(top>MAX_SIZE)
			throw new StackOverflowException();
		
		stackData.add(newData); //add new data to the stack
		top++;
	
	}
	
	/**
	 * to get item out of the stack.
	 * @return value that is popped out of the stack
	 * @throws StackUnderflowException if stack is empty.
	 */
	public T pop() throws StackUnderflowException{
				
		// check if the stack is empty before popping up.
		if(stackData.isEmpty())
			throw new StackUnderflowException();

		return stackData.remove(stackData.size()-1); //popping;
	}
	
	/**
	 * checks whether the stack is empty or not
	 * @return true if yes, false if not;
	 */
	public boolean isEmpty(){
		return stackData.isEmpty();
	}

}


