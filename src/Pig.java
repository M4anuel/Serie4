//Abdihakin Sahal Omar 20-947-107
//Manuel Flückiger 22-112-502
import java.util.Objects;
import java.util.Scanner;

public class Pig {
    public static void main(String[] args) {
        final int MAX_POINTS = 100;
        System.out.println("Spielregeln:\n" +
                "Spieler sind abwechselnd dran, beginnend mit Spieler 1. \n" +
                "Das Ziel ist "+MAX_POINTS+" Punkte zu erreichen. \n" +
                "Dabei kann jeder Spieler in seinem Spielzug entscheiden ob er weiterspielen möchte," +
                " indem er y oder n in die Konsole eingibt.\n" +
                "Dabei werden gewürfelte Punkte akkumuliert." +
                " Sollte eine 1 gewürfelt werden, sind " +
                "alle, in dem Zug gewonnenen Punkte, verloren. Sollten 2 Einsen gewürfelt werden, \n" +
                "verliert der Spieler alle bisher gesammelten Punkte" +
                "\nMöchtest du im Ein- oder Zweispielermodus spielen? (e/z)");
        Scanner scanner = new Scanner(System.in);
        PairOfDice dices = new PairOfDice();

        if (Objects.equals(scanner.next(), "z")){
            System.out.println("Wie soll Spieler 1 heissen?");
            Player player1 = new Player(scanner.next());
            System.out.println("Wie soll Spieler 2 heissen?");
            Player player2 = new Player(scanner.next());
            pig(player1, player2, MAX_POINTS, dices);
        }
        else{
            System.out.println("Wie soll Spieler 1 heissen?");
            Player player1 = new Player(scanner.next());
            Player player2 = new Player("Computer");
            pig(player1, player2, MAX_POINTS, dices);
        }

    }
    public static void pig(Player player1, Player player2, int MAX_POINTS, PairOfDice dices){
        while(true) {
            player1.addPoints(piggyBack(player1, dices));
            sleep(1);//taktische sleeps, damit das Spiel nicht zu schnell angezeigt wird und overwhelming scheint
            if (player1.getPoints() >= MAX_POINTS) {
                System.out.println(player1.getName() + " hat gewonnen");
                break;
            }
            //Player 1 ist immer ein Mensch, nur Player 2 braucht checks, ob es ein Computer ist. ("Bug") wenn
            //Player 2 als Namen Computer nimmt, wird er nicht spielen können, aber dann ist er auch dumm :)

            if (Objects.equals(player2.getName(), "Computer")) { //überall Objects.equals um Null-safe zu sein
                player2.addPoints(piggyBackComputer(player2, dices));
            }else {
                player2.addPoints(piggyBack(player2, dices));
            }
            if (player2.getPoints() >= MAX_POINTS) {
                System.out.println(player2.getName() + " hat gewonnen");
                break;
            }
            sleep(1);
        }
    }
    public static int piggyBack(Player p, PairOfDice dices){//Methodenname hat irgendwo mit dem Namen des Spiels zu tun
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
    public static int piggyBackComputer(Player p, PairOfDice dices){//Computer spezifische Methode, könnte man sicher noch einfacher machen
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
            sleep( 0.5);//Simulation, als würde der Computer entscheiden + man sieht besser was passiert
        }
        System.out.println("Der Computer hat damit jetzt "+(p.getPoints()+temp)+" Punkte");
        return temp;
    }
    public static boolean isOne(PairOfDice p){return p.getDice1().getPoints() == 1 || p.getDice2().getPoints() == 1;}
    public static boolean areOnes(PairOfDice p){return p.getDice1().getPoints() == 1 && p.getDice2().getPoints() == 1;}
    public static void sleep(double sec){
        try {
            Thread.sleep((long) (sec*1000));//wartet sec lange bis das Program weiter ausgeführt wird
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
