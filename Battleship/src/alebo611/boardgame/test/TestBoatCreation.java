package alebo611.boardgame.test;
import alebo611.boardgame.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestBoatCreation {

	@Test
	public void testCollitionHorizontal() {
		
		Board b = new Board();
		
		try {
			b.addBoatControlled(1, 1, 4, true);
		} catch (IndexOutOfBoundsException e) {
			fail("Should not generate exception");
		} catch (CollisionWithAnotherBoatException e) {
			fail("Should not generate exception");
		}
		
		
		
		
	}

}
