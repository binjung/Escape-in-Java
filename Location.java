import java.util.ArrayList;
public class Location {


	String[][] grid = new String[7][7];

	int x;
	int y;
	boolean cantMove = true;
	ArrayList<Item>[][] m = new ArrayList[7][7];
	Character[][] n = new Character[7][7];
	boolean guardDead = false;
	boolean enemyDead = false;
	boolean untied = false;
	boolean gotkey = false;
	boolean wound = false;
	boolean noteRead = false;
	boolean empty = false;
	boolean audi = false;



	public Location(int x,int y) {
		this.x = x;
		this.y = y; 

		grid[5][3] = "Storage Room";
		grid[4][3] = "Security Room";
		grid[4][2] = "Kitchen";
		grid[4][4] = "Hallway";
		grid[3][4] = "Empty Room";
		grid[3][2] = "Hallway Leading to Exit";
		grid[2][2] = "Livingroom";
		grid[2][1] = "Room where Mike is captured";
		grid[2][3] = "Hallway to Garage";
		grid[1][3] = "Garage";
		grid[1][4] = "Outside";
		grid[1][5] = "Roadway";
		
		grid[6][2] = null;
		grid[2][0] = null;
		grid[0][2] = null;
		grid[0][3] = null;
		grid[0][4] = null;
		grid[0][5] = null;
		grid[0][6] = null;
		grid[1][6] = null;


		grid[1][1] = null;
		grid[3][1] = null;
		grid[4][1] = null;
		grid[5][1] = null;
		grid[1][2] = null;
		grid[1][5] = null;
		grid[3][3] = null;
		grid[2][4] = null;

		grid[5][2] = null;
		grid[5][4] = null;
		grid[2][5] = null;
		grid[3][5] = null;
		grid[4][5] = null;
		grid[5][5] = null;

		m[5][3] = new ArrayList<Item>();
		m[5][3].add(new Item("Flashlight"));
		m[5][3].add(new Item("Hammer"));
		m[5][3].add(new Item("Cellphone"));

		m[4][2] = new ArrayList<Item>();
		m[4][2].add(new Item("Alcohol"));
		m[4][2].add(new Item("Towel"));
		m[4][2].add(new Item("Pistol"));

		m[2][3] = new ArrayList<Item>();
		m[2][3].add(new Item("Key"));

		n[2][1] = new Character("Mike");
		n[2][2] = new Character("Enemy");		
		n[4][3] = new Character("Guard");

		System.out.println("These are all the items you can find in the room. You must pick them up before using it.");
		System.out.println(m[x][y]);
	}

	public void pickup(Player p){
		if(m[x][y] != null){
			for(int i = 0; i < m[x][y].size(); i++){
				p.addInventory(((Item)m[x][y].get(i)));
			}
		}
	}

	public void setCantMove(){
		cantMove = false;
	}

	public void move(String direction) {

		if(x == 5 && y ==3 && cantMove && direction.equals("west")){
			System.out.println("The door is locked... Door knob is very rusty, so it seems like it can be broken.");
		}
		else if (direction.equals("north")) {
			if (y >= 0 && y < 7) {
				y = y-1;

				if(grid[x][y] != null){
				
				System.out.println("Your current location: " + " " + grid[x][y]);			
				}

			
			else if (grid[x][y] == null) {
				System.out.println("It's blocked.");
				y += 1;
					
				}	
			}	
					
		}
		else if (direction.equals("south")) {
			if (y >= 0 && y < 7) {
				y = y+1;			

				if(grid[x][y] != null) {
				
				System.out.println("Your current location: " + " " + grid[x][y]);			
				}

			
			else if(grid[x][y] == null) {
					
					System.out.println("It's blocked.");
					y -= 1;	
				
				}							
			}
			
		}

		else if (direction.equals("east")) {
			if (x >= 0 && x < 7) {
				x = x+1;

				if(grid[x][y] != null){
					
				System.out.println("Your current location: " + " " + grid[x][y]);			
				}



			else if(grid[x][y] == null) {
				System.out.println("It's blocked.");
				x -= 1;
				}		
			}
					
		}
		else if (direction.equals("west")) {

			if (x >= 0 && x < 7) {
				x = x-1;		

				if(grid[x][y] != null){
				System.out.println("Your current location: " + " " + grid[x][y]);			

				}	

			
			else if(grid[x][y] == null) {
				
					System.out.println("It's blocked.");
					x += 1;

				}			
			}
				
		}

		if(x ==4 && y ==3){

			if(guardDead == false) {

			System.out.println("Guard appears, and he is running towrds you furiously to kill you!");
				guardDead = true;
			}
		}


		if(x ==4 && y ==4){
			if(empty == false) {
				System.out.println("It's an empty hallway. Nothing is here.");
				empty = true;
			}
		}

		if(x ==4 && y ==2){
			if(wound == false) {
				System.out.println("You found an alcohol, a towel, and a pistol in the table.");
				wound = true;
			}
		}

		if(x ==3 && y ==2){
			if(noteRead == false) {
				System.out.println("A note covered with blood is found on the groud.");
				noteRead = true;
			}
		}

		if(x ==2 && y ==2){

			if(enemyDead == false) {
				System.out.println("Another enemy was guarding the room where Mike is captured... He knows that you have escaped... He pulls a gun on you.");
				enemyDead = true;
			}
		}

		if(x ==2 && y ==1){
			if(untied == false) {
				System.out.println("Your Friend Mike is tied to a rope... Luckily, he is alive! Mike says 'Thanks, man.. Now, let's get out of here quickly. I have car ready in the garage. And.. please untie me, it hurts.");
				untied = true;
			}
		}

		if(x ==2 && y ==3){
			if(gotkey == false) {
				System.out.println("A key is hanged in the wall.");
				gotkey = true;
			}
		}

		if(x ==1 && y ==3){
			if(audi == false) {
				System.out.println("Black Audi R8 is parked in the garage.");
				audi = true;
			}	

		}

		if(x ==2 && y ==4){
			System.out.println("You have escaped successfully and saved Mike! Good job.");
		}	
	}
}