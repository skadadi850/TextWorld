public class Wumpus extends Creature{
    private static Level.Room playerRoom;

    public Wumpus (Level.Room wumpusRoom, Level.Room playerRoom, String name){
        super (wumpusRoom);
        this.playerRoom = playerRoom;
    }
    @Override
    public void move() {
        if (playerRoom.areNeighbors(currentRoom)){

        }


        Level.Room next = currentRoom.getRandomRoom(currentRoom);
        moveToRoom (next);
    }



}
