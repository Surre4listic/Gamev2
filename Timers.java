import java.util.Timer;
import java.util.TimerTask;

interface callBack { void Reset(); }

public class Timers {

    Timer timer = new Timer();
    TimerTask timerTask;
    boolean isCreated;
   
    public Timers() {
        isCreated = false;
    }

    public void Start(callBack callback, Double delay) {
        isCreated = true;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                callback.Reset();
            }
        };
        timer.schedule(timerTask, (long)(delay * 1000));
    }

    public void Cancel() {

        timerTask.cancel();
        timer.purge();
        System.out.println("-------------");
        /*
        if (tt != null ) {tt.cancel();}
        if (timer != null ) {timer.purge();}
        */
    }

    // set value if timer is created, this is used to keep track on timers, balances etc
    public void setCreated(boolean value) { this.isCreated = value; }
    // get value if there is a timer and see if it's used already
    public boolean getCreated() { return isCreated; }

}