public class Input {

    public boolean Get(String input) {

        if ("move".equalsIgnoreCase(input)) {
            Main.room = null;
            Main.room = new Room();
        }

        return true;
    }

}
