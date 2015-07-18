package alebo611.boardgame.test;
import alebo611.boardgame.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestBoatCreation {

	boolean exceptionOccured;
	
	@Before
	public void setUp(){
		exceptionOccured = false;
		
	}
	
	
	
	public void testCollitionHorizontal() {
		
		Board b = new Board();
		
		try {
			b.addBoatControlled(5, 5, 4, true);
		} catch (IndexOutOfBoundsException e) {
			fail("Should not generate exception");
		} catch (CollisionWithAnotherBoatException e) {
			fail("Should not generate exception");
		}
		
		
		boolean exceptionOccured = false;
		try {
			b.addBoatControlled(4, 5, 4, true); // will collide
		} catch (IndexOutOfBoundsException e) {
			fail("Should not generate this exception");
		} catch (CollisionWithAnotherBoatException e) {
			exceptionOccured = true;
		}
		
		assertTrue("Exception not thrown", exceptionOccured);
		
		exceptionOccured = false;
		
		try {
			b.addBoatControlled(6, 6, 4, true); // will collide with wall
		} catch (IndexOutOfBoundsException e) {
			exceptionOccured = true;
		} catch (CollisionWithAnotherBoatException e) {
			fail("Should not generate this exception");
		}
		
		assertTrue("Boat does not fit view, exception should be thrown", exceptionOccured);
		
	}
	
	

public void testCollitionVertical() {
		
		Board b = new Board();
		
		try {
			b.addBoatControlled(5, 5, 4, false);
		} catch (IndexOutOfBoundsException e) {
			fail("Should not generate exception");
		} catch (CollisionWithAnotherBoatException e) {
			fail("Should not generate exception");
		}
		
		
		boolean exceptionOccured = false;
		try {
			b.addBoatControlled(3, 6, 4, true); // will collide
		} catch (IndexOutOfBoundsException e) {
			fail("Should not generate this exception");
		} catch (CollisionWithAnotherBoatException e) {
			exceptionOccured = true;
		}
		
		assertTrue("Exception not thrown", exceptionOccured);
		
	
		
		exceptionOccured = false; //reset
		try {
			b.addBoatControlled(1, 7, 4, false); // will collide with wall
		} catch (IndexOutOfBoundsException e) {
			exceptionOccured = true;
		} catch (CollisionWithAnotherBoatException e) {
			fail("Should not generate this exception");
		}
		
		assertTrue("Boat does not fit view, exception should be thrown", exceptionOccured);
		
	}

	/**
	 * Create one vertical boat first and then try to create one other vertical in the
	 * same column that will overlap
	 * 
	 * 
	 */
	@Test
	public void testCollitionBetweenTwoVerticalBoats(){
		Board b = new Board();
		
		try {
			b.addBoatControlled(5, 5, 4, false);
		
		} catch (IndexOutOfBoundsException e) {
			fail("Should not generate exception");
		} catch (CollisionWithAnotherBoatException e) {
			fail("Should not generate exception");
		}
		
		try {
			b.addBoatControlled(3, 5, 3, false); // will collide
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			fail("Should not generate this exception");
		} catch (CollisionWithAnotherBoatException e) {
			exceptionOccured = true;
		}
	
		
		assertTrue("Exception not thrown", exceptionOccured);
	
	}
	
	/**
	 * Manual test so far
	 */
	@Test
	public void testCreateLotOfRandomBoatsAndVerifyGameField(){
		Board b = new Board();
		
		b.addBoatRandom(1);
		b.addBoatRandom(2);
		b.addBoatRandom(3);
		b.addBoatRandom(4);
		b.addBoatRandom(5);

		b.printBoard();
	}
}
