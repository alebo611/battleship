package alebo611.boardgame.test;
import alebo611.boardgame.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestBoatCreation {

	@Test
	public void testCollitionHorizontal() {
		
		Board b = new Board();
		
		try {
			b.addBoatControlled(5, 5, 4, true);
		} catch (IndexOutOfBoundsException e) {
			fail("Should not generate exception");
		} catch (CollisionWithAnotherBoatException e) {
			fail("Should not generate exception");
		}
		
		
		int i = 0;
		try {
			b.addBoatControlled(4, 5, 4, true); // will collide
		} catch (IndexOutOfBoundsException e) {
			fail("Should not generate this exception");
		} catch (CollisionWithAnotherBoatException e) {
			i = 7;
		}
		
		assertTrue("Exception not thrown", i == 7);
		
		try {
			b.addBoatControlled(6, 6, 4, true); // will collide with wall
		} catch (IndexOutOfBoundsException e) {
			i = 5;
		} catch (CollisionWithAnotherBoatException e) {
			fail("Should not generate this exception");
		}
		
		assertTrue("Boat does not fit view, exception should be thrown", i == 5);
		
	}
	
	
@Test
public void testCollitionVertical() {
		
		Board b = new Board();
		
		try {
			b.addBoatControlled(5, 5, 4, false);
		} catch (IndexOutOfBoundsException e) {
			fail("Should not generate exception");
		} catch (CollisionWithAnotherBoatException e) {
			fail("Should not generate exception");
		}
		
		
		int i = 0;
		try {
			b.addBoatControlled(3, 6, 4, true); // will collide
		} catch (IndexOutOfBoundsException e) {
			fail("Should not generate this exception");
		} catch (CollisionWithAnotherBoatException e) {
			i = 7;
		}
		
		assertTrue("Exception not thrown", i == 7);
		
		
		try {
			b.addBoatControlled(5, 3, 4, false); // will collide
		} catch (IndexOutOfBoundsException e) {
			fail("Should not generate this exception");
		} catch (CollisionWithAnotherBoatException e) {
			i = 3;
		}
		assertTrue("Exception not thrown", i == 3);
		
		
		try {
			b.addBoatControlled(1, 7, 4, false); // will collide with wall
		} catch (IndexOutOfBoundsException e) {
			i = 5;
		} catch (CollisionWithAnotherBoatException e) {
			fail("Should not generate this exception");
		}
		
		assertTrue("Boat does not fit view, exception should be thrown", i == 5);
		
	}

}
