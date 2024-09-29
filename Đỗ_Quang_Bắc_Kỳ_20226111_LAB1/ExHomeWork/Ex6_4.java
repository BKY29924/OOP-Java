import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Ex6_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập năm: ");
        int year = input.nextInt();

        System.out.print("Nhập tháng: ");
        int month = input.nextInt();

        int daysInMonth = getDaysInMonth(month, year);
        System.out.println("Tháng " + month + " năm " + year + " có " + daysInMonth + " ngày.");

        input.close();
    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            return 0; // Trả về 0 cho invalid month
        }

        if (month == 2) {
            return (isLeapYear(year)) ? 29 : 28; // Năm nhuận
        }

        return (month == 4 || month == 6 || month == 9 || month == 11) ? 30 : 31;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
