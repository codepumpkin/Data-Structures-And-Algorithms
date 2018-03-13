package com.codepumpkin.dataStructures;

import java.util.NoSuchElementException;

/**
 * You can read more about SinglyLinkedList Implementation in Java  at 
 * http://codepumpkin.com/linked-list/
 * 
 * @author codepumpkin.com
 * 
 * */
public class SinglyLinkedList< E> {

	
	public SinglyLinkedList() {
	}
	
	
	/**
	 * This inner class will hold the value of element and link to the next node.
	 * 
	 */
	private static class Node< E>{
		private E element;
		private Node< E> next;
		public Node(E e, Node< E> n){
			element = e;
			next = n;
		}
		
		public E getElement(){
			return element;
		}
		
		public Node< E> next(){
			return next;
		}
		
		public void setNext(Node< E> n){
			next=n;
		}
	}
	/**
	  * This will hold the first element of the linkedlist  
	  */
	public Node< E> head=null;
	/**
	  * This will hold the last element of the linkedlist 
	  */
	public Node< E> tail=null;
	/**
	  * This will hold the size of the linkedlist 
	  */
	public int size=0;
	
	
	/**
	  * This method is to check for current size of linkedlist
	  * Complexity: O(1) as we need to return size element  
	  */
	public boolean isEmpty(){
		return size==0;
	}
	
	/**
	  * This method will return first element of linkedlist which is element in head
	  * Complexity: O(1) as we have to return head element 
	  */
	public E first(){
		return head != null?head.getElement():null;
		
	}
	
	/**
	  * This method will return last element of linkedlist which is element in tail
	  * Complexity: O(1) as we have to return tail element 
	  */
	public E last(){
		return tail != null?tail.getElement(): null;
	}
	
	/**
	  * This method is for adding element at the end of the linked list.
	  * we are creating a new node for given element and change the reference with tail element
	  * Complexity: O(1) as we have to just add element and set reference
	  * 
	  */
	public void addLast(E e){
		Node< E> newest= new Node<>(e,null);
		if(isEmpty()){
			head= newest;
		}else{
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	
	/**
	  * This method is for adding element at the starting of the linked list.
	  * we are creating a new node for given element and change the reference with head element
	  * Complexity: O(1) as we have to just add element and set reference   
	  */
	public void addFirst(E e){
		head = new Node<> (e,head);
		if(isEmpty()){
			tail=head;
		}
		size++;
	}
	
	/**
	  * This method is for removing element at the start of the linked list.
	  * we than change the reference of head element and return the removed element
	  * Complexity: O(1) as we have to just remove reference
	  *    
	  */
	public E removeFirst(){
		if(isEmpty()){
			return null;
		}
		E ele = head.element;
		head = head.next();
		size--;
		if(size==0)
			tail= null;
		return ele;
	}
	
	/**
	  * This method is for retrieving element at given index i
	  * Complexity: O(n) as we have to iterate to get to the given index   
	  */
	public E get(int i){
		if(isEmpty()){
			return null;
		}
		Node<E> n = head;
		while(i>0){
			if(n.next == null)
				throw new IndexOutOfBoundsException();
			n = n.next;
			i--;
		}
		return n.getElement();
	}
	
	/**
	  * This method is for removing first occurrence of given element from the linkedlist. 
	  *  Complexity: O(n) as we have to iterate to get to the given element  
	  */
	public E remove(E v){
		if(isEmpty()){
			return null;
		}
		Node< E > n = head;
		while(n.element != v){
			if(n.next == null){
				throw new NoSuchElementException();
			}
			n=n.next;
		}
		size--;
		return n.element;
	}
	
	/**
	  * This method is for adding new element after given index in the linkedlist
	  * Complexity: O(n) as we have to iterate to get to the given index
	  *    
	  */
	 public void addAfter(int i, E v) {
	        Node< E > n = head;
	        while(i>0) {
	            if (n.next == null) {
	                throw new IndexOutOfBoundsException();
	            }
	            n = n.next;
	            i--;
	        }
	        Node<E> newNode = new Node<E>(v,n.next);
	        n.next = newNode;
	        size++;
	    }
	 
	 public static void main(String[] args){
			 SinglyLinkedList< Integer > myList = new SinglyLinkedList<>();
			 myList.addFirst(10);
			 myList.addLast(20);
			 myList.addLast(40);
			 myList.addAfter(1, 30);
			 System.out.println(myList.get(2));
			 myList.addLast(50);			 
		 }
	
}

