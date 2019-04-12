public abstract class Creature {
    protected Level.Room currentRoom;
    String name;

    public Creature (Level.Room room, String name){
        this.currentRoom = room;
        this.name = name;

    }
    public void setCurrentRoom(Level.Room newRoom) {
        this.currentRoom = newRoom;
    }

    public void moveRandom(){
        Level.Room next = currentRoom.getRandomNeighbor();
        moveToNextRoom(next);
    }

    public String getName() {
        return name;
    }

    public void setNames(String names) {
        this.name = names;
    }

//    public abstract void move();

    protected Level.Room getCurrentRoom (){
        return currentRoom;
    }

    protected boolean moveToNextRoom(Level.Room r){
        currentRoom.removeCreature(this);
        this.setCurrentRoom(r);
        r.addCreature(this);
        return(currentRoom != null);
    }

    public abstract void act();
}