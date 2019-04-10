import java.util.ArrayList;

public class Chicken extends Creature{

    public Chicken(Level.Room r, String name){
        super(r);

    }

    @Override
    public void move() {
        Level.Room next = currentRoom.getRandomRoom(currentRoom);
        setCurrentRoom (next);
        // add chicken remove chick from room
    }
}
