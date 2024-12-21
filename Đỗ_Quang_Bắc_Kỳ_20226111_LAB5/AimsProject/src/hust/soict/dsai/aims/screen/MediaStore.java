package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.*;

import javax.naming.LimitExceededException;
import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;

public class MediaStore extends JPanel {
	private Media media;
	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCartButton = new JButton("Add to cart");
		container.add(addToCartButton);
		
		addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					cart.addMedia(media);
				} catch (LimitExceededException e1) {
					e1.printStackTrace();
				}
                JOptionPane.showMessageDialog(null, media.getTitle() + " has been added to the cart.",
                		"Cart", JOptionPane.INFORMATION_MESSAGE);
            }
        });
		
		if (media instanceof Playable) {
			JButton playButton = new JButton("Play");
			container.add(playButton);
			
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	playMedia((Playable) media);
                }
            });
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private void playMedia(Playable media) {
        JDialog playDialog = new JDialog((Frame) null, "Playing media", true);
        playDialog.setLayout(new BorderLayout());
        playDialog.setSize(300, 200);
        playDialog.setLocationRelativeTo(null);

        JLabel playLabel = new JLabel("Playing: " + media.getTitle(), JLabel.CENTER);
        playLabel.setFont(new Font(playLabel.getFont().getName(), Font.PLAIN, 16));

        JTextArea outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        try {
			outputArea.setText(media.play());
		} catch (PlayerException e) {
			e.printStackTrace();
		}
        outputArea.setWrapStyleWord(true);
        outputArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        playDialog.add(playLabel, BorderLayout.NORTH);
        playDialog.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playDialog.dispose();
            }
        });

        playDialog.add(closeButton, BorderLayout.SOUTH);
        playDialog.setVisible(true);
    }
}
