public class Wumpus extends Creature{
    private Player player;

    public Wumpus(Level.Room wumpusRoom, Player p, String name){
        super (wumpusRoom, name);
        this.player = p;
    }
    @Override

    public void act(){
        Level.Room next = avoidPlayer();

        if (next != null){
            this.moveToNextRoom(next);
        }
    }

    private Level.Room avoidPlayer() {
        Level.Room playerRoom = player.getCurrentRoom();
        Level.Room next = currentRoom.getRandomNeighbor();;
        if (playerRoom.areNeighbors(currentRoom)) {
            if (next.equals(playerRoom)) {
                currentRoom.neighbors.remove(playerRoom);
                next = currentRoom.getRandomNeighbor();
            }
        }
        return next;
    }

//    public void move() {
//        if (playerRoom.areNeighbors(currentRoom)){
//            Level.Room next = currentRoom.getRandomNeighbor();
//            if (next.equals(playerRoom)){
//                currentRoom.neighbors.remove(next);
//                next = currentRoom.getRandomNeighbor();
//            }
//            moveToRoom (next);
//        }
//    }



}
