package serie04;

import java.util.Random;

public class Dice {

	// maximale Punktezahl des Würfels
	public final int MAX = 6;

	// aktuelle Punktezahl des Würfels
	private int points;

	// Objekt zur Erzeugung von Zufallszahlen
	private Random randomGenerator;

	/**
	 * instanziiert einen neuen Würfel und initialisiert die Variablen
	 */
	public Dice() {
		this.randomGenerator = new Random();
		this.points = 1;
	}

	/**
	 * "wirft" den Würfel (setzt die Punktezahl auf eine zufällige, gültige Zahl)
	 */
	public int roll() {
		this.points = this.randomGenerator.nextInt(MAX) + 1;
		return this.points;
	}

	/**
	 * setzt die aktuelle Punktezahl des Würfels auf den übergebenen Wert
	 */
	public void setPoints(int points) {
		if (points >= 1 && points <= MAX)
			this.points = points;
		else
			this.printMessage("Unzulässige Eingabe. " + "Würfel wird nicht verändert.");
	}

	/**
	 * gibt die aktuelle Punktezahl des Würfels zurück
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
