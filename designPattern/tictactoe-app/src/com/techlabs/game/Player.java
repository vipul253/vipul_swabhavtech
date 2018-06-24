package com.techlabs.game;

public class Player {
	private Mark mark;
	
	public Player(Mark mark){
		if(mark!=Mark.EMPTY)
			this.mark=mark;
	}
	
	public Mark getPlayer(){
		return this.mark;
	}
	
}
