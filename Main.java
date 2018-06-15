package dungeon;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Dungeon game = new Dungeon(reader);
        game.run();
    }
}
