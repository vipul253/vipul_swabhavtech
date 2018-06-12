package com.techlabs.game;

public class GameAnalyser {
	
	private Board board;
	private State state;
	private Mark mark;

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
		return null;
	}

	public Mark checkVertical() {
		for(int i=0;i<3;i++){
			mark=this.board.getMarkAtPos(i);
			if(mark!=Mark.EMPTY){
				if(mark==this.board.getMarkAtPos(i+3)&&mark==this.board.getMarkAtPos(i+6)){
					return mark;
				}
			}
		}
		return null;
	}

	public Mark checkDiagonal() {
		mark = this.board.getMarkAtPos(4);
		if(mark!=Mark.EMPTY){
			if(mark==this.board.getMarkAtPos(0)&&mark==this.board.getMarkAtPos(8)){
				return mark;
			}
			if(mark==this.board.getMarkAtPos(0)&&mark==this.board.getMarkAtPos(8)){
				return mark;
			}
		}
		return null;
	}
	
	public State checkState(){
		Mark mark;
		if((mark=this.checkHorizontal())==null){
			if((mark=this.checkVertical())==null){
				if((mark=this.checkDiagonal())==null){
					if(this.board.isFull()){
						return State.DRAW;
					}
				}
			}
		}
		if(mark==Mark.X)
			return State.CROSS_WON;
		if(mark==Mark.O)
			return State.NOUGHT_WON;
		return State.PLAYING;
	}
}

