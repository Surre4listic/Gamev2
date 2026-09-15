public class Output {

    private static boolean isDebugEnabled = true; // Set to true to enable debug messages
    
    public static void Send(String message) {
        System.out.println(" " + message.replace("\n", "\n "));
    }

    public static void Send(String message, boolean prompt) {
        System.out.println(" " + message.replace("\n", "\n "));
    }

    // Debug method to print debug messages
    public static void Debug(String message) {
        if (isDebugEnabled) {
            System.out.println("[DEBUG] " + message);
        }
    }

}
