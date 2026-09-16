import java.util.Scanner;

public class Main {

    static Player player;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Input input = new Input();

        Output.Send("Welcome to the game! Please choose a character name:", false);
        Main.player = new Player(scanner.nextLine());

        while (input.Get(scanner.nextLine())) {}

        scanner.close();
        Output.Send("Thank you for playing!", false);

    }
}