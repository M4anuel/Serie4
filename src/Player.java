import java.util.Objects;
import java.util.Scanner;
//Hilfsklasse zum Pig Game
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
        this.addPoints(this.piggyBack(dices, isComputer));
    }
    /**
     * sollte der Player ein "echter" Spieler sein, muss dieser sagen, ob er würfeln möchte oder nicht.
     * Dies kann er so lange entscheiden, bis er entweder "n" sagt oder eine oder zwei Einsen würfelt.
     * entweder wird die Summe der akkumulierten Punkte auf den Würfeln zurückgegeben, oder 0, falls eine 1 gewürfelt wurde.
     * der "Computer" würfelt dabei immer bis er >=20 Punkte hat, oder er eine oder zwei einsen gewürfelt hat
     */

    public int piggyBack(PairOfDice dices, boolean isComputer){//Methodenname hat irgendwo mit dem Namen des Spiels zu tun
        int temp = 0;
        if (!isComputer){
            System.out.println(this.getName()+" ist dran. Du hast "+this.getPoints()+" Punkte. Möchtest du würfeln? (y/n)");
            Scanner scanner = new Scanner(System.in);
            while(Objects.equals(scanner.next(),"y")){
                dices.throwDice();
                temp += dices.getPoints();
                System.out.println(this.getName()+" hat "+ dices.getPoints() +" gewürfelt und hätte damit "+(this.getPoints()+temp)+" Punkte");
                if (play(dices)){
                    return 0;
                }
                System.out.println("weiterwürfeln? (y/n)");
            }
            //Sollte der User input etwas anderes als "y" sein, müsste es n sein. aber falls der Benutzer aus Versehen
            //irgendetwas eingibt, wollen wir nicht, dass das Programm abstürzt, deswegen kommt einfach der andere Spieler dran
            System.out.println(this.getName()+" hat damit jetzt "+(this.getPoints()+temp)+" Punkte");
        }
        else {
            System.out.println("Der Computer ist dran. Er hat "+this.getPoints()+" Punkte.");
            while(temp<20){
                dices.throwDice();
                temp += dices.getPoints();
                System.out.println("der Computer hat "+ dices.getPoints() +" gewürfelt und hätte damit "+(this.getPoints()+temp)+" Punkte");
                if (play(dices)){
                    return 0;
                }
                Pig.sleep( 0.5);//Simulation, als würde der Computer entscheiden + man sieht besser was passiert
            }
            System.out.println("Der Computer hat damit jetzt "+(this.getPoints()+temp)+" Punkte");
        }
        return temp;
    }

    /**
     * Methode schaut, ob eine oder 2 Einsen gewürfelt wurden, und handelt dementsprechend
     */
    private boolean play(PairOfDice dices){
        if(areOnes(dices)){
            System.out.println("aber dabei zwei Einsen gewürfelt und so alle Punkte verloren...");
            this.setPoints(0);
            return true;
        }
        else if(isOne(dices)){
            System.out.println("aber dabei eine Eins gewürfelt");
            return true;
        }
        else return false;
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
