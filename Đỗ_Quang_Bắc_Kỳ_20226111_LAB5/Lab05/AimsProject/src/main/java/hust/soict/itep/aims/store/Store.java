package hust.soict.itep.aims.store;
import java.util.ArrayList;
import hust.soict.itep.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore;

    public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public Store() {
        itemsInStore = new ArrayList<Media>();
    }
	
	public void addMedia(Media media) throws IllegalArgumentException {
		if (media.getCost() < 0) {
			throw new IllegalArgumentException("ERROR: Cost cannot be negative.");
		} else {
			itemsInStore.add(media);
        	System.out.println("Media \"" + media.getTitle() + "\" added to store.");
		}
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
        System.out.println("Media \"" + media.getTitle() + "\" removed from store.");
    }
}
