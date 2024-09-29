import java.util.Scanner;

public class Ex6_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What's your name?");
        String strName = input.nextLine();
        System.out.println("How old are you?");
        int iAge= input.nextInt();
        System.out.println("How tall are you (m)");
        double dHeight= input.nextDouble();

        System.out.println("Mrs/Ms. "+ strName + "," + iAge +" years old. "+ "Your height is "+ dHeight+".");

        input.close();
    }
}
