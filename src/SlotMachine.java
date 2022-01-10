import java.text.DecimalFormat;
import java.util.Scanner;

public class SlotMachine {
	//Variables
	private String nameOfSlot;
	private int balance;
	private int numJackpots;
	private int jackpotPayout;
	private int numWins;
	private int payout;
	private int plays;

	//Sets the variables for each instance
	public SlotMachine(String nameOfSlot, int balance, int numJackpots, int jackpotPayout, int numWins, int payout) {
		setName(nameOfSlot);
		setBalance(balance);
		setJackpots(numJackpots);
		setJackpotPayout(jackpotPayout);
		setWins(numWins);
		setPayout(payout);
	}

	//Checks if there is enough funds to play
	public boolean isEnough(double testAmount) {
		return getBalance() > testAmount;
	}

	//Checks if there is a jackpot win
	public boolean isJackpot() {
		return (plays % numJackpots == 0);
	}
	
	//Checks if there is a regular win
	public boolean isWin() {
		return (plays % numWins == 0);
	}
	
	//Keeps track of the slot machines creates
	public static int indexLast(Object[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == null)
				return i;
		}
		return -1;
	}

	//Stops the user from creating more slot machines than the casino can hold
	public static void newMachine(SlotMachine[] machines) {
		if (indexLast(machines) == -1) {
			System.out.println("The Casino is full. No more machines can be brought into the casino.");
			return;
		}

		//If casino isn't full, runs through this prompt to create a new slot machine
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the name of the new slot machine:");
		String name = sc.next();
		System.out.println("Please enter the starting balance on this slot machine:");
		int balance = sc.nextInt();
		System.out.println("How many plays does it take for someone to win the jackpot?");
		int numJackpots = sc.nextInt();
		System.out.println("How many plays does it take for someone to win anything at all?");
		int numWins = sc.nextInt();
		System.out.println("How much is the jackpot for this slot machine?");
		int jackpotPayout = sc.nextInt();
		System.out.println("How much is the normal payout for this slot machine?");
		int payout = sc.nextInt();

		machines[indexLast(machines)] = new SlotMachine(name, balance, numJackpots, jackpotPayout, numWins, payout);
	}

	//Getters and setters
	public String getName() {
		return nameOfSlot;
	}

	public int getBalance() {
		return balance;
	}

	public int getNumJackpots() {
		return numJackpots;
	}

	public int getJackpotPayout() {
		return jackpotPayout;
	}

	public int getNumWins() {
		return numWins;
	}

	public int getPayout() {
		return payout;
	}

	public int getPlays() {
		return plays;
	}

	public void setName(String nameOfSlot) {
		this.nameOfSlot = nameOfSlot;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setJackpots(int numJackpots) {
		this.numJackpots = numJackpots;
	}

	public void setJackpotPayout(int jackpotPayout) {
		this.jackpotPayout = jackpotPayout;
	}

	public void setWins(int numWins) {
		this.numWins = numWins;
	}

	public void setPayout(int payout) {
		this.payout = payout;
	}

	public void setPlays(int plays) {
		this.plays = plays;
	}

	@Override
	public String toString() { //Returns result as a string
		DecimalFormat df = new DecimalFormat("$###,###,###,##0.00");
		return nameOfSlot + ", " + df.format(balance) + ", Plays: " + plays;
	}

}
