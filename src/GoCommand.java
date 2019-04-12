public class GoCommand implements Command {
    Level level;
    String roomName;

    public GoCommand(Level g) {
        this.level = g;
    }

    @Override
    public void init(String userString) {
        this.roomName = getLastWordIn(userString);
    }

    private String getLastWordIn(String userString) {
        return userString.substring(3);
    }

    @Override
    public boolean execute() {
        Player p = level.getPlayer();
        p.setCurrentRoom(level.getRoom(this.roomName));
        return true;
    }
}
