package com.techlabs.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.game.Cell;
import com.techlabs.game.Mark;

public class CellTest {
	
	Cell testCell = new Cell();
	
	@Test
	public void EmptyInitTest() {
		Cell testCell = new Cell();
		assertTrue(testCell.cellState()==Mark.EMPTY);
	}
	
	@Test
	public void setMarkTest() {
		testCell.setMark(Mark.X);
		assertTrue(testCell.cellState()==Mark.X);
	}
	
	@Test
	public void isEmptyTest() {
		testCell.setMark(Mark.EMPTY);
		assertTrue(testCell.isEmpty()==true);
	}
	
	@Test
	public void CellStateTest() {
		testCell.setMark(Mark.O);
		assertTrue(testCell.cellState()==Mark.O);
	}
}
