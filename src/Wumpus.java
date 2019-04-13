public class Wumpus extends Creature{
    private Player player;
    private Level.Room wumpusRoom;

    public Wumpus(Level.Room wumpusRoom,Player p, String name){
        super (wumpusRoom, name);
        this.wumpusRoom = wumpusRoom;
        this.player = p;
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

        for (Level.Room pr : player.getCurrentRoom().getNeighbors()) {
            while (next.equals(playerRoom) || next.equals(pr)) {
                next = wumpusRoom.getRandomNeighbor();
            }
        }

        return next;
    }
}
