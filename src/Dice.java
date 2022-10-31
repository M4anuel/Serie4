//Abdihakin Sahal Omar 20-947-107
//Manuel Flückiger 22-112-502
import java.util.Random;

public class Dice {

	// maximale Punktezahl des Wuerfels
	public final int MAX = 6;

	// aktuelle Punktezahl des Wuerfels
	private int points;

	// Objekt zur Erzeugung von Zufallszahlen
	private final Random randomGenerator;

	/**
	 * instanziiert einen neuen Wuerfel und initialisiert die Variablen
	 */
	public Dice() {
		this.randomGenerator = new Random();
		this.points = 1;
	}

	/**
	 * "wirft" den Wuerfel (setzt die Punktezahl auf eine zufaellige, gluetige Zahl)
	 */
	public int roll() {
		this.points = this.randomGenerator.nextInt(MAX) + 1;
		return this.points;
	}

	/**
	 * setzt die aktuelle Punktezahl des Wuerfels auf den bergebenen Wert
	 */
	public void setPoints(int points) {
		if (points >= 1 && points <= MAX)
			this.points = points;
		else
			this.printMessage("Unzulssige Eingabe. " + "Wrfel wird nicht verndert.");
	}

	/**
	 * gibt die aktuelle Punktezahl des Wuerfels zurueck
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
