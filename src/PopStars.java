public class PopStars extends Creature{
    private Level.Room playerRoom;

    public PopStars (Level.Room wumpusRoom, Level.Room playerRoom, String name){
        super (wumpusRoom);
        this.playerRoom = playerRoom;
    }
    @Override
    public void move() {
        if (playerRoom.areNeighbors(currentRoom)){
            Level.Room next = currentRoom;

            if (next.equals(playerRoom)){
                currentRoom.neighbors.remove(next);
                next = currentRoom.getRandomRoom(currentRoom);
            }
            moveToRoom (next);
        }
    }
}
