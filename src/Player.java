import java.util.Objects;
import java.util.Scanner;

public class Player {
    //Name des Spielers
    private String name;
    //Akkumulierte Punktzahl des Spielers
    private int points = 0;

    /**
     *instanziiert einen neuen Spieler und initialisiert den Namen
     */

    public Player(String name){
        this.name = name;
    }
    /**
     *instanziiert einen neuen Spieler und initialisiert den Namen und die Punktzahl
     * -> Debug Konstruktor
     */
    public Player(String name, int points){
        this.name = name;
        this.points = points;
    }

    /**
     * simuliert Zug eines spielers und wendet je nachdem, ob es ein Computer ist oder nicht, die passende Methode an
     */
    public void turn(PairOfDice dices, boolean isComputer){
        if (!isComputer) {
            this.addPoints(piggyBack(this, dices));
        }
        else {
            this.addPoints(piggyBackComputer(this,dices));
        }
    }
    /**
     * sollte der Player ein "echter" Spieler sein, muss dieser sagen, ob er würfeln möchte oder nicht.
     * Dies kann er so lange entscheiden, bis er entweder "n" sagt oder eine oder zwei Einsen würfelt.
     * entweder wird die Summe der akkumulierten Punkte auf den Würfeln zurückgegeben, oder 0, falls eine 1 gewürfelt wurde.
     */

    public int piggyBack(Player p, PairOfDice dices){//Methodenname hat irgendwo mit dem Namen des Spiels zu tun
        System.out.println(p.getName()+" ist dran. Du hast "+p.getPoints()+" Punkte. Möchtest du würfeln? (y/n)");
        int temp = 0;
        Scanner scanner = new Scanner(System.in);
        while(Objects.equals(scanner.next(),"y")){
            dices.throwDice();
            temp += dices.getPoints();
            System.out.println(p.getName()+" hat "+ dices.getPoints() +" gewürfelt und hätte damit "+(p.getPoints()+temp)+" Punkte");
            if(areOnes(dices)){//erste lose-Bedingung
                System.out.println("aber dabei zwei Einsen gewürfelt und so alle Punkte verloren...");
                p.setPoints(0);
                return 0;
            }
            else if(isOne(dices)){//zweite lose-Bedingung
                System.out.println("aber dabei eine Eins gewürfelt");
                return 0;
            }
            System.out.println("weiterwürfeln? (y/n)");
        }
        //Sollte der User input etwas anderes als "y" sein, müsste es n sein. aber falls der Benutzer aus Versehen
        //irgendetwas eingibt, wollen wir nicht, dass das Programm abstürzt, deswegen kommt einfach der andere Spieler dran
        System.out.println(p.getName()+" hat damit jetzt "+(p.getPoints()+temp)+" Punkte");
        return temp;
    }

    /**
     * Sollte der Player ein "Computer" sein, soll er, laut Aufgabe, solange "würfeln", bis die Summe >20 ist.
     * damit der Spieler weiss, was abgeht, wird es in der Konsole dokumentiert.
     * Auch hier wird die Summe oder 0 zurückgegeben, jenachdem, ob eine 1 gewürfelt wurde bevor die Summe >20 ist.
     */
    public int piggyBackComputer(Player p, PairOfDice dices){//Computer spezifische Methode, könnte man noch mit der oberen Methode verschmelzen
        System.out.println("Der Computer ist dran. Er hat "+p.getPoints()+" Punkte.");
        int temp = 0;
        while(temp<20){
            dices.throwDice();
            temp += dices.getPoints();
            System.out.println("der Computer hat "+ dices.getPoints() +" gewürfelt und hätte damit "+p.getPoints()+temp+" Punkte");
            if(areOnes(dices)){
                System.out.println("aber dabei zwei Einsen gewürfelt und so alle Punkte verloren...");
                p.setPoints(0);
                return 0;
            }
            else if(isOne(dices)){
                System.out.println("aber dabei eine Eins gewürfelt");
                return 0;
            }
            Pig.sleep( 0.5);//Simulation, als würde der Computer entscheiden + man sieht besser was passiert
        }
        System.out.println("Der Computer hat damit jetzt "+(p.getPoints()+temp)+" Punkte");
        return temp;
    }

    /**
     * überprüft, ob einer der Würfel eine 1 ist
     */
    public boolean isOne(PairOfDice p){return p.getDice1().getPoints() == 1 || p.getDice2().getPoints() == 1;}
    /**
     * überprüft, ob beide Würfel eine 1 sind
     */
    public boolean areOnes(PairOfDice p){return p.getDice1().getPoints() == 1 && p.getDice2().getPoints() == 1;}

    //Getter und Setter Methoden
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }
    public void addPoints(int i){
        this.points+= i;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
