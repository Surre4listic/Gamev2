public class Output {

    // set to true to enable debug messages
    private static boolean isDebugEnabled = true;
    
    // standard print function (with prompt after message)
    public static void Send(String message) {
        System.out.println(" " + message.replace("\n", "\n ") + 
        "\n H: "+ Main.player.getHealth() + "/" + Main.player.getHealthMax() +
        " <"+ (!Main.player.getBalance()?"B":"-") + (!Main.player.getProned()?"P":"") +">");
    }

    // print without prompt
    public static void Send(String message, boolean prompt) {
        System.out.println(" " + message.replace("\n", "\n "));
    }

    // show debugging if we have isDebugEnabled are true
    public static void Debug(String message) {
        if (isDebugEnabled) {
            System.out.println("[DEBUG] " + message);
        }
    }

}
