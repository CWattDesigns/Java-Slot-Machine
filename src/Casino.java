import java.util.*;
public class Casino {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Player players[] = new Player[50]; //Sets an array of 50 players
		SlotMachine machines[] = new SlotMachine[50]; //Sets an array of 50 Slot Machines

		//Creates the first player: Uncle Charlie
		players[0] = new Player("Uncle Charlie", "1/25/1984", 100);
		//Creates the first 3 slot machines
		machines[0] = new SlotMachine("Lucky 7", 5000, 10000, 5000, 10, 5);
		machines[1] = new SlotMachine("Lucky Lotto", 55000, 100000, 75000, 50, 25);
		machines[2] = new SlotMachine("Purple People Eater", 1000, 50, 40, 5, 2);

		//Sets a current player and machine they are playing on to be displayed
		Player currentPlayer = players[0];
		SlotMachine currentMachine = machines[0];

		int option = 6;
		do {
			MenuPrompt.display(currentPlayer, currentMachine); //Calls the MenuPrompt class
			option = sc.nextInt();
			int index = 0;
			Player player = currentPlayer;
			switch (option) {
			case 1: //Allows user to create a new player
				Player.newPlayer(players); //Calls the Player class
				break;
			case 2: //Allows user to select a player to play
				print(players);
				System.out.println("Which player will you choose? ");
				index = sc.nextInt() - 1;
				//Checks if selected player has enough funds to play
				if (players[index].getBalance() < 1) {
					System.out.println("This player is out of funds! Pick another player.");
					break;
				}
				currentPlayer = players[index];
				break;
			case 3: //Allows user to create a new slot machine
				SlotMachine.newMachine(machines); //Calls the SlotMachine class
				break;
			case 4: //Allows user to select a machine to play on
				print(machines);
				System.out.println("Which machine will you choose? ");
				index = sc.nextInt() - 1;
				//Checks if selected machine has enough funds to play
				if (machines[index].getBalance() < machines[index].getPayout()) {
					System.out.println("This machine is out of funds! Pick another machine.");
					break;
				}
				currentMachine = machines[index];
				break;
			case 5: //Allows the selected player to play a round on the selected machine 
				player.getBalance();
				do {
					int i = 0;
					int j = 0;
					int count = 0;
					play(currentPlayer, currentMachine);
					
					for(int j1 = 1; j1<500; j1++) {
						count+=1;
					}
					currentMachine = machines[i + 1];
					
					System.out.println("The player played: "+ count + " times!");
				}while (player.getBalance() != 0);
				break;
			case 6: //Exits the program
				System.out.println("Goodbye!");
				break;
			default: //Prints an error message for invalid inputs
				System.out.println("Invalid. Please try again.");
				break;
			}
		} while (option != 6); //Breaks the loop
	}

	//Keeps track of and prints objects such as players and slot machines
	public static void print(Object[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == null)
				continue;
			System.out.println("[" + (i + 1) + "] " + arr[i]);
		}
	}

	//Initiates 1 play through using the current player and the current machine
	public static void play(Player player, SlotMachine machine) {
		Scanner sc = new Scanner(System.in);
		String input = "0";
		//Checks if the player has funds to play
		if (player.getBalance() < 1) {
			System.out.println("This player is out of funds! Pick a different player.");
			return;
		}
		//Checks if the machine has funds to play
		if (machine.getBalance() < machine.getPayout()) {
			System.out.println("This machine is out of funds! Pick a different machine.");
			return;
		}

		//Initiates a play on the machine
		player.play(machine);

		//Checks for a jackpot win and calculates the remaining funds depending on the result
		if (machine.isJackpot()) {
			System.out.println("CONGRATULATIONS!!! YOU JUST HIT THE " + machine.getName().toUpperCase() + " JACKPOT!!!");
			player.setBalance(player.getBalance() + machine.getJackpotPayout());
			machine.setBalance(machine.getBalance() - machine.getJackpotPayout());
		} else if (machine.isWin()) { //Checks for a regular win and performs according calculations
			System.out.println("You just won $" + machine.getPayout() + " on the " + machine.getName() + " machine.");
			player.setBalance(player.getBalance() + machine.getPayout());
			machine.setBalance(machine.getBalance() - machine.getPayout());
		} else { //Prints out a loss statement if play doesn't result in jackpot or win
			System.out.println("Sorry! Better luck next time " + player.getName() + "!");
		}
		
	}

}
