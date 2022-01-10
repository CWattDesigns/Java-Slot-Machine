import java.text.DecimalFormat;
import java.util.Scanner;

public class Player {
	//Variables
	private Name name;
	private Date dateOfBirth;
	private int moneyBalance;

	//Sets the name, date of birth, and balance for each player
	public Player(String name, String dateOfBirth, int moneyBalance) {
		setName(name);
		setDOB(dateOfBirth);
		setBalance(moneyBalance);
	}
	//Keeps track of the amount of players created
	public static int indexLast(Object[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == null)
				return i;
		}
		return -1;
	}

	//Stops letting the user add new players when the number of players reaches 50
	public static void newPlayer(Player[] players) {
		if (indexLast(players) == -1) {
			System.out.println("Sorry, but the casino is full!");
			return;
		}

		//If the casino isn't full, runs this prompt to add a new player
		Scanner sc = new Scanner(System.in);
		System.out.println("What is their first name?");
		String firstName = sc.next();
		System.out.println("What is their last name?");
		String lastName = sc.next();
		System.out.println("What is their date of birth? (Enter in MM/DD/YYYY format)");
		String dateOfBirth = sc.next();
		System.out.println("How much money will they take into the casino? (Enter an integer amount)");
		int balance = sc.nextInt();

		players[indexLast(players)] = new Player((firstName + " " + lastName), dateOfBirth, balance);
	}

	//Getters and setters
	public Name getName() {
		return name;
	}

	public Date getDOB() {
		return dateOfBirth;
	}

	public int getBalance() {
		return moneyBalance;
	}

	public void setName(String name) {
		this.name = new Name(name);
	}

	public void setDOB(String dateOfBirth) {
		this.dateOfBirth = new Date(dateOfBirth);
	}

	public void setBalance(int moneyBalance) {
		this.moneyBalance = moneyBalance;
	}

	//Calculates player balance based on each play result
	public void play(SlotMachine machine) {
		this.moneyBalance--;
		machine.setBalance(machine.getBalance() + 1);
		machine.setPlays(machine.getPlays() + 1);
	}

	@Override
	public String toString() { //Returns results as a string
		DecimalFormat df = new DecimalFormat("$###,###,###,##0.00");
		return name + ", " + dateOfBirth + ", " + df.format(moneyBalance);
	}

}
