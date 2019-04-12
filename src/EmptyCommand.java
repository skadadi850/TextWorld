public class EmptyCommand implements Command {
    @Override
    public void init(String userString) {
        System.out.println(userString + " is not a valid response");
    }

    @Override
    public boolean execute() {
        return false;
    }
}
