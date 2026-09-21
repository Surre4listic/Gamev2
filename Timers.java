import java.util.Timer;
import java.util.TimerTask;

interface callBack { void Reset(); }

public class Timers {

    Timer timer = new Timer();
    boolean isCreated;
   
    public Timers() {
        isCreated = false;
    }

    public void Start(callBack callback, Double delay) {
        isCreated = true;
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                callback.Reset();
            }
        };
        timer.schedule(tt, (long)(delay * 1000));
    }

    public void setCreated() { }

    public boolean getCreated() { return isCreated; }

}

