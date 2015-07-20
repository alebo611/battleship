package alebo611.boardgame;

public interface Shooter {
	
	enum HitResult {
		WATER,
		HIT_SHIP_NOT_SUNK_YET,
		THIS_SQUARE_IS_ALREADY_BURNING,
		HIT_SHIP_SUNK
	}
	
	
	public void createAllBoats();
	
	/**
	 * Shot a square. 
	 * 
	 * @param x Square horizontal position
	 * @param y Square vertical position
	 * @return true if something was hit, false otherwise
	 */
	public HitResult shoot(int x, int y);
	
}
