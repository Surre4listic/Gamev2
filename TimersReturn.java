interface Listener {
    void onTaskComplete(TimersReturn result);
}

public class TimersReturn {

    private final String name;

    public TimersReturn(String name) {
        this.name = name;
    }

    public String getName() { return name; }
        
}