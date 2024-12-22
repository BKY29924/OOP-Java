
package hust.soict.vp.aims.store;
import hust.soict.vp.aims.media.*;
import java.util.LinkedList;
public class Store {
    private LinkedList<Media> itemsInStore = new LinkedList<Media>();

    private boolean checkMedia(Media disc) {
        for (Media item : itemsInStore) {
            if (item.equals(disc)) {
                return true;
            }
        }
        return false;
    }

    public Media findMedia(String title) {
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    public LinkedList<Media> getItemsInStore() { return itemsInStore; }

    public void removeMedia(Media disc) {
        if(checkMedia(disc)) {
            itemsInStore.remove(disc);
            System.out.println( disc.getTitle() + " 've been deleted from the store !");
        } else {
            System.out.println("There is no "+ disc.getTitle() + " in the store !");
        }
    }

    public void addMedia(Media disc) {
        if(!checkMedia(disc)) {
            itemsInStore.add(disc);
            System.out.println( disc.getTitle() + " 've been added to the store !");
        } else {
            System.out.println( disc.getTitle() + " 'already exists in the store !");
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("\n**********STORE***************\nitems in the store: \n");
        if(itemsInStore.isEmpty()) string.append("There is no dvd in the store !\n");
        else {
            for (Media item : itemsInStore) {
                string.append(item.getTitle() + " - " + item.getCost() + " $\n");
            }
        }
        string.append("*********************************\n");
        return string.toString();
    }

    public void showMediaDetails(int mediaId) {
        for (Media item : itemsInStore) {
            if (item.getId() == mediaId) {
                System.out.println(item.toString());
                return;
            }
        }
        System.out.println("Media not found.");
    }

    public Media getMediaById(int mediaId) {
        for (Media item : itemsInStore) {
            if (item.getId() == mediaId) {
                return item;
            }
        }
        return null;
    }

    public void playMedia(int mediaId) {
        Media media = getMediaById(mediaId);
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }
}