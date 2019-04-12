public class LookCommand implements Command {
    Player player;

    public LookCommand (Player p){
        this.player = p;
    }


    @Override
    public void init(String userString) {

    }

    @Override
    public boolean execute() {
        Level.Room playerRoom = player.getCurrentRoom();
        System.out.println("Items: " + playerRoom.displayItems());
        System.out.println("Creature List: " + playerRoom.displayCreatures());

        return (playerRoom != null);
    }
}
