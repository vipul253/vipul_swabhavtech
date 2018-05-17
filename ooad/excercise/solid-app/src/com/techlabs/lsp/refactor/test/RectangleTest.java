package com.techlabs.lsp.refactor.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.lsp.refactor.*;

public class RectangleTest {
	
	Rectangle rectangle = new Rectangle(20, 30);
	Square square = new Square(30);
	
	public void shouldNotChangeHeight(Rectangle rectangle){
		int heightBefore = rectangle.getHeight();
		rectangle.setWidth(rectangle.getWidth()+10);
		int heightAfter = rectangle.getHeight();
		assertTrue(heightBefore==heightAfter);
	}
	
	@Test
	public void testHeightChangeRectangle() {
		shouldNotChangeHeight(rectangle);
	}
}