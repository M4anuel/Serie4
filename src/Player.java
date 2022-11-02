import java.util.Objects;
import java.util.Scanner;

public class Player {
    private String name;
    private int points = 0;

    public Player(String name, int points){//debug Methode
        this.name = name;
        this.points = points;
    }
    public Player(String name){
        this.name = name;
    }

    public void turn(PairOfDice dices, boolean isComputer){
        if (!isComputer) {
            this.addPoints(piggyBack(this, dices));
        }
        else {
            this.addPoints(piggyBackComputer(this,dices));
        }
    }

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

    public int piggyBackComputer(Player p, PairOfDice dices){//Computer spezifische Methode, könnte man sicher noch einfacher machen
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
    public boolean isOne(PairOfDice p){return p.getDice1().getPoints() == 1 || p.getDice2().getPoints() == 1;}
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
