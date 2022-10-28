import java.util.Random;

public class Dice {

	// maximale Punktezahl des Wrfels
	public final int MAX = 6;

	// aktuelle Punktezahl des Wrfels
	private int points;

	// Objekt zur Erzeugung von Zufallszahlen
	private Random randomGenerator;

	/**
	 * instanziiert einen neuen Wrfel und initialisiert die Variablen
	 */
	public Dice() {
		this.randomGenerator = new Random();
		this.points = 1;
	}

	/**
	 * "wirft" den Wrfel (setzt die Punktezahl auf eine zufllige, gltige Zahl)
	 */
	public int roll() {
		this.points = this.randomGenerator.nextInt(MAX) + 1;
		return this.points;
	}

	/**
	 * setzt die aktuelle Punktezahl des Wrfels auf den bergebenen Wert
	 */
	public void setPoints(int points) {
		if (points >= 1 && points <= MAX)
			this.points = points;
		else
			this.printMessage("Unzulssige Eingabe. " + "Wrfel wird nicht verndert.");
	}

	/**
	 * gibt die aktuelle Punktezahl des Wrfels zurck
	 */
	public int getPoints() {
		return this.points;
	}

	/**
	 * gibt eine Systemmeldung aus
	 */
	private void printMessage(String message) {
		System.out.println(message);
	}
}
