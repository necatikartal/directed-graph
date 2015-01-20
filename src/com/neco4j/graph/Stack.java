package com.neco4j.graph;

/**
 *Generic stack class that implements generic stack class
 */
public class Stack<T> extends Object implements IStack<T> {
	
	private T[] items;
	private int top;

	/**
	 * No-argument queue constructor
	 */
	@SuppressWarnings("unchecked")
	public Stack() {
		top = -1;
		items = (T[]) new Object[20];
	} 

	/**
	 * One-argument stack constructor
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		top = -1;
		items = (T[]) new Object[size];
	} 

	/**
	 * Adds the given item to the top of the stack
	 * @param item
	 * @throws if stack is full
	 */
	@Override
	public void Push(T item) {
		if (isFull())
			throw new FullStackException(String.format(
					"Stack is full, cannot push %s", item));
		items[++top] = item;
	} 

	/**
	 * Removes the top item from the stack and returns it
	 * @throws if stack is empty
	 * @return top item
	 */
	@Override
	public T Pop() {
		if (isEmpty())
			throw new EmptyStackException("Stack is empty, cannot pop");
		return items[top--];
	} 

	/**
	 * Returns the top item from the stack without popping it
	 * @throws if stack is empty
	 * @return top item
	 */
	@Override
	public T Peek() {
		if (isEmpty())
			throw new EmptyStackException("Stack is empty, cannot peek");
		return items[top];
	} 

	/**
	 * Returns whether the stack is empty or not
	 * @return true/false condition
	 */
	@Override
	public boolean isEmpty() {
		return top == -1;
	} 

	/**
	 * Returns whether the stack is full or not
	 * @return true/false condition
	 */
	@Override
	public boolean isFull() {
		return top == items.length - 1;
	} 

	/**
	 * Returns the number of items currently in the stack
	 * @return count
	 */
	@Override
	public int Count() {
		return top + 1;
	}
} 

/**
 * Custom empty stack exception class
 * @author Necati Kartal
 */
@SuppressWarnings("serial")
class EmptyStackException extends RuntimeException {
	
	/**
	 * No-argument exception constructor
	 */
	public EmptyStackException() {
		this("Stack is empty");
	}

	/**
	 * One-argument exception constructor
	 * @param exception
	 */
	public EmptyStackException(String exception) {
		super(exception);
	}
}

/**
 * Custom full Stack exception class
 * @author Necati Kartal
 */
@SuppressWarnings("serial")
class FullStackException extends RuntimeException {
	
	/**
	 * No-argument exception constructor
	 */
	public FullStackException() {
		this("Stack is full");
	}

	/**
	 * One-argument exception constructor
	 * @param exception
	 */
	public FullStackException(String exception) {
		super(exception);
	}
}