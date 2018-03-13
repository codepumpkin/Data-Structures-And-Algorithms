package com.codepumpkin.dataStructures.al;

/**
 * This is array based implementation of arraylist
 * You can read more about ArrayList implementation in java at 
 * http://codepumpkin.com/arraylist/
 * 
 * @author codepumpkin.com
 * 
 * */
public class ArrayList<E> implements List<E> {

	public static final int CAPACITY = 20;
	E[] data;
	private int size=0;
	public ArrayList(){
		this(CAPACITY);
	}
	
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	/*
	 * This runs on O(1)
	 * 
	 * */
	@Override
	public int size() {
		return size;
	}

	/*
	 * This runs on O(1)
	 * 
	 * */
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	/*
	 * This runs on O(1)
	 * 
	 * */
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if(i < 0 && i >= size+1) throw new IndexOutOfBoundsException("Illigal index"+i);
		return data[i];
	}

	/*
	 * This runs on O(1)
	 * 
	 * */
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if(i < 0 && i >= size+1) throw new IndexOutOfBoundsException("Illigal index"+i);
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	/*
	 * This runs on O(n)
	 * 
	 * */
	
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if(i < 0 && i >= size+1) throw new IndexOutOfBoundsException("Illigal index"+i);
		if(size==data.length) resize(data.length *2);;
		for(int k=size-1;k>=i;k--){
			data[k+1] = data[k];
		}
		data[i] = e;
		size++;
	}
/*
 * This runs on O(n)
 * 
 * */

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		if(i < 0 && i >= size+1) throw new IndexOutOfBoundsException("Illigal index"+i);
		E temp = data[i];
		for(int k=i;k<=size-1;k++){
			data[k]=data[k+1];
		}
		data[size-1] = null;
		size--;
		return temp;
	}
	
	protected void resize(int capacity) 
	{
		E[] temp = (E[]) new Object[capacity]; 
		System.arraycopy(data, 0, temp, 0,data.length);
		data = temp;
	}
	
	
}

