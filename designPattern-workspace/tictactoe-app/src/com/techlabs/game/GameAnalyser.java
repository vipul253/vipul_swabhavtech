package com.techlabs.game;

public class GameAnalyser {
	
	private Board board;
	private State state;
	private Mark mark=null;

	public GameAnalyser(Board board) {
		this.board = board;
		this.state=State.PLAYING;
	}
	
	public State getState() {
		return state;
	}

	public Mark checkHorizontal() {
		for(int i=0;i<7;i=i+3){
			mark=this.board.getMarkAtPos(i);
			if(mark!=Mark.EMPTY&&mark==this.board.getMarkAtPos(i+1)&&mark==this.board.getMarkAtPos(i+2)){
				return mark;
			}
		}
		return mark;
	}

	public Mark checkVertical() {
		for(int i=0;i<3;i++){
			mark=this.board.getMarkAtPos(i);
			if(mark.equals(this.board.getMarkAtPos(i+3))&&mark.equals(this.board.getMarkAtPos(i+6))&&mark!=Mark.EMPTY){
				return mark;
			}
		}
		return mark;
	}

	public Mark checkDiagonal() {
		mark = this.board.getMarkAtPos(4);
		if (mark == this.board.getMarkAtPos(0)
				&& mark == this.board.getMarkAtPos(8))
			return mark;
		else if (mark == this.board.getMarkAtPos(2)
				&& mark == this.board.getMarkAtPos(6))
			return mark;
		else
			return mark;
	}
	
	public State checkState(){
		Mark mark;
		if((mark=this.checkHorizontal())==null)
			if((mark=this.checkVertical())==null)
				if((mark=this.checkDiagonal())==null)
					if(this.board.isFull())
						return State.DRAW;
		if(mark==Mark.X)
			return State.CROSS_WON;
		else if(mark==Mark.O)
			return State.NOUGHT_WON;
		return State.PLAYING;
	}
}

