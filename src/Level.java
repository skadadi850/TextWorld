import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Level {

    private ArrayList<Creature> creatures = new ArrayList<>();
    private HashMap<String, Room> rooms;

    public Level (){
        this.rooms = new HashMap<String,Room>();
    }

    public void addRoom(String name, String description) {
        Room n = new Room(name);
        n.setDescription(description);
        rooms.put(name, n);


    }

    public void addDirectedEdge(String name1, String name2) {
        Room n1 = rooms.get(name1);
        Room n2 = rooms.get(name2);

        n1.addNeighbor(n2);
    }


    public void addUndirectedEdge(String name1, String name2) {
        Room n1 = rooms.get(name1);
        Room n2 = rooms.get(name2);

        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }


    public Room getRoom(String name) {
        return rooms.get(name);
    }

    public class Room{
        public String name;
        public HashMap<String, Room> neighbors;
        private String description;
        public List <Item> items = new ArrayList <>();
        //public List <Creature> creatures = new ArrayList<>();


        public Room (String name){
            this.name = name;
            this.neighbors = new HashMap<String, Room>();
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private void addNeighbor (Room n){
            neighbors.put(n.name,n);
        }

        public String getNeighborNames(){
            String names = "";
            for (String name : neighbors.keySet()){
                names += name + " ";
            }
            return names;
        }

        public ArrayList<Room> getNeighbors(){
            ArrayList <Level.Room> adjacentRooms;
            adjacentRooms = new ArrayList<>(rooms.values());
            return adjacentRooms;
        }

        public Room getNeighbor (String name){
            return neighbors.get(name);
        }

        public String getName() {
            return name;
        }

        public List<Item> getItems(){
            return items;
        }

        public String displayItems (){
            String output = "";

            for (Item i : items){
                output += i.getName() + " ";
            }
            return output;
        }

        public void addItem (String name){
            Item i = new Item(name);
            items.add(i);
        }

        public void addItem (String name, String description){
            Item i = new Item(name, description);
            items.add(i);
        }

        public void addItem (Item item){
            if (item == (null)){
                System.out.println("You cannot pick up that item");
            }
            items.add(item);
        }

        public Item removeItem (String name){
            for (Item i : items){
                if (i.getName().equals(name)){
                    items.remove(i);
                    return i;
                }
            }
            return null;
        }

        public void updateAllCreatures(){
            for (Creature c : creatures){
                c.act();
            }
        }

        public List<Creature> getCreatures(){
            return creatures;
        }

        public String displayCreatures (){
            String output = "";

            for (Creature i : creatures){
                output += i.getName() + " ";
            }
            return output;
        }

        public void addCreature (Creature c){
            if (c == (null)){
                System.out.println("You cannot add that creature");
            }
            creatures.add(c);
        }

        public void removeCreature (Creature c){
            creatures.remove(c);
        }



        public boolean destroyCreature (String name){
            return creatures.remove(name);
        }


        public Room getRandomNeighbor () {
            ArrayList<Level.Room> neighbors = this.getNeighbors();
            Level.Room next = neighbors.get((int)(Math.random()*neighbors.size()));
            return next;
        }

        protected void moveTowards (Level.Room r){

        }

        protected void moveAwayFrom (Level.Room r){

        }



        protected boolean areNeighbors (Level.Room playerRoom){
            ArrayList<Level.Room> playerNeighbors = getNeighbors();
            for (Level.Room room : playerNeighbors){
                if (room.equals(playerRoom)){
                    return true;
                }
            }
            return false;
        }


    }
}

//