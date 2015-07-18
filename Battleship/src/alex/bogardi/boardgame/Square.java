package alex.bogardi.boardgame;
class Square {

    int x,y;

    boolean onFire;

    Boat belongsTo;

    Square(int x,int y, Boat b){
        
        this.x=x;
        this.y=y;
        this.belongsTo = b;
        this.onFire = false;
        
        }
    
}
