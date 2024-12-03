package hust.soict.vp.test;

import hust.soict.vp.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class TestPolymorphism {
    public static void main(String[] args) {
        List<Media> mediaeVBacKy = new ArrayList<Media>();

        // Thông tin của DVD
        DigitalVideoDisc dvd = new DigitalVideoDisc(101, "The Matrix", "Science Fiction", 7.8f, "Warner Bros", 136);

        // Thông tin của CD
        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Bohemian Rhapsody", 6));
        tracks.add(new Track("Stairway to Heaven", 8));
        CompactDisc cd = new CompactDisc(102, "Classic Rock Hits", "Rock", 8.0f, "Various Artists", tracks);

        //Thông tin của Book
        List<String> authors = new ArrayList<String>();
        authors.add("George Orwell");
        authors.add("Aldous Huxley");
        Book book = new Book(103, "Dystopian Classics", "Literature", 9.5f, authors);

        // Thêm các đối tượng vào danh sách
        mediaeVBacKy.add(dvd);
        mediaeVBacKy.add(cd);
        mediaeVBacKy.add(book);

        // Hiển thị thông tin của từng Media
        for (Media m : mediaeVBacKy) {
            System.out.println(m.toString());
        }
    }
}
