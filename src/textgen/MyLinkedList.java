package textgen;

import java.io.IOException;
import java.util.AbstractList;

import javax.print.attribute.standard.RequestingUserName;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head=null;
		tail=null;
		size=0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element==null){
			throw new NullPointerException("Null Element cannot be added");
		}
		LLNode<E> newNode=new LLNode<E>(element);
		size++;
		if(head==null){
			head=newNode;
			tail=newNode;
			head.next=tail;
			tail.prev=head;
			return true;
		}
		tail.next=newNode;
		newNode.prev=tail;
		tail=newNode;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		
		if(index<0||index>=size){
			throw new IndexOutOfBoundsException("Index is invalid");
		}
		
		
		return getNode(index).data;
	}

	
	private LLNode<E> getNode(int index) 
	{
		// TODO: Implement this method.
		
		if(index<0||index>=size){
			throw new IndexOutOfBoundsException("Index is invalid");
		}
		LLNode<E> temp=head;
		for(int i=0;i<=index;i++){
			if(i==index){
				return temp;
			}
			temp=temp.next;
		}
		
		return null;
	}
	
	
	
	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		if(element==null){
			throw new NullPointerException("Null Element cannot be added");
		}
		
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("Index is invalid");
		}
		
		if(index==size||size==0){
			add(element);
			return;
		}
		
		LLNode<E> newNode=new LLNode<E>(element);
		size++;
		
		if(index==0){
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
			return;
		}
		
		LLNode<E> temp=getNode(index-1);
		
		newNode.next=temp.next;
		newNode.prev=temp;
		temp.next=newNode;
		temp=newNode.next;
		temp.prev=newNode;
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index<0||index>=size){
			throw new IndexOutOfBoundsException("Index is invalid");
		}
		
		LLNode<E> del;
		size--;
		if(index==size-1){
			del=tail;
			tail=tail.prev;
			tail.next=null;
			del.prev=null;
			return del.data;
		}
		
		if(index==0){
			del=head;
			head=head.next;
			head.prev=null;
			del.next=null;
			return del.data;
		}
		
		
		LLNode<E> temp=getNode(index-1);
		
		del=temp.next;
		
		temp.next=del.next;
		temp=del.next;
		temp.prev=del.prev;
		del.next=null;
		del.prev=null;
		return del.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index<0||index>=size){
			throw new IndexOutOfBoundsException("Index is invalid");
		}
		
		LLNode<E> temp=getNode(index);
		E del=temp.data;
		temp.data=element;
		
		return del;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
