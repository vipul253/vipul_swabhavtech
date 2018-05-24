package com.techlabs.adapter;

import java.util.Iterator;
import java.util.LinkedList;

public class SwabhavQueue<T> implements Iterable<T> {
	
	private LinkedList<T> queue;
	
	public SwabhavQueue() {
		this.queue=new LinkedList<T>();
	}
	
	public void enqueue(T e){
		this.queue.addLast(e);
	}
	
	public T dequeue(){
		return this.queue.removeFirst();
	}
	
	public int count(){
		return this.queue.size();
	}

	@Override
	public Iterator<T> iterator() {
		return this.queue.iterator();
	}
}
