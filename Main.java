import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		Player player = new Player();
		Scanner sc = new Scanner(System.in);
		boolean canMove = false; // player can't move at the very beginning

		// Asking Player's Name
		System.out.println("Welcome to the game 'ESCAPE'!!!! To begin the adventure, what is your Name?");
		String input = sc.nextLine();
		player.setName(input);
		//System.out.println("What" + " " + input);

		// INTRO
		System.out.println("You wake up in a cold, dim room. You cannot move because you are tied up in a metal chair with a rope.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e){
		}
		
		System.out.println("Unfortunately, the room is too dim for you to fully recognize its structure, and you have absolutely no clue about the current location.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e){
		}

		System.out.println("The room is in complete silence... seems like there is no one here.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e){
		}

		System.out.println("Your right hand is tied up, but they can reach your right-side pocket. You have a lighter that can be used in your pocket.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e){
		}
		// INTRO ENDS

		Location lc = new Location(5,3); // initial location
    	
		while(true){
		String command1 = sc.nextLine();
		String[] command2 = command1.split(" ");

	if(!canMove){
		if(command2[0].equals("use") && command2[1].equals("lighter")){
			canMove = true;
			System.out.println("Ropes are burned. Now, you are free to move!");
		}
		else if (command2[0].equals("inventory")) {
        	System.out.println (" ");
        	player.listInventory();
        }
		else{
			System.out.println("You can't move yet... you are tied up");
		}
	}
	else{
		if(command2[0].equals("move")){
			lc.move(command2[1]);
		}
		if (command2[0].equals("inventory")) {
        	System.out.println (" ");
        	player.listInventory();
        }
    	if(command2[0].equals("pickup")) {
    		lc.pickup(player);
    		player.listInventory();
    	}
		if(command2[0].equals("use") && command2[1].equals("hammer")){
    		lc.setCantMove();
    		System.out.println("Door knob has been removed. You can open the door now!");
    	}
    	if(command2[0].equals("use") && command2[1].equals("cellphone")){
    		System.out.println("Dialing... Dialing... You hear a recorded message. 'Hey, Listen" + " " + input + "You are in danger. They will kill you. I have a car ready in the garage. Run as soon as possible!.. Be careful!'");
    	}	

    	if(command2[0].equals("open") && command2[1].equals("door")){
    		System.out.println("You hear a guy talking on the phone from that room... 'What are we going to do with him? Are we going to kill him? Oh, you are almost here. I will until then. Okay, Bye.' ");
    	}
    	if(command2[0].equals("use") && command2[1].equals("flashlight")){
    		System.out.println("It's very bright!");
    	}

    	if(command2[0].equals("attack") && command2[1].equals("guard")){
    		System.out.println("Your lucky punch hits him right in the head. He is unconscious now... But, you're fataly wounded from his attack. You must find a way to heal.");
    	}
    	
    	if(command2[0].equals("use") && command2[1].equals("alcohol")){
    		System.out.println("Your wound is sanitized temporarily. You stopped bleeding");
    	}

    	if(command2[0].equals("use") && command2[1].equals("towel")){
    		System.out.println("Your blood is wiped. You look much better now.");
    	}

    	if(command2[0].equals("read") && command2[1].equals("note")){
    		System.out.println("PLEASE HEL..... .");
    	}

    	if(command2[0].equals("fire") && command2[1].equals("enemy")){
    		System.out.println("Bang!~~ You killed him in one shot. 'Knock,Knock!' 'HELP~~~ HELP~~~~!. You hear a noise from room in north direction.");
    	}

    	if(command2[0].equals("untie")) {
    		System.out.println("He is untied and free to move.");
    	}

    	if(command2[0].equals("drive")) {
    		System.out.println("You have escaped successfully! It's been a long way" + " " + input + " " + "Great job! I hope you enjoyed playing it!");
    		break;
    	}

    	if(command2[0].equals("quit")) 
    		break;
	}
	
}//while loop
}//main
}//class




