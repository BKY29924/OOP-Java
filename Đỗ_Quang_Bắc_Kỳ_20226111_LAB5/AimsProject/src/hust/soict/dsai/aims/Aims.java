package hust.soict.dsai.aims;
import java.util.*;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.ObservableList;

public class Aims {
	
	public static void mediaDetailsMenu(Scanner input, Cart cart, Store store, Media media) {
		if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
			System.out.println("================================");
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("    1. Add to cart");
			System.out.println("    2. Play");
			System.out.println("    0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			System.out.print("Enter option: ");
			int option = input.nextInt();
			input.nextLine();
			
			if (option == 0) storeMenu(input, store, cart);
			else if (option == 1) {
				try {
					cart.addMedia(media);
				} catch (LimitExceededException e) {
					e.printStackTrace();
				}
				mediaDetailsMenu(input, cart, store, media);
			} else if (option == 2) {
				if (media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					try {
						cd.play();
					} catch (PlayerException e) {
						e.printStackTrace();
					}
				} else if (media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					try {
						dvd.play();
					} catch (PlayerException e) {
						e.printStackTrace();
					}
				}
				mediaDetailsMenu(input, cart, store, media);
			} else {
				System.out.println("Invalid input. Please reinput.");
				mediaDetailsMenu(input, cart, store, media);
			}
		} else {
			System.out.println("================================");
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("    1. Add to cart");
			System.out.println("    0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1");
			System.out.print("Enter option: ");
			int option = input.nextInt();
			input.nextLine();

			if (option == 0) storeMenu(input, store, cart);
			else if (option == 1) {
				try {
					cart.addMedia(media);
				} catch (LimitExceededException e) {
					e.printStackTrace();
				}
				mediaDetailsMenu(input, cart, store, media);
			}  else {
				System.out.println("Invalid input. Please reinput.");
				mediaDetailsMenu(input, cart, store, media);
			}
		}
	}
	
	public static void storeMenu(Scanner input, Store store, Cart cart) {
		System.out.println("================================");
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("    1. See a media’s details");
		System.out.println("    2. Add a media to cart");
		System.out.println("    3. Play a media");
		System.out.println("    4. See current cart");
		System.out.println("    0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		System.out.print("Enter option: ");
		int option = input.nextInt();
		input.nextLine();
		
		if (option == 0) showMenu(input, store, cart);
		else if (option == 1) {
			System.out.print("Enter media's title (ignore case): ");
			String title = input.nextLine();
			
			ArrayList<Media> itemsInStore = store.getItemsInStore();
			boolean found = false;
			for (Media media : itemsInStore) {
				if (media.getTitle().equalsIgnoreCase(title)) { // đúng title (không cần đúng chữ in hoa)
					System.out.println(media.toString());
					mediaDetailsMenu(input, cart, store, media);
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with title \"" + title + "\" not found in the store.");
			}
			storeMenu(input, store, cart);
			
		} else if (option == 2) {
			System.out.print("Enter media's title (ignore case): ");
			String title = input.nextLine();
			
			ArrayList<Media> itemsInStore = store.getItemsInStore();
			boolean found = false;
			for (Media media : itemsInStore) {
				if (media.getTitle().equalsIgnoreCase(title)) { // đúng title (không cần đúng chữ in hoa)
					try {
						cart.addMedia(media);
					} catch (LimitExceededException e) {
						e.printStackTrace();
					}
					
					// nếu media vừa thêm là DVD thì print số lượng DVD trong cart
					if (media instanceof DigitalVideoDisc) {
						int numDVDinCart = 0;
						for (Media m : cart.getItemsOrdered()) {
							if (m instanceof DigitalVideoDisc) numDVDinCart++;
						}
						
						System.out.println("Number of DVD(s) in cart: " + numDVDinCart);
					}
					
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with title \"" + title + "\" not found in the store.");
			}
			storeMenu(input, store, cart);
		} else if (option == 3) {
			System.out.print("Enter media's title (ignore case): ");
			String title = input.nextLine();
			
			ArrayList<Media> itemsInStore = store.getItemsInStore();
			boolean found = false;
			for (Media media : itemsInStore) {
				if (media.getTitle().equalsIgnoreCase(title)) { // đúng title (không cần đúng chữ in hoa)
					
					if (media instanceof DigitalVideoDisc) {
						DigitalVideoDisc mediadvd = (DigitalVideoDisc) media;
						try {
							mediadvd.play();
						} catch (PlayerException e) {
							e.printStackTrace();
						}
					} else if (media instanceof CompactDisc) {
						CompactDisc mediacd = (CompactDisc) media;
						try {
							mediacd.play();
						} catch (PlayerException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Media \"" + media.getTitle() + "\" is unplayable.");
					}
					
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with title \"" + title + "\" not found in the store.");
			}
			storeMenu(input, store, cart);
		} else if (option == 4) {
			seeCurrentCart(input, store, cart);
		} else {
			System.out.println("Invalid input. Please reinput.");
			storeMenu(input, store, cart);
		}

	}
	
	public static void updateStoreMenu(Scanner input, Store store, Cart cart) {
		System.out.println("================================");
		System.out.println("Update store options: ");
		System.out.println("--------------------------------");
		System.out.println("    1. Add a media to store");
		System.out.println("    2. Remove a media from store");
		System.out.println("    0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		System.out.print("Enter option: ");
		int option = input.nextInt();
		input.nextLine();
		
		if (option == 0) showMenu(input, store, cart);
		else if (option == 1) {
			System.out.print("Choose a type of media to add (1 = CD; 2 = DVD; 3 = Book): ");
			int mediatype = input.nextInt();
			input.nextLine();
			
			if (mediatype == 1) {
				System.out.print("Media id: ");
				int id = input.nextInt();
				input.nextLine();
				System.out.print("CD title: ");
				String title = input.nextLine();
				System.out.print("CD category: ");
				String category = input.nextLine();
				System.out.print("CD cost: ");
				float cost = input.nextFloat();
				input.nextLine();
				System.out.print("CD artist: ");
				String artist = input.nextLine();
				System.out.print("CD director: ");
				String director = input.nextLine();
				System.out.print("CD track(s) (each track separated by ';' | title and length of each track separated by '/'): ");
				String tracksInput = input.nextLine();
				
				ArrayList<Track> trackList = new ArrayList<Track>();
		        for (String track : tracksInput.split(";")) {
		        	String trackTitle = track.split("/")[0].trim();
		        	int trackLength = Integer.parseInt(track.split("/")[1].trim());
		        	Track newTrack = new Track(trackTitle, trackLength);
		        	trackList.add(newTrack);
		        }
				
				CompactDisc newCD = new CompactDisc(id, title, category, cost, artist, trackList, director);
				store.addMedia(newCD);
				updateStoreMenu(input, store, cart);
			} else if (mediatype == 2) {
				System.out.print("Media id: ");
				int id = input.nextInt();
				input.nextLine();
				System.out.print("DVD title: ");
				String title = input.nextLine();
				System.out.print("DVD category: ");
				String category = input.nextLine();
				System.out.print("DVD cost: ");
				float cost = input.nextFloat();
				input.nextLine();
				System.out.print("DVD length: ");
				int length = input.nextInt();
				input.nextLine();
				System.out.print("DVD director: ");
				String director = input.nextLine();
				
				DigitalVideoDisc newDVD = new DigitalVideoDisc(id, title, category, cost, length, director);
				store.addMedia(newDVD);
				updateStoreMenu(input, store, cart);
			} else if (mediatype == 3) {
				System.out.print("Media id: ");
				int id = input.nextInt();
				input.nextLine();
				System.out.print("Book title: ");
				String title = input.nextLine();
				System.out.print("Book category: ");
				String category = input.nextLine();
				System.out.print("Book cost: ");
				float cost = input.nextFloat();
				input.nextLine();
				System.out.print("Book author(s) (each author separated by a comma ','): ");
				String authorsInput = input.nextLine();
				
				ArrayList<String> authorList = new ArrayList<>();
		        for (String author : authorsInput.split(",")) {
		            authorList.add(author.trim());
		        }
				
				Book newBook = new Book(id, title, category, cost, authorList);
				store.addMedia(newBook);
				updateStoreMenu(input, store, cart);
			} else {
				System.out.println("Invalid input. You will be redirected to Update store menu.");
				updateStoreMenu(input, store, cart);
			}
		} else if (option == 2) {
			System.out.print("Enter id of media to remove: ");
			int id = input.nextInt();
			input.nextLine();
			
			boolean found = false;
			for (Media media : store.getItemsInStore()) {
				if (media.getId() == id) {
					store.removeMedia(media);
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with id = " + id + " not found in the store.");
			}
			updateStoreMenu(input, store, cart);
		} else {
			System.out.println("Invalid input. Please reinput.");
			updateStoreMenu(input, store, cart);
		}
	}
	
	public static void seeCurrentCart(Scanner input, Store store, Cart cart) {
		cart.printCart();
		cartMenu(input, store, cart);
	}
	
	public static void cartMenu(Scanner input, Store store, Cart cart) {
		System.out.println("================================");
		System.out.println("Cart options: ");
		System.out.println("--------------------------------");
		System.out.println("    1. Filter medias in cart");
		System.out.println("    2. Sort medias in cart");
		System.out.println("    3. Remove media from cart");
		System.out.println("    4. Play a media");
		System.out.println("    5. Place order");
		System.out.println("    0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		System.out.print("Enter option: ");
		int option = input.nextInt();
		input.nextLine();
		
		if (option == 0) showMenu(input, store, cart);
		else if (option == 1) {
			System.out.print("Choose a filter criteria (1 = by id; 2 = by Title): ");
			int filtertype = input.nextInt();
			input.nextLine();
			if (filtertype == 1) {
				cart.searchMediabyID(input);
			} else if (filtertype == 2) {
				cart.searchMediabyTitle(input);
			} else {
				System.out.println("Invalid input. You will be redirected to Cart menu.");
			}
			cartMenu(input, store, cart);
		} else if (option == 2) {
			System.out.print("Choose a sort criteria (1 = by Title; 2 = by Cost): ");
			int sorttype = input.nextInt();
			input.nextLine();
			
			if (sorttype == 1) {
				cart.sortCart(Media.COMPARE_BY_TITLE_COST);
				System.out.println("Cart sorted by title.");
				cart.printCart();
			} else if (sorttype == 2) {
				cart.sortCart(Media.COMPARE_BY_COST_TITLE);
				System.out.println("Cart sorted by cost.");
				cart.printCart();
			} else {
				System.out.println("Invalid input. You will be redirected to Cart menu.");
			}
			cartMenu(input, store, cart);
			
		} else if (option == 3) {
			System.out.print("Enter title of media to remove (ignore case): ");
			String title = input.nextLine();
			
			boolean found = false;
			for (Media media : cart.getItemsOrdered()) {
				if (media.getTitle().equalsIgnoreCase(title)) {
					cart.removeMedia(media);
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with title \"" + title + "\" not found in cart.");
			}
			cartMenu(input, store, cart);
		} else if (option == 4) {
			System.out.print("Enter media's title (ignore case): ");
			String title = input.nextLine();
			
			ObservableList<Media> itemsOrdered = cart.getItemsOrdered();
			boolean found = false;
			for (Media media : itemsOrdered) {
				if (media.getTitle().equalsIgnoreCase(title)) { // đúng title (không cần đúng chữ in hoa)
					
					if (media instanceof DigitalVideoDisc) {
						DigitalVideoDisc mediadvd = (DigitalVideoDisc) media;
						try {
							mediadvd.play();
						} catch (PlayerException e) {
							e.printStackTrace();
						}
					} else if (media instanceof CompactDisc) {
						CompactDisc mediacd = (CompactDisc) media;
						try {
							mediacd.play();
						} catch (PlayerException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Media \"" + media.getTitle() + "\" is unplayable.");
					}
					
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with title \"" + title + "\" not found in the store.");
			}
			cartMenu(input, store, cart);
		} else if (option == 5) {
			System.out.println("Your order is created.");
			cart.getItemsOrdered().clear();
			System.out.println("Cart is now emptied.");
			cartMenu(input, store, cart);
		} else {
			System.out.println("Invalid input. Please reinput.");
			cartMenu(input, store, cart);
		}
}
	
	public static void showMenu(Scanner input, Store store, Cart cart) {
		System.out.println("================================");
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("    1. View store");
		System.out.println("    2. Update store");
		System.out.println("    3. See current cart");
		System.out.println("    0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		System.out.print("Enter option: ");
		int option = input.nextInt();
		input.nextLine();
		
		if (option == 0) System.exit(0);
		else if (option == 1) {
			new StoreScreen(store, cart);
			ArrayList<Media> itemsInStore = store.getItemsInStore();
			System.out.println("**************** LIST OF ITEMS IN STORE ****************");
			for (Media media : itemsInStore) {
				System.out.println(media.toString());
			}
			System.out.println("********************************************************");
			storeMenu(input, store, cart);
		} else if (option == 2) {
			updateStoreMenu(input, store, cart);
		} else if (option == 3) {
			new CartScreen(store, cart);
			seeCurrentCart(input, store, cart);
		} else {
			System.out.println("Invalid input. Please reinput.");
			showMenu(input, store, cart);
		}
	}
	
	public static void main(String[] args) {
		
		Store store = new Store();
		Cart cart = new Cart();
		Scanner input = new Scanner(System.in);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "DVD1 ", "cate1", 54, 220, "director1");
		store.addMedia(dvd1);
		store.addMedia(new DigitalVideoDisc(2, "DVD2 ", "cate2", 46, 165, "director2"));
		store.addMedia(new DigitalVideoDisc(3, "DVD3 ", "cate3", 51, 167, "director3"));
		store.addMedia(new Book(4, "Book1", "cate4", 36, new ArrayList<>(List.of("author1"))));
		store.addMedia(new Book(5, "Book 2", "cate 5", 21, new ArrayList<>(List.of("author2", "author 3"))));
		Book book3 = new Book(6, "Book 3", "cate 6", 28, new ArrayList<>(List.of("author4", "author 5")));
		store.addMedia(book3);
		ArrayList<Track> trackList = new ArrayList<Track>();
		Track newTrack = new Track("track1", 60);
    	trackList.add(newTrack);
		store.addMedia(new CompactDisc(7, "CD 1", "cat7", 45, "artist1", trackList, "director4"));
		trackList = new ArrayList<Track>();
		newTrack = new Track("track2", 65);
    	trackList.add(newTrack);
    	CompactDisc cd2 = new CompactDisc(8, "CD 2", "cat8", 51, "artist2", trackList, "director5");
		store.addMedia(cd2);
		trackList = new ArrayList<Track>();
		newTrack = new Track("track3", 43);
    	trackList.add(newTrack);
		newTrack = new Track("track4", 31);
    	trackList.add(newTrack);
		store.addMedia(new CompactDisc(9, "CD 3", "cat9", 61, "artist3", trackList, "director6"));
		
		try {
			cart.addMedia(dvd1);
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
		try {
			cart.addMedia(book3);
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
		try {
			cart.addMedia(cd2);
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
		
		new StoreScreen(store, cart);
		showMenu(input, store, cart);
		input.close();
	}
}