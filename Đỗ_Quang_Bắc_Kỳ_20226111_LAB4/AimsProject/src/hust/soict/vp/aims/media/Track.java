package hust.soict.vp.aims.media;

import java.util.Objects;

public class Track {
    private String title;
    private int length;

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public boolean equals(Track tmp) {
        return (title == tmp.getTitle()) && (length == tmp.getLength());
    }
}