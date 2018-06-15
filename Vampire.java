package dungeon;
import java.util.Random;

public class Vampire {
    private int xCoordinate;
    private int yCoordinate;
    private boolean isAlive;

    public Vampire(int xLimit, int yLimit) {
        while (xCoordinate == 0 && yCoordinate == 0){
        xCoordinate = new Random().nextInt(xLimit);
        yCoordinate = new Random().nextInt(yLimit);}
        isAlive = true;
    }
    
    public void kill(){
        isAlive = false;
    }
    
    
    public boolean isAlive(){
        return isAlive;
    }
    
    public int getXCoordinate(){
        return xCoordinate;
    }
    
    public void setXCoordinate(int xCo){
        xCoordinate = xCo;
    }
    
    public int getYCoordinate(){
        return yCoordinate;
    } 
    
    public void setYCoordinate(int yCo){
        yCoordinate = yCo;
    }
    
    @Override
    public String toString(){
        return "v " + xCoordinate + " " + yCoordinate;
    }
    

}
