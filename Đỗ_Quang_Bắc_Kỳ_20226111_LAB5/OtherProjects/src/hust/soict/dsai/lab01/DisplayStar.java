// Exercise 6.3
package hust.soict.dsai.lab01;;
import java.util.Scanner;

public class DisplayStar {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		// Khoi tao bien n: chieu cao cua tam giac
		int n_hungndp = -1;
		while (n_hungndp <= 0) {
			System.out.print("Input n (n > 0, if not you must reinput until n > 0)\n n = ");
			n_hungndp = keyboard.nextInt();
		}
		
		keyboard.close();
		
		int space = n_hungndp - 1;
		
		for (int i = 1; i <= n_hungndp; i++) {
			
			// Dich đi n-1 khoảng trắng
			for (int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			
			// Điền 2n-1 dấu *
			for (int k = 0; k < 2 * i - 1; k++) {
				System.out.print("*");
			}
			
			System.out.print("\n");
			space--;
		}
	}
}
