import java.util.Scanner;
//2.2.5
public class CaculateNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số a: ");
        double a = input.nextDouble();
        System.out.print("Nhập số b: ");
        double b = input.nextDouble();

        System.out.println("Tổng 2 số là: "+ (a+b));
        System.out.println("Hiệu 2 số là: "+ (a-b));
        System.out.println("Tích 2 số là: "+ (a*b));
        System.out.println("Thương 2 số là: "+ (a/b));

    }
}
