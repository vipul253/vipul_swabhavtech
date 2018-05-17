package com.techlabs.lsp.voilation.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.lsp.voilation.*;

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
	public void testHeightChange() {
		shouldNotChangeHeight(rectangle);
		shouldNotChangeHeight(square);
	}

}
