package hust.soict.itep.aims.screen;

import java.io.IOException;
import javax.swing.JFrame;
import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Cart cart;
	private Store store;

	public CartScreen(Store store, Cart cart) {
		super();
		this.store = store;
		this.cart = cart;

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/aims/screen/Cart.fxml"));
					CartScreenController controller = new CartScreenController(store, cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
