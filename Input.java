public class Input {

    public boolean Get(String input) {

        // move into another room
        if ("move".equalsIgnoreCase(input)) {

            // call method to clear room and timers
            Main.room.clearRoom();
            // call constructor that creates a new room
            Main.room = new Room();

        // attack mob in the room
        } else if ("attack".equalsIgnoreCase(input)) {

            Main.player.Attack("asdf");

        } else if ("exit".equalsIgnoreCase(input) || "quit".equalsIgnoreCase(input)) {

            return false;

        }
        return true;
    }

}
