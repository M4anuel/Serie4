//Abdihakin Sahal Omar 20-947-107
//Manuel Flückiger 22-112-502
public class PairOfDiceTest {
    public static void main(String[] args) {
        PairOfDice pair = new PairOfDice();
        System.out.println(pair.getPoints());
        pair.throwDice();
        System.out.println(pair.getPoints());
    }
}
