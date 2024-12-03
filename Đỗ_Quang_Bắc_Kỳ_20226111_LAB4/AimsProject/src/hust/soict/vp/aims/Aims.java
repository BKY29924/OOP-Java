package hust.soict.vp.aims;

import hust.soict.vp.aims.cart.Cart;
import hust.soict.vp.aims.store.Store;
import hust.soict.vp.aims.media.*;

import java.util.*;

public class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", 15.0f, "Do Quang Bac Ky", 120);

        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Shape of You", 3));
        tracks.add(new Track("Blinding Lights", 4));

        CompactDisc cd = new CompactDisc(2, "Top 40 Hits", "Pop", 20.5f, "Do Quang Bac Ky", tracks);

        List<String> authors = new ArrayList<String>();
        authors.add("Do Quang Bac Ky");
        Book book = new Book(3, "1984", "Dystopian", 18.7f, authors);

        Store store = new Store();
        store.addMedia(cd);
        store.addMedia(dvd);
        store.addMedia(book);

        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);
        showMenu(scanner, store, cart);
    }

    public static void showMenu(Scanner scanner, Store store, Cart cart) {
        while (true) {
            System.out.println("AIMS:");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");

            int option = scanner.nextInt();
            switch (option) {
                case 0: {
                    scanner.close();
                    System.exit(0);
                    break;
                }
                case 1: {
                    storeMenu(scanner, store, cart);
                    break;
                }
                case 2: {
                    updateStoreMenu(scanner, store);
                    break;
                }
                case 3: {
                    cart.print();
                    cartMenu(scanner, cart);
                    break;
                }
            }
        }
    }

    public static void updateStoreMenu(Scanner scanner, Store store) {
        System.out.println("===========================");
        System.out.println("1. add Media");
        System.out.println("2. delete Media");
        System.out.println("3. update Media in Store");
        System.out.println("0. Back");
        System.out.println("===========================");
        System.out.print("Option: ");

        int option = scanner.nextInt();
        switch (option) {
            case 1: {
                System.out.println("1. DigitalVideoDisc");
                System.out.println("2. CompactDisc");
                System.out.println("3. Book");
                System.out.println("-------");
                System.out.print("-> Your type: ");

                int option2 = scanner.nextInt();
                System.out.print("Enter id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine();
                switch (option2) {
                    case 1: {
                        System.out.print("Enter director's name: ");
                        String director = scanner.nextLine();
                        System.out.print("Enter dvd's length: ");
                        int length = scanner.nextInt();
                        scanner.nextLine();
                        store.addMedia(new DigitalVideoDisc(id, title, category, cost, director, length));
                        break;
                    }
                    case 2: {
                        System.out.print("Enter artist's name: ");
                        StringBuffer artist = new StringBuffer(scanner.nextLine());
                        System.out.print("Enter number of track: ");
                        int nbTrack = scanner.nextInt();
                        scanner.nextLine();
                        ArrayList<Track> tracks = new ArrayList<Track>();
                        StringBuilder name = new StringBuilder();
                        for (int i = 0; i < nbTrack; i++) {
                            System.out.print("Enter Track[" + i + "]'s name: ");
                            name.replace(0, name.length(), scanner.nextLine());
                            System.out.print("Enter Track[" + i + "]'s length: ");
                            int length = scanner.nextInt();
                            tracks.add(new Track(name.toString(), length));
                            scanner.nextLine();
                        }
                        store.addMedia(new CompactDisc(id, title, category, cost, artist.toString(), tracks));
                        break;
                    }
                    case 3: {
                        System.out.print("Enter author's name (Enter nothing to skip): ");
                        StringBuilder author = new StringBuilder(scanner.nextLine());
                        ArrayList<String> authors = new ArrayList<String>();
                        while (author.toString().isEmpty()) {
                            authors.add(author.toString());
                            System.out.print("Enter author's name (Enter nothing to skip): ");
                        }
                        store.addMedia(new Book(id, title, category, cost, authors));
                        break;
                    }
                }
                break;
            }
            case 2: {
                System.out.println("Enter item's title: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                Iterator<Media> iter = store.getItemsInStore().iterator();
                while (iter.hasNext()) {
                    Media item = iter.next();
                    if (item.getTitle().equals(title)) {
                        iter.remove();
                        System.out.println(item.getClass().getSimpleName() + " " + item.getTitle() + "'ve been deleted from the store !");
                    }
                }
                break;
            }
            case 3: {
                System.out.println("Enter item's id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter cost: ");
                float cost = scanner.nextFloat();
                store.getItemsInStore().get(id).setCost(cost);
                store.getItemsInStore().get(id).setTitle(title);
                store.getItemsInStore().get(id).setCategory(category);
                System.out.println(store);
                break;
            }
        }
    }

    public static void mediaDetailsMenu(Scanner scanner, Store store, Cart cart) {
        System.out.print("Enter media's title: ");
        String title = scanner.nextLine();
        Media item = store.findMedia(title);
        if (item == null) {
            System.out.println("There is no such media !");
            return;
        }
        System.out.println(item);
        while (true) {
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");


            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1: {
                    cart.addMedia(item);
                    break;
                }
                case 2: {
                    if (item.getClass().getSimpleName().equals("Book")) {
                        System.out.println("This media is unplayable");
                    } else {
                        if (item instanceof DigitalVideoDisc) {
                            ((DigitalVideoDisc) item).play();
                        }
                        if (item instanceof CompactDisc) {
                            ((CompactDisc) item).play();
                        }
                    }
                    break;
                }
                case 0: {
                    return;
                }
            }
        }
    }

    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println(store);
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1: {
                    mediaDetailsMenu(scanner, store, cart);
                    break;
                }
                case 0: {
                    return;
                }
                case 2: {
                    System.out.print("Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = store.findMedia(title);
                    if (item == null) {
                        System.out.println("There is no such media !");
                    } else {
                        cart.addMedia(item);
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = store.findMedia(title);
                    if (item == null) {
                        System.out.println("There is no such media !");
                    } else {
                        if (item.getClass().getSimpleName().equals("Book")) {
                            System.out.println("This media is unplayable");
                        } else {
                            if (item instanceof DigitalVideoDisc) {
                                ((DigitalVideoDisc) item).play();
                            }
                            if (item instanceof CompactDisc) {
                                ((CompactDisc) item).play();
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    cart.print();
                    cartMenu(scanner, cart);
                    break;
                }
            }
        }
    }

    public static void cartMenu(Scanner scanner, Cart cart) {
        while (true) {
            System.out.println("===========================");
            System.out.println("1. Remove item from cart");
            System.out.println("2. Sort by title");
            System.out.println("3. Sort by cost");
            System.out.println("0. Back");
            System.out.println("===========================");
            System.out.print("Option: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1: {
                    System.out.println("Enter media's title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    cart.removeMedia(title);
                    break;
                }
                case 2: {
                    cart.sortByTitleCost();
                    cart.print();
                    break;
                }
                case 3: {
                    cart.sortByCostTitle();
                    cart.print();
                    break;
                }
                case 0: {
                    return;
                }
            }
        }
    }
}
