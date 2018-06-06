package com.techlabs.game;

public class Board {
	
	private Cell[] grid;
	
	public Board(){
		grid = new Cell[10];
		for(int i=0;i<grid.length;i++){
			this.grid[i]=new Cell();
		}
	}
	
	public void setMark(Mark mark,int position){
		this.grid[position].setMark(mark);
	}
	
	public boolean isEmpty(){
		for(int i=0;i<grid.length;i++){
			if(!(grid[i].cellState().equals(Mark.EMPTY))){
				return false;
			}
		}
		return true;
	}
	
	public boolean isFull(){
		for(int i=0;i<grid.length-1;i++){
			if(!(grid[i].cellState().equals(Mark.EMPTY))){
				return true;
			}
		}
		return false;
	}
	
	public Mark getMarkAtPos(int pos){
		if(pos<grid.length-1)
			return this.grid[pos].cellState();
		else
			return null;
	}
	
	public int getBoardSize(){
		return this.grid.length;
	}
	
	public Cell[] getGrid(){
		return this.grid;
	}
}
