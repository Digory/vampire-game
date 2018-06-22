package dungeon;

import java.util.Scanner;

public class Dungeon {

    private Map map;
    private final Scanner reader;

    public Dungeon(Scanner reader) {
        this.reader = reader;
    }

    public void run() {
        getSpecifications();
        while (map.gameOn()) {
            map.displayMap();
            String input = reader.nextLine();
            map.movePlayer(input);
        }
        if (map.vampiresAreDead()) {
            System.out.println("YOU WIN");
        } else {
            System.out.println("YOU LOSE");
        }
    }

    public void getSpecifications() {
        int size = 0;
        while (size < 5) {
            System.out.print("How big would you like the dungeon to be? (5 or more): ");
            try {
                size = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
        boolean vampiresMove = false;
        System.out.print("Would you like easy mode, or hard mode? ");
        
        /* If they don't reply with a valid input then the game defaults to
           easy mode (i.e. vampires do not move). 
        */
        
        String mode = reader.nextLine();
            if (mode.toLowerCase().equals("hard")) {
                vampiresMove = true;
            }
        map = new Map(size, size, 6, 15, vampiresMove);
    }

}
