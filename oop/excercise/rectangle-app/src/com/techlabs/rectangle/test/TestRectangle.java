package com.techlabs.rectangle.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.techlabs.rectangle.*;

public class TestRectangle {
	
	Rectangle r1 = new Rectangle();
	
	@Test
	public void testDimensions() {
		r1.setHeight(50);
		r1.setWidth(9);
		
		assertTrue(r1.getHeight() <= 100);
		assertTrue(r1.getHeight() >= 10);
		assertTrue(r1.getWidth() <= 100);
		assertTrue(r1.getWidth() <= 100);
	}
	
	@Test
	public void testArea(){
		
		r1.setHeight(101);
		r1.setWidth(9);
		
		int expectedArea = 100*10;
		assertEquals(expectedArea, r1.calcArea());
	}

}
