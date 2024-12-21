package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc(1, "Jungle", "Animation", 20.95f, 100, "Adrew Ng");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc(2, "Cinderella", "Animation", 20.95f, 100, "Adrew Ng");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
		jungleDVD = new DigitalVideoDisc(1, "Jungle", "Animation", 20.95f, 100, "Adrew Ng");
		cinderellaDVD = new DigitalVideoDisc(2, "Cinderella", "Animation", 20.95f, 100, "Adrew Ng");
		correctSwap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
	}
	
	public static void swap(Object o1, Object o2) {
		Object temp = o1;
		o1 = o2;
		o2 = temp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(3, oldTitle, "Animation", 20.95f, 100, "Adrew Ng");
	}
	
	public static void correctSwap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
		String temp = o1.getTitle();
		o1.setTitle(o2.getTitle());
		o2.setTitle(temp);
	}
}
