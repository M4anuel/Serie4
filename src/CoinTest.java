//Abdihakin Sahal Omar 20-947-107
//Manuel Flückiger 22-112-502
public class CoinTest {
    public static void main(String[] args) {
        Coin euro = new Coin(false);
        Coin pound = new Coin(false);
        System.out.println(euro.equals(pound));
        System.out.println(euro == pound);
        System.out.println(euro.toString() + pound.toString());

    }
}