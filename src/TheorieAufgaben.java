//Abdihakin Sahal Omar 20-947-107
//Manuel Flückiger 22-112-502
public class TheorieAufgaben {
    public static void main(String[] args) {

        //alle zum durchprobieren...
        System.out.println("Aufgabe 1");
        System.out.print("a)");
        theorie1(5, 4);
        System.out.print("\nb)");
        theorie1(8, 4);
        System.out.print("\nc)");
        theorie1(10, 11);
        System.out.print("\nd)");
        theorie1(10, 12);
        System.out.print("\ne)");
        theorie1(10, 13);
        System.out.println("\nAufgabe 2");
        System.out.println(gregorianYear(400));
        System.out.println("\nAufgabe 3");
        System.out.println(isIsosceles(3, 3, 2));
        System.out.println("Aufgabe 4 advanced");
        System.out.println(count("Manuel Flückiger", 'e'));
        //Ich habe diese Funktion so gemacht, dass wir nach irgend einem Char filtern können.
        //um die gewollte funktion zu haben, müsst ihr als zweiten parameter einfach 'a' schreiben anstatt hier 'e'
        System.out.println("Aufgabe 5");
        theorie5();
        System.out.println("Theorie 6");
        theorie6();
        System.out.println("Theorie 7");
        theorie7();

    }
    public static void theorie1(int num1, int num2){
        if (num1 >= num2) {
            System.out.print("1 ");
            System.out.print("2 ");
            num1 = num2 - 1;
        }
        System.out.print("3 ");
        if ((num1 + 1) >= num2) System.out.print("4 ");
        else if ((num1 + 2) >= num2) {
            System.out.print("5 ");
            System.out.print("6 ");
        }
        else {
            System.out.print("7 ");
            System.out.print("8 ");
        }
    }
    public static boolean gregorianYear(int year){
        if(year<1583){
            System.out.println("Der Kalender war noch nicht geboren");
            return false;
        }
        return (year%4==0&&(year%100!=0||year%400==0));
    }
    public static boolean isIsosceles(int x, int y, int z){
        return (!(x == y && y == z ) && (x == y || y == z || z == x ));
    }
    public static int count(String name, char c){
        return name.length()==0 ? 0 : (name.charAt(0)==c ? 1 : 0) + count(name.substring(1),c);
    }
    public static void theorie5(){
        int low = 0, high = 5;do {
            System.out.println(low);
            low++;
        } while (low < high);
    }
    public static void theorie6(){
        for (int i = 1; i <= 3; i++) {
            for (int j = i; j > 0; j--)
                System.out.println(i + " " + j);
        }
    }
    public static void theorie7(){
        int value = 0;
        int num = 10;
        while(num<=40){
            value+=num;
            num+=10;
        }
        System.out.println(value);
    }
}