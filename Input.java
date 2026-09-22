public class Input {

    public boolean Get(String input) {

        // move into another room
        if ("move".equalsIgnoreCase(input)) {

            // check for balance, return true if it has. outputs that it's needed if not.
            if (Main.player.checkBalance()) {
                // call method to clear room and timers for any mobs
                Main.room.clearRoom();
                // call constructor that creates a new room
                Main.room = new Room();
            }

        // look
        } else if ("look".equalsIgnoreCase(input)) {

            Main.room.display();

        // attack mob in the room
        } else if (input.startsWith("attack ")) {

            if (Main.player.checkBalance()) {
                Main.player.Attack(input.replace("attack ", ""));
            }

        // exit the game
        } else if ("exit".equalsIgnoreCase(input) || "quit".equalsIgnoreCase(input)) {
            return false;
        } else {
            Output.Send("Sorry \""+input+"\" is not recognized.");
        }

        return true;
    }

}
