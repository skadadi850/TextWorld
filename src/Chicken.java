public class Chicken extends Creature{
    private Level.Room currentRoom;
    String name;

    public Chicken(Level.Room r, String id){
        super(r, id);
        this.name = id;
        this.currentRoom = r;

    }

    @Override
    public void act(){
        Level.Room next = currentRoom.getRandomNeighbor();
        if (next != null){
            this.move(next);
        }

    }
    public void move(Level.Room next) {
        moveToNextRoom (next);
    }

}
