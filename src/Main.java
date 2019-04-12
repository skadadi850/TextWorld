import com.sun.javafx.binding.Logging;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, Command> commands = new HashMap<>();
    private static Player p = new Player("Simran", "hs senior");
    private static Level g = new Level(p);
    public static void main(String[] args) {

        g.addRoom("hall", "long, narrow, endless, claustrophobic hallway");
        g.addRoom("closet" , "dark, dark closet");
        g.addRoom("dungeon" , "WARNING: dragon approaching");

        Item rope = new Item ("rope","strong twine");
        Item sword = new Item ("sword", "pointy");
        g.getRoom("hall").addItem(rope);
        g.getRoom("dungeon").addItem(sword);

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall","closet");

        p.setCurrentRoom(g.getRoom("hall"));

        String response = "";
        Scanner s = new Scanner(System.in);

        g.createRandomChickens(3);
        g.createPopStar(1);
        g.createWumpus(2);

        initCommands();


        do {

            System.out.println("You are in the " + p.getCurrentRoom().getName());
            System.out.println("What do you want to do?");
            System.out.print(">");
            response = s.nextLine();
            Command command = lookUpCommand(response);
            command.execute();
            g.updateAllCreatures();
        } while (!response.equals("quit"));


    }

    private static void initCommands(){
        commands.put("take",new TakeCommand(g));
        commands.put("look", new LookCommand(p));
        commands.put("add-room", new AddRoomCommand(g));
        commands.put("drop",new DropCommand(g));
        commands.put("go", new GoCommand(g));
        commands.put("quit", new QuitCommand(g));
    }

    private static Command lookUpCommand(String response){
        String commandWord = getFirstWordIn(response);

        Command c = commands.get(commandWord);
        if (c==null)return new EmptyCommand();
        c.init(response);

        return c;
    }

    private static String getFirstWordIn(String response) {
        int spaceValue = response.indexOf(" ");
        if (spaceValue == -1){
            return response;
        }
        return response.substring(0,response.indexOf(" "));
    }


}

