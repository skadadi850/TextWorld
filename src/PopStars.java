import javax.sound.midi.Soundbank;

public class PopStars extends Creature{
    private Player player;
    private Level.Room popStarRoom;


    public PopStars (Level.Room popStarRoom,Player p, String name){
        super (popStarRoom,name);
        this.popStarRoom = popStarRoom;
        this.player = p;
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
        Level.Room next = this.currentRoom;
        if (next.neighborsCreatures(player.getCurrentRoom())) {
            next = player.getCurrentRoom();
            return next;
        }

        for (Level.Room pop : popStarRoom.getNeighbors()){
            for (Level.Room pr : player.getCurrentRoom().getNeighbors()){
                if (pop.equals(pr)){
                    next = pop;
                }
            }
        }
        return next;
    }
}
