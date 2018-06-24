package com.techlabs.game;

public class Game {
	
	private Board board;
	private GameAnalyser analyser;
	private Player[] players = new Player[2];
	private Player currentPlayer;
	
	public void start(){
		this.players[0]=new Player(Mark.X);
		this.players[1]=new Player(Mark.O);
		this.board= new Board();
		this.analyser = new GameAnalyser(board);
		this.currentPlayer=this.players[0];
	}
	
	public void play(int pos){
		board.setMark(currentPlayer.getPlayer(), pos);
		if(currentPlayer.getPlayer()==Mark.X)
			currentPlayer=this.players[1];
		else
			currentPlayer=this.players[0];
	}
	
	public GameAnalyser getAnalyser(){
		return this.analyser;
	}
	
	public Board getBoard(){
		return this.board;
	}
}
