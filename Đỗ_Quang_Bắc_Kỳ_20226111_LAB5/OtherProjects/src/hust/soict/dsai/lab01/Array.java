// Exercise 6.5
package hust.soict.dsai.lab01;
import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		// Nhập số phần tử mảng
		System.out.print("Nhap so phan tu mang (> 0): ");
		int n = keyboard.nextInt();
		
		while (n <= 0) {
			System.out.print("Nhap loi! Moi nhap lai so phan tu cua mang: ");
			n = keyboard.nextInt();
		}
		
		// Khởi tạo mảng
		Double[] myArray = new Double[n];
		
		// Nhập phần tử mảng
		for (int i_hungndp = 0; i_hungndp < n; i_hungndp++) {
			System.out.print("array[" + i_hungndp + "] = ");
			myArray[i_hungndp] = keyboard.nextDouble();
		}
		
		// Hiển thị mảng vừa nhập
		System.out.println("Mang vua duoc nhap:");
		for (int i = 0; i < n; i++) {
			System.out.print(myArray[i] + "\t");
		}
		System.out.print("\n");
		
		// Sắp xếp mảng theo thứ tự tăng dần
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (myArray[i] > myArray[j]) {
					Double temp_hungndp = myArray[i];
					myArray[i] = myArray[j];
					myArray[j] = temp_hungndp;
				}
			}
		}
		
		// Hiển thị mảng đã sắp xếp
		System.out.println("Mang vua sap xep:");
		for (int i = 0; i < n; i++) {
			System.out.print(myArray[i] + "\t");
		}
		System.out.print("\n");
		
		// Tính tổng và trung bình
		Double sum = 0.0, avg = 0.0;
		
		for (int i = 0; i < n; i++) {
			sum += myArray[i];
		}
		avg = sum / n;
		
		System.out.println("sum = " + sum);
		System.out.print("avg = " + avg);
		
		keyboard.close();
	}
}
