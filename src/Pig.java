//Abdihakin Sahal Omar 20-947-107
//Manuel Flückiger 22-112-502
import java.util.Objects;
import java.util.Scanner;

public class Pig {
    public static void main(String[] args) {
        final int MAX_POINTS = 10;
        System.out.println("Spielregeln:\nSpieler sind abwechselnd dran, beginnend mit Spieler 1. \n" +
                "Das Ziel ist "+MAX_POINTS+" Punkte zu erreichen. \n" +
                "Dabei kann jeder Spieler in sinem Spielzug entscheiden ob er weiterspielen möchte," +
                " indem er y oder n in die Konsole eingibt.\nDabei werden gewürfelte Punkte akkumuliert." +
                " Sollte eine 1 gewürfelt werden, sind " +
                "alle, in dem Zug gewonnenen Punkte, verloren.");

        PairOfDice dices = new PairOfDice();
        Player player1 = new Player("Manuel Player 1", 0);
        Player player2 = new Player("Flückiger Pla 2",0);
        while(true){
            player1.addPoints(piggyBack(player1,dices));
            if (player1.getPoints()>=MAX_POINTS){
                System.out.println(player1.getName()+" hat gewonnen");
                break;
            }
            player2.addPoints(piggyBack(player2,dices));
            if (player1.getPoints()>=MAX_POINTS){
                System.out.println(player2.getName()+" hat gewonnen");
                break;
            }
        }

    }
    public static int piggyBack(Player p, PairOfDice dices){
        System.out.println(p.getName()+" ist dran. Du hast "+p.getPoints()+" Punkte. Möchtest du würfeln? (y/n)");
        int temp = 0;
        Scanner scanner = new Scanner(System.in);
        while(Objects.equals(scanner.next(),"y")){
            dices.throwDice();
            temp += dices.getPoints();
            System.out.println(p.getName()+" hat "+ dices.getPoints() +" gewürfelt und hätte damit "+p.getPoints()+temp+" Punkte");
            if(isOne(dices)){ //should there be a one now, the player doesn't get any points, and it's the other player's turn
                System.out.println("aber dabei eine Eins gewürfelt");
                System.out.println("anderer Spieler würfelt:");
                sleeP();
                return 0;
            }
        }
        return temp;
    }
    public static boolean isOne(PairOfDice p){
        return p.getDice1().getPoints() == 1 || p.getDice2().getPoints() == 1;
    }
    public static void sleeP(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
