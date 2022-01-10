
public class MenuPrompt { //Creates a menu driven prompt that is displayed until the user decides to exit it.
	public static void display(Player currentPlayer, SlotMachine currentMachine) {
		System.out.println("*******************************************************************************************");
		System.out.println("The player " + currentPlayer.getName() + " has $" + currentPlayer.getBalance()
				+ " and is currently playing on the " + currentMachine.getName() + " machine.");
		System.out.println();
		System.out.println("[1] Add a Player");
		System.out.println("[2] Select a Player");
		System.out.println("[3] Add a Machine");
		System.out.println("[4] Select a Machine");
		System.out.println("[5] Play a Round");
		System.out.println("[6] Exit");
		System.out.println("*******************************************************************************************");

	}

}
