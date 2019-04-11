public class Wumpus extends Creature{
    private Player player;
    private Level.Room wumpusRoom;

    public Wumpus(Level.Room wumpusRoom, String name){
        super (wumpusRoom, name);
        this.wumpusRoom = wumpusRoom;
    }

    public void act (Player p){
        this.player = p;
        act();
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
        Level.Room next = wumpusRoom.getRandomNeighbor();;
        if (playerRoom.neighborsCreatures(wumpusRoom)) {
            if (next.equals(playerRoom)) {
                wumpusRoom.neighbors.remove(playerRoom);
                next = wumpusRoom.getRandomNeighbor();
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
