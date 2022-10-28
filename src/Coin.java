import java.util.Random;

public class Coin {
    private boolean side; //true = head, false = tails
    public Coin(){
        this.side = flip();
    }
    public Coin(boolean side){
        this.side = side;
    }

    public boolean getSide() {
        return side;
    }
    public void setSide(boolean b){
        this.side=b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return getSide() == coin.getSide();
    }
    @Override
    public String toString(){
        if (this.side == false){
            return "Tails";
        }
        else {
            return "Head";
        }
    }

    public static boolean flip(){
        Random rand = new Random();
        return rand.nextInt(2)==1;
    }

}
