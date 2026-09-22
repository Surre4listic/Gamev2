import java.util.Timer;

public class Timers {

    // variables to keep track on this timer and use to check if it's in use.
    private final String name;
    private boolean isReady;

    // create a timer
    private Timer timer;
    // create a timertask from our own modified class
    private TimersTask task;
    // set a listener to pass to timertask
    private Listener listener;
    // 

    public Timers(String name, Listener listener) {
        Output.Debug("Timers (Constructor): " + name );
        this.name = name;
        this.listener = listener;
        this.timer = new Timer();
        this.isReady = true;
    }

    public void Start(Long time) {
        isReady = false;
        Output.Debug("Timers (Start): " + this.name + ". Time: " + time.intValue());
        task = new TimersTask(this.name, listener);
        timer.schedule(task, 3000);
    }

    public void Cancel() {
        timer.cancel();
    }

    public boolean getReady() {
        return isReady;
    }

    public void setReady(boolean value) {
        isReady = value;
    }

    
}
