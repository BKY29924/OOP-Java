package hust.soict.vp.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost);
        this.tracks = tracks;
        this.artist = artist;
        this.setLength(getLength());
    }

    public CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track song) {
        if (tracks.contains(song)) {
            System.out.println(song.getTitle() + "is already in the CD");
        } else {
            tracks.add(song);
        }
    }

    public void removeTrack(Track song) {
        if (tracks.contains(song)) {
            tracks.remove(song);
        } else {
            System.out.println(song.getTitle() + "is not in the CD");
        }
    }

    @Override
    public float getLength() {
        float sum = 0;
        for (Track song : tracks) {
            sum += song.getLength();
        }
        return sum;
    }

    public void play() {
        System.out.println("\nTitle: " + getTitle() + '\n' + "Artist: " + getArtist() + "\n\n");
        for (Track song : tracks) {
            song.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("CD: " +
                " [id = " + getId() +
                ", artist: " + artist +
                ", title = '" + getTitle() + '\'' +
                ", category = '" + getCategory() + '\'' +
                ", length : " + getLength() + " min" +
                ", cost= " + getCost() + "$]" + '\n' + "Tracks: \n"
                + "===================" + '\n');
        for (Track track : tracks) {
            print.append(track.getTitle());
            print.append('\t');
            print.append(track.getLength());
            print.append(" min");
            print.append('\n');
        }
        return print.toString();
    }
}