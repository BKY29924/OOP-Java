import java.util.Scanner;
// 2.2.6 Part 2
public class SystemFirstDegreeEquation {
    public static void main(String[] args) {
        // a1*x + b1*y = c1
        // a2*x + b2*y = c2
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập a1: ");
        double a1 = input.nextDouble();
        System.out.print("Nhập b1: ");
        double b1 = input.nextDouble();
        System.out.print("Nhập c1: ");
        double c1 = input.nextDouble();
        System.out.print("Nhập a2: ");
        double a2 = input.nextDouble();
        System.out.print("Nhập b2: ");
        double b2 = input.nextDouble();
        System.out.print("Nhập c2: ");
        double c2 = input.nextDouble();

        double det = a1 * b2 - a2 * b1;

        if (det == 0) {
            if (c1 / c2 == a1 / a2) {
                System.out.println("Hệ phương trình có vô số nghiệm.");
            } else {
                System.out.println("Hệ phương trình vô nghiệm.");
            }
        } else {
            double x = (c1 * b2 - c2 * b1) / det;
            double y = (a1 * c2 - a2 * c1) / det;

            System.out.println("Nghiệm của hệ phương trình là:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }

        input.close();
    }
}
