package hust.soict.dsai.test.cart;
import java.util.*;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc; 

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		try {
			cart.addMedia(dvd1);
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
		try {
			cart.addMedia(dvd2);
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 115, "Walt Disney");
		try {
			cart.addMedia(dvd3);
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "Harry Potter and the Chamber of Secret", "Animation", 22.95f, 104, "Chris Columbus");
		try {
			cart.addMedia(dvd4);
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
		
		// kiểm tra phương thức print
		cart.printCart();
		
		Scanner input = new Scanner(System.in);
		// kiểm tra phương thức tra cứu bằng id và title
		cart.searchMediabyID(input);
		cart.searchMediabyTitle(input);
	}
}
