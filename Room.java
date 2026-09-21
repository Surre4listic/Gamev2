import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {

    private List<Mob> mobsInRoom = new ArrayList<>();
    private static final Random random = new Random();
    
    // display a new room
    public Room() {
        String displayRoom = "Room";

        // call method that populates room
        populateRoom();
        
        for (Mob mob : mobsInRoom) {
            displayRoom += "\n" + mob.getName();
        }

        Output.Send(displayRoom);
    }

    // display a empty room
    public Room(boolean isNew) {
        Output.Send("New room");
    }

    // method to populate room with 0-3 potential mobs 
    private void populateRoom() {
        for (int i = 1; i <= random.nextInt(4); i++) {
            Output.Debug("populateRoom: i=" + i);
            mobsInRoom.add(MobCreate.createMob(MobTemplate.values()[random.nextInt(MobTemplate.values().length)]));
        }
    }

}
