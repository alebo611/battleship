package alebo611.boardgame;
import java.util.ArrayList;

import org.hamcrest.core.IsNull;


public class Board implements Shooter {
    
    
    ArrayList<Boat> boats;
    public int fieldSize = 10;

    public Square[][] battleField;
    
    /*
    public static void main(String [] args){
        Board b = new Board();
    }
    */



    public Board(){
        battleField = new Square[fieldSize][fieldSize];
        boats = new ArrayList<Boat>();
    }
    
    public void addBoatRandom(int boatSize){
        Boat b = new Boat(fieldSize, boatSize, this);
        addBoatToListAndBoard(b);
    }
    
    public void addBoatControlled(int x, int y, int boatSize, boolean horizontal) throws IndexOutOfBoundsException, CollisionWithAnotherBoatException {
  		Boat b = new Boat(x,y,fieldSize, boatSize,horizontal, this);
  		addBoatToListAndBoard(b);
	}
    
    private void addBoatToListAndBoard(Boat b){
    	boats.add(b);
 		 for (Square s : b.squares){
            battleField[s.x][s.y] = s;
        }
    }
    
    
    

    public void printBoard(){

        for (int i = 0; i < fieldSize; i++){
            for (int j = 0; j < fieldSize; j++){
                if(battleField[j][i] != null){
                    System.out.print(battleField[j][i].belongsTo.getSignature());
                }
                else{
                	System.out.print('0');
                }
            }
            System.out.print("\n");
        }
    }

	@Override
	public HitResult shoot(int x, int y) {
		
		Square s = this.battleField[x][y];
		
		if(s == null){
			return HitResult.WATER;
		}
		else if(s.onFire){			
			return HitResult.THIS_SQUARE_IS_ALREADY_BURNING;
		}
		else{
			s.onFire = true;
			// Now were gonna find out if we sunk the ship or not
			return s.belongsTo.isAlive() ?  HitResult.HIT_SHIP_NOT_SUNK_YET : HitResult.HIT_SHIP_SUNK;
			}
			
		}

	@Override
	public void createAllBoats() {
		this.addBoatRandom(2);
		this.addBoatRandom(3);
		this.addBoatRandom(3);
		this.addBoatRandom(4);
		this.addBoatRandom(5);
	}
		

}
