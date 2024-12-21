package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class TestPolymorphism {

	public static void main(String[] args) {
		
		List<Media> media = new ArrayList<Media>();
		
		CompactDisc cd = new CompactDisc(1, "CDx", "Hardcore", 10.55f, "Avicii", new ArrayList<Track>(), 115, "Dylan Baubach");
		DigitalVideoDisc dvd = new DigitalVideoDisc(2, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		Book book = new Book(3, "War and Peace", "Novel", 21.75f, new ArrayList<>(Arrays.asList("Lev Tolstoy")));
		
		media.add(cd);
		media.add(dvd);
		media.add(book);
		
		for (Media m : media) {
			System.out.println(m.toString());
		}
	}
}
