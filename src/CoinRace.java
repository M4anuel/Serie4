public class CoinRace {
    public static void main(String[] args) {

        Coin muenze1 = new Coin();
        Coin muenze2 = new Coin();
        boolean[] muenze13 = new boolean[3];
        boolean[] muenze23 = new boolean[3];
        //Die Methode um die Gewinnbedingung zu prüfen kann ausgewechselt werden, mit der Methode
        //hasWonAdvanced, um auch 3-mal Zahl als gewonnen zu zählen
        //Runde 1
        System.out.println("        Player 1   Player 2");
        System.out.println("Runde 1: "+muenze1.toString()+"     "+muenze2.toString());
        muenze13[0]=muenze1.getSide();
        muenze23[0]=muenze2.getSide();

        //Runde 2
        muenze1.setSide(Coin.flip());
        muenze13[1]=muenze1.getSide();
        muenze2.setSide(Coin.flip());
        muenze23[1]=muenze2.getSide();
        System.out.println("Runde 2: "+muenze1.toString()+"     "+muenze2.toString());

        //Runde 3
        muenze1.setSide(Coin.flip());
        muenze13[2]=muenze1.getSide();
        muenze2.setSide(Coin.flip());
        muenze23[2]=muenze2.getSide();
        System.out.println("Runde 3: "+muenze1.toString()+"     "+muenze2.toString());

        int laufvariable = 4;
        while(true){
            if (hasWon(muenze13) && hasWon(muenze23)){
                System.out.println("beide Spieler haben gewonnen");
                break;
            }
            else if (hasWon(muenze13)){
                System.out.println("p1 hat gewonnen");
                break;
            }
            else if (hasWon(muenze23)){
                System.out.println("p2 hat gewonnen");
                break;
            }
            else {
                for (int i = 0; i < 2; i++) {
                    muenze13[i] = muenze13[i + 1];
                    muenze23[i] = muenze23[i + 1];
                }
                muenze1.setSide(Coin.flip());
                muenze13[2] = muenze1.getSide();
                muenze2.setSide(Coin.flip());
                muenze23[2] = muenze2.getSide();
                System.out.println("Runde " + laufvariable + ": " + muenze1.toString() + "     " + muenze2.toString());
                laufvariable++;
            }
        }

    }

    public static boolean hasWon(boolean[] arr){
        return arr[0] && arr[1] && arr[2];
    }
    public static boolean hasWonadvanced(boolean[] arr){ //Falls die Gewinnbedingung einfach 3 mal dasselbe ist
        return arr[0] == arr[1] && arr[1] == arr[2];
    }
}

