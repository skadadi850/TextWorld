public class DropCommand implements Command {
    Level level;
    String itemName;

    public DropCommand(Level g){
        this.level = g;
    }

    @Override
    public void init(String userString) {
        this.itemName = getLastWordIn(userString);
    }

    private String getLastWordIn(String userString) {
        return userString.substring(5);
    }

    @Override
    public boolean execute() {
        Player p = level.getPlayer();
        boolean success = p.dropItem(itemName,p);
        return success;
    }
}


