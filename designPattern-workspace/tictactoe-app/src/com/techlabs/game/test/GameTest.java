package com.techlabs.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.game.*;

public class GameTest {
	Game g1 = new Game();
	@Test
	public void setMarkTest() {
		g1.start();
		g1.play(1);
		assertTrue(g1.getBoard().getMarkAtPos(1)==Mark.X);
	}

}
