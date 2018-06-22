package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VampiresDatabase {

    private int xLimit;
    private int yLimit;
    private int playersX;
    private int playersY;
    private List<Vampire> vampires;

    public VampiresDatabase(int numOfVampires, int xLimit, int yLimit) {
        this.xLimit = xLimit;
        this.yLimit = yLimit;
        vampires = new ArrayList<Vampire>();
        for (int i = 0; i < numOfVampires; i++) {
            while (true) {
                /*Continues to generate a vampire until its coordinates do not
                conflict with another vampire.
                */
                Vampire newVampire = new Vampire(xLimit, yLimit);
                if (!listContainsAVampireAtThatCoordinate(newVampire)) {
                    vampires.add(newVampire);
                    break;
                }
            }
        }
    }
    
    public void moveAll(int playersX, int playersY){
        this.playersX = playersX;
        this.playersY = playersY;
        for (Vampire elements : vampires){
            move(elements);
        }
    }
    
    public boolean playerAlreadyThere(Vampire vampire){
        return playersX == vampire.getXCoordinate() &&
                playersY == vampire.getYCoordinate();
    }
    
    public boolean validLocation(Vampire vampire){
        if (listContainsAVampireAtThatCoordinate(vampire)){
            return false;
        }
        if (playerAlreadyThere(vampire)){
            return false;
        }
        if (vampire.getXCoordinate() >= xLimit || vampire.getXCoordinate()
                < 0){
            return false;
        }
        if (vampire.getYCoordinate() >= yLimit || vampire.getYCoordinate()
                < 0){
            return false;
        }
        return true;
    }

    public void move(Vampire vampire) {
        /* The vampires move randomly, one space at a time, and so have 8 
        possible points to go from their current location. They can only move to
        that point if there isn't a vampire there, or the player. Coordinates 
        are generated until those criteria are met.
        */
        int originalX = vampire.getXCoordinate();
        int originalY = vampire.getYCoordinate();
        int counter = 0;
        while(true){
        int randomNumber = new Random().nextInt(8);
        switch (randomNumber) {
            case 0: {
                vampire.setXCoordinate(originalX-1);
                vampire.setYCoordinate(originalY-1);
                break;
            }
            case 1: {
                vampire.setYCoordinate(originalY-1);
                break;
            }
            case 2: {
                vampire.setXCoordinate(originalX+1);
                vampire.setYCoordinate(originalY-1);
                break;
            }
            case 3: {
                vampire.setXCoordinate(originalX+1);
                break;
            }
            case 4: {
                vampire.setXCoordinate(originalX+1);
                vampire.setYCoordinate(originalY+1);
                break;
            }
            case 5: {
                vampire.setYCoordinate(originalY+1);
                break;
            }
            case 6: {
                vampire.setXCoordinate(originalX-1);
                vampire.setYCoordinate(originalY+1);
                break;
            }
            case 7: {
                vampire.setXCoordinate(originalX-1);
                break;
            }
        }
        counter++;
        if (validLocation(vampire)){
            break;
        }
        else if (counter == 5){
            /* If the game map is small, it is possible the vampire will not
            be able to move to a suitable location. The counter allows the 
            program to leave the vampire in its original location and move on.
            */
            vampire.setXCoordinate(originalX);
            vampire.setYCoordinate(originalY);
            break;
        }
        }
    }

    public boolean listContainsAVampireAtThatCoordinate(Vampire vampire) {
        for (Vampire elements : vampires) {
            if (elements.getXCoordinate() == vampire.getXCoordinate()
                    && elements.getYCoordinate() == vampire.getYCoordinate()
                    && elements != vampire) {
                return true;
            }
        }
        return false;
    }

    public boolean killVampireWithTheseCoordinates(int xCo, int yCo) {
        for (Vampire elements : vampires) {
            if (elements.getXCoordinate() == xCo
                    && elements.getYCoordinate() == yCo) {
                elements.kill();
                return true;
            }
        }
        return false;
    }

    public void getCoordinates() {
        for (Vampire elements : vampires) {
            System.out.println(elements);
        }
    }

    public List<Vampire> getVampiresList() {
        return vampires;
    }

}
