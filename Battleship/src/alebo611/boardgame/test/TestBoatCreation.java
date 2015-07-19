package alebo611.boardgame.test;
import alebo611.boardgame.Board;
import alebo611.boardgame.Shooter;
import alebo611.boardgame.CollisionWithAnotherBoatException;
import alebo611.boardgame.Shooter.HitResult;
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
	public void testCreateLotOfRandomBoatsAndShootEmAll(){
		Board b = new Board();
		
		b.addBoatRandom(1);
		b.addBoatRandom(2);
		b.addBoatRandom(3);
		b.addBoatRandom(4);
		b.addBoatRandom(5);
		
		int controlHitNotSunk =  1 + 2 + 3 + 4 + 5 - 5; // five of the hits result in sunken ship
		int controlSunk = 5;
		int waterCount = (b.fieldSize * b.fieldSize) - controlHitNotSunk - controlSunk;
		
		int c1 = 0,c2 = 0,c3=0;
		for(int i = 0; i < b.fieldSize; i++){
			for(int j = 0; j < b.fieldSize; j++){
				switch(b.shoot(i, j)){
				case HIT_SHIP_NOT_SUNK_YET:
					c1++;
					break;
				case HIT_SHIP_SUNK:
					c2++;
					break;
				case WATER:
					c3++;
					break;
					
				default:
				}
			}
		}
		
		assertTrue(c1 + "!=" + controlHitNotSunk, c1 == controlHitNotSunk);
		assertTrue(c2 + "!=" + controlSunk, c2 == controlSunk);
		assertTrue(c3 + "!=" + waterCount, c3 == waterCount);
			
		b.printBoard();
	}
}
