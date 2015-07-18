package alebo611.boardgame;
import java.util.ArrayList;
import java.util.Random;


class Boat {
    
    ArrayList<Square> squares;
    Board belongsTo;
    {
    	
    	 squares = new ArrayList<Square>();
    	
    }

    /**
     * Create a boat without choosing position
     * 
     * @param max
     * @param shipSize
     * @param b
     */
    Boat(int max, int shipSize, Board b){
        this.belongsTo = b;

        Random rand = new Random();
        boolean horizontal;
       


        horizontal = rand.nextBoolean();
        

        int p1,p2;

        while(true){
        p1 = rand.nextInt(max - shipSize); //compensate for ship size
        p2 = rand.nextInt(max);
        if(!willCollide(p1,p2,shipSize,horizontal)) break; 
        }

        createBoat(p1, p2, shipSize, horizontal);
            
    }
    
    /**
     * Create a boat by choosing position
     * 
     * 
     * @param x
     * @param y
     * @param max
     * @param shipSize
     * @param horizontal
     * @throws IndexOutOfBoundsException
     */
    Boat(int x, int y, int max, int shipSize, boolean horizontal, Board b) throws IndexOutOfBoundsException, CollisionWithAnotherBoatException{
    	this.belongsTo = b;
    	
    	if (horizontal && x + shipSize > max) throw new IndexOutOfBoundsException("Boat does not fit view!");    	
    	if (!horizontal && y + shipSize > max) throw new IndexOutOfBoundsException("Boat does not fit view!");    	
        if (willCollide(x, y, shipSize, horizontal)) throw new CollisionWithAnotherBoatException();
        
        createBoat(x, y, shipSize, horizontal);
    }
    
    void createBoat(int p1, int p2, int shipSize, boolean horizontal){
        int i=0;
        do{
            
            i++;
            p1++;
            this.addSquare(horizontal? p1 : p2,horizontal? p2 : p1);
            
        }while(i < shipSize);
    	
    }

    void addSquare(int x, int y){

        Square s = new Square(x,y, this);
        squares.add(s);
    }

    boolean willCollide(int p1, int p2, int shipSize, boolean horizontal){
        
    	
    	for(int i =  0; i < shipSize; i++){
    		
    		int x = horizontal ? p1 + i : p2;
    		int y = horizontal ? p2: p1 + i;
    		if(this.belongsTo.battleField[x][y] != null) return true;
        }
    	
    	return false;
    }


        

        
    
}
