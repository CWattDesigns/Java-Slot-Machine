import java.util.*;

public class Name {
	//Variables
	private String firstName;
	private char middleInitial;
	private String lastName;

	public Name(String fullName) { //Checks name for first and last name
		String temp[] = fullName.split(" ");
		if (temp.length < 3) {
			setFirstName(temp[0]);
			setLastName(temp[1]);
		} else {
			setFirstName(temp[0]);
			setMiddleInitial(temp[1].charAt(0));
			setLastName(temp[2]);
		}
	}

	//Assigns name values in the instance of a missing middle initial
	public Name(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	//Sets names and middle initial for the instance
	public Name(String firstName, char middleInitial, String lastName) {
		this.setFirstName(firstName);
		this.setMiddleInitial(middleInitial);
		this.setLastName(lastName);
	}

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public char getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(char middleInitial) {
		if (Character.isAlphabetic(middleInitial))
			this.middleInitial = Character.toUpperCase(middleInitial);
		else
			System.out.println("Invalid entry.");
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() { //Returns output as a string
		if (Character.isAlphabetic(middleInitial)) {
			return (firstName + " " + middleInitial + ". " + lastName);
		}
		return (firstName + " " + lastName);
	}

	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Name) && !(obj instanceof String)) {
			return false;
		}

		Name nObj = (Name) obj;
		return this.getFirstName().equals(nObj.getFirstName()) && this.getMiddleInitial() == nObj.getMiddleInitial()
				&& this.getLastName().equals(nObj.getLastName());

	}

}
