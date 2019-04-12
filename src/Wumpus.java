public class Wumpus extends Creature{
    private Player player;
    private Level.Room wumpusRoom;

    public Wumpus(Level.Room wumpusRoom,Player p, String name){
        super (wumpusRoom, name);
        this.wumpusRoom = wumpusRoom;
        this.player = p;
    }

    public void act (Player p){
        this.player = p;
        act();
    }


    @Override

    public void act(){
        Level.Room next = avoidPlayer();

        if (next != null){
            moveToNextRoom(next);
        }
    }

    private Level.Room avoidPlayer() {
        Level.Room playerRoom = player.getCurrentRoom();
        Level.Room next = wumpusRoom.getRandomNeighbor();
        while (next.equals(playerRoom)) {
            next = wumpusRoom.getRandomNeighbor();
        }

      //  if (playerRoom.neighborsCreatures(wumpusRoom)) {

    //    }
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
