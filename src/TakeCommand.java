public class TakeCommand implements Command {
    Level level;
    String itemName;

    public TakeCommand (Level level){
        this.level = level;
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
        boolean success = p.takeItem(itemName);
        return success;
    }
}
