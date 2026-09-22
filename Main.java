import java.util.Scanner;

public class Main {

    // set static for the player and the room so it can be called from anywhere
    static Player player;
    static Room room;
    public static void main(String[] args) {

        // set objects for input
        Scanner scanner = new Scanner(System.in);
        Input input = new Input();

        // Easier way to switch between debug mode
        Output.Send("\n\nDebug console? 'Y'?\n\n", false);
        if (scanner.nextLine().equalsIgnoreCase("y")) { Output.isDebugEnabled = true; }

        Output.Send("Welcome to the game! Please choose a character name:", false);
        // create the player object with the next input as the name
        Main.player = new Player(scanner.nextLine());
        Output.Send("Nice to meet you, "+ player.getName() + ".\nIf you need some help just type \"help\".");

        // start a new empty room for the player
        room = new Room(true);

        // wait for input and continue until we return false
        while (input.Get(scanner.nextLine())) {}

        // close the scanner and end the game
        scanner.close();
        Output.Send("Thank you for playing!", false);

    }
}