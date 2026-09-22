import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {

    public List<Mob> mobsList = new ArrayList<>();
    private static final Random random = new Random();
    
    // display a new room
    public Room() {
        this.populateRoom();
        display();
    }

    // display a empty room
    public Room(boolean isNew) {
        display();
    }

    // method to populate room with 0-3 potential mobs 
    private void populateRoom() {
        for (int i = 1; i <= random.nextInt(4); i++) {
            // add random mob from within length of mobtemplate and use method mobcreate to give it
            mobsList.add(MobTemplate.createMob(MobTemplate.values()[random.nextInt(MobTemplate.values().length)]));
        }
    }

    //
    public void display() {
        String displayRoom = "You enterd room ***.";
        // show all mobs to the room
        for (Mob mob : mobsList) { displayRoom += "\n" + mob.getName(); }
        Output.Send(displayRoom);
    }

    // 
    public Mob inRoom(String name) {
        for (Mob mob : mobsList) {
            if (mob.getName().equalsIgnoreCase(name)) {return mob;}
        }
        return null;
    }

    // clear the room of mobs and call necessary methods to remove timers
    public void clearRoom() {
        if (this.mobsList != null) {
            for (Mob mob : this.mobsList) {
                mob.ClearTimer();
            }
        }
    }


}
