package alebo611.boardgame;
public class Square {

    int x,y;

    boolean onFire;

    public Boat belongsTo;

    Square(int x,int y, Boat b){
        
        this.x=x;
        this.y=y;
        this.belongsTo = b;
        this.onFire = false;
        
        }
    
}
