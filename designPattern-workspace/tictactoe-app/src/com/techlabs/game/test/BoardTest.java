package com.techlabs.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.game.Board;
import com.techlabs.game.Mark;

public class BoardTest {
	
	Board testBoard = new Board();
	
	@Test
	public void setMarkTest() {
		
		testBoard.setMark(Mark.X, 0);
		testBoard.setMark(Mark.X, 1);
		testBoard.setMark(Mark.X, 2);
		testBoard.setMark(Mark.X, 3);
		testBoard.setMark(Mark.X, 4);
		testBoard.setMark(Mark.X, 5);
		testBoard.setMark(Mark.X, 6);
		testBoard.setMark(Mark.X, 7);
		testBoard.setMark(Mark.X, 8);
		
		for(int i=0;i<9;i++){
			System.out.println(testBoard.getMarkAtPos(i));
			assertTrue(testBoard.getMarkAtPos(i)==Mark.X);
		}
	}
	
	@Test
	public void isEmptyTest(){
		assertTrue(testBoard.isEmpty()==true);
	}
	
	@Test
	public void isFull(){
		assertFalse(testBoard.isFull());
		testBoard.setMark(Mark.X, 0);
		testBoard.setMark(Mark.X, 1);
		testBoard.setMark(Mark.X, 2);
		testBoard.setMark(Mark.X, 3);
		testBoard.setMark(Mark.X, 4);
		testBoard.setMark(Mark.X, 5);
		testBoard.setMark(Mark.X, 6);
		//testBoard.setMark(Mark.X, 7);
		testBoard.setMark(Mark.X, 8);
		assertFalse(testBoard.isFull());
		
	}
	
	@Test
	public void getMarkAtPosTest(){
		testBoard.setMark(Mark.O, 2);
		assertTrue(testBoard.getMarkAtPos(2)==Mark.O);
	}
}
