package com.techlabs.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.game.*;

public class PlayerTest {
	Board board = new Board();
	Player player = new Player(Mark.X);
	
	@Test
	public void setMarkTest() {
		board.setMark(player.getPlayer(), 3);
		assertTrue(board.getMarkAtPos(3)==Mark.X);
	}

}
