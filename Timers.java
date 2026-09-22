import java.util.Timer;
import java.util.TimerTask;

// callback interface to help the class that created timer react to completetion
interface callBack { void timerComplete(); }

public class Timers {

    Timer timer = new Timer();
    TimerTask timerTask;
    boolean isReady = true;
    String timerName;
   
    // constructor
    public Timers(String name) { this.timerName = name; }

    // start a timer
    public void Start(callBack callback, Double delay) {
        this.isReady = false;
        timerTask = new TimerTask() {
            @Override
            // call callBack interface when complete
            public void run() { callback.timerComplete(); }
        };
        timer.schedule(timerTask, (long)(delay * 1000));
    }

    public void Cancel() {
        timerTask.cancel();
        timer.purge();
    }

    // set value if timer is created, this is used to keep track on timers, balances etc
    public void setReady(boolean value) { this.isReady = value; }
    // get value if there is a timer and see if this is ready or not
    public boolean getReady() { return isReady; }

}