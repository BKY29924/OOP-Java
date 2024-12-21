package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
		nbDigitalVideoDiscs++;
	}

	public String play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		
			return "Playing DVD: " + this.getTitle() + "\n" +
        	"DVD length: " + this.getLength() + "\n";
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive.");
		}
	}
	
	public String toString() {
		// 
		return "DVD - title: " + this.getTitle() +
				" - category: " + this.getCategory() +
				" - director: " + this.getDirector() +
				" - length: " + this.getLength() +
				" - cost: " + this.getCost() + "$";
	}
}
