import java.util.Scanner;

// 2.2.6 Part 3
public class SecondDegreeEquation {
    public static void main(String[] args) {
        // a*x^2+b*x+c = 0 -> kép, đơn,phức
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập a: ");
        double a = input.nextDouble();

        System.out.print("Nhập b: ");
        double b = input.nextDouble();

        System.out.print("Nhập c: ");
        double c = input.nextDouble();

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Nghiệm của phương trình là:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else {
            double re = -b / (2 * a); // re : phần thực
            if (delta == 0) {
                System.out.println("Phương trình có nghiệm kép:");
                System.out.println("x = " + re);
            } else {
                double im = Math.sqrt(-delta) / (2 * a); // re: phần ảo
                System.out.println("Phương trình có nghiệm phức:");
                System.out.println("x1 = " + re + " + " + im + "i");
                System.out.println("x2 = " + re + " - " + im + "i");
            }
        }

        input.close();
    }
}
