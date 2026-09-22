import java.util.Timer;
import java.util.TimerTask;

// callback interface to help the class that created timer react to completetion
interface callBack { void timerComplete(); }

public class Timers {

    Timer timer = new Timer();
    TimerTask timerTask;
    boolean isReady;
    String name;
   
    // constructor
    public Timers(String name) {
        this.name = name;
        this.isReady  = true;
    }

    // start a timer
    public void Start(callBack callback, Double delay) {
        this.isReady = false;
        timerTask = new TimerTask() {
            @Override
            public void run() { callback.timerComplete(); }
        };
        timer.schedule(timerTask, (long)(delay * 1000));
    }

    public void Cancel() {
        timerTask.cancel();
        timer.purge();
    }

    public boolean getReady() { return this.isReady; }
    public void setReady(boolean value) { this.isReady = value; }


}