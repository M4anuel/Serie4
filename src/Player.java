public class Player {
    private String name;
    private int points = 0;

    public Player(String name, int points){//debug Methode
        this.name = name;
        this.points = points;
    }
    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }
    public void addPoints(int i){
        this.points+= i;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
