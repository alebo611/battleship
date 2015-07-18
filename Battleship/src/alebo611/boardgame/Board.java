package alebo611.boardgame;
import java.util.ArrayList;


public class Board {
    
    
    ArrayList<Boat> boats;
    int fieldSize = 10;

    Square[][] battleField;
    
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

}
