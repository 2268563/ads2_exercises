package ex02;

import java.util.*;
import java.io.*;

public class ArrayQueue<E> {

	public static final int CAPACITY = 10; // default queue capacity
	private E[] Q; // E array used to implement the queue
	private int n; // actual capacity of queue
	private int front; // index for the top of queue
	private int rear; // rear of the queue
	private int size; // size of the queue

	public ArrayQueue() {
		this(CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		n = capacity;
		Q = (E[]) new Object[n];
		front = rear = size = 0;
	}
	//
	// NOTE: java does not allow creation of array with parametrised type!
	//

	public int size() {
		return size;
	}
	//
	// IMPLEMENT ME - done
	//

	public boolean isEmpty() {
		return size == 0;
	}
	//
	// IMPLEMENT ME - done
	//

	public E front() throws ArrayQueueException {
		if (isEmpty()) {
			throw new ArrayQueueException("Queue underflow");
		}
		return Q[front];
	}
	//
	// IMPLEMENT ME - done
	//

	public void enqueue(E element) throws ArrayQueueException {
		if (size == n) {
			throw new ArrayQueueException("Queue overflow");
		}
		Q[rear] = element;
		rear = (rear + 1) % n;
		size += 1;
	}
	//
	// IMPLEMENT ME - done
	//

	public E dequeue() throws ArrayQueueException {
		if (isEmpty()) {
			throw new ArrayQueueException("Queue underflow");
		}
		E temp = Q[front];
		Q[front] = null;
		front = (front + 1) % n;
		size -= 1;
		return temp;
	}
	//
	// IMPLEMENT ME - done
	//

	public String toString() {
		String result = "[";
		for (int i = 0; i < size; i++) {
			result += Q[(i + front) % n];
			if (i != size() - 1) {
				result += ',';
			}
		}
		return result + ']';
	}
	//
	// IMPLEMENT ME - done
	//
	//
	// NOTE: if the queue contains 1,2,3 then return "[1,2,3]"
	// if the queue contains 1 then return "[1]"
	// if the queue is empty return "[]"
	//
}
