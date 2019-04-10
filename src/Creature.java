import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Creature {
    protected Level.Room currentRoom;
    String names;


    public void setCurrentRoom(Level.Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Creature (Level.Room room){
        this.currentRoom = room;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public abstract void move();

    protected Level.Room getCurrentRoom (){
        return currentRoom;
    }

    protected boolean moveToRoom(Level.Room r){
        currentRoom = r;
        currentRoom.removeCreature(this);
        currentRoom.addCreature(this);
        return(currentRoom != null);
    }

}