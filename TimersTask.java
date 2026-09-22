import java.util.TimerTask;

public class TimersTask extends TimerTask {

    private final Listener listener;
    private final String name;

    public TimersTask(String name, Listener listener) {
        Output.Debug("TimersTask (Constructor): " + name);
        this.name = name;
        this.listener = listener;
    }    

    @Override 
    public void run() {
        try {

            TimersReturn result = new TimersReturn(this.name);

            if (listener != null) {
                listener.onTaskComplete(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}