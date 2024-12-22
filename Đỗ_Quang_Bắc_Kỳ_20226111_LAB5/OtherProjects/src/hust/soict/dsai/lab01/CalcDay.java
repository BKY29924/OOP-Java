// Exercise 6.4
package hust.soict.dsai.lab01;;
import java.util.Scanner;

public class CalcDay {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		// Khởi tạo các đầu vào hợp lệ cho tháng
		String[][] months = {
				{"January", "Jan", "Jan.", "1"},
				{"February", "Feb", "Feb.", "2"},
				{"March", "Mar", "Mar.", "3"},
				{"April", "Apr", "Apr.", "4"},
				{"May", "May", "May", "5"},
				{"June", "June", "Jun", "6"},
				{"July", "July", "Jul", "7"},
				{"August", "Aug", "Aug.", "8"},
				{"September", "Sep", "Sep.", "9"},
				{"October", "Oct", "Oct.", "10"},
				{"November", "Nov", "Nov.", "11"},
				{"December", "Dec", "Dec.", "12"}
		};
		
		// Nhập tháng
		System.out.print("Input month: ");
		String inputMonth = keyboard.nextLine();
		int month = 0;
		
		boolean monthIsValid = false;
		for (int i = 0; i < months.length; i++) {
			for (int j = 0; j < months[i].length; j++) {
				if (inputMonth.equals(months[i][j])) {
					month = i + 1;
					monthIsValid = true;
					break;
				}
			}
		}
		
		// Xử lí nhập không hợp lệ
		while (monthIsValid == false) {
			System.out.print("Invalid input! Reinput month: ");
			inputMonth = keyboard.nextLine();
			
			monthIsValid = false;
			for (int i = 0; i < months.length; i++) {
				for (int j = 0; j < months[i].length; j++) {
					if (inputMonth.equals(months[i][j])) {
						month = i + 1;
						monthIsValid = true;
						break;
					}
				}
			}
		}
		
		// Nhập năm
		System.out.print("Input year (must input the whole year, in non-negative number): ");
		int year_hungndp = keyboard.nextInt();
		
		// Xử lí nhập không hợp lệ (nhỏ hơn 0)
		while (year_hungndp < 0) {
			System.out.print("Invalid input! Reinput year: ");
			year_hungndp = keyboard.nextInt();
		}
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println(month + "/" + year_hungndp + " has 31 days.");
			
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println(month + "/" + year_hungndp + " has 30 days.");
			
		} else { // Xử lí tháng 2
			if (year_hungndp % 4 != 0) {
				System.out.println(month + "/" + year_hungndp + " has 28 days.");
				
			} else {
				if (year_hungndp % 100 == 0 && year_hungndp % 400 != 0) {
					System.out.println(month + "/" + year_hungndp + " has 28 days.");
					
				} else {
					System.out.println(month + "/" + year_hungndp + " has 29 days.");
				}
			}
		}
		
		keyboard.close();
	}
}
