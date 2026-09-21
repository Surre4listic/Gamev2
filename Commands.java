public interface Commands {

    // If the command should display something
    default void Display(String message) {
        Output.Send(message);
    }

    // If the command should do something
    default void Action() {

    }

}