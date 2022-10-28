public class test {
    public static void main(String[] args) {
        //int num1 = 5, num2 = 4;
        //int num1 = 8, num2 = 4;
        int num1 = 10, num2 = 11;
        //int num1 = 10, num2 = 12;
        //int num1 = 10, num2 = 13;
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