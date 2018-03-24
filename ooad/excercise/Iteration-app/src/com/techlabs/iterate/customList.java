package com.techlabs.iterate;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class customList implements Iterable<Integer> {
	
	private int listStart;
	private int listEnd;
	
	public customList(int listStart, int listEnd){
		this.listStart=listEnd;
		this.listEnd=listEnd;
	}
	@Override
	public Iterator<Integer> iterator(){
		return new CustomIterator();
	}
	
	private class CustomIterator implements Iterator<Integer> {
		private int pointer;
		
		public CustomIterator() {
			this.pointer = customList.this.listStart;
		}
		@Override
		public boolean hasNext() {
			return this.pointer<customList.this.listEnd;
		}

		@Override
		public Integer next() {
			if(this.hasNext()){
				int currentPointer=this.pointer;
				pointer++;
				return currentPointer;
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
	public int getListStart(){
		return this.listStart;
	}
	
	public int getListEnd(){
		return this.listEnd;
	}
}
