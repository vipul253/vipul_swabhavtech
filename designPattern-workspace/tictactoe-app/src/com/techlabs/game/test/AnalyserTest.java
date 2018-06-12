package com.techlabs.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.game.*;

public class AnalyserTest {
	
	@Test
	public void HorizontalTest() {
		Board testBoard = new Board();
		GameAnalyser analyser = new GameAnalyser(testBoard);
		testBoard.setMark(Mark.X, 3);
		testBoard.setMark(Mark.X, 4);
		testBoard.setMark(Mark.X, 5);
		assertTrue(analyser.checkHorizontal()==Mark.X);
		
	}
	
	@Test
	public void VerticalTest() {
		Board testBoard = new Board();
		GameAnalyser analyser = new GameAnalyser(testBoard);
		testBoard.setMark(Mark.X, 2);
		testBoard.setMark(Mark.X, 5);
		testBoard.setMark(Mark.X, 8);
		assertTrue(analyser.checkVertical()==Mark.X);
		
	}
	
	@Test
	public void DiagonalTest(){
		Board testBoard = new Board();
		GameAnalyser analyser = new GameAnalyser(testBoard);
		testBoard.setMark(Mark.X, 0);
		testBoard.setMark(Mark.X, 4);
		testBoard.setMark(Mark.X, 8);
		assertTrue(analyser.checkDiagonal()==Mark.X);
	}
	
	@Test
	public void stateTest(){
		Board testBoard = new Board();
		GameAnalyser analyser = new GameAnalyser(testBoard);
		testBoard.setMark(Mark.X, 0);
		testBoard.setMark(Mark.O, 1);
		testBoard.setMark(Mark.O, 2);
		testBoard.setMark(Mark.X, 3);
		testBoard.setMark(Mark.EMPTY, 4);
		testBoard.setMark(Mark.EMPTY, 5);
		testBoard.setMark(Mark.X, 6);
		testBoard.setMark(Mark.O, 7);
		testBoard.setMark(Mark.EMPTY, 8);
		assertTrue(analyser.checkState()==State.CROSS_WON);
	}

}
