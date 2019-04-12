public class EmptyCommand implements Command {
    @Override
    public void init(String userString){
    }

    @Override
    public boolean execute() {
        System.out.println("Your response was invalid. Please enter look, move<room>, add-room<room>, drop<item>, " +
                "take<item>, quit");
        return true;
    }
}
