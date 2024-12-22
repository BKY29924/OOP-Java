// Exercise 6.6
package hust.soict.dsai.lab01;
import java.util.Scanner;

public class AddMatrices {

	public static void main(String[] args) {
		Scanner keyboard_hungndp = new Scanner(System.in);
		
		// Nhập kích thước ma trận
		System.out.print("Nhap kich thuoc ma tran MxN, cach nhau boi dau cach (m, n > 0): ");
		int m = keyboard_hungndp.nextInt();
		int n = keyboard_hungndp.nextInt();
		
		while (m * n <= 0) {
			System.out.print("Nhap loi! Moi nhap lai: ");
			m = keyboard_hungndp.nextInt();
			n = keyboard_hungndp.nextInt();
		}
		
		// Khởi tạo 2 ma trận
		Double[][] mat1 = new Double[m][n];
		Double[][] mat2 = new Double[m][n];
		
		// Nhập ma trân thứ nhất
		System.out.println("Nhap ma tran dau tien (moi dong la 1 hang, moi phan tu cach nhau boi dau cach):");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat1[i][j] = keyboard_hungndp.nextDouble();
			}
		}
		
		// Nhập ma trân thứ hai
		System.out.println("Nhap ma tran thu hai (moi dong la 1 hang, moi phan tu cach nhau boi dau cach):");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat2[i][j] = keyboard_hungndp.nextDouble();
			}
		}
		
		// Tính tổng 2 ma trận
		Double[][] result = new Double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
		
		// Hiển thị kết quả
		System.out.println("Ket qua la:");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		keyboard_hungndp.close();
	}
}
