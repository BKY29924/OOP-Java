package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track() {
		// TODO Auto-generated constructor stub
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	public String play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		
			return "Playing Track: " + this.getTitle() + "\n" +
        	"Track length: " + this.getLength() + "\n";
		} else {
			throw new PlayerException("ERROR: Track length is non-positive.");
		}
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;  // cùng là 1 đối tượng
	    
	    if (o == null || getClass() != o.getClass()) return false;  // đối tượng null hoặc không cùng lớp
	    
	    Track track = (Track) o;  // ép kiểu để so sánh
	    return this.title.equals(track.title) && this.length == track.length;
	}

}
