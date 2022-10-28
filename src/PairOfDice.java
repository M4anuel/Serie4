public class PairOfDice {
    private Dice dice1, dice2;

    public PairOfDice(){
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }
    public void throwDice(){
        dice1.roll();
        dice2.roll();
    }
    public int getPoints(){
        return dice1.getPoints()+ dice2.getPoints();
    }
    public Dice getDice1() {
        return dice1;
    }

    public void setDice1(Dice dice1) {
        this.dice1 = dice1;
    }

    public Dice getDice2() {
        return dice2;
    }

    public void setDice2(Dice dice2) {
        this.dice2 = dice2;
    }

}
