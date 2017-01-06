import java.util.*;

public class Player {

	private String name;
	private ArrayList<Item> inventory;

	public Player() {
		inventory = new ArrayList<Item>();
		inventory.add(new Item("lighter"));
	}

	public String getName() {
		return name;
	}

	public void addInventory(Item item) {	
		inventory.add(item);	
	}

	public void listInventory() {
		
		if (inventory.size() == 0) {
			System.out.println("Your inventory is Empty.");
		}

		else {
			System.out.println("You Inventory Contains: ");
			for(int i = 0; i < inventory.size(); i++)
			System.out.println(inventory.get(i).getName());
		}
	}

	public void setName(String newName) {
		name = newName;
	}
}