package hust.soict.dsai.aims.screen;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	public AddBookToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		setTitle("Add Book to Store");
	}

	JPanel createCenter(Cart cart) {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(7, 2, 5, 5));

        JLabel lblId = new JLabel("ID:");
        JTextField txtId = new JTextField();
        JLabel lblTitle = new JLabel("Title:");
        JTextField txtTitle = new JTextField();
        JLabel lblCategory = new JLabel("Category:");
        JTextField txtCategory = new JTextField();
        JLabel lblCost = new JLabel("Cost:");
        JTextField txtCost = new JTextField();
        JLabel lblAuthors = new JLabel("Author(s) (each author separated by a comma ','):");
        JTextField txtAuthors = new JTextField();

        center.add(lblId);
        center.add(txtId);
        center.add(lblTitle);
        center.add(txtTitle);
        center.add(lblCategory);
        center.add(txtCategory);
        center.add(lblCost);
        center.add(txtCost);
        center.add(lblAuthors);
        center.add(txtAuthors);

        JButton btnAdd = new JButton("Add Book");
        center.add(new JPanel());
        center.add(btnAdd);

        btnAdd.addActionListener(e -> {
        	int id;
            String title = txtTitle.getText();
            String category = txtCategory.getText();
            float cost;
            String authors = txtAuthors.getText();

            id = Integer.parseInt(txtId.getText());
            cost = Float.parseFloat(txtCost.getText());
            
            ArrayList<String> authorList = new ArrayList<>();
	        for (String author : authors.split(",")) {
	            authorList.add(author.trim());
	        }

            store.addMedia(new Book(id, title, category, cost, authorList));
            JOptionPane.showMessageDialog(this, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            txtId.setText("");
            txtTitle.setText("");
            txtCategory.setText("");
            txtCost.setText("");
            txtAuthors.setText("");
        });
		
		return center;
	}
}
