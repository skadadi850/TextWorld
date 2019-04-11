import java.util.HashMap;
import java.util.Scanner;

public class Main {
    HashMap<String, Command> commands;
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




        do {

            initCommands();

            System.out.println("You are in the " + p.getCurrentRoom().getName());
            System.out.println("What do you want to do?");
            System.out.println(">");
            response = s.nextLine();
            Command command = lookUpCommand(response);
            command.execute();

            if (response.contains("go")){
                String roomName = response.substring(3);
                p.setCurrentRoom( g.getRoom(roomName));
            } else if (response.equals("look")){
                System.out.println("Items: " + p.getCurrentRoom().displayItems());
                System.out.println(p.currentRoom.getCreatures().size());
            } else if (response.contains("add room")) {
                String roomName = response.substring(9);
                g.addRoom(roomName, "new room");
                g.addUndirectedEdge(p.getCurrentRoom().getName(), roomName);
            } else if (response.contains("take")){
                String object = response.substring(5);
                Item i = p.currentRoom.removeItem(object);
                p.addItem(i);
            } else if (response.contains("drop")){
                String object = response.substring(5);
                Item i = p.removeItem(object);
                p.currentRoom.addItem(i);
                System.out.println("You have dropped a " + i.getName());

            } else if (response.equals("quit")){
                response = "quit";
            } else {
                System.out.println("Try Again! Type go <room>, look, add room <room>, or quit");
            }
        } while (!response.equals("quit"));


    }

    private void initCommands(){
        commands.put("take",new TakeCommand(g));
        commands.put("look", new LookCommand(p));
        commands.put("add-room", new AddRoomCommand(g));
        commands.put("drop",new DropCommand(g));
        commands.put("go", new GoCommand(g));
        commands.put("quit", new QuitCommand(g));
    }

    private Command lookUpCommand(String response){
        String commandWord = getFirstWordIn(response);

        Command c = commands.get(commandWord);
        if (c==null)return new EmptyCommand();
        c.init(response);

        return c;
    }

    private String getFirstWordIn(String response) {
        return response.substring(0,response.indexOf(" "));
    }


}

