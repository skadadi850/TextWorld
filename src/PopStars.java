public class PopStars extends Creature{
    private Player player;
    private Level.Room wumpusRoom;

    public PopStars (Level.Room wumpusRoom, Player p, String name){
        super (wumpusRoom,name);
        this.player = p;
        this.wumpusRoom = wumpusRoom;
    }
    @Override
    public void act(){
        Level.Room next = lookForPlayer();

        if (next != null){
            this.moveToNextRoom(next);
        }
    }

    private Level.Room lookForPlayer() {
        Level.Room next = wumpusRoom;
        if (player.currentRoom.areNeighbors(currentRoom)) {
            next = currentRoom;
        }

        for (Level.Room wr : wumpusRoom.getNeighbors()){
            for (Level.Room pr : player.getCurrentRoom().getNeighbors()){
                if (wr.equals(pr)){
                    next = wr;
                }
            }
        }
        return next;
    }

//
//    public void move() {
//        if (player.currentRoom.areNeighbors(currentRoom)){
//            Level.Room next = currentRoom;
//
//            if (next.equals(player.currentRoom)){
//                currentRoom.neighbors.remove(next);
//                next = currentRoom.getRandomNeighbor();
//            }
//            moveToRoom (next);
//        }
//    }
}
