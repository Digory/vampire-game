package dungeon;

import java.util.Arrays;

public class Map {

    private final int length;
    private final int height;
    private int vampires;
    private final boolean vampiresMove;
    private boolean gameOn;
    private final VampiresDatabase vampiresDatabase;
    private final Player player;

    public Map(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.vampiresMove = vampiresMove;
        gameOn = true;
        vampiresDatabase = new VampiresDatabase(vampires, length, height);
        player = new Player(moves, length, height);
    }

    public void displayMap() {
        System.out.println(player.getMoves() + "\n");
        System.out.println(player);
        vampiresDatabase.getCoordinates();
        System.out.println("");
        displayMapArray();
        
    }
    
    public void movePlayer(String input){
        player.move(input);
        /* Kills the vampire if the player moved to a vampire's coordinates;
        then checks to see if the game should still be continued (i.e. if the
        player is allowed to move and there are vampires left).
        */
        if (vampiresDatabase.killVampireWithTheseCoordinates(player.getXCoordinate(),
                player.getYCoordinate())){
            vampires--;
        }
        if (player.getMoves() == 0 || 
                vampires == 0){
            gameOn = false;
        }
        if (vampiresMove){
        vampiresDatabase.moveAll(player.getXCoordinate(), player.getYCoordinate());
        }
    }
    
    public boolean vampiresAreDead(){
        return vampires == 0;
    }

    public void displayMapArray() {
        /* The game map is a char array with empty spaces marked with a '-', 
        vampires marked with a 'v', and the player an '@' sign.
        */
        char[][] map = new char[length][height];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], '-');
        }
        map[player.getYCoordinate()][player.getXCoordinate()] = '@';
        for (Vampire elements : vampiresDatabase.getVampiresList()) {
            if (elements.isAlive()){
            map[elements.getYCoordinate()][elements.getXCoordinate()] = 'v';}
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }

    public boolean gameOn() {
        return gameOn;
    }

}
