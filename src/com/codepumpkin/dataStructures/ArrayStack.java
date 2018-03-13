package com.codepumpkin.dataStructures;

/**
 * This is an array implementation of a stack.
 * You can read more about Stack Implementation Using Array at 
 * http://codepumpkin.com/stack-implementation-using-array/
 * 
 * @author codepumpkin.com
 * 
 * */
@SuppressWarnings("unchecked")
public class ArrayStack<AnyType> implements StackInterface<AnyType> {
	private static final int DEFAULT_CAPACITY = 15;
	private int top; // reference to the top element
	private AnyType[] A;

	/**
	 * Creates a Stack of the size initialCapacity
	 */
	public ArrayStack(int initialCapacity) {
		if (initialCapacity <= 0)
			A = (AnyType[]) new Object[DEFAULT_CAPACITY];
		else
			A = (AnyType[]) new Object[initialCapacity];

		top = -1; // stack is empty
	}

	/**
	 * Creates a Stack with the default capacity
	 */
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Tests if the stack is empty.
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * Returns the top item without its removal.
	 */
	public AnyType peek() {
		if (isEmpty())
			throw new StackException("Stack is empty");
		return A[top];
	}

	/**
	 * Removes and returns the item at the top of this stack.
	 */
	public AnyType pop() {
		AnyType x = peek();
		A[top] = null; // make sure the object is destroyed
		top--;
		return x;
	}

	/**
	 * Inserts an item onto the top of the stack.
	 */
	public void push(AnyType e) {
		if (top == A.length)
			throw new StackException("Stack has overflowed");
		top++;
		A[top] = e;
	}

	/**
	 * Removes all items from the Stack.
	 */
	public void clear() {
		for (int i = 0; i <= top; i++)
			A[i] = null;

		top = -1;
	}

	/**
	 * Returns a string representation of the Stack.
	 */
	public String toString() {
		if (isEmpty())
			return "[ ]";

		StringBuffer out = new StringBuffer("[");
		for (int i = 0; i < top; i++)
			out.append(A[i] + ", ");

		out.append(A[top] + "]");
		return out.toString();
	}

	public static void main(String[] args) {
		ArrayStack<Integer> s = new ArrayStack<Integer>(6);

		try {

			for (int i = 0; i < 6; i++)
				s.push(i);

			// s.clear();
			System.out.println(s);

			for (int i = 0; i < 5; i++)
				s.pop();

			System.out.println(s);

		} catch (StackException e) {
			System.err.println(e);
		}
	}
}

/** StackInterface **/

interface StackInterface<AnyType> {
	/**
	 * Tests if the stack is empty.
	 */
	public boolean isEmpty();

	/**
	 * Removes and returns the item at the top of this stack.
	 */
	public AnyType pop() throws StackException;

	/**
	 * Returns the top item without its removal
	 */
	public AnyType peek() throws StackException;

	/**
	 * Inserts an item onto the top of the stack.
	 */
	public void push(AnyType e) throws StackException;

	/**
	 * Removes all items from the stack.
	 */
	public void clear();
}

/** StackException **/

class StackException extends RuntimeException {
	public StackException(String name) {
		super(name);
	}

	public StackException() {
		super();
	}
}
