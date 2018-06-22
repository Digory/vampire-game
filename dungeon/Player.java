package dungeon;

public class Player {
    private int xCoordinate;
    private int yCoordinate;
    private final int xLimit;
    private final int yLimit;
    private int moves;
    
    public Player(int moves, int xLimit, int yLimit){
        xCoordinate = 0;
        yCoordinate = 0;
        this.moves = moves;
        this.xLimit = xLimit;
        this.yLimit = yLimit;
    }
    
    public void move(String input){
        /* The move counter will only be decremented if the input was valid.
        The player can enter more than one move at a time (e.g. "ddsw").
        */
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == 'w'){
                if (moveY(-1)){
                    moves--;
                }
            }
            else if (input.charAt(i) == 'a'){
                if (moveX(-1)){
                    moves--;
                }
            }
            else if (input.charAt(i) == 's'){
                if (moveY(1)){
                    moves--;
                }
            }
            else if (input.charAt(i) == 'd'){
                if (moveX(1)){
                    moves--;
                }
            }
        }
    }
    
    public boolean moveX(int amount){
        if (xCoordinate + amount < 0 ||
                xCoordinate + amount >= xLimit){
            return false;
        }
        xCoordinate += amount;
        return true;
    }
    
    public boolean moveY(int amount){
        if (yCoordinate + amount < 0 ||
                yCoordinate + amount >= yLimit){
            return false;
        }
        yCoordinate += amount;
        return true;
    }
    
    public int getXCoordinate(){
        return xCoordinate;
    }
    
    public int getYCoordinate(){
        return yCoordinate;
    }
    
    public int getMoves(){
        return moves;
    }
    
    @Override
    public String toString(){
        return "@ " + xCoordinate + " " + yCoordinate;
    }

}
