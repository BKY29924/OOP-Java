package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.PlayerException;

public interface Playable {
	public String play() throws PlayerException;

    String getTitle();
}
