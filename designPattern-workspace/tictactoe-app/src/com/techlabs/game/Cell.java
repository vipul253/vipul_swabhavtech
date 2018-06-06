package com.techlabs.game;

public class Cell {
	private Mark mark;
	
	public Cell(){
		this.mark=Mark.EMPTY;
	}
	
	public void setMark(Mark mark){
		if(this.mark==Mark.EMPTY)
			this.mark=mark;
	}
	
	public boolean isEmpty(){
		if(this.mark==Mark.EMPTY){
			return true;
		}
		return false;
	}
	
	public Mark cellState(){
		return this.mark;
	}
	
	public String getMark(){
		if(this.mark==Mark.EMPTY)
			return " ";
		return this.mark.toString();
	}
	
}
