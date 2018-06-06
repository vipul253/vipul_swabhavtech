package com.techlabs.game.test;

import java.util.Scanner;

import com.techlabs.game.*;

public class GameConsole {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Game g1 = new Game();
		int ch;
		do{
			System.out.println("1.Start New \n2.Exit");
			ch=in.nextInt();
			switch(ch){
			case 1:g1.start();
			while(g1.getAnalyser().checkState()==State.PLAYING){
				int pos;
				System.out.println("enter position");
				pos=in.nextInt();
				g1.play(pos);
				printBoard(g1.getBoard());
				System.out.println(g1.getAnalyser().checkState());
			}
			break;
			default:ch=2;
			
			}
		}while(ch!=2);
		in.close();
	}
	
	public static void printBoard(Board board){
		Cell[] grid = board.getGrid();
		for(int i=0;i<7;i=i+3){
			System.out.println(grid[i].getMark()+" |"+grid[i+1].getMark()+" |"+grid[i+2].getMark());
		}
	}
}















/*
		g1.start();
		g1.play(0);
		g1.play(1);
		g1.play(2);
		g1.play(3);
		g1.play(4);
		g1.play(5);
		g1.play(6);
		printBoard(g1.getBoard());
*/
