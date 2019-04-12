public class AddRoomCommand implements Command {
    Level level;
    String roomName;

    public AddRoomCommand (Level g){
        this.level = g;
    }


    @Override
    public void init(String userString) {
        this.roomName = userString.substring(9);
    }

    @Override
    public boolean execute() {
        boolean success = level.addRoom(roomName);
        return success;
    }
}
