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

        if (Objects.equals(scanner.next(), "z")){
            System.out.println("Wie soll Spieler 1 heissen?");
            Player player1 = new Player(scanner.next());
            System.out.println("Wie soll Spieler 2 heissen?");
            Player player2 = new Player(scanner.next());
            pig(player1, player2, MAX_POINTS);
        }
        else{
            System.out.println("Wie soll Spieler 1 heissen?");
            Player player1 = new Player(scanner.next());
            Player player2 = new Player("Computer");
            pig(player1, player2, MAX_POINTS);
        }

    }

    /**
     * nimmt als Parameter:
     * zwei Player, einer davon möglicherweise ein Computer
     * eine maximale Punktzahl, um die Gewinnbedingung des Spiels anpassen zu können
     * der Gameloop läuft, bis die Gewinnbedingung, gesetzt durch die maximale Punktzahl,
     * erreicht wird. danach wird der Gewinner bekannt gegeben
     */
    public static void pig(Player player1, Player player2, int MAX_POINTS){
        PairOfDice dices = new PairOfDice();
        while((player2.getPoints() <MAX_POINTS)&&(player1.getPoints() <MAX_POINTS)) {
            player1.turn(dices,false);
            sleep(1);//taktische sleeps, damit das Spiel nicht zu schnell angezeigt wird und overwhelming scheint
            //Player 1 ist immer ein Mensch, nur Player 2 braucht checks, ob es ein Computer ist. ("Bug") wenn
            //Player 2 als Namen Computer nimmt, wird er nicht spielen können, aber dann ist er auch nervig und auf bughunt :)

            if (Objects.equals(player2.getName(), "Computer")) { //überall Objects.equals um Null-safe zu sein
                player2.turn(dices,true);
            }else {
                player2.turn(dices,false);
            }
            sleep(1);
        }
        if (player1.getPoints()<player2.getPoints()){
            System.out.println(player2.getName()+" hat gewonnen");
        }
        else {
            System.out.println(player1.getName()+" hat gewonnen");
        }
    }

    /**
     * nimmt als Parameter Sekunden und pausiert das Programm für so lange
     */
    public static void sleep(double sec){
        try {
            Thread.sleep((long) (sec*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
