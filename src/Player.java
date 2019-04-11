import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name, description;
    private List<Item> items = new ArrayList<>();
    Level.Room currentRoom;

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addItem (Item item){
        if (item == (null)){
            System.out.println("You cannot pick up that item");
        } else {
            System.out.println("You picked up a " + item.getName());
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

    public boolean destroyItem (String name){
        return items.remove(name);
    }

    public List<Item> getItems (){
        return items;
    }

    public void displayInventory (){
        for (Item i : items){
            System.out.println(i.getName() + " ");
        }
    }

    public Level.Room getCurrentRoom (){
        return currentRoom;
    }

    public void setCurrentRoom (Level.Room newRoom){
        currentRoom = newRoom;
    }

    public boolean moveToRoom (String name){
        Level.Room neighbor = currentRoom.getNeighbor(name);
        if (neighbor != null) {
            return true;
        }return false;
    }

    public boolean takeItem(String itemName) {
        Item i = this.currentRoom.removeItem(itemName);
        this.addItem(i);
        return (i.equals(null));
    }
}
