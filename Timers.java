import java.util.Timer;
import java.util.TimerTask;

public class Timers {

    private boolean isOngoing = false;
    private Timer timer;

    public Timers() {}

    public void Reset() {
        this.isOngoing = false;
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = null;
        }
    }

    public void Start(Double time) {
        // make sure it does not exist
        this.Reset();
        // set a new timer
        this.timer = new Timer();
        // set isOngoing to true
        this.isOngoing = true;

        // Set the schedule function and rate
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Timers.this.Reset();
            }
        },
        // set the amount of time in milliseconds before first execution
        0,
        // set the amount of time between each execution (in milliseconds)
        (long)(time * 1000));
    }

    public boolean onGoing() {
        return this.isOngoing;
    }
}
