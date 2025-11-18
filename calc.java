import java.util.Scanner;

public class calc{

    public static int add(int a, int b) {
        return a+b;
    }

    public static int sub(int a, int b) {
        return a-b;
    }

    public static int mul(int a, int b) {
        return a*b;
    }
    public static double div(int a, int b) {
        return a/b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int a = sc.nextInt();
        System.out.println("Enter the second number: ");
        int b = sc.nextInt();
        System.out.println("Enter the operation: ");
        int op = sc.nextInt();
        switch(op){
            case 1:
                System.out.println(add(a, b));
                break;
            case 2:
                System.out.println(sub(a,b));
                break;
            case 3:
                System.out.println(mul(a,b));
                break;
            case 4:
                System.out.println(div(a,b));
                break;
            default:
                System.out.println("Invalid Operation");
                break;
        }
        sc.close();
    }
}   
