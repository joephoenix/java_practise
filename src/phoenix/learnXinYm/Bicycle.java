package phoenix.learnXinYm;

public class Bicycle {
	// Bicycle's Fields/Variables
	public int cadence; // Public: Can be accessed from anywhere
	private int speed; // Private: Only accessible from within the class
	protected int gear; // Protected: Accessible from the class and subclasses
	String name; // default: Only accessible from within this package

	// Constructors are a way of creating classes
	// This is a constructor
	public Bicycle() {
		gear = 1;
		cadence = 50;
		speed = 5;
		name = "Bontrager";
	}

	// This is a constructor that takes arguments
	public Bicycle(int startCadence, int startSpeed, int startGear, String name) {
		this.gear = startGear;
		this.cadence = startCadence;
		this.speed = startSpeed;
		this.name = name;
	}

	// Function Syntax:
	// <public/private/protected> <return type> <function name>(<args>)

	// Java classes often implement getters and setters for their fields

	// Method declaration syntax:
	// <scope> <return type> <method name>(<args>)
	public int getCadence() {
		return cadence;
	}

	// void methods require no return statement
	public void setCadence(int newValue) {
		cadence = newValue;
	}

	public void setGear(int newValue) {
		gear = newValue;
	}

	public void speedUp(int increment) {
		speed += increment;
	}

	public void slowDown(int decrement) {
		speed -= decrement;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	// Method to display the attribute values of this Object.
	@Override
	public String toString() {
		return "gear: " + gear + " cadence: " + cadence + " speed: " + speed
				+ " name: " + name;
	}
}
