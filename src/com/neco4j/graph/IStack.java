package com.neco4j.graph;

/**
 * A small generic stack interface
 */
public interface IStack<T> {
	
	/**
	 * Adds the given item to the top of the stack
	 */
	void Push(T item);

	/**
	 * Removes the top item from the stack and returns it
	 */
	T Pop();

	/**
	 * Returns the top item from the stack without popping it
	 */
	T Peek();

	/**
	 * Returns whether the stack is empty or not
	 */
	boolean isEmpty();

	/**
	 * Returns whether the stack is full or not
	 */
	boolean isFull();

	/**
	 * Returns the number of items currently in the stack
	 */
	int Count();
} 