package com.neco4j.graph;

/**
 * Generic Queue class that implements generic queue interface
 * @author Necati Kartal
 * @param <T>
 */
public class Queue<T> implements IQueue<T> {

	private T[] items;
	private int front, back;
	private int count;

	/**
	 * No-argument queue constructor
	 */
	@SuppressWarnings("unchecked")
	public Queue() {
		items = (T[]) new Object[10000];
		front = 0;
		back = 0;
		setCount(0);
	}

	/**
	 * One-argument queue constructor
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public Queue(int size) {
		items = (T[]) new Object[size];
		front = 0;
		back = 0;
		setCount(0);
	}

	/**
	 * Enqueue the item to the queue
	 * @param item
	 */
	@Override
	public void Enqueue(T item) {
		if (isFull())
			throw new FullQueueException(String.format(
					"Queue is full, cannot enqueue %s", item));
		setCount(getCount() + 1);
		items[back] = item;
		back = (back + 1) % items.length;
	}

	/**
	 * Dequeue the item from the queue
	 * @return item
	 */
	@Override
	public T Dequeue() {
		if (isEmpty())
			throw new EmptyQueueException("Queue is empty, cannot dequeue");
		setCount(getCount() - 1);
		T ritem = items[front];
		front = (front + 1) % items.length;
		return ritem;
	}

	/**
	 * Checks the queue is empty or not
	 * @return isEmpty
	 */
	@Override
	public Boolean isEmpty() {
		return getCount() == 0;
	}

	/**
	 * Checks the queue is full or not
	 * @return isFull
	 */
	@Override
	public Boolean isFull() {
		return getCount() == items.length;
	}

	/**
	 * Display the queue
	 */
	@Override
	public void Display() {
		for (int i = front; i != back; i = ((i + 1) % items.length))
			System.out.println(items[i]);
	}

	/**
	 * Gets the queue's items count
	 * @return count
	 */
	@Override
	public int getCount() {
		return count;
	}

	/**
	 * Sets the queue's item count
	 * @param count
	 */
	@Override
	public void setCount(int count) {
		this.count = count;
	}
}
/**
 * Custom empty queue exception class
 * @author Necati Kartal
 */
@SuppressWarnings("serial")
class EmptyQueueException extends RuntimeException {
	
	/**
	 * No-argument exception constructor
	 */
	public EmptyQueueException() {
		this("Queue is empty");
	}

	/**
	 * One-argument exception constructor
	 * @param exception
	 */
	public EmptyQueueException(String exception) {
		super(exception);
	}
}

/**
 * Custom full queue exception class
 * @author Necati Kartal
 */
@SuppressWarnings("serial")
class FullQueueException extends RuntimeException {
	
	/**
	 * No-argument exception constructor
	 */
	public FullQueueException() {
		this("Queue is full");
	}

	/**
	 * One-argument exception constructor
	 * @param exception
	 */
	public FullQueueException(String exception) {
		super(exception);
	}
}