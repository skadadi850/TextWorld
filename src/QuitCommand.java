public class QuitCommand implements Command {
    public QuitCommand(Level g) {}

    @Override
    public void init(String userString) {
        System.out.println("Thanks for playing!");
    }

    @Override
    public boolean execute() {
        return false;
    }
}
