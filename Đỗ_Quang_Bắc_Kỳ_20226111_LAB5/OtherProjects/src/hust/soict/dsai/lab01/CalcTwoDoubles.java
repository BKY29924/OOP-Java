// 2.2.5: Write a program to calculate sum, difference, product, and quotient of 2 double numbers which are entered by users.
// CalcTwoDoubles.java

import java.util.Scanner;

public class CalcTwoDoubles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Input a = ");
		Double num1 = sc.nextDouble();

		System.out.print("Input b = ");
		Double num2 = sc.nextDouble();

		// Caculate sum, difference and product of the 2 numbers
		Double sum, dif_hungndp, product, quotient;
		sum = num1 + num2;
		dif_hungndp = num1 - num2;
		product = num1 * num2;

		// Output sum, difference and sum
		System.out.println(num1 + " + " + num2 + " = " + sum);
		System.out.println(num1 + " - " + num2 + " = " + dif_hungndp);
		System.out.println(num1 + " * " + num2 + " = " + product);

		// Calculate quotient of the 2 numbers and output
		if (num2 == 0.0) {
			System.out.println(num1 + " is not divisible by " + num2 + ".");
		} else {
			quotient = num1 / num2;
			System.out.println(num1 + " / " + num2 + " = " + quotient);
		}

		sc.close();
	}
}