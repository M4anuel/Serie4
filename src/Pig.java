import java.util.Objects;
import java.util.Scanner;

public class Pig {
    public static void main(String[] args) {
        System.out.println("Spielregeln:\n Spieler sind abwechselnd dran, beginnend mit Spieler 1. \n" +
                "Das Ziel ist 100 Punkte zu erreichen. \n" +
                "Dabei kann jeder Spieler in sinem Spielzug entscheiden ob er weiterspielen möchte," +
                " indem er y oder n in die Konsole eingibt.\n Dabei werden gewürfelte Punkte akkumuliert." +
                " Sollte eine 1 gewürfelt werden, sind " +
                "alle, in dem Zug gewonnenen Punkte, verloren.");
        int a, b;
        a = b = 0;
        int temp = 0;
        boolean player = false;
        String answer;
        PairOfDice dices = new PairOfDice();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Will Spieler 1 würfeln? (y/n)");

        while(a<100 || b<100){
            if (!player){
                dices.throwDice();
                answer = scanner.next();
                if (answer.equals("y")){
                    dices.throwDice();
                    System.out.println("Spieler 1 hat "+ dices.getPoints()+" gewürfelt");
                    if (dices.isOne()){
                        System.out.println("aber dabei eine Eins gewürfelt");
                        temp = 0;
                        player = true;
                    }
                    else{
                        temp+=dices.getPoints();
                        System.out.println("Spieler 1 hat jetzt "+a+temp+" Punkte.");
                        System.out.println("nochmals würfeln (y/n)?");
                    }
                }
                else if (answer.equals("n")){
                    a+=temp;
                    System.out.println("Spieler 1 hat jetzt "+a+" Punkte.");
                    System.out.println("Spieler 2, willst du würfeln? (y/n)");
                    player = true;
                }
            }
            if (player){
                dices.throwDice();
                answer = scanner.next();
                if (answer.equals("y")){
                    dices.throwDice();
                    System.out.println("Spieler 2 hat "+ dices.getPoints()+" gewürfelt");
                    if (dices.isOne()){
                        System.out.println("aber dabei eine Eins gewürfelt");
                        System.out.println("Spieler 2:");
                        temp = 0;
                        player = false;
                    }
                    else{
                        temp+=dices.getPoints();
                        System.out.println("Spieler 2 hat jetzt "+b+temp+" Punkte.");
                        System.out.println("nochmals würfeln (y/n)?");
                    }
                }
                else if (answer.equals("n")){
                    a+=temp;
                    System.out.println("Spieler 2 hat jetzt "+b+" Punkte.");
                    System.out.println("Spieler 1, willst du würfeln? (y/n)");
                    player = false;
                }
            }
        }
    }
}
