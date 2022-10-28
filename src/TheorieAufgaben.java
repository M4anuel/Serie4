public class TheorieAufgaben {
    public static void main(String[] args) {

        //alle zum durchprobieren...
        System.out.print("a)");
        theorie1(5, 4);
        System.out.print("\nb)");
        theorie1(8,4);
        System.out.print("\nc)");
        theorie1(10,11);
        System.out.print("\nd)");
        theorie1(10,12);
        System.out.print("\ne)");
        theorie1(10,13);
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
    }
}