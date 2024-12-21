package hust.soict.dsai.aims.screen;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
	public AddCDToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		setTitle("Add CD to Store");
	}

	JPanel createCenter(Cart cart) {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(8, 2, 5, 5));

        JLabel lblId = new JLabel("ID:");
        JTextField txtId = new JTextField();
        JLabel lblTitle = new JLabel("Title:");
        JTextField txtTitle = new JTextField();
        JLabel lblCategory = new JLabel("Category:");
        JTextField txtCategory = new JTextField();
        JLabel lblCost = new JLabel("Cost:");
        JTextField txtCost = new JTextField();
        JLabel lblArtist = new JLabel("Artist:");
        JTextField txtArtist = new JTextField();
        JLabel lblDirector = new JLabel("Director:");
        JTextField txtDirector = new JTextField();
        JLabel lblTracks = new JLabel("Tracks (each track separated by ';' | title and length of each track separated by '/'):");
        JTextField txtTracks = new JTextField();

        center.add(lblId);
        center.add(txtId);
        center.add(lblTitle);
        center.add(txtTitle);
        center.add(lblCategory);
        center.add(txtCategory);
        center.add(lblCost);
        center.add(txtCost);
        center.add(lblArtist);
        center.add(txtArtist);
        center.add(lblDirector);
        center.add(txtDirector);
        center.add(lblTracks);
        center.add(txtTracks);

        JButton btnAdd = new JButton("Add CD");
        center.add(new JPanel());
        center.add(btnAdd);

        btnAdd.addActionListener(e -> {
        	int id;
            String title = txtTitle.getText();
            String category = txtCategory.getText();
            String artist = txtArtist.getText();
            float cost;
            String director = txtDirector.getText();
            String tracks = txtTracks.getText();

            id = Integer.parseInt(txtId.getText());
            cost = Float.parseFloat(txtCost.getText());
            
            ArrayList<Track> trackList = new ArrayList<Track>();
	        for (String track : tracks.split(";")) {
	        	String trackTitle = track.split("/")[0].trim();
	        	int trackLength = Integer.parseInt(track.split("/")[1].trim());
	        	Track newTrack = new Track(trackTitle, trackLength);
	        	trackList.add(newTrack);
	        }

            store.addMedia(new CompactDisc(id, title, category, cost, artist, trackList, director));
            JOptionPane.showMessageDialog(this, "CD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            txtId.setText("");
            txtTitle.setText("");
            txtCategory.setText("");
            txtCost.setText("");
            txtArtist.setText("");
            txtDirector.setText("");
            txtTracks.setText("");
        });
		
		return center;
	}
}
