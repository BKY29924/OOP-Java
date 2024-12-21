package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 115, "Walt Disney");
		store.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "Harry Potter and the Chamber of Secret", "Animation", 22.95f, 104, "Chris Columbus");
		store.addMedia(dvd4);
		
		// hiển thị danh sách tên các DVD trong store
		for (Media dvd : store.getItemsInStore()) {
			System.out.println(dvd.getTitle() + ", ID = " + dvd.getId());
		}
		
		store.removeMedia(dvd3);
		
		// hiển thị danh sách tên các DVD trong store
		for (Media dvd : store.getItemsInStore()) {
			System.out.println(dvd.getTitle() + ", ID = " + dvd.getId());
		}
	}
}
