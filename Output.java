public class Output {

    // set to true to enable debug messages
    private static boolean isDebugEnabled = true;
    
    // standard print function (with prompt after message)
    public static void Send(String message) {
        // first message
        message = " " + message.replace("\n", "\n ");
        // then health, mana etc
        message += "\n H: "+ Main.player.getHealth() + "/" + Main.player.getHealthMax();
        // then balances and such
        message += " <"+ (Main.player.getBalance()?"B":"-") + (!Main.player.getProned()?"P":"") +">";
        System.out.println(message);
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
