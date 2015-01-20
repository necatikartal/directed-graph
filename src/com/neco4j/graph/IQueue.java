package com.neco4j.graph;

/**
 * Generic queue interface
 * @author Necati Kartal
 * @param <T> 
 */
public interface IQueue<T> {

	/**
	 * Enqueue the item to the queue
	 * @param item
	 */
	void Enqueue(T item);

	/**
	 * Dequeue the item from the queue
	 * @return item
	 */
	T Dequeue();

	/**
	 * Checks the queue is empty or not
	 * @return isEmpty
	 */
	Boolean isEmpty();

	/**
	 * Checks the queue is full or not
	 * @return isFull
	 */
	Boolean isFull();

	/**
	 * Display the queue
	 */
	void Display();

	/**
	 * Gets the queue's items count
	 * @return count
	 */
	int getCount();

	/**
	 * Sets the queue's item count
	 * @param count
	 */
	void setCount(int count);
}