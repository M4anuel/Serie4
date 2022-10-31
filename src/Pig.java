//Abdihakin Sahal Omar 20-947-107
//Manuel Flückiger 22-112-502
import java.util.Scanner;

public class Pig {
    public static void main(String[] args) {
        System.out.println("Spielregeln:\n Spieler sind abwechselnd dran, beginnend mit Spieler 1. \n" +
                "Das Ziel ist 100 Punkte zu erreichen. \n" +
                "Dabei kann jeder Spieler in sinem Spielzug entscheiden ob er weiterspielen möchte," +
                " indem er y oder n in die Konsole eingibt.\n Dabei werden gewürfelte Punkte akkumuliert." +
                " Sollte eine 1 gewürfelt werden, sind " +
                "alle, in dem Zug gewonnenen Punkte, verloren.");

        PairOfDice dices = new PairOfDice();
        Player player1 = new Player("Manuel Player 1", 0);
        Player player2 = new Player("Flückiger Pla 2",0);
        int temp;
        while(player1.getPoints()<=20 && player2.getPoints()<=20){
            temp = 0;
            player1.addPoints(piggyBack(player1,dices,temp));
            temp = 0;
            player2.addPoints(piggyBack(player2,dices,temp));
        }

    }
    public static int piggyBack(Player p, PairOfDice dices, int temp){
        System.out.println(p.getName()+" ist dran. Möchtest du würfeln?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.equals("n")){ //if a player is satisfied with the gained points he can choose no to save his points
            System.out.println(p.getName()+" hat jetzt "+p.getPoints()+" Punkte.");
            sleeP();
            return temp;
        }
        else if(answer.equals("y")){//if the answer is y, dices are thrown
            dices.throwDice();
            temp += dices.getPoints();
            System.out.println(p.getName()+" hat "+ dices.getPoints() +" gewürfelt");
            if(isOne(dices)){ //should there be a one now, the player doesn't get any points, and it's the other player's turn
                System.out.println("aber dabei eine Eins gewürfelt");
                System.out.println("anderer Spieler würfelt:");
                sleeP();
                return 0;
            }
            else{//if the next throw isn't 1, this rounds addition goes up by the the amount of points on the dices
                System.out.println(p.getName()+" hat jetzt "+(p.getPoints()+temp)+" Punkte.");
                return piggyBack(p, dices, temp);
            }
        }
        return 0;
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
