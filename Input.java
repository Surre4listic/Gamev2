public class Input {

    public boolean Get(String input) {

        if ("move".equalsIgnoreCase(input)) {
            Main.room = null;
            Main.room = new Room();
        } else if ("attack".equalsIgnoreCase(input)) {
            Main.player.Attack("asdf");
        }

        return true;
    }

}
