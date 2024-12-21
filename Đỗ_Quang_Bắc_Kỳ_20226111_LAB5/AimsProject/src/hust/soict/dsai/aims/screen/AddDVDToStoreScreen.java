package hust.soict.dsai.aims.screen;
import java.awt.GridLayout;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
	public AddDVDToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		setTitle("Add DVD to Store");
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
        JLabel lblLength = new JLabel("Length:");
        JTextField txtLength = new JTextField();
        JLabel lblDirector = new JLabel("Director:");
        JTextField txtDirector = new JTextField();

        center.add(lblId);
        center.add(txtId);
        center.add(lblTitle);
        center.add(txtTitle);
        center.add(lblCategory);
        center.add(txtCategory);
        center.add(lblCost);
        center.add(txtCost);
        center.add(lblLength);
        center.add(txtLength);
        center.add(lblDirector);
        center.add(txtDirector);

        JButton btnAdd = new JButton("Add DVD");
        center.add(new JPanel());
        center.add(btnAdd);

        btnAdd.addActionListener(e -> {
        	int id;
            String title = txtTitle.getText();
            String category = txtCategory.getText();
            float cost;
            int length;
            String director = txtDirector.getText();

            id = Integer.parseInt(txtId.getText());
            cost = Float.parseFloat(txtCost.getText());
            length = Integer.parseInt(txtLength.getText());

            store.addMedia(new DigitalVideoDisc(id, title, category, cost, length, director));
            JOptionPane.showMessageDialog(this, "DVD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            txtId.setText("");
            txtTitle.setText("");
            txtCategory.setText("");
            txtCost.setText("");
            txtLength.setText("");
            txtDirector.setText("");
        });
		
		return center;
	}
}
