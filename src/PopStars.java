public class PopStars extends Creature{
    private Player player;
    private Level.Room popStarRoom;

    public PopStars (Level.Room popStarRoom, String name){
        super (popStarRoom,name);
        this.popStarRoom = popStarRoom;
    }

    public void act (Player p){
        this.player = p;
        act();
    }

    @Override
    public void act(){
        Level.Room next = lookForPlayer();

        if (next != null){
            this.moveToNextRoom(next);
        }
    }

    private Level.Room lookForPlayer() {
        Level.Room next = popStarRoom;
        if (player.currentRoom.neighborsCreatures(currentRoom)) {
            next = currentRoom;
        }

        for (Level.Room popr : popStarRoom.getNeighbors()){
            for (Level.Room pr : player.getCurrentRoom().getNeighbors()){
                if (popr.equals(pr)){
                    next = popr;
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
